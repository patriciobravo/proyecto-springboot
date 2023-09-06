package cl.springboot.ms.dto.request;

import org.w3c.dom.DocumentType;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DriverRequestDto {

	//@Schema(example = "Patricio")
    //@Size(min = 5, max = 10, message = "El tamaño del nombre no es correcto")
    //@NotEmpty(message = "{person.name.not.empty}")
    private String name;

    //@Schema(example = "Morales")
    //@NotNull(message = "El apellido no puede ser nulo")
    //@NotEmpty(message = "{person.last.name.not.empty}")
    private String lastName;

    //@NotNull(message = "La edad no puede ser nula")
    //@Min(value = 1, message = "La edad debe ser mayor que 1")
    private Integer age;

    //@Schema(example = "CC")
    //@NotNull(message = "El tipo de documento no puede ser nulo")
    //private DocumentType documentType = DocumentType.CC;
//
  //  private CellphoneRequestDto cellphone;
}
