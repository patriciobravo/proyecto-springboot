package cl.springboot.ms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.springboot.ms.domain.Order;
import cl.springboot.ms.domain.StatusType;

public interface OrderRepository extends JpaRepository<Order, Long> {

	Optional<Order> findByIdOrderAndStatus(Long uuid, StatusType loaded);	

}

