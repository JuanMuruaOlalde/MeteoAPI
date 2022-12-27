package es.susosise.meteo_api;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class EndpointsApp_adaptador {

    @Autowired
    ParteMetereologico_servicios_modelo servicios;

    @GetMapping("/")
    public String MostrarLaPaginaInicial() {
        return "InterfazUsuarioGUI_infraestructura";
    }

    @GetMapping("ultimasConsultas-conApi")
    public String mostrarUltimasConsultas() {
        return "UltimasConsultas_conAPI_infraestructura";
    }

    @GetMapping("/ultimasConsultas")
    public String mostrarUltimasConsultas(Model model) {
        ArrayList<ParteMetereologico_dto_adaptador> resultados = new ArrayList<>();
        ArrayList<ParteMetereologico_entidad_modelo> partes = servicios.getLos10Ultimos();
        for (ParteMetereologico_entidad_modelo parte : partes) {
            resultados.add(new ParteMetereologico_dto_adaptador(parte.poblacion + " , " + parte.codigoPais,
                    parte.fecha, parte.temperatura_celsius, parte.humedad_porcentual, parte.vientoVelocidad_ms,
                    parte.vientoOrientacion_grados));
        }
        model.addAttribute("ultimosPartesConsultados", resultados);
        return "UltimasConsultas_conPaginaCompleta_infraestructura";
    }

}
