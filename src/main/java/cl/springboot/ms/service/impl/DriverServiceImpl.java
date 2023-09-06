package cl.springboot.ms.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.springboot.ms.domain.Driver;
import cl.springboot.ms.dto.response.DriverResponseDto;
import cl.springboot.ms.exception.DomainExceptionCode;
import cl.springboot.ms.exception.NotFoundException;
import cl.springboot.ms.mapper.DriverMapper;
import cl.springboot.ms.repository.DriverRepository;
import cl.springboot.ms.service.DriverService;
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

		return driverRepository.findAll().stream()
				.map(driver -> driverMapper.toResponseDriverDto(driver))
				.collect(Collectors.toList());

	}

	@Override
	public DriverResponseDto findByUuid(UUID uuid) {

		return driverMapper.toResponseDriverDto(findById(uuid));
	}

	private Driver findById(UUID personUuid) {

		return driverRepository.findById(personUuid)
				.orElseThrow(() -> new NotFoundException(DomainExceptionCode.DRIVER_NOT_FOUND));
	}

}
