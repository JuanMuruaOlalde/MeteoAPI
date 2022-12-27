package es.susosise.meteo_api;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MeteoApiApplicationTests {

	@Autowired
	ParteMetereologico_servicios_modelo servicios;

	@Test
	void tenemosPartesMetereologicosParaPruebas() {
		ArrayList<ParteMetereologico_entidad_modelo> partes = ParteMetereologico_entidad_modelo.getPartesParaPruebas();
		assertTrue(partes.size() > 0);
	}

	@Test
	void laListaDePartesRecientesDevuelveSiempreAlgo_AlMenosLosDePrueba() {
		ArrayList<ParteMetereologico_entidad_modelo> partes = servicios.getLos10Ultimos();
		assertTrue(partes.size() > 0);
	}

}
