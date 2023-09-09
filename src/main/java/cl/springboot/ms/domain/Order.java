package cl.springboot.ms.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOrder;



	private String code;
	
	double weight;
	
	private LocalDateTime schedule;
	
	@Column(length = 100)
    @Enumerated(EnumType.STRING)
    private StatusType status = StatusType.LOADED;

	private Boolean isDeleted = Boolean.FALSE;

	private LocalDateTime deletedAt;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_producto"))
	private Truck truck;
	
	//@JsonIgnore
	@JsonBackReference
	@OneToMany(mappedBy = "order", cascade =  CascadeType.ALL , orphanRemoval = true)
	private Set<OrderProduct> order_products = new HashSet<>();

	public Order(Long idOrder, String code, double weight, LocalDateTime schedule, StatusType status, Boolean isDeleted,
			LocalDateTime deletedAt) {
		super();
		this.idOrder = idOrder;
		this.code = code;
		this.weight = weight;
		this.schedule = schedule;
		this.status = status;
		this.isDeleted = isDeleted;
		this.deletedAt = deletedAt;
	}
	
	

	public Order() {
		super();
	}



	public long getIdOrder() {
		return idOrder;
	}



	public void setIdOrder(long idOrder) {
		this.idOrder = idOrder;
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



	public Truck getTruck() {
		return truck;
	}



	public void setTruck(Truck truck) {
		this.truck = truck;
	}



	public Set<OrderProduct> getOrder_products() {
		return order_products;
	}



	public void setOrder_products(Set<OrderProduct> order_products) {
		this.order_products = order_products;
	}



	





	
	
}


