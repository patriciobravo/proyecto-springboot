package cl.springboot.ms.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.springboot.ms.domain.Truck;

@Repository
public interface TruckRepository extends JpaRepository<Truck, UUID>{
	
	List<Truck> findAll();

	
	 

}
