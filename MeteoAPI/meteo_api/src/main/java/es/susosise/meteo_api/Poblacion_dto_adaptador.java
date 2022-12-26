package es.susosise.meteo_api;

public class Poblacion_dto_adaptador {
    private String poblacion;
    private String codigoPais;


    public Poblacion_dto_adaptador() {
    }

    public Poblacion_dto_adaptador(String poblacion, String codigoPais) {
        this.poblacion = poblacion;
        this.codigoPais = codigoPais;
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

}
