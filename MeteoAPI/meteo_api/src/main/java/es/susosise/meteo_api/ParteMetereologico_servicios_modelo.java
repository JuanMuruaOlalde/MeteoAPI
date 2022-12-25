package es.susosise.meteo_api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParteMetereologico_servicios_modelo {

    @Autowired
    MisPropiedades mispropiedades;

    public ParteMetereologico_dto_adaptador ObtenerDatosMetereologicos(String poblacion, String codigoPais) {
        //_TODO_pendiente de implementar esta funcion.
        //se ha puesto esto provisional, con datos fijos, para tener algo que mostrar.
        ParteMetereologico_dto_adaptador parte = new ParteMetereologico_dto_adaptador();
        parte.temperatura_celsius = 5.0;
        parte.humedad_porcentual = 5.0;
        parte.velocidadDelViento_ms = 5.0;
        parte.orientacionDelViento_grados = 5;

        return parte;
    }
    
    @Autowired
    ParteMetereologico_persistencia_adaptador persistencia;

    public ParteMetereologico_servicios_modelo(ParteMetereologico_persistencia_adaptador persistencia) {
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
