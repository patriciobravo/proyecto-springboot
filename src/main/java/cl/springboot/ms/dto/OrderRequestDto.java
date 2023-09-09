package cl.springboot.ms.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import cl.springboot.ms.domain.OrderProduct;
import cl.springboot.ms.domain.StatusType;
import cl.springboot.ms.domain.Truck;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


public class OrderRequestDto {
	

	//private long idOrder;

	private String code;
	
	double weight;
	
	private LocalDateTime schedule;
	
	
    private StatusType status = StatusType.LOADED;

	private Boolean isDeleted = Boolean.FALSE;

	private LocalDateTime deletedAt;	
	
	private UUID uuidTruck;
	
	private Set<OrderProduct> order_products;

//	public long getIdOrder() {
//		return idOrder;
//	}
//
//	public void setIdOrder(long idOrder) {
//		this.idOrder = idOrder;
//	}

	public UUID getUuidTruck() {
		return uuidTruck;
	}

	public void setUuidTruck(UUID uuidTruck) {
		this.uuidTruck = uuidTruck;
	}

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

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}

	

	public Set<OrderProduct> getOrder_products() {
		return order_products;
	}

	public void setOrder_products(Set<OrderProduct> order_products) {
		this.order_products = order_products;
	}

	public OrderRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
