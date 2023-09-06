package cl.springboot.ms.dto.response;

import java.util.UUID;

import cl.springboot.ms.domain.StatusType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DriverResponseDto {

	private UUID uuid;

	private String name;
	
	private String cellphone;
	
	private String email;
	
	private boolean enabled;

	private StatusType documentType = StatusType.LOADED;

}
