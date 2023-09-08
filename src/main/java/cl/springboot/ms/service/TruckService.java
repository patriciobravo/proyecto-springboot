package cl.springboot.ms.service;

import java.util.List;
import java.util.UUID;

import cl.springboot.ms.dto.TruckRequestDto;
import cl.springboot.ms.dto.TruckResponseDto;
import jakarta.validation.Valid;

public interface TruckService {

	TruckResponseDto save(@Valid TruckRequestDto request);

	List<TruckResponseDto> findAll();

	TruckResponseDto findByUuid(UUID uuid);

	TruckResponseDto update(UUID uui, @Valid TruckRequestDto request);

	TruckResponseDto delete(UUID uuid);



}
