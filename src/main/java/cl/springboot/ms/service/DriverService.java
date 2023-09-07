package cl.springboot.ms.service;

import java.util.List;
import java.util.UUID;

import cl.springboot.ms.dto.DriverRequestDto;
import cl.springboot.ms.dto.DriverResponseDto;
import jakarta.validation.Valid;

public interface DriverService {

	List<DriverResponseDto> findAll();

	DriverResponseDto findByUuid(UUID uuid);

	DriverResponseDto save(@Valid DriverRequestDto request);

	DriverResponseDto delete(UUID uuid);

	DriverResponseDto update(DriverResponseDto request);


	
	

}
