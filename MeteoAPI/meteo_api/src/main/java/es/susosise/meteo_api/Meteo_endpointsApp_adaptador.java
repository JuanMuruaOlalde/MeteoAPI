package es.susosise.meteo_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;



@Controller
public class Meteo_endpointsApp_adaptador {

//    @Autowired ParteMetereologico_entidad_modelo parteMeteorologico;
//    @Autowired Poblacion_entidad_modelo poblacion;

    @GetMapping("/")
    public String MostrarLaPaginaInicial(Model model) {
        return "meteo_GUI_infraestructura";
    }
    
    
}
