package cl.springboot.ms.swagger;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import cl.springboot.ms.dto.DriverRequestDto;
import cl.springboot.ms.dto.DriverResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Tag(name = "Driver", description = "API de Driver")
public interface DriverSwagger {
	
	 @Operation(
	            summary = "Listar drivers",
	            description = "Endpoint que nos ayuda a listar todos los drivers de la base de datos"
	    )
	    @ApiResponse(
	            responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") }
	    )
	 public List<DriverResponseDto> findAll();

	    @Operation(
	            summary = "Buscar un driver",
	            description = "Endpoint que nos ayuda encontrar un drive por su uuid"
	    )
	    @ApiResponses({
	            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") }),
	            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") })
	    })
	 public DriverResponseDto findById(@PathVariable Long uuid);

	    @Operation(
	            summary = "Guardar un driver",
	            description = "Endpoint que nos ayuda guardar un drive"
	    )
	    @ApiResponses({
	            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") }),
	            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") })
	    })
	    public DriverResponseDto save(@Valid @RequestBody DriverRequestDto request);

	    @Operation(
	            summary = "Actualizar un driver",
	            description = "Endpoint que nos ayuda a actualizar un drive por medio de su uuid y la informacion a modificar"
	    )
	    @ApiResponses({
	            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") }),
	            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") })
	    })
	    public DriverResponseDto update(@PathVariable Long uuid, @RequestBody DriverRequestDto request);
	    
	    @Operation(
	            summary = "Eliminar un driver",
	            description = "Endpoint que nos ayuda a eliminar un drive por medio de su uuid y la informacion a modificar"
	    )
	    @ApiResponses({
	            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") }),
	            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = DriverResponseDto.class), mediaType = "application/json") })
	    })
	    public DriverResponseDto delete(@PathVariable Long uuid);

}
