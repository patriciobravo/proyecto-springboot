package cl.springboot.ms.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.springboot.ms.domain.Driver;

@Repository
public interface DriverRepository extends CrudRepository<Driver, UUID>{
	
	 List<Driver> findAll();

}
