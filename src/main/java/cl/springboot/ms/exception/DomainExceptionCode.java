package cl.springboot.ms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DomainExceptionCode {

    DRIVER_NOT_FOUND(201, 404, "No se encontro Conductor con ese ID"),
	DRIVER_NOT_FOUND_DELETE(201, 404, "No se encontro Conductor con ese ID para eliminar");
   // ADDRESS_NOT_FOUND(202, 404, "address_not_found");

    private Integer codeApp;

    private Integer statusCode;

    private String messageKey;
}
