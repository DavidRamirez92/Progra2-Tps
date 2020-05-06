package misImplementaciones.dinamico;

import misApis.ColaTDA;

public class Cola implements ColaTDA {
  class Nodo{
	  int valor;
	  Nodo sig;
  }

Nodo inicio,ult;
	
	public void inicializarCola() {
		inicio=ult=null;

	}

	public void acolar(int x) {//Costo Constante
		Nodo nuevo=new Nodo();
		nuevo.valor=x;
		nuevo.sig=null;
		if(ult==null) 
			ult.sig=nuevo;
		ult=nuevo;
		if(inicio==null)
			inicio=ult;
	
	
        
	}
	
	public void desacolar() {//Costo Constante
		inicio=inicio.sig;
		if(inicio==null) {
			ult=null;
		}

	}

	public int primero() {//Costo Constante
		return inicio.valor;
	}

	public boolean colaVacia() {//costo constante
		return ult==null;
	}

}
