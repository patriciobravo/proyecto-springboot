package cl.springboot.ms.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DomainExceptionCode {

    DRIVER_NOT_FOUND(201, 404, "No se encontro Conductor con ese ID"),
    ORDER_NOT_FOUND(201, 404, "No se encontro Orden con ese ID"),
    ORDER_NOT_LOADED(201, 200, "Orden no se encuentra en estado Loaded. No se puede eliminar producto"),
    PRODUCT_NOT_ORDER(201, 404, "Producto no encontado en esta Orden"),
    TRUCK_NOT_FOUND(201, 404, "No se encontro camión con ese ID");

   // ADDRESS_NOT_FOUND(202, 404, "address_not_found");

    private Integer codeApp;

    private Integer statusCode;

    private String messageKey;
}
