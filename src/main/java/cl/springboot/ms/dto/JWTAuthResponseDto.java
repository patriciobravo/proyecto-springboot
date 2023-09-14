package cl.springboot.ms.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class JWTAuthResponseDto {

    private String tokenDeAcceso;
    //private String tipoDeToken = "Bearer";
}
