package cl.springboot.ms.service;

import cl.springboot.ms.domain.StatusType;
import cl.springboot.ms.dto.OrderRequestDto;
import jakarta.validation.Valid;

public interface OrderService {

	OrderRequestDto save(@Valid OrderRequestDto request);

	OrderRequestDto update(Long uuid, StatusType state);

	String delete(Long uuid, @Valid OrderRequestDto request);

}
