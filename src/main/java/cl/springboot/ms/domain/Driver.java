package cl.springboot.ms.domain;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "drivers", uniqueConstraints = { @UniqueConstraint(columnNames = {"code"})})
@SQLDelete(sql = "UPDATE drivers SET is_deleted=true, deleted_at=now() WHERE id_driver=?")
@Where(clause = "is_deleted is false")
@Getter
@Setter
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDriver;
   
    private String name;
   
    private String email;
  
    private String code;

    private Boolean isDeleted = Boolean.FALSE;
    
    private Boolean enabled = Boolean.TRUE;

    private LocalDateTime deletedAt;
   
    private String cellphone;

    @OneToOne(mappedBy = "driver", fetch = FetchType.LAZY)
    private Truck truck;

}
