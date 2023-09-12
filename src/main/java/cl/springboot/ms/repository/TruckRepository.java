package cl.springboot.ms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.springboot.ms.domain.Truck;

public interface TruckRepository extends JpaRepository<Truck, Long>{
	
	List<Truck> findAll();

	Optional<Truck> findByDriver(Object driver);

	Optional<Truck> findByCode(String code);

	
	 

}
