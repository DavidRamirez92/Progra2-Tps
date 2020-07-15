package misImplementaciones.dinamico;

import misApis.ABBTDA;

public class ABB implements ABBTDA {
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

	public void agregar(int x) {
		if (r==null) {
			r=new Nodo();
			r.valor=x;
			r.der=new ABB();
			r.izq=new ABB();
			r.der.inicializarABB();
			r.izq.inicializarABB();
		}
		else if(x<raiz()) 
			this.hijoIzq().agregar(x);
		else if(x>raiz())
			this.hijoDer().agregar(x);
			
	}


	public void eliminar(int x) {
		if (r != null) { 
			if (r.valor == x && r.izq.arbolVacio() && r.der.arbolVacio()) {
				r = null; 
			} 
			else {if (r.valor == x && !r.izq.arbolVacio() ) {
				r.valor = this.maximo(r.izq); 
				r.izq.eliminar(r.valor);
			} else {if (r.valor == x && r.izq.arbolVacio()) {
				r.valor = this .minimo(r.der);
				r.der.eliminar(r.valor); 
			} else {if (r.valor < x){ 
				r.der.eliminar(x);
			} else{ 
				r.izq.eliminar(x); 
			} 
			}

			}
			}
		}
	}

	public boolean arbolVacio() {
		return (r == null);
	}

	private int minimo(ABBTDA a) {
		if (a.hijoIzq().arbolVacio())
			return a.raiz();
		else
			return minimo(a.hijoIzq());
	}

	private int maximo(ABBTDA a) {
		if (a.hijoDer().arbolVacio())
			return a.raiz();
		else
			return maximo(a.hijoDer());
	}
}
