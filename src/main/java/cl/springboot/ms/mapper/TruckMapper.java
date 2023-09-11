package cl.springboot.ms.mapper;

import java.util.Objects;
import java.util.Optional;

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

		if (Objects.nonNull(request.getIdDriver())) {
			truck.setDriver(driver);
		}

		return truck;

	}

	public TruckResponseDto toResponseTruckDto(Truck truck) {
		
		if (truck == null) {
			return null;
		}

		TruckResponseDto truckResponseDto = new TruckResponseDto();

		if (Objects.nonNull(truck.getIdTruck())) {
			truckResponseDto.setIdTruck(truck.getIdTruck());
		}

		if (Objects.nonNull(truck.getCode())) {
			truckResponseDto.setCode(truck.getCode());
		}
		
		if (Objects.nonNull(truck.getDriver().getIdDriver())) {
			truckResponseDto.setIdDriver(truck.getDriver().getIdDriver());
		}

		if (Objects.nonNull(truck.getEnabled())) {
			truckResponseDto.setEnabled(truck.getEnabled());
		}
		
		if (Objects.nonNull(truck.getIsDeleted())) {
			truckResponseDto.setIsDeleted(truck.getIsDeleted());
		}
		


		return truckResponseDto;
	}

	public TruckResponseDto toResponseTruckDto(Optional<Truck> truck) {
		
		TruckResponseDto truckResponseDto = new TruckResponseDto();

		if (Objects.nonNull(truck.get().getIdTruck())) {
			truckResponseDto.setIdTruck(truck.get().getIdTruck());
		}

		if (Objects.nonNull(truck.get().getCode())) {
			truckResponseDto.setCode(truck.get().getCode());
		}
		
		if (Objects.nonNull(truck.get().getDriver().getIdDriver())) {
			truckResponseDto.setIdDriver(truck.get().getDriver().getIdDriver());
		}

		if (Objects.nonNull(truck.get().getEnabled())) {
			truckResponseDto.setEnabled(truck.get().getEnabled());
		}
		


		return truckResponseDto;
	}

	public Truck toTruckUpdate(Long uui, Driver driver, TruckRequestDto request) {
		if (request == null) {
			return null;
		}

		Truck truck = new Truck();
		
		if (Objects.nonNull(uui)) {
			truck.setIdTruck(uui);
		}


		if (Objects.nonNull(request.getCode())) {
			truck.setCode(request.getCode());
		}

		if (Objects.nonNull(request.getIdDriver())) {
			truck.setDriver(driver);
		}
		
		if (Objects.nonNull(request.getOrder())) {
			truck.setOrder(request.getOrder());
		}

		return truck;
	}

	public void update(TruckRequestDto request, Truck truck, Driver driver) {
		// TODO Auto-generated method stub
		
	}

}
