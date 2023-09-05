package cl.springboot.ms.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {

	@Id
	private UUID uuid = UUID.randomUUID();

	private String code;
	
	double weight;
	
	private LocalDateTime schedule;
	
	@Column(length = 100)
    @Enumerated(EnumType.STRING)
    private StatusType status = StatusType.LOADED;

	private Boolean isDeleted = Boolean.FALSE;

	private LocalDateTime deletedAt;

//	@OneToOne(fetch = FetchType.LAZY)
//	private Driver driver;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_venta_producto"))
	private Truck truck;
	
	@OneToMany(mappedBy = "order", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<OrderProduct> oderProduct;
}
