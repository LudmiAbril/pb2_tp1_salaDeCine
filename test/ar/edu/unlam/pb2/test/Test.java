package ar.edu.unlam.pb2.test;

import static org.junit.Assert.*;

import ar.edu.unlam.pb2.dominio.Persona;
import ar.edu.unlam.pb2.dominio.SalaDeCine;

public class Test {

	@org.junit.Test
	public void queLaSalaEsteVacia() {
		Integer filas = 10;
		Integer butacas = 8;
		SalaDeCine sala = new SalaDeCine(filas, butacas);

		Integer esperado = 0;
		Integer obtenido = sala.cantidadDeButacasOcupadas();

		assertEquals(esperado, obtenido);
	}

	@org.junit.Test
	public void verificarQueUnaButacaEsteOcupada() {
		Integer filas = 10;
		Integer butacas = 8;
		SalaDeCine sala = new SalaDeCine(filas, butacas);
		Persona persona = new Persona();

		assertFalse(sala.consultarSiLaButacaEstaOcupada(2, 3));
	}

	@org.junit.Test
	public void verificarQueSePuedaOcuparUnaButaca() {
		Integer filas = 10;
		Integer butacas = 8;
		SalaDeCine sala = new SalaDeCine(filas, butacas);
		Persona persona = new Persona();
		sala.ocuparButaca(2, 5, persona);

		assertTrue(sala.consultarSiLaButacaEstaOcupada(2, 5));
	}

	@org.junit.Test
	public void verificarTotalDeButacasOcupadas() {
		Integer filas = 10;
		Integer butacas = 8;
		SalaDeCine sala = new SalaDeCine(filas, butacas);
		Persona persona = new Persona();
		sala.ocuparButaca(2, 5, persona);
		sala.ocuparButaca(4, 5, persona);
		sala.ocuparButaca(1, 5, persona);

		Integer deseada = 3;
		Integer obtenida = sala.cantidadDeButacasOcupadas();

		assertEquals(deseada, obtenida);
	}
	
	@org.junit.Test
	public void consultarSiSePuedeAcomodarUnGrupoEnFila() {
		Integer filas = 10;
		Integer butacas = 8;
		SalaDeCine sala = new SalaDeCine(filas, butacas);

		assertTrue(sala.hayEspacioPara(5));
	}

}
