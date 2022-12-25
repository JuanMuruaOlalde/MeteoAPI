package es.susosise.meteo_api;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mispropiedades")
public class MisPropiedades {

    private String weatherAPIkey;

    public String getWeatherAPIkey() {
        return this.weatherAPIkey;
    }

    public void setWeatherAPIkey(String weatherAPIkey) {
        this.weatherAPIkey = weatherAPIkey;
    }

}
