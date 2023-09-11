package cl.springboot.ms.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
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
	  @JoinColumn(name = "id_truck", nullable = false, foreignKey=@ForeignKey(name = "fk_id_truck"))
	private Truck truck;
	
	//@JsonIgnore
	@JsonBackReference
	@OneToMany(mappedBy = "order", cascade =  CascadeType.ALL , orphanRemoval = true)
	private Set<OrderProduct> order_product = new HashSet<>();
	
}


