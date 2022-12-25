package es.susosise.meteo_api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;



@Controller
public class EndpointsAplicacion_adaptador {


    @GetMapping("/")
    public String MostrarLaPaginaInicial(Model model) {
        return "meteo_GUI_infraestructura";
    }
    
    
}
