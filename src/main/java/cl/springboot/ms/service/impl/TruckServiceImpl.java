package cl.springboot.ms.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.springboot.ms.domain.Driver;
import cl.springboot.ms.domain.Truck;
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
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
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

	@Override
	public TruckResponseDto findByUuid(Long uuid) {

		Truck truck = truckRepository.findById(uuid)
				.orElseThrow(() -> new NotFoundException(DomainExceptionCode.TRUCK_NOT_FOUND));

		return truckMapper.toResponseTruckDto(truck);
	}

	@Override
	public TruckResponseDto save(@Valid TruckRequestDto request) {

		Driver driver = findById(request.getIdDriver());
		Optional<Truck> truck = truckRepository.findByDriver(driver);
		Optional<Truck> truckExist = truckRepository.findByCode(request.getCode());

		if (truckExist.isPresent()) {
			throw new NotFoundException(DomainExceptionCode.TRUCK_EXIST);
		}

		if (truck.isPresent()) {
			log.info("driver en camion" + truck.get().getIdTruck());
			log.info("driver en camion" + truck.get().getDriver());
			throw new NotFoundException(DomainExceptionCode.DRIVER_IN_TRUCK);

		}

		Truck truckSaved = truckRepository.save(truckMapper.toTruck(driver, request));

		return truckMapper.toResponseTruckDto(truckSaved);

	}

//	private boolean validateDriver(UUID uuid) {
//		log.info("Ingreso a validar driver");
//		List<TruckResponseDto> trucks = findAll();
//		
//		log.info("Ingreso a validar driver " + trucks);
//		for (TruckResponseDto t : trucks) {
//			if(t.getUuidDriver().equals(uuid)) {
//				log.info("camion tiene asociado un driver");
//				return new NotFoundException(DomainExceptionCode.TRUCK_NOT_FOUND);
//				 return true;
//			}
//		}
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public TruckResponseDto delete(Long uuid) {

		// Driver driver = findById(uuid);
		Truck truck = truckRepository.findById(uuid)
				.orElseThrow(() -> new NotFoundException(DomainExceptionCode.TRUCK_NOT_FOUND));

		// if(driver != null){
		truckRepository.delete(truck);
		// }

		return truckMapper.toResponseTruckDto(truck);
	}

	@Override
	public TruckResponseDto update(Long uui, TruckRequestDto request) {

		Driver driver = findById(request.getIdDriver());

		Optional<Truck> truckExist = truckRepository.findByCode(request.getCode());
		
		if (truckExist.isPresent() && truckExist.get().getIdTruck() != (uui)) {
			
			throw new NotFoundException(DomainExceptionCode.TRUCK_EXIST);
		}

		Truck truck = truckMapper.toTruckUpdate(uui, driver, request);
	
		return truckMapper.toResponseTruckDto(	truckRepository.save(truck));
	}

	private Driver findById(Long uuid) {
		log.info("ID DE DRIVER   " + uuid);
		return driverRepository.findById(uuid)
				.orElseThrow(() -> new NotFoundException(DomainExceptionCode.DRIVER_NOT_FOUND));
	}

}
