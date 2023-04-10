package ar.edu.unlam.pb2.interfaz;

import java.util.Scanner;

import ar.edu.unlam.pb2.dominio.Persona;
import ar.edu.unlam.pb2.dominio.SalaDeCine;

public class SalaDeCineTest {

	private static final int CONSULTAR_SI_LA_SALA_ESTA_VACIA = 1;
	private static final int CONSULTAR_SI_UNA_BUTACA_ESTA_OCUPADA = 2;
	private static final int OCUPAR_BUTACA = 3;
	private static final int CONSULTAR_TOTAL_BUTACAS_OCUPADAS = 4;
	private static final int CONSULTAR_SI_HAY_ESPACIO_PARA_X_PERSONAS = 5;
	private static final int SALIR = 0;
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Integer filas, butacas, filaIngresada, butacaIngresada;
		Persona espectador = new Persona();

		filas = 10;
		butacas = 10;

		SalaDeCine cineSanJusto = new SalaDeCine(filas, butacas);

		System.out.println("Bienvenido a la sala de cine");

		int opcion;
		do {
			mostrarMenuPrincipal();
			opcion = teclado.nextInt();
			switch (opcion) {
			case CONSULTAR_SI_LA_SALA_ESTA_VACIA:
				mostrarEstadoDeSalaDeCine(cineSanJusto);
				break;
			case CONSULTAR_SI_UNA_BUTACA_ESTA_OCUPADA:
				filaIngresada = ingresarFila();
				butacaIngresada = ingresarButaca();
				consultarSiUnaButacaEstaOcupada(filaIngresada, butacaIngresada, cineSanJusto);
				break;
			case OCUPAR_BUTACA:
				// consulta primero arriba y vuelve para atras al menu principal para ocupar la
				// butaca
				filaIngresada = ingresarFila();
				butacaIngresada = ingresarButaca();
				cineSanJusto.ocuparButaca(filaIngresada, butacaIngresada, espectador);
				break;
			case CONSULTAR_TOTAL_BUTACAS_OCUPADAS:
				Integer totalButacasOcupadas = cineSanJusto.cantidadDeButacasOcupadas();
				System.out.println("\nTotal de butacas ocupadas: " + totalButacasOcupadas);
				break;
			case CONSULTAR_SI_HAY_ESPACIO_PARA_X_PERSONAS:
				consultarEspacioParaXPersonas(cineSanJusto);
				break;

			case SALIR:
				System.out.println("***Gracias por usar el sistema***");
				break;
			}
		} while (opcion != SALIR);

	}

	private static void mostrarMenuPrincipal() {

		System.out.println("\n\n********************************************");
		System.out.println("\n1- Consultar si la sala esta vacia");
		System.out.println("\n2- Consultar si una butaca esta ocupada");
		System.out.println("\n3- Ocupar butaca");
		System.out.println("\n4- Consultar total de butacas ocupadas");
		System.out.println("\n5- Consultar si hay espacio para x personas");
	}

	/**
	 * @param cineSanJusto
	 */
	private static void consultarEspacioParaXPersonas(SalaDeCine cineSanJusto) {
		System.out.println("\nIngrese la cantidad de personas");
		Integer cantidadDePersonasIngresadas = teclado.nextInt();
		Boolean hayEspacio = cineSanJusto.hayEspacioPara(cantidadDePersonasIngresadas);
		if (hayEspacio) {
			System.out.println(
					"***\nSe encontraron butacas contiguas para " + cantidadDePersonasIngresadas + " personas");
		} else {
			System.out.println(
					"\nNo se encontraron butacas contiguas para " + cantidadDePersonasIngresadas + " personas");
		}
	}

	/**
	 * @param filaIngresada
	 * @param butacaIngresada
	 * @param cineSanJusto
	 */
	private static void consultarSiUnaButacaEstaOcupada(Integer filaIngresada, Integer butacaIngresada,
			SalaDeCine cineSanJusto) {
		Boolean butacaOcupada = cineSanJusto.consultarSiLaButacaEstaOcupada(filaIngresada, butacaIngresada);
		if (butacaOcupada) {
			System.out.println(
					"\nLa butaca: " + butacaIngresada + " de la fila: " + filaIngresada + " se encuentra OCUPADA");
		} else {
			System.out.println(
					"\nLa butaca: " + butacaIngresada + " de la fila: " + filaIngresada + " se encuentra LIBRE");
		}
	}

	/**
	 * @return Integer
	 */
	private static Integer ingresarButaca() {
		System.out.println("\nIngrese la butaca");
		Integer butacaIngresada = teclado.nextInt();
		return butacaIngresada;
	}

	/**
	 * @return Integer
	 */
	private static Integer ingresarFila() {
		System.out.println("\nIngrese la fila");
		Integer filaIngresada = teclado.nextInt();
		return filaIngresada;
	}

	/**
	 * @param cine
	 */
	private static void mostrarEstadoDeSalaDeCine(SalaDeCine cine) {
		Boolean salaVacia = consultarSiLaSalaEstaVacia(cine);

		mostrarEstadoDeButacas(cine, salaVacia);
	}

	private static Boolean consultarSiLaSalaEstaVacia(SalaDeCine cineSanJusto) {
		Integer cantidadDeButacasOcupadas = cineSanJusto.cantidadDeButacasOcupadas();
		if (cantidadDeButacasOcupadas > 0) {
			return false;
		}
		return true;
	}

	private static void mostrarEstadoDeButacas(SalaDeCine cine, Boolean salaVacia) {
		Integer cantidadDeButacasOcupadas;
		if (salaVacia) {
			System.out.println("\nLa sala del Cine San Justo se encuentra vacia");

		} else {
			cantidadDeButacasOcupadas = cine.cantidadDeButacasOcupadas();
			System.out.println("\nSe encuentran ocupadas " + cantidadDeButacasOcupadas + " butacas");

		}
	}

}

