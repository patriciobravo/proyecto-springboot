package cl.springboot.ms.service;

import java.util.List;

import cl.springboot.ms.dto.DriverRequestDto;
import cl.springboot.ms.dto.DriverResponseDto;
import jakarta.validation.Valid;

public interface DriverService {

	List<DriverResponseDto> findAll();

	DriverResponseDto findByUuid(Long uuid);

	DriverResponseDto save(@Valid DriverRequestDto request);

	DriverResponseDto delete(Long uuid);

	DriverResponseDto update(Long uuid, DriverRequestDto request);


	
	

}
