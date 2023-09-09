package cl.springboot.ms.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.springboot.ms.domain.Order;
import cl.springboot.ms.domain.StatusType;
import cl.springboot.ms.domain.Truck;
import cl.springboot.ms.dto.OrderRequestDto;
import cl.springboot.ms.exception.DomainExceptionCode;
import cl.springboot.ms.exception.NotFoundException;
import cl.springboot.ms.mapper.OrderMapper;
import cl.springboot.ms.repository.OrderProductRepository;
import cl.springboot.ms.repository.OrderRepository;
import cl.springboot.ms.repository.TruckRepository;
import cl.springboot.ms.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service

public class OrderServiceImpl implements OrderService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private OrderMapper orderMapper;


	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderProductRepository orderProductRepository;

	@Autowired
	private final TruckRepository truckRepository;

	@Override
	public OrderRequestDto save(OrderRequestDto request) {
		
		Truck truck = truckRepository.findById(request.getUuidTruck())
				.orElseThrow(() -> new NotFoundException(DomainExceptionCode.TRUCK_NOT_FOUND));
		

		Order order = mapearEntidadOrder(request, truck);

		Order orderSaved = orderRepository.save(order);
		return mapearOrderRequestDto(orderSaved);
	}

	private OrderRequestDto mapearOrderRequestDto(Order orderSaved) {
		
		return modelMapper.map(orderSaved, OrderRequestDto.class);
	}

	private Order mapearEntidadOrder(OrderRequestDto request, Truck truck) {
		
		Order order = modelMapper.map(request, Order.class);
				
		order.getOrder_products().forEach(next -> {
			next.setOrder(order);
		});

		order.setTruck(truck);

		return order;
	}

	@Override
	public OrderRequestDto update(Long uuid, StatusType state) {

		Order order = findById(uuid);
		order.setStatus(state);

		Order orderUpdate = orderRepository.save(order);
		return orderMapper.mapearOrderRequestDto(orderUpdate);

	}

	@Override
	public String delete(Long uuid, @Valid OrderRequestDto request) {

		orderRepository.findByIdOrderAndStatus(uuid, StatusType.LOADED)
				.orElseThrow(() -> new NotFoundException(DomainExceptionCode.ORDER_NOT_LOADED));

		orderProductRepository.deleteAll(request.getOrder_products());
		
		
		

		return "Productos eliminados";
	}

	private Order findById(Long uuid) {

		return orderRepository.findById(uuid)
				.orElseThrow(() -> new NotFoundException(DomainExceptionCode.ORDER_NOT_FOUND));
	}
}
