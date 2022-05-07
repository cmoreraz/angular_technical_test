package com.softtek.vehicles.services;

import java.util.List;
import java.util.Optional;

import com.softtek.vehicles.models.entity.Vehicles;

public interface VehicleService {

	public Iterable<Vehicles> findAll();

	public Optional<Vehicles> findById(Long id);

	public Vehicles save(Vehicles entity);

	public void deleteById(Long id);
	
	public List<Vehicles> findByPlacaOrIdentification(String term);

}
