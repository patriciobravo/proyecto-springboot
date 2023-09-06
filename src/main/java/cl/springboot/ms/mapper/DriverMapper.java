package cl.springboot.ms.mapper;

import java.util.Objects;

import org.springframework.stereotype.Component;

import cl.springboot.ms.domain.Driver;
import cl.springboot.ms.dto.response.DriverResponseDto;



@Component
//@Mapper(config = MapperConfig.class)
public class DriverMapper {


	//DriverResponseDto toResponseDriverDto(Driver driver);
	
	public DriverResponseDto toResponseDriverDto(Driver driver) {

		if (driver == null) {
			return null;
		}

		var driverResponseDto = new DriverResponseDto();

		if (Objects.nonNull(driver.getUuid())) {
			driverResponseDto.setUuid(driver.getUuid());
		}

		if (Objects.nonNull(driver.getName())) {
			driverResponseDto.setName(driver.getName());
		}

		return driverResponseDto;
	}
}
