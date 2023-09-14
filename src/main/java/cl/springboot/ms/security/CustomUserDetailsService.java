package cl.springboot.ms.security;

import cl.springboot.ms.exception.NotFoundException;
import cl.springboot.ms.exception.DomainExceptionCode;
import cl.springboot.ms.repository.UserAuthenticationRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CustomUserDetailsService {

    private UserAuthenticationRepository userAuthenticationRepository;

    public UserDetailsService getUserDetailsService() {

        return new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

                return userAuthenticationRepository.findByEmail(username)
                        .orElseThrow( () -> new NotFoundException(DomainExceptionCode.DRIVER_NOT_FOUND) );
            }
        };
    }
}
