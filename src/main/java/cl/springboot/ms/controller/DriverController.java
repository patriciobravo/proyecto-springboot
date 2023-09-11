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

import cl.springboot.ms.dto.DriverRequestDto;
import cl.springboot.ms.dto.DriverResponseDto;
import cl.springboot.ms.service.DriverService;
import cl.springboot.ms.swagger.DriverSwagger;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/driver")
public class DriverController implements DriverSwagger {

	@Autowired
	private final DriverService driverService;

	@GetMapping
	public List<DriverResponseDto> findAll() {

		return driverService.findAll();
	}

	@GetMapping("/{uuid}")
	public DriverResponseDto findById(@PathVariable Long uuid) {

		return driverService.findByUuid(uuid);
	}

	@PostMapping
	public DriverResponseDto save(@Valid @RequestBody DriverRequestDto request) {

		return driverService.save(request);
	}

	@PutMapping("/{uuid}")
	public DriverResponseDto update(@PathVariable Long uuid, @RequestBody DriverRequestDto request) {

		return driverService.update(uuid, request);
	}

	@DeleteMapping("/{uuid}")
	public DriverResponseDto delete(@PathVariable Long uuid) {

		return driverService.delete(uuid);
	}

}
