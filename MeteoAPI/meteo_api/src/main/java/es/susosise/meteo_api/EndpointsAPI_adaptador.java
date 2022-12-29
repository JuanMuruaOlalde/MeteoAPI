package es.susosise.meteo_api;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class EndpointsAPI_adaptador {
    @Autowired
    ParteMetereologico_servicios_modelo servicios;

    @GetMapping("/meteo")
    public ParteMetereologico_dto_adaptador obtenerDatosMetereologicos(@PathParam("poblacion") String poblacion,
            @PathParam("codigoPais") String codigoPais)
            throws IOException, JSONException, URISyntaxException, InterruptedException {
        return servicios.ObtenerDatosMetereologicos(poblacion, codigoPais);
    }

    @GetMapping("/meteo/ultimasConsultas")
    public ArrayList<ParteMetereologico_dto_adaptador> obtenerDatosHistoricos() {
        ArrayList<ParteMetereologico_dto_adaptador> resultados = new ArrayList<>();
        ArrayList<ParteMetereologico_entidad_modelo> partes = servicios.getLos10Ultimos();
        for (ParteMetereologico_entidad_modelo parte : partes) {
            resultados.add(new ParteMetereologico_dto_adaptador(parte.poblacion + " , " + parte.codigoPais,
                    parte.fecha, parte.temperatura_celsius, parte.humedad_porcentual, parte.vientoVelocidad_ms,
                    parte.vientoOrientacion_grados));
        }
        return resultados;
    }

}
