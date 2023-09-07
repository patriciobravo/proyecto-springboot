package cl.springboot.ms.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.springboot.ms.domain.Driver;
import cl.springboot.ms.dto.DriverRequestDto;
import cl.springboot.ms.dto.DriverResponseDto;
import cl.springboot.ms.exception.DomainExceptionCode;
import cl.springboot.ms.exception.NotFoundException;
import cl.springboot.ms.mapper.DriverMapper;
import cl.springboot.ms.repository.DriverRepository;
import cl.springboot.ms.service.DriverService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository;

	@Autowired
	private DriverMapper driverMapper;

	@Override
	public List<DriverResponseDto> findAll() {

		return driverRepository.findAll().stream().map(driver -> driverMapper.toResponseDriverDto(driver))
				.collect(Collectors.toList());
	}

	@Override
	public DriverResponseDto findByUuid(UUID uuid) {
		
		//Driver driver = driverRepository.findById(uuid).orElseThrow(() -> new NotFoundException(DomainExceptionCode.DRIVER_NOT_FOUND));	
		Driver driver = findById(uuid);
		
		return driverMapper.toResponseDriverDto(driver);
	}

	@Override
	public DriverResponseDto save(@Valid DriverRequestDto request) {

		Driver driverSaved = driverRepository.save(driverMapper.toDriver(request));

//        if (Objects.nonNull(request.getCellphone())) {
//        	driverMapper.addToPerson(personSaved, request.getCellphone());
//        }

		return driverMapper.toDriverResponseDto(driverSaved);
	}

	@Override
	public DriverResponseDto delete(UUID uuid) {

		Driver driver = findById(uuid);

		driverRepository.delete(driver);

		return driverMapper.toResponseDriverDto(driver);
	}


	@Override
	public DriverResponseDto update(DriverResponseDto request) {

		var driver = findById(request.getUuid());

		driverMapper.updateDriver(request, driver);

		return driverMapper.toDriverResponseDto(driverRepository.save(driver));
	}

	private Driver findById(UUID uuid) {

		return driverRepository.findById(uuid)
				.orElseThrow(() -> new NotFoundException(DomainExceptionCode.DRIVER_NOT_FOUND));
	}
}
