package es.susosise.meteo_api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class EndpointsAPI_adaptador {

@Autowired ParteMetereologico_servicios_modelo servicios;

    @GetMapping("/meteo")
    public ParteMetereologico_dto_adaptador obtenerDatosMetereologicos(@PathParam("poblacion") String poblacion, @PathParam("codigoPais") String codigoPais) throws IOException, JSONException {
        return servicios.ObtenerDatosMetereologicos(poblacion, codigoPais);
    }
    
    
}
