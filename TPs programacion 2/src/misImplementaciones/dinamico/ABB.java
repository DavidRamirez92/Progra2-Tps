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
		else if(x<raiz()) {
			this.hijoIzq().agregar(x);
		}else
			this.hijoDer().agregar(x);
			
	}


	public void eliminar(int x) {
		if (!this.arbolVacio()) {
			if (r.valor == x) {// encontro valor
				if (r.der == null && r.izq == null) {// es hoja
					r = null;// elimina valor
				} else {// no es hoja
					if (!r.der.arbolVacio()) {
						int a = minimo(r.der);
						r.valor = a;
						r.der.eliminar(a);
					} else {
						int a = maximo(r.izq);
						r.valor = a;
						r.izq.eliminar(a);
					}

				}
			} else {
				if (r.valor > x) {
					r.der.eliminar(x);
				} else {
					r.izq.eliminar(x);

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
