package cl.springboot.ms.service;

import java.util.List;
import java.util.UUID;

import cl.springboot.ms.dto.response.DriverResponseDto;

public interface DriverService {

	List<DriverResponseDto> findAll();

	DriverResponseDto findByUuid(UUID uuid);
	
	

}
