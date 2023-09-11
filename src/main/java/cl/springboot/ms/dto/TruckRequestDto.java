package cl.springboot.ms.dto;

import java.util.List;

import cl.springboot.ms.domain.Order;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TruckRequestDto {
	
	@Schema(example = "WTRE30")
    @Size(min = 6, max = 6, message = "El tamaño de patente no es correcto")
    @NotEmpty(message = "patente no puede ser vacio")
	private String code;    

	@Schema(example = "1")
  	@NotNull(message = "conductor no puede ser vacio")
	private Long idDriver;
	
	private List<Order> order;

}
