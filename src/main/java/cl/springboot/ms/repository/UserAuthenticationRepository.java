package cl.springboot.ms.repository;

import cl.springboot.ms.domain.Driver;
import cl.springboot.ms.domain.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserAuthenticationRepository extends CrudRepository<UserAuthentication, Long> {

    Optional<UserAuthentication> findByEmail(String email);
}
