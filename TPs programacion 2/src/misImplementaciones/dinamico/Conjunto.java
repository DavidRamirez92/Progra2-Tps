package misImplementaciones.dinamico;

import misApis.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
 class Nodo{
	 int valor;
	 Nodo sig;
 }
 Nodo inicio;
	public void inicializarConjunto() {
		inicio=null;

	}

	public void agregar(int x) {
		if(!this.pertenece(x)) {
			Nodo nuevo=new Nodo();
			nuevo.valor=x;
			nuevo.sig=inicio;
			inicio=nuevo;
		}

	}

	public void sacar(int x) {
		if(inicio!=null) {
			if(inicio.valor==x) {
				inicio=inicio.sig;
			}else {
				Nodo aux=inicio;
				while(aux.sig!=null&&aux.sig.valor!=x)
					aux=aux.sig;
				if(aux.sig!=null) 
					aux.sig=aux.sig.sig;
			}
		}

	}

	public int elegir() {
		return inicio.valor;
	}

	public boolean conjuntoVacio() {
		return(inicio==null);
	}

	public boolean pertenece(int x) {
		Nodo aux=inicio;
		while(aux!=null&&aux.valor!=x) 
			aux=aux.sig;
		return (aux!=null);
	}

}
