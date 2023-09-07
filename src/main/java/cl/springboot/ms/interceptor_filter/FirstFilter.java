package cl.springboot.ms.interceptor_filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
@Order(1)
public class FirstFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(FirstFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);

        log.info("************** Desde el metodo init() del filtro");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("************** Desde el metodo doFilter() del filtro");

        filterChain.doFilter(servletRequest, servletResponse);

        log.info("************** Finalizacion desde el metodo doFilter() del filtro");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();

        log.info("************** Desde el metodo destroy() del filtro");
    }
}
