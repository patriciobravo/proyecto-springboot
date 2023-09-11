package cl.springboot.ms.service;

import java.util.List;

import cl.springboot.ms.dto.TruckRequestDto;
import cl.springboot.ms.dto.TruckResponseDto;
import jakarta.validation.Valid;

public interface TruckService {

	TruckResponseDto save(@Valid TruckRequestDto request);

	List<TruckResponseDto> findAll();

	TruckResponseDto findByUuid(Long uuid);

	TruckResponseDto update(Long uui, @Valid TruckRequestDto request);

	TruckResponseDto delete(Long uuid);



}
