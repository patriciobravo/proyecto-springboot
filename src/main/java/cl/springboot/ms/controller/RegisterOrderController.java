package cl.springboot.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.springboot.ms.domain.StatusType;
import cl.springboot.ms.dto.OrderRequestDto;
import cl.springboot.ms.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/package")

public class RegisterOrderController  {
	
	@Autowired
	private final OrderService orderService;
	
	
	@PostMapping
	public OrderRequestDto save(@Valid @RequestBody OrderRequestDto request) {
		
		return orderService.save(request);
	}
	
	@PutMapping("/{uuid}/{state}")
	public OrderRequestDto update(@PathVariable Long uuid, @PathVariable StatusType state) {

		return orderService.update(uuid, state);
	}	
	
	@DeleteMapping("/{uuid}")
	public String delete(@PathVariable Long uuid, @Valid @RequestBody OrderRequestDto request) {

		return orderService.delete(uuid, request);
	}
	

}
