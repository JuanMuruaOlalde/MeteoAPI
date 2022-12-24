package es.susosise.meteo_api;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="poblaciones")
public class Poblacion_entidad_modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="poblacion_id")
    private Long idInterno;

    String nombre;
    String codigoPais;

    public Poblacion_entidad_modelo() {
    }

    public Poblacion_entidad_modelo(Long idInterno, String nombre, String codigoPais) {
        this.idInterno = idInterno;
        this.nombre = nombre;
        this.codigoPais = codigoPais;
    }

    public Long getIdInterno() {
        return idInterno;
    }

    public void setIdInterno(Long idInterno) {
        this.idInterno = idInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

}
