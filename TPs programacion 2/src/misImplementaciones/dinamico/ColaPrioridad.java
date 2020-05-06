package misImplementaciones.dinamico;

import misApis.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
	class Nodo{
		int p,v;
		Nodo sig;
	}
	Nodo inicio;
	public void inicializarColaPrioridad() {
		inicio=null;

	}

	public void acolarPrioridad(int x, int p) {
		Nodo ant=null, actual=inicio;
		while(actual!=null&&actual.p>=p) {
			ant=actual;
			actual=actual.sig;
		}
		Nodo nuevo=new Nodo();
		nuevo.p=p;
		nuevo.v=x;
		if(ant==null) {
			nuevo.sig=inicio;
			inicio=nuevo;
		}else {
			nuevo.sig=actual;
			ant.sig=nuevo;
		}

	}

	public void desacolar() {
		inicio=inicio.sig;

	}

	public int primero() {
		return inicio.v;
	}


	public int prioridad() {
		return inicio.p;
	}

	public boolean colaVacia() {
		return(inicio==null);
	}

}
