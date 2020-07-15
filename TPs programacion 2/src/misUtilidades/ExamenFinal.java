package misUtilidades;

import misApis.ABBTDA;
import misApis.ColaPrioridadTDA;
import misApis.ColaTDA;
import misApis.ConjuntoTDA;
import misApis.GrafoTDA;
import misApis.PilaTDA;
import misImplementaciones.dinamico.Cola;
import misImplementaciones.dinamico.ColaPrioridad;
import misImplementaciones.dinamico.Pila;

public class ExamenFinal {
	class NodoLibreta{
		int nroLibreta;
		NodoLibreta sigLibreta;
		NodoNotas inicioNotas;
	}
	class NodoNotas{
		int nota;
		NodoNotas sigNota;
	}
	NodoLibreta inicioLibreta;
	public void inicializarLibreta() {
		inicioLibreta=null;
	}
	//precondicion: el nodo buscado existe
	public int profundidadArbol(ABBTDA arbol,int valor) {
		if(arbol.raiz()==valor) {
			return 1;

		}else {
			if(valor>arbol.raiz()) {
				return 1+profundidadArbol(arbol.hijoDer(),valor);
			}else {
				return 1+profundidadArbol(arbol.hijoIzq(),valor);
			}
		}

	}

	public void verticesOrdenados(GrafoTDA grafo) {
		ConjuntoTDA vertices=grafo.vertices();
		ColaPrioridadTDA cola=new ColaPrioridad();
		cola.inicializarColaPrioridad();
		PilaTDA pila=new Pila();
		pila.inicializarPila();
		int elemento;
		while(!vertices.conjuntoVacio()) {
			elemento=vertices.elegir();
			vertices.sacar(elemento);
			cola.acolarPrioridad(1, elemento);

		}
		while(!cola.colaVacia()) {
			pila.apilar(cola.prioridad());
			cola.desacolar();
		}
		while(!pila.pilaVacia()) {
			System.out.println(pila.tope());
			pila.desapilar();
		}
	}
	
	private NodoLibreta buscarClave(int libreta) {
		NodoLibreta actual=inicioLibreta;
		while(actual!=null&&actual.nroLibreta!=libreta)
			actual=actual.sigLibreta;
		return actual;
	}
	private NodoNotas buscarValor(NodoNotas inicio,int x) {
		NodoNotas notaActual=inicio;
		while(notaActual!=null&&notaActual.nota!=x)
			notaActual=notaActual.sigNota;
		return notaActual;	
	}
	public void agregar(int clave, int valor) {//Lineal
		NodoLibreta actualLibreta=buscarClave(clave);
		if(actualLibreta==null) {
			NodoLibreta nuevaLibreta=new NodoLibreta();
			nuevaLibreta.nroLibreta=clave;
			nuevaLibreta.inicioNotas=null;
			nuevaLibreta.sigLibreta=inicioLibreta;
			inicioLibreta=nuevaLibreta;
			actualLibreta=nuevaLibreta;
		}
		NodoNotas actualValor=buscarValor(actualLibreta.inicioNotas,valor);
			if(actualValor==null) {
				NodoNotas nuevoValor=new NodoNotas();
				nuevoValor.nota=valor;
				nuevoValor.sigNota=actualLibreta.inicioNotas;
				actualLibreta.inicioNotas=nuevoValor;
				
			}
		}

}
