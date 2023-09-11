package cl.springboot.ms.swagger;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import cl.springboot.ms.dto.TruckRequestDto;
import cl.springboot.ms.dto.TruckResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@Tag(name = "Truck", description = "API de Truck")
public interface TruckSwagger {
	
	 @Operation(
	            summary = "Listar truck",
	            description = "Endpoint que nos ayuda a listar todos los trucks de la base de datos"
	    )
	    @ApiResponse(
	            responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") }
	    )
	 	public List<TruckResponseDto> findAll();

	    @Operation(
	            summary = "Buscar un truck",
	            description = "Endpoint que nos ayuda encontrar un truck por su id"
	    )
	    @ApiResponses({
	            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") }),
	            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") })
	    })
	    public TruckResponseDto findById(@PathVariable Long idTruck);

	    @Operation(
	            summary = "Guardar un truck",
	            description = "Endpoint que nos ayuda guardar un truck"
	    )
	    @ApiResponses({
	            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") }),
	            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") })
	    })
	    public TruckResponseDto save(@Valid @RequestBody TruckRequestDto request);

	    @Operation(
	            summary = "Actualizar un truck",
	            description = "Endpoint que nos ayuda a actualizar un truck por medio de su uuid y la informacion a modificar"
	    )
	    @ApiResponses({
	            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") }),
	            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") })
	    })
	    public TruckResponseDto update(@PathVariable Long idTruck, @RequestBody TruckRequestDto request);
	    
	    @Operation(
	            summary = "Elimina un truck",
	            description = "Endpoint que nos ayuda a eliminar un truck por medio de su uuid y la informacion a modificar"
	    )
	    @ApiResponses({
	            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") }),
	            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema(implementation = TruckResponseDto.class), mediaType = "application/json") })
	    })
	    
	    public TruckResponseDto delete(@PathVariable Long idTruck);

}
