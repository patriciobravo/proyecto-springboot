package cl.springboot.ms.dto;

import java.time.LocalDateTime;
import java.util.Set;

import cl.springboot.ms.domain.OrderProduct;
import lombok.Data;

@Data
public class OrderRequestDto {
	
	private String code;
	
	double weight;
	
	private LocalDateTime schedule;
	
	private LocalDateTime deletedAt;	
	
	private Long uuidTruck;
	
	private Set<OrderProduct> order_products;

}
