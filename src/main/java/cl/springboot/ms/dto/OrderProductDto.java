package cl.springboot.ms.dto;

import lombok.Data;

@Data
public class OrderProductDto {

	private String code;
	
	double weight;
	
	String sku;
	
	Integer quantity;
	



	private OrderRequestDto order;
 
	
	

}
