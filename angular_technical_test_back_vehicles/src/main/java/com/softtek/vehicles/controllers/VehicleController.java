package com.softtek.vehicles.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.vehicles.models.entity.Vehicles;
import com.softtek.vehicles.services.VehicleService;

@RestController
@CrossOrigin({"http://localhost:4200"})
public class VehicleController {
	
	@Autowired
	protected VehicleService service;
	
	@GetMapping
	public ResponseEntity<?> list(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> view(@PathVariable Long id){
		
		Optional<Vehicles> o = service.findById(id);
		
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping
	public ResponseEntity<?> create(@Valid @RequestBody Vehicles entity, BindingResult result){
		
		if(result.hasErrors()) {
			return this.validate(result);
		}
		
		Vehicles entityDb = service.save(entity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@Valid @RequestBody Vehicles entity, BindingResult result, @PathVariable Long id){
		
		if(result.hasErrors()) {
			return this.validate(result);
		}
		
	    Optional<Vehicles> o = this.service.findById(id);
	    
	    if(!o.isPresent()) {
	    	return ResponseEntity.notFound().build();
	    }
	    
	    Vehicles entityDb = o.get();
	    
	    entityDb.setDriverIdentification(entity.getDriverIdentification());
	    entityDb.setPlaca(entity.getPlaca());
	    entityDb.setModel(entity.getModel());
	    entityDb.setDriverName(entity.getDriverName());
	    
	    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(entityDb));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findByPlacaOrIdentification(term));
	}
	
	private ResponseEntity<?> validate(BindingResult result){
		
		Map<String, Object> errores = new HashMap<>();
		
		result.getFieldErrors().forEach(err -> {
			errores.put(err.getField(), " El campo " + err.getField() + " " + err.getDefaultMessage());
		});
		
		return ResponseEntity.badRequest().body(errores);
	}

}
