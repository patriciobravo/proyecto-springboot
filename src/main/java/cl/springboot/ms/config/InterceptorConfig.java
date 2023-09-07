package cl.springboot.ms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import cl.springboot.ms.interceptor_filter.FirstInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private FirstInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(interceptor);
    }
}
