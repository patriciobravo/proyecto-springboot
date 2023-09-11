package cl.springboot.ms.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "trucks")
@SQLDelete(sql = "UPDATE trucks SET is_deleted=true, deleted_at=now() WHERE id_t"
		+ "ruck=?")
@Where(clause = "is_deleted is false")
@Data
public class Truck {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTruck;

    private String code;
    
    private Boolean enabled = Boolean.TRUE;
    
    private Boolean isDeleted = Boolean.FALSE;
    
    private LocalDateTime deletedAt;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_driver", nullable = false, foreignKey=@ForeignKey(name = "fk_id_driver"))
    private Driver driver;
    
   @OneToMany(mappedBy = "truck", cascade = { CascadeType.ALL }, orphanRemoval = true)
 	private List<Order> order;
}
