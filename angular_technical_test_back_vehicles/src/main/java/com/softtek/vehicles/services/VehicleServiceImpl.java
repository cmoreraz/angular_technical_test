package com.softtek.vehicles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.vehicles.models.entity.Vehicles;
import com.softtek.vehicles.models.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleRepository repository; 

	@Override
	@Transactional(readOnly = true)
	public Iterable<Vehicles> findAll() {
		return this.repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Vehicles> findById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	@Transactional
	public Vehicles save(Vehicles entity) {
		return this.repository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vehicles> findByPlacaOrIdentification(String term) {
		return this.repository.findByPlacaOrIdentification(term);
	}

}
