package cl.springboot.ms.interceptor_filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("Interceptor")
public class FirstInterceptor implements HandlerInterceptor {

    private final Logger log = LoggerFactory.getLogger(FirstInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("Escribiendo mensaje desde preHandle() del interceptor...");
        log.info("Request: {}", request.getRequestURI());
        log.info("Metodo de la peticion: {}", request.getMethod());


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // Nos permite modificar el response, hasta el modelView
        // HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);

        log.info("Escribiendo mensaje desde postHandle() del interceptor...");
        log.info("Request: {}", request.getRequestURI());
        log.info("Metodo de la peticion: {}", request.getMethod());
    }
}
