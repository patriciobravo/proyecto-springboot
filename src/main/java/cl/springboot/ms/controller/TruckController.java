package cl.springboot.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.springboot.ms.dto.TruckRequestDto;
import cl.springboot.ms.dto.TruckResponseDto;
import cl.springboot.ms.service.TruckService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/truck")
public class TruckController {

	@Autowired
	private final TruckService truckService;

	@GetMapping
	public List<TruckResponseDto> findAll() {

		return truckService.findAll();
	}
//
//	@GetMapping("/{uuid}")
//	public DriverResponseDto findById(@PathVariable UUID uuid) {
//
//		return driverService.findByUuid(uuid);
//	}

	@PostMapping
	public TruckResponseDto save(@Valid @RequestBody TruckRequestDto request) {

		return truckService.save(request);
	}

//	@PutMapping
//	public DriverResponseDto update(@RequestBody DriverResponseDto request) {
//
//		return driverService.update(request);
//	}
//
//	@DeleteMapping("/{uuid}")
//	public Object delete(@PathVariable UUID uuid) {
//
//		return driverService.delete(uuid);
//	}

}
