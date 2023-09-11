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
import lombok.Data;

@Entity
@Table(name ="order_products")
@Data
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
	@JoinColumn(name = "id_order", nullable = false, foreignKey=@ForeignKey(name = "fk_id_order"))
	private Order order;

  
	

}
