package cl.springboot.ms.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import cl.springboot.ms.domain.OrderProduct;
import lombok.Data;


public class OrderRequestDto {
	
	private String code;
	
	double weight;
	
	private LocalDateTime schedule;
	
	private LocalDateTime deletedAt;	
	
	private UUID uuidTruck;
	
	private Set<OrderProduct> order_products;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public LocalDateTime getSchedule() {
		return schedule;
	}

	public void setSchedule(LocalDateTime schedule) {
		this.schedule = schedule;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	public UUID getUuidTruck() {
		return uuidTruck;
	}

	public void setUuidTruck(UUID uuidTruck) {
		this.uuidTruck = uuidTruck;
	}

	public Set<OrderProduct> getOrder_products() {
		return order_products;
	}

	public void setOrder_products(Set<OrderProduct> order_products) {
		this.order_products = order_products;
	}

	public OrderRequestDto(String code, double weight, LocalDateTime schedule, LocalDateTime deletedAt, UUID uuidTruck,
			Set<OrderProduct> order_products) {
		super();
		this.code = code;
		this.weight = weight;
		this.schedule = schedule;
		this.deletedAt = deletedAt;
		this.uuidTruck = uuidTruck;
		this.order_products = order_products;
	}

	public OrderRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
