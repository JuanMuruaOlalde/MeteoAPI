package es.susosise.meteo_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.type.jakartajson.JsonBJsonFormatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.configurationprocessor.json.JSONTokener;
import org.springframework.stereotype.Service;

@Service
public class ParteMetereologico_servicios {

    @Autowired
    ParteMetereologico_persistencia persistencia;

    @Autowired
    MisPropiedades mispropiedades;

    public ParteMetereologico_servicios(ParteMetereologico_persistencia persistencia) {
        this.persistencia = persistencia;
    }

    public ParteMetereologico_dto ObtenerDatosMetereologicos(String poblacion, String codigoPais)
            throws IOException, JSONException, URISyntaxException, InterruptedException {
        Coordenadas_dto coordenadas = getGeolocalizacion(poblacion, codigoPais);
        if (coordenadas != null) {
            ParteMetereologico_dto parteMetereologico = getMetereologia(coordenadas);
            parteMetereologico.setFecha(new Date());
            parteMetereologico.setUbicacion(poblacion + " , " + codigoPais);
            ParteMetereologico_entidad paraGuardar = new ParteMetereologico_entidad();
            paraGuardar.setPoblacion(poblacion);
            paraGuardar.setCodigoPais(codigoPais);
            paraGuardar.setTemperatura_celsius(parteMetereologico.getTemperatura_celsius());
            paraGuardar.setHumedad_porcentual(parteMetereologico.getHumedad_porcentual());
            paraGuardar.setVientoVelocidad_ms(parteMetereologico.getVelocidadDelViento_ms());
            paraGuardar.setVientoOrientacion_grados(parteMetereologico.getOrientacionDelViento_grados());
            guardar(paraGuardar);
            return parteMetereologico;
        }
        return null;
    }

    public ArrayList<ParteMetereologico_entidad> getLos10Ultimos() {
        ArrayList<ParteMetereologico_entidad> partes = (ArrayList<ParteMetereologico_entidad>) persistencia
                .findTop10ByOrderByFechaDesc();
        if (partes.size() == 0) {
            partes = ParteMetereologico_entidad.getPartesParaPruebas();
        }
        return partes;
    }

    public Long getCuantosHayAlmacenados() {
        return persistencia.count();
    }

    public List<ParteMetereologico_entidad> getTodas() {
        return persistencia.findAll();
    }

    public Object buscarPorIdentificador(Long idInterno) {
        Optional<ParteMetereologico_entidad> parteMeteorologico = persistencia.findById(idInterno);
        if (parteMeteorologico.isPresent()) {
            return parteMeteorologico.get();
        } else {
            return new ParteMetereologico_entidad();
        }
    }

    public void guardar(ParteMetereologico_entidad parteMeteorologico) {
        persistencia.save(parteMeteorologico);
    }

    public void eliminar(ParteMetereologico_entidad parteMeteorologico) {
        persistencia.delete(parteMeteorologico);
    }

    private Coordenadas_dto getGeolocalizacion(String poblacion, String codigoPais)
            throws IOException, JSONException, URISyntaxException, InterruptedException {
        // nota: Utiliza un servicio de OpenWeather
        // https://openweathermap.org/api/geocoding-api
        URL urlGeolocalizacion = new URL("http://api.openweathermap.org/geo/1.0/direct"
                + "?q=" + poblacion + "," + codigoPais
                + "&appid=" + mispropiedades.getWeatherAPIkey());
        String datosTexto = llamarALaApiYObtenerRespuesta_deLaFormaModerna(urlGeolocalizacion);
        JSONArray datos = (JSONArray) new JSONTokener(datosTexto).nextValue();
        JSONObject datosJson = datos.getJSONObject(0);
        String latitud = datosJson.getString("lat");
        String longitud = datosJson.getString("lon");
        return new Coordenadas_dto(latitud, longitud);
    }

    private ParteMetereologico_dto getMetereologia(Coordenadas_dto coordenadas)
            throws IOException, JSONException, URISyntaxException, InterruptedException {
        // nota: Utiliza un servicio de OpenWeather
        // https://openweathermap.org/current
        URL urlMetereologia = new URL("https://api.openweathermap.org/data/2.5/weather"
                + "?lat=" + coordenadas.getLatitud()
                + "&lon=" + coordenadas.getLongitud()
                + "&units=metric"
                + "&lang=es"
                + "&appid=" + mispropiedades.getWeatherAPIkey());
        String datosTexto = llamarALaApiYObtenerRespuesta_deLaFormaModerna(urlMetereologia);
        // JSONArray datos = (JSONArray) new JSONTokener(datosTexto).nextValue();
        JSONObject datosJson = (JSONObject) new JSONTokener(datosTexto).nextValue();
        Double temperaturaActual = datosJson.getJSONObject("main").getDouble("temp");
        Double humedadActual = datosJson.getJSONObject("main").getDouble("humidity");
        double vientoVelocidad = datosJson.getJSONObject("wind").getDouble("speed");
        Integer vientoDireccion = datosJson.getJSONObject("wind").getInt("deg");
        return new ParteMetereologico_dto(temperaturaActual, humedadActual, vientoVelocidad, vientoDireccion);
    }

    private String llamarALaApiYObtenerRespuesta_deLaFormaUniversal(URL url) throws IOException {
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");
        conexion.setConnectTimeout(3000);
        conexion.setReadTimeout(3000);
        int respuestaGCodigo = conexion.getResponseCode();
        if (respuestaGCodigo != HttpURLConnection.HTTP_OK) {
            BufferedReader receptor = new BufferedReader(new InputStreamReader(conexion.getErrorStream()));
            String unaLinea;
            StringBuffer respuestaError = new StringBuffer();
            while ((unaLinea = receptor.readLine()) != null) {
                respuestaError.append(unaLinea);
            }
            receptor.close();
            conexion.disconnect();
            return respuestaError.toString();
        } else {
            BufferedReader receptor = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String unaLinea;
            StringBuffer respuestaOk = new StringBuffer();
            while ((unaLinea = receptor.readLine()) != null) {
                respuestaOk.append(unaLinea);
            }
            receptor.close();
            conexion.disconnect();
            return respuestaOk.toString();
        }
    }

    private String llamarALaApiYObtenerRespuesta_deLaFormaModerna(URL url)
            throws IOException, URISyntaxException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest peticion = HttpRequest.newBuilder(url.toURI())
                .header("accept", "application/json")
                .build();
        HttpResponse<String> respuesta = cliente.send(peticion, BodyHandlers.ofString());
        return respuesta.body();
    }

}
