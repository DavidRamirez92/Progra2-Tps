package misImplementaciones.dinamico;

import misApis.ABBTDA;
import misImplementaciones.dinamico.ABB.Nodo;

public class AVL implements ABBTDA {

	class Nodo{
		int valor;
		ABBTDA der,izq;
	}
	Nodo r;

		public void inicializarABB() {
			r=null;

		}

		public int raiz() {
			return r.valor;
		}

		public ABBTDA hijoDer() {
			return r.der;
		}

		public ABBTDA hijoIzq() {
			return r.izq;
		}

	@Override
	public void agregar(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean arbolVacio() {
		// TODO Auto-generated method stub
		return false;
	}

}
