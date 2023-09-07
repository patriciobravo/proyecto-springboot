package cl.springboot.ms.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TruckResponseDto {
	
	private UUID uuid;
	
	@Schema(example = "XXXXX")
    private String code;
    
    private Boolean enabled;
    
    private UUID uuidDriver;
    
   

}
