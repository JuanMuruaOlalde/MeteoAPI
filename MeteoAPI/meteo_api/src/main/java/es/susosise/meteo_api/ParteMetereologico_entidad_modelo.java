package es.susosise.meteo_api;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="partes_metereologicos")
public class ParteMetereologico_entidad_modelo {
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

    public ParteMetereologico_entidad_modelo() {
        poblacion = "noPoblacion";
        codigoPais = "";
        fecha = new Date();
        temperatura_celsius = Double.NaN;
        humedad_porcentual = Double.NaN;
        vientoVelocidad_ms = Double.NaN;
        vientoOrientacion_grados = 0;
    }

    public ParteMetereologico_entidad_modelo(Long idInterno, String poblacion, String codigoPais, Date fecha, Double temperatura_celsius, Double humedad_porcentual, Double velocidadDelViento_ms, Integer orientacionDelViento_grados) {
        this.idInterno = idInterno;
        this.poblacion = poblacion;
        this.codigoPais = codigoPais;
        this.fecha = fecha;
        this.temperatura_celsius = temperatura_celsius;
        this.humedad_porcentual = humedad_porcentual;
        this.vientoVelocidad_ms = velocidadDelViento_ms;
        this.vientoOrientacion_grados = orientacionDelViento_grados;
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

    public void setOrientacionDelViento_grados(Integer orientacionDelViento_grados) {
        this.vientoOrientacion_grados = orientacionDelViento_grados;
    }

}
