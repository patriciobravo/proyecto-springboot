package cl.springboot.ms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TruckResponseDto {
	
	private long idTruck;
	
	@Schema(example = "XXXXX")
    private String code;
    
    private Boolean enabled;
    
    private Boolean isDeleted;
    
    private long idDriver;
    
   

}
