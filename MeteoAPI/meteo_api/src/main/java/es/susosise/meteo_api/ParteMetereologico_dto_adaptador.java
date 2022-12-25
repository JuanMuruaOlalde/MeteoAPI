package es.susosise.meteo_api;

public class ParteMetereologico_dto_adaptador {
    Double temperatura_celsius;
    Double humedad_porcentual;
    Double velocidadDelViento_ms;
    Integer orientacionDelViento_grados;


    public ParteMetereologico_dto_adaptador() {
    }

    public ParteMetereologico_dto_adaptador(Double temperatura_celsius, Double humedad_porcentual, Double velocidadDelViento_ms, Integer orientacionDelViento_grados) {
        this.temperatura_celsius = temperatura_celsius;
        this.humedad_porcentual = humedad_porcentual;
        this.velocidadDelViento_ms = velocidadDelViento_ms;
        this.orientacionDelViento_grados = orientacionDelViento_grados;
    }

    public Double getTemperatura_celsius() {
        return this.temperatura_celsius;
    }

    public void setTemperatura_celsius(Double temperatura_celsius) {
        this.temperatura_celsius = temperatura_celsius;
    }

    public Double getHumedad_porcentual() {
        return this.humedad_porcentual;
    }

    public void setHumedad_porcentual(Double humedad_porcentual) {
        this.humedad_porcentual = humedad_porcentual;
    }

    public Double getVelocidadDelViento_ms() {
        return this.velocidadDelViento_ms;
    }

    public void setVelocidadDelViento_ms(Double velocidadDelViento_ms) {
        this.velocidadDelViento_ms = velocidadDelViento_ms;
    }

    public Integer getOrientacionDelViento_grados() {
        return this.orientacionDelViento_grados;
    }

    public void setOrientacionDelViento_grados(Integer orientacionDelViento_grados) {
        this.orientacionDelViento_grados = orientacionDelViento_grados;
    }

}
