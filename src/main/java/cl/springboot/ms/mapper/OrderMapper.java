package cl.springboot.ms.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.springboot.ms.domain.Order;
import cl.springboot.ms.domain.Truck;
import cl.springboot.ms.dto.OrderRequestDto;
import cl.springboot.ms.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OrderMapper {
	
	@Autowired
	private ModelMapper modelMapper;

	public Order mapearEntidadOrder(OrderRequestDto request, Truck truck) {
		Order order = modelMapper.map(request, Order.class);
		log.info("orderSaved" + order);
		
		order.getOrder_products().forEach(next -> {
			next.setOrder(order);
		});

		order.setTruck(truck);

		return order;
	}

	
	public OrderRequestDto mapearOrderRequestDto(Order orderUpdate) {
				
		return modelMapper.map(orderUpdate, OrderRequestDto.class);
	}

}
