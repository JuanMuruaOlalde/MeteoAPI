package es.susosise.meteo_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;



@RestController
public class Meteo_endpointsAPI_adaptador {

//    @Autowired ParteMetereologico_entidad_modelo parteMeteorologico;
//    @Autowired Poblacion_entidad_modelo poblacion;

    @GetMapping("/meteo")
    public String obtenerDatosMetereologicos(Model model) {
        return "Hola, mundo";
    }
    
    
}
