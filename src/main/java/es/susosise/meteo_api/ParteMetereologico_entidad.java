package es.susosise.meteo_api;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "partes_metereologicos")
public class ParteMetereologico_entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInterno;

    String poblacion;
    String codigoPais;
    Date fecha;
    Double temperatura_celsius;
    Double humedad_porcentual;
    Double vientoVelocidad_ms;
    Integer vientoOrientacion_grados;

    public ParteMetereologico_entidad() {
        poblacion = "noPoblacion";
        codigoPais = "";
        fecha = new Date();
        temperatura_celsius = Double.NaN;
        humedad_porcentual = Double.NaN;
        vientoVelocidad_ms = Double.NaN;
        vientoOrientacion_grados = 0;
    }

    public ParteMetereologico_entidad(Long idInterno,
            String poblacion, String codigoPais,
            Date fecha,
            Double temperatura_celsius, Double humedad_porcentual,
            Double velocidadDelViento_ms, Integer vientoOrientacion_grados) {
        this.idInterno = idInterno;
        this.poblacion = poblacion;
        this.codigoPais = codigoPais;
        this.fecha = fecha;
        this.temperatura_celsius = temperatura_celsius;
        this.humedad_porcentual = humedad_porcentual;
        this.vientoVelocidad_ms = velocidadDelViento_ms;
        this.vientoOrientacion_grados = vientoOrientacion_grados;
    }

    public Long getIdInterno() {
        return this.idInterno;
    }

    public void setIdInterno(Long idInterno) {
        this.idInterno = idInterno;
    }

    public String getPoblacion() {
        return this.poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCodigoPais() {
        return this.codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Double getVientoVelocidad_ms() {
        return this.vientoVelocidad_ms;
    }

    public void setVientoVelocidad_ms(Double velocidadDelViento_ms) {
        this.vientoVelocidad_ms = velocidadDelViento_ms;
    }

    public Integer getVientoOrientacion_grados() {
        return this.vientoOrientacion_grados;
    }

    public void setVientoOrientacion_grados(Integer vientoOrientacion_grados) {
        this.vientoOrientacion_grados = vientoOrientacion_grados;
    }

    public static ArrayList<ParteMetereologico_entidad> getPartesParaPruebas() {
        ArrayList<ParteMetereologico_entidad> partes = new ArrayList<>();
        ParteMetereologico_entidad parte01 = new ParteMetereologico_entidad(1L, "Bilbao", "ES",
                new Date(), 18.3, 46.2, 3.9, 333);
        partes.add(parte01);
        ParteMetereologico_entidad parte02 = new ParteMetereologico_entidad(2L, "Santander", "ES",
                new Date(), 19.7, 45.2, 2.5, 333);
        partes.add(parte02);
        ParteMetereologico_entidad parte03 = new ParteMetereologico_entidad(3L, "Albacete", "ES",
                new Date(), 27.3, 21.8, 1.3, 125);
        partes.add(parte03);
        ParteMetereologico_entidad parte04 = new ParteMetereologico_entidad(4L, "Sevilla", "ES",
                new Date(), 31.7, 32.2, 2.5, 78);
        partes.add(parte04);

        return partes;
    }

}
