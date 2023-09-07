package cl.springboot.ms.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class TruckRequestDto {
	
	private String code;    

	private UUID uuidDriver;

}
