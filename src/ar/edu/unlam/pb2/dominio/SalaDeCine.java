package ar.edu.unlam.pb2.dominio;

public class SalaDeCine {
	private Persona[][] butacas;

	public SalaDeCine(Integer filas, Integer columnas) {
		this.butacas = new Persona[filas][columnas];
	}

	public Boolean consultarSiLaButacaEstaOcupada(Integer fila, Integer butaca) {
		if (butacas[fila][butaca] == null) {
			return false;
		}

		return true;
	}

	public void ocuparButaca(Integer fila, Integer butaca, Persona persona) {
		if (!consultarSiLaButacaEstaOcupada(fila, butaca)) {
			butacas[fila][butaca] = persona;

		}
	}

	public Integer cantidadDeButacasOcupadas() {
		Integer ocupadas = 0;
		for (int f = 0; f < butacas.length; f++) {
			for (int c = 0; c < butacas[f].length; c++) {
				if (butacas[f][c] != null) {
					ocupadas++;
				}
			}
		}
		return ocupadas;
	}

	public Boolean hayEspacioPara(Integer cantidad) {
		Integer contiguas = 0;
		for (int f = 0; f < butacas.length; f++) {
			for (int c = 0; c < butacas[f].length; c++) {
				if ((butacas[f][c] == null && c + 1 < butacas[f].length)
						|| (contiguas == cantidad - 1 && butacas[f][c] == null)) {
					contiguas++;
					if (contiguas == cantidad) {
						return true;
					}
				} else {
					contiguas = 0;
				}
			}
		}
		return false;
	}

}
