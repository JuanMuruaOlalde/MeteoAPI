package es.susosise.meteo_api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Meteo_persistencia_adaptador {
    
    @Autowired
    Meteo_persistencia_infraestructura persistencia;

    public Meteo_persistencia_adaptador(Meteo_persistencia_infraestructura persistencia) {
        this.persistencia = persistencia;
    }
    
    public Long getCuantasHay() {
        return persistencia.count();
    }
    
    public List<ParteMetereologico_entidad_modelo> getTodas() {
        return persistencia.findAll();
    }
    
   
    public Object buscarPorIdentificador(Long idInterno) {
        Optional<ParteMetereologico_entidad_modelo> parteMeteorologico = persistencia.findById(idInterno);
        if (parteMeteorologico.isPresent()) {
            return parteMeteorologico.get();
        } else {
            return new ParteMetereologico_entidad_modelo();
        }
    }
    
    public void guardar(ParteMetereologico_entidad_modelo parteMeteorologico) {
            persistencia.save(parteMeteorologico);
    }
    
    public void eliminar(ParteMetereologico_entidad_modelo parteMeteorologico) {
        persistencia.delete(parteMeteorologico);
    }

 
}
