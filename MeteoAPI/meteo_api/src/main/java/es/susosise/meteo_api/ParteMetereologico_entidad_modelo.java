package es.susosise.meteo_api;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="partes_metereologicos")
public class ParteMetereologico_entidad_modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="parte_id")
    private Long idInterno;

    String poblacion;
    Date fecha;
    Double temperatura_celsius;
    Double humedad_porcentual;

    public ParteMetereologico_entidad_modelo() {
        fecha =  new Date();
        temperatura_celsius = Double.NaN;
        humedad_porcentual = Double.NaN;
    }


    public ParteMetereologico_entidad_modelo(Long idInterno, String poblacion, Date fecha, Double temperatura_celsius, Double humedad_porcentual) {
        this.idInterno = idInterno;
        this.poblacion = poblacion;
        this.fecha = fecha;
        this.temperatura_celsius = temperatura_celsius;
        this.humedad_porcentual = humedad_porcentual;
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

}
