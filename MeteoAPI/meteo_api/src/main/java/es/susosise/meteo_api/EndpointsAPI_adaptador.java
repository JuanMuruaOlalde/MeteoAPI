package es.susosise.meteo_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class EndpointsAPI_adaptador {

@Autowired ParteMetereologico_servicios_modelo servicios;

    @GetMapping("/meteo")
    public ParteMetereologico_dto_adaptador obtenerDatosMetereologicos() {
        return servicios.ObtenerDatosMetereologicos("Arrasate", "ES");
    }
    
    
}
