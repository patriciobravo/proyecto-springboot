package cl.springboot.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.springboot.ms.domain.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
