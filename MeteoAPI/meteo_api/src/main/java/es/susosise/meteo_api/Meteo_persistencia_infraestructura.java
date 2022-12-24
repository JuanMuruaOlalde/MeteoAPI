package es.susosise.meteo_api;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Meteo_persistencia_infraestructura extends JpaRepository<ParteMetereologico_entidad_modelo, Long> {
    //nota: No es necesario proveer una implementación explícita para este interfaz
    //      porque ya lo hace Spring Boot, proporcionando una implementación por defecto basada en SimpleJpaRepository
    //      ( https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository.html )

    //También se pueden añadir ciertas nuevas funciones con solo definir sus signaturas, Spring Boot se encarga de proporcionar su implementación.
    // (https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)

    
}