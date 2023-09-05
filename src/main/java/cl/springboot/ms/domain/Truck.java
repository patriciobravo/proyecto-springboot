package cl.springboot.ms.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "trucks")
@Data
public class Truck {

	@Id
    private UUID uuid = UUID.randomUUID();
	
    private String code;
    
    private Boolean enabled = Boolean.TRUE;
    
    private Boolean isDeleted = Boolean.FALSE;
    
    private LocalDateTime deletedAt;
    
    @OneToOne(fetch = FetchType.LAZY)
    private Driver driver;
    
    @OneToMany(mappedBy = "truck", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Order> order;
}
