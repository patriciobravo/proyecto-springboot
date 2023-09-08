package cl.springboot.ms.service.impl;

import org.springframework.stereotype.Service;

import cl.springboot.ms.dto.OrderRequestDto;
import cl.springboot.ms.service.OrderService;
import jakarta.validation.Valid;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public OrderRequestDto save(@Valid OrderRequestDto request) {
		// TODO Auto-generated method stub
		return null;
	}

}
