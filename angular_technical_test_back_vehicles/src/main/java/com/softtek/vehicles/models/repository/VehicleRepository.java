package com.softtek.vehicles.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.softtek.vehicles.models.entity.Vehicles;

public interface VehicleRepository extends CrudRepository<Vehicles, Long> {
	
	@Query("select a from Vehicles a where a.placa like %?1% or a.driverIdentification like %?1%")
	public List<Vehicles> findByPlacaOrIdentification(String term);

}
