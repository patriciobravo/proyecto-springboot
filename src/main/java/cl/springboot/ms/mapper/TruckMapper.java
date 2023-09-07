package cl.springboot.ms.mapper;

import java.util.Objects;

import org.springframework.stereotype.Component;

import cl.springboot.ms.domain.Driver;
import cl.springboot.ms.domain.Truck;
import cl.springboot.ms.dto.TruckRequestDto;
import cl.springboot.ms.dto.TruckResponseDto;
import jakarta.validation.Valid;

@Component
public class TruckMapper {

	public Truck toTruck(Driver driver, @Valid TruckRequestDto request) {

		if (request == null) {
			return null;
		}

		Truck truck = new Truck();

		if (Objects.nonNull(request.getCode())) {
			truck.setCode(request.getCode());
		}

		if (Objects.nonNull(request.getUuidDriver())) {
			truck.setDriver(driver);
		}

		return truck;

	}

	public TruckResponseDto toResponseTruckDto(Truck truck) {
		
		if (truck == null) {
			return null;
		}

		TruckResponseDto truckResponseDto = new TruckResponseDto();

		if (Objects.nonNull(truck.getUuid())) {
			truckResponseDto.setUuid(truck.getUuid());
		}

		if (Objects.nonNull(truck.getCode())) {
			truckResponseDto.setCode(truck.getCode());
		}
		
		if (Objects.nonNull(truck.getDriver().getUuid())) {
			truckResponseDto.setUuidDriver(truck.getDriver().getUuid());
		}

		if (Objects.nonNull(truck.getEnabled())) {
			truckResponseDto.setEnabled(truck.getEnabled());
		}
		


		return truckResponseDto;
	}

}
