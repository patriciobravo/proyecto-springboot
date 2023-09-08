package cl.springboot.ms.dto;

import java.util.List;
import java.util.UUID;

import cl.springboot.ms.domain.Order;
import lombok.Data;

@Data
public class TruckRequestDto {
	
	private String code;    

	private UUID uuidDriver;
	
	private List<Order> order;

}
