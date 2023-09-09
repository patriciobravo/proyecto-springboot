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
import cl.springboot.ms.repository.OrderProductRepository;
import cl.springboot.ms.repository.OrderRepository;
import cl.springboot.ms.repository.TruckRepository;
import cl.springboot.ms.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ModelMapper modelMapper;

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

		Order order = mapearEntidad(request, truck);

		// order.setTruck(truck);
//		order.getOrderProduct().forEach(det ->{
//			det.setOrder(new Order());
//		});

		log.info("ORDER  " + order);
		orderRepository.save(order);
		return request;
	}

	private Order mapearEntidad(OrderRequestDto request, Truck truck) {
		// TODO Auto-generated method stub
		Order order = modelMapper.map(request, Order.class);
		order.getOrder_products().forEach(next -> {
			next.setOrder(order);
			log.info("ORDER ID " + next.getOrder().getIdOrder());
		});

		order.setTruck(truck);

		return order;
	}

	@Override
	public OrderRequestDto update(Long uuid, StatusType state) {

		Order order = findById(uuid);
		order.setStatus(state);

		orderRepository.save(order);
		return modelMapper.map(order, OrderRequestDto.class);
		
	}

	private Order findById(Long uuid) {

		log.info("ID DE ORDER   " + uuid);

		return orderRepository.findById(uuid)
				.orElseThrow(() -> new NotFoundException(DomainExceptionCode.ORDER_NOT_FOUND));
	}

	@Override
	public OrderRequestDto delete(Long uuid, @Valid OrderRequestDto request) {

		Order order = orderRepository.findByIdOrderAndStatus(uuid, StatusType.LOADED)
				.orElseThrow(() -> new NotFoundException(DomainExceptionCode.ORDER_NOT_LOADED));
		
		orderProductRepository.deleteAll(request.getOrder_products());
			
		log.info("ORDER PARA ELIMINAR PRODUCTOS  " + order);
		
		return null;
	}

	
}
