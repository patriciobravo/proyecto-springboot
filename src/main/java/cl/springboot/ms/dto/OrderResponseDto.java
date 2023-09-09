package cl.springboot.ms.dto;

import java.util.Set;

import cl.springboot.ms.domain.OrderProduct;
import lombok.Data;

@Data
public class OrderResponseDto  {
	
	private String message;
	
	private long idOrderProduct;	
	
	private Set<OrderProduct> order_products;

}
