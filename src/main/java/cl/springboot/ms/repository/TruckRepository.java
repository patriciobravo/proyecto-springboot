package cl.springboot.ms.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.springboot.ms.domain.Driver;
import cl.springboot.ms.domain.Truck;

@Repository
public interface TruckRepository extends CrudRepository<Truck, UUID>{
	
	List<Truck> findAll();
	 

}
