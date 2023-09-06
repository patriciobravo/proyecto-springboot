package cl.springboot.ms.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.springboot.ms.dto.response.DriverResponseDto;
import cl.springboot.ms.service.DriverService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/driver")

public class DriverController {

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

}
