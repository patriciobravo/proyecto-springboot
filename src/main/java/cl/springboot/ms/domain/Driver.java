package cl.springboot.ms.domain;


import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "driver")
@SQLDelete(sql = "UPDATE driver SET is_deleted=true, deleted_at=now() WHERE uuid=?")
@Where(clause = "is_deleted is false")
@Getter
@Setter
public class Driver {
	
	@Id
    private UUID uuid = UUID.randomUUID();

    @Size(min = 5, max = 10, message = "El tamaño del nombre no es correcto")
    private String name;

    @Email
    private String email;
  
    private String code;

    private Boolean isDeleted = Boolean.FALSE;
    
    private Boolean enabled = Boolean.TRUE;

    private LocalDateTime deletedAt;
   
    private String cellphone;

    @OneToOne(mappedBy = "driver", fetch = FetchType.LAZY)
    private Truck truck;

}
