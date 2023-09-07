package cl.springboot.ms.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.springboot.ms.domain.Driver;
import cl.springboot.ms.dto.TruckRequestDto;
import cl.springboot.ms.dto.TruckResponseDto;
import cl.springboot.ms.exception.DomainExceptionCode;
import cl.springboot.ms.exception.NotFoundException;
import cl.springboot.ms.mapper.TruckMapper;
import cl.springboot.ms.repository.DriverRepository;
import cl.springboot.ms.repository.TruckRepository;
import cl.springboot.ms.service.TruckService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TruckServiceImpl implements TruckService {

	@Autowired
	private final TruckRepository truckRepository;
	
	@Autowired
	private final DriverRepository driverRepository;

	@Autowired
	private TruckMapper truckMapper;

	@Override
	public List<TruckResponseDto> findAll() {

		return truckRepository.findAll().stream().map(truck -> truckMapper.toResponseTruckDto(truck))
				.collect(Collectors.toList());
	}
//
//	@Override
//	public DriverResponseDto findByUuid(UUID uuid) {
//		
//		//Driver driver = driverRepository.findById(uuid).orElseThrow(() -> new NotFoundException(DomainExceptionCode.DRIVER_NOT_FOUND));	
//		Driver driver = findById(uuid);
//		
//		return driverMapper.toResponseDriverDto(driver);
//	}

	@Override
	public TruckResponseDto save(@Valid TruckRequestDto request) {
		
		Driver driver = findById(request.getUuidDriver());
		
		if(!driver.getIsDeleted()) {
			
			truckRepository.save(truckMapper.toTruck(driver,request));
			
		}
		return null;
	

		
	}

//	@Override
//	public DriverResponseDto delete(UUID uuid) {
//
//		Driver driver = findById(uuid);
//		
//		//if(driver != null){
//			driverRepository.delete(driver);
//		//}
//
//		return driverMapper.toResponseDriverDto(driver);
//	}
//
//
//	@Override
//	public DriverResponseDto update(DriverResponseDto request) {
//
//		var driver = findById(request.getUuid());
//
//		driverMapper.updateDriver(request, driver);
//
//		return driverMapper.toDriverResponseDto(driverRepository.save(driver));
//	}
//
	private Driver findById(UUID uuid) {

		return driverRepository.findById(uuid)
				.orElseThrow(() -> new NotFoundException(DomainExceptionCode.DRIVER_NOT_FOUND));
	}
}
