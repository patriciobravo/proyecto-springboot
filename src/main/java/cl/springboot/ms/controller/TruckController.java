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

	@GetMapping("/{uuid}")
	public TruckResponseDto findById(@PathVariable UUID uuid) {

		return truckService.findByUuid(uuid);
	}

	@PostMapping
	public TruckResponseDto save(@Valid @RequestBody TruckRequestDto request) {

		return truckService.save(request);
	}

	@PutMapping("/{uuid}")
	public TruckResponseDto update(@PathVariable UUID uuid, @RequestBody TruckRequestDto request) {

		return truckService.update(uuid,request);
	}

	@DeleteMapping("/{uuid}")
	public TruckResponseDto delete(@PathVariable UUID uuid) {

		return truckService.delete(uuid);
	}

}
