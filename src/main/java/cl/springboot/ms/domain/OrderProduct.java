package cl.springboot.ms.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="order_products")
public class OrderProduct {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idOrderProduct;

	private String code;
	
	double weight;
	
	String sku;
	
	Integer quantity;
	
	private LocalDateTime schedule;
	
	private Boolean isDeleted = Boolean.FALSE;
	private LocalDateTime deletedAt;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false, foreignKey=@ForeignKey(name = "fk_order_id"))
	private Order order;

  
	public OrderProduct() {
		super();
		
	}



	public long getIdOrderProduct() {
		return idOrderProduct;
	}



	public void setIdOrderProduct(long idOrderProduct) {
		this.idOrderProduct = idOrderProduct;
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



	public String getSku() {
		return sku;
	}



	public void setSku(String sku) {
		this.sku = sku;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public LocalDateTime getSchedule() {
		return schedule;
	}



	public void setSchedule(LocalDateTime schedule) {
		this.schedule = schedule;
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



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}



	

}
