package es.susosise.meteo_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MisPropiedades.class)
public class MeteoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeteoApiApplication.class, args);
	}

}
