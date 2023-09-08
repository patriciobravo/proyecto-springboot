package cl.springboot.ms.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import cl.springboot.ms.domain.OrderProduct;
import cl.springboot.ms.domain.StatusType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
public class OrderRequestDto {
	
	private String code;
	
	double weight;
	
	private LocalDateTime schedule;
	
    private StatusType status = StatusType.LOADED;

	private Boolean isDeleted = Boolean.FALSE;

	private LocalDateTime deletedAt;

	private UUID uuidTruck;
	
	@OneToMany(mappedBy = "order", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<OrderProduct> oderProduct;
	

}
