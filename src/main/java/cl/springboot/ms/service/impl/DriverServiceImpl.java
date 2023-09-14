package cl.springboot.ms.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.springboot.ms.domain.Driver;
import cl.springboot.ms.domain.Truck;
import cl.springboot.ms.dto.DriverRequestDto;
import cl.springboot.ms.dto.DriverResponseDto;
import cl.springboot.ms.exception.DomainExceptionCode;
import cl.springboot.ms.exception.NotFoundException;
import cl.springboot.ms.mapper.DriverMapper;
import cl.springboot.ms.repository.DriverRepository;
import cl.springboot.ms.repository.TruckRepository;
import cl.springboot.ms.service.DriverService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

//@AllArgsConstructor
@RequiredArgsConstructor
@Service
@Slf4j
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository;
	
	@Autowired
	private TruckRepository truckRepository;
	//private TruckService truckService;

	@Autowired
	private DriverMapper driverMapper;

	//private IDriverMapper iDriverMapper;



	@Override
	public List<DriverResponseDto> findAll() {

		return driverRepository.findAll().stream().map(driver -> driverMapper.toResponseDriverDto(driver))
				.collect(Collectors.toList());
	}

	@Override
	public DriverResponseDto findByUuid(Long uuid) {
		
		Driver driver = findById(uuid);
		
		return driverMapper.toResponseDriverDto(driver);
	}

	@Override
	public DriverResponseDto save(@Valid DriverRequestDto request) {

		Optional<Driver> driver = driverRepository.findByCode(request.getCode());
		
		if(driver.isPresent()) {
			throw new NotFoundException(DomainExceptionCode.DRIVER_EXIST);
		}
			
		Driver driverSaved = driverRepository.save(driverMapper.toDriver(request));
		
//		if (Objects.nonNull(request.getTruck())) {
//			truckService.addToTruck(driverSaved, request.getTruck());
//        }

		return driverMapper.toDriverResponseDto(driverSaved);
	}

	@Override
	public DriverResponseDto delete(Long uuid) {
		
		log.info("DELETE"+ uuid);

		Driver driver = findById(uuid);
		Optional<Truck> truck = truckRepository.findByDriver(driver);

		if (truck.isPresent()) {
			log.info("driver en camion" + truck.get().getIdTruck());
			log.info("driver en camion" + truck.get().getDriver());
			throw new NotFoundException(DomainExceptionCode.DRIVER_NOT_DELETE);

		}

		log.info("DRIVER DELETE"+ driver);


		driverRepository.delete(driver);

		return driverMapper.toResponseDriverDto(driver);
	}


	@Override
	public DriverResponseDto update(Long uui, DriverRequestDto request) {

		Driver driver = findById(uui);

		driverMapper.updateDriver(request, driver);

		return driverMapper.toDriverResponseDto(driverRepository.save(driver));
	}

	private Driver findById(Long uuid) {
		
		return driverRepository.findById(uuid)
				.orElseThrow(() -> new NotFoundException(DomainExceptionCode.DRIVER_NOT_FOUND));
	}
}
