package cl.springboot.ms.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DriverRequestDto {

	@Schema(example = "Prueba")
    @Size(min = 5, max = 10, message = "El tamaño del nombre no es correcto")
    @NotEmpty(message = "nombre no puede ser vacio")
    private String name;
    
	@Schema(example = "prueba@prueba.cl")	
	@NotEmpty(message = "nombre no puede ser vacio")
	@Email(message = "email debe ser valido")
    private String email;
    
    private String code;

    @Schema(example = "958641094")
    @Size(min = 9, max = 9, message = "El tamaño del telefono es incorrecto")
    @NotEmpty(message = "telefono no puede ser vacio")
    private String cellphone;

}
