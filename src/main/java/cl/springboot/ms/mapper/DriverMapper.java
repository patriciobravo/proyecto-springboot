package cl.springboot.ms.mapper;

import java.util.Objects;

import org.springframework.stereotype.Component;

import cl.springboot.ms.domain.Driver;
import cl.springboot.ms.dto.DriverRequestDto;
import cl.springboot.ms.dto.DriverResponseDto;



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
		
		if (Objects.nonNull(driver.getCode())) {
			driverResponseDto.setCode(driver.getCode());
		}

		if (Objects.nonNull(driver.getEmail())) {
			driverResponseDto.setEmail(driver.getEmail());
		}


		if (Objects.nonNull(driver.getEnabled())) {
			driverResponseDto.setEnabled(driver.getEnabled());
		}

		
		if (Objects.nonNull(driver.getEnabled())) {
			driverResponseDto.setEnabled(driver.getEnabled());
		}


		return driverResponseDto;
	}
	
	 public Driver toDriver(DriverRequestDto request) {

	        if (request == null) {
	            return null;
	        }

	        var driver = new Driver();

	        if (Objects.nonNull(request.getName())) {
	            driver.setName(request.getName());
	        }

	        if (Objects.nonNull(request.getEmail())) {
	            driver.setEmail(request.getEmail());
	        }
	        
	        if (Objects.nonNull(request.getCode())) {
	            driver.setCode(request.getCode());
	        }


	        if (Objects.nonNull(request.getCellphone())) {
	            driver.setCellphone(request.getCellphone());
	        }

	      
	        return driver;
	    }
	
	 public DriverResponseDto toDriverResponseDto(Driver driver) {

	        if (driver == null) {
	            return null;
	        }

	        var personResponseDto = new DriverResponseDto();

	        if (Objects.nonNull(driver.getUuid())) {
	            personResponseDto.setUuid(driver.getUuid());
	        }

	        if (Objects.nonNull(driver.getName())) {
	            personResponseDto.setName(driver.getName());
	        }
	        
	        if (Objects.nonNull(driver.getEmail())) {
	            personResponseDto.setEmail(driver.getEmail());
	        }
	        
	       
	        personResponseDto.setEnabled(driver.getEnabled());
	       

//	        if (Objects.nonNull(driver.getDocumentType())) {
//	            personResponseDto.setDocumentType(driver.getDocumentType());
//	        }

	        return personResponseDto;
	    }

	public void updateDriver(DriverRequestDto request, Driver driver) {
		

        if (Objects.nonNull(request.getName())) {
        	driver.setName(request.getName());
        }

        if (Objects.nonNull(request.getEmail())) {
        	driver.setEmail(request.getEmail());
        }
        
        if (Objects.nonNull(request.getCode())) {
        	driver.setCode(request.getCode());
        }

        if (Objects.nonNull(request.getCellphone())) {
        	driver.setCellphone(request.getCellphone());
        }

      
	}
}
