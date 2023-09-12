package cl.springboot.ms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import cl.springboot.ms.domain.Driver;

public interface DriverRepository extends CrudRepository<Driver, Long>{
	
	 List<Driver> findAll();

	Optional<Driver> findByCode(String code);
	 

}
