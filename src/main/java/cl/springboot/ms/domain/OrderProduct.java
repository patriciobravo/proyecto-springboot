package cl.springboot.ms.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="order_products")
@Data
public class OrderProduct {
	
	@Id
	private UUID uuid = UUID.randomUUID();

	private String code;
	
	double weight;
	
	String sku;
	
	Integer quantity;
	
	private LocalDateTime schedule;
	
	private Boolean isDeleted = Boolean.FALSE;
	private LocalDateTime deletedAt;
	
	@Column(length = 100)
    @Enumerated(EnumType.STRING)
    private StatusType status = StatusType.LOADED;



//	@OneToOne(fetch = FetchType.LAZY)
//	private Driver driver;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_producto"))
	private Order order;

}
