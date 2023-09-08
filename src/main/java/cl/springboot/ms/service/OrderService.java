package cl.springboot.ms.service;

import cl.springboot.ms.dto.OrderRequestDto;
import jakarta.validation.Valid;

public interface OrderService {

	OrderRequestDto save(@Valid OrderRequestDto request);

}
