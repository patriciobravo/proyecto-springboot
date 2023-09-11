package cl.springboot.ms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DriverResponseDto {

	private long idDriver;

	@Schema(example = "Prueba")
	private String name;
	
	@Schema(example = "123456789")
	private String cellphone;
	
	@Schema(example = "12334434")
	private String code;
	
	@Schema(example = "prueba@prueba.cl")
	private String email;
	
	private boolean enabled;	

}
