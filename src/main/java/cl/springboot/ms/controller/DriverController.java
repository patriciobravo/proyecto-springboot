package cl.springboot.ms.controller;

import java.util.List;
import java.util.UUID;

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

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/driver")
public class DriverController  {

	@Autowired
	private final DriverService driverService;

	@GetMapping
	public List<DriverResponseDto> findAll() {

		return driverService.findAll();
	}

	@GetMapping("/{uuid}")
	public DriverResponseDto findById(@PathVariable UUID uuid) {

		return driverService.findByUuid(uuid);
	}

	@PostMapping
	public DriverResponseDto save(@Valid @RequestBody DriverRequestDto request) {

		return driverService.save(request);
	}

	@PutMapping("/{uuid}")
	public DriverResponseDto update(@PathVariable UUID uuid, @RequestBody DriverRequestDto request) {

		return driverService.update(uuid, request);
	}

	@DeleteMapping("/{uuid}")
	public DriverResponseDto delete(@PathVariable UUID uuid) {

		return driverService.delete(uuid);
	}

}
