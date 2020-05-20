package misImplementaciones.estatico;

import misApis.ConjuntoTDA;

public class ConjuntoUniversoAcotado implements ConjuntoTDA {
	boolean[]vector;
	int cantidad;

	public void inicializarConjunto() {
		vector = new boolean[100];
		for (int i=0; i<= 100; i++)
			vector[i] = false;
	}

	public void agregar(int valor) {
		if(!this.pertenece(valor)) {
			vector[valor-1] = true;
			cantidad++;
		}
	}

	public void sacar(int valor) {
		if(this.pertenece(valor)) {
			vector[valor] = false;
		}
	}

	public int elegir() {
		int i;
		for (i = 0; i <= 100; i++) {
			if (vector[i])
				break;
		}
		return i;
	}

	public boolean conjuntoVacio() {
		int i;
		for (i = 0; i <= 100; i++) {
			if (vector[i])
				return false;
		}
		return true;
	}

	public boolean pertenece(int valor) {
		return vector[valor];
	}

}
