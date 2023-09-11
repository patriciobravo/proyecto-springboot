package cl.springboot.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.springboot.ms.dto.TruckRequestDto;
import cl.springboot.ms.dto.TruckResponseDto;
import cl.springboot.ms.service.TruckService;
import cl.springboot.ms.swagger.TruckSwagger;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/truck")
@Slf4j
public class TruckController implements TruckSwagger{

	@Autowired
	private final TruckService truckService;

	@GetMapping
	public List<TruckResponseDto> findAll() {

		return truckService.findAll();
	}

	@GetMapping("/{idTruck}")
	public TruckResponseDto findById(@PathVariable Long idTruck) {

		return truckService.findByUuid(idTruck);
	}

	@PostMapping
	public TruckResponseDto save(@Valid @RequestBody TruckRequestDto request) {
		// request.setIdDriver(Long.valueOf("1"));
		log.info("REQUEST ID  "+ request.getIdDriver());
		log.info("REQUEST ID  "+ request.getCode());
		log.info("REQUEST ID  "+ request.getOrder());

		return truckService.save(request);
	}

	@PutMapping("/{idTruck}")
	public TruckResponseDto update(@PathVariable Long idTruck, @RequestBody TruckRequestDto request) {

		return truckService.update(idTruck,request);
	}

	@DeleteMapping("/{idTruck}")
	public TruckResponseDto delete(@PathVariable Long idTruck) {

		return truckService.delete(idTruck);
	}

}
