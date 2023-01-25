package es.susosise.meteo_api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class EndpointsApp {

    @Autowired
    ParteMetereologico_servicios servicios;

    @GetMapping("/")
    public String MostrarLaPaginaInicial() {
        return "PaginaPrincipal_conAPI";
    }

    @GetMapping("/ultimasConsultas-conApi")
    public String mostrarUltimasConsultas() {
        return "UltimasConsultas_conAPI";
    }

    @GetMapping("/PaginaCompleta")
    public String MostrarPaginaInicial(Model model) {
        Poblacion_dto unaPoblacion = new Poblacion_dto("", "es");
        model.addAttribute("poblacionAConsultar", unaPoblacion);
        return "PaginaPrincipal_conPaginaCompleta";
    }

    @PostMapping("/PaginaCompleta")
    public String ProcesarAccionesDeLaPaginaInicial(String action,
            @ModelAttribute("poblacionAConsultar") Poblacion_dto poblacionAConsultar, Model model)
            throws IOException, JSONException, URISyntaxException, InterruptedException {
        ParteMetereologico_dto parte = servicios
                .ObtenerDatosMetereologicos(poblacionAConsultar.getPoblacion(), poblacionAConsultar.getCodigoPais());
        model.addAttribute("temperatura_celsius", parte.temperatura_celsius);
        model.addAttribute("humedad_porcentual", parte.humedad_porcentual);
        model.addAttribute("velocidadDelViento_ms", parte.velocidadDelViento_ms);
        model.addAttribute("orientacionDelViento_grados", parte.orientacionDelViento_grados);
        return "PaginaPrincipal_conPaginaCompleta";
    }

    @GetMapping("/ultimasConsultas-conPaginaCompleta")
    public String mostrarUltimasConsultas(Model model) {
        ArrayList<ParteMetereologico_dto> resultados = new ArrayList<>();
        ArrayList<ParteMetereologico_entidad> partes = servicios.getLos10Ultimos();
        for (ParteMetereologico_entidad parte : partes) {
            resultados.add(new ParteMetereologico_dto(parte.poblacion + " , " + parte.codigoPais,
                    parte.fecha, parte.temperatura_celsius, parte.humedad_porcentual, parte.vientoVelocidad_ms,
                    parte.vientoOrientacion_grados));
        }
        model.addAttribute("ultimosPartesConsultados", resultados);
        return "UltimasConsultas_conPaginaCompleta";
    }

}
