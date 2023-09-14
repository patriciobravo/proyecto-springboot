package cl.springboot.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.springboot.ms.domain.OrderProduct;

import java.util.Optional;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    Optional<Object> findByIdOrderProduct(long idOrderProduct);
}
