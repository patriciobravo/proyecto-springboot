package cl.springboot.ms.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfig {
	
	 @Bean
	    public OpenAPI myOpenAPI() {

	        Server devServer = new Server();
	        devServer.setUrl("http://localhost:8080/");
	        devServer.setDescription("URL del servidor Local de proyecto SpringBoot");

	        Server prodServer = new Server();
	        prodServer.setUrl("https://escalab.com");
	        prodServer.setDescription("URL del servidor en Produccion");

	        Contact contact = new Contact();
	        contact.setEmail("patricio.andres21@gmail.com");
	        contact.setName("Patricio");
	        contact.setUrl("https://www.escalab.com");

	        Info info = new Info()
	                .title("Proyecto SpringBoot API")
	                .version("1.0")
	                .contact(contact)
	                .description("Documento que expone las APIs construida para proyecto de curso de Spring Boot")
	                .termsOfService("https://www.escalab.com/terms");

	        return new OpenAPI()
	                .info(info)
	                .servers(List.of(devServer, prodServer));
	    }

	    @Bean
	    public ModelResolver modelResolver(ObjectMapper objectMapper) {

	        return new ModelResolver(objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE));
	    }

}
