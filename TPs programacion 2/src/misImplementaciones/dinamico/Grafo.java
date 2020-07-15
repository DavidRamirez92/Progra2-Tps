package misImplementaciones.dinamico;

import misApis.ConjuntoTDA;
import misApis.GrafoTDA;

public class Grafo implements GrafoTDA {

	class NodoV{//vertice
		int et;//etiqueta
		NodoV sigV;
		NodoA inicio;
	}
	
	class NodoA{//arista
		int peso;
		NodoA sigA;
		NodoV dest;
	}
	
	NodoV inicio;

	@Override
	public void inicializarGrafo() {
		// TODO Auto-generated method stub
		inicio = null;
	}

	private NodoV posVertice(int v) {
		NodoV actual = inicio;
		
		while (actual.et != v)
			actual = actual.sigV;
		
		return actual;			
	}
	// precond. los vertices existen
	@Override
	public void agregarArista(int v1, int v2, int p) {
		
		NodoV verticeOrigen = posVertice(v1);
		NodoV verticeDestino = posVertice(v2);
		 NodoA actual = verticeOrigen.inicio;
		 while (actual!=null && actual.dest!=verticeDestino)
			 actual = actual.sigA;
		 if (actual==null) { // no existe arista
			 NodoA nuevo = new NodoA();
			 
			 nuevo.peso = p;
			 nuevo.dest = verticeDestino;
			 
			 nuevo.sigA = verticeOrigen.inicio;
			 verticeOrigen.inicio = nuevo;		 
		 }		
	}

	@Override // precond : la arista existe
	public void eliminarArista(int v1, int v2) {
		// TODO Auto-generated method stub
		
		NodoV verticeOrigen = posVertice(v1);
		NodoV verticeDestino = posVertice(v2);
		
		// busco el lugar de la arista
		NodoA ant = null , actual = verticeOrigen.inicio;
		while (actual.dest != verticeDestino) {
			ant = actual;
			actual = actual.sigA;
		}
		
		if (ant == null) { // si la arista es la primera de la lista
			verticeOrigen.inicio = verticeOrigen.inicio.sigA;
		} else {
			ant.sigA = actual.sigA;
		}

	}

	// precond. el vertice no debe existir
	@Override
	public void agregarVertice(int v) {
		// TODO Auto-generated method stub
		NodoV nuevo = new NodoV();
		
		nuevo.et =v;
		nuevo.inicio = null;
		
		nuevo.sigV = inicio;
		inicio = nuevo;

	}

	@Override
	public void eliminarVertice(int v) {
		NodoV actualV = inicio;
		NodoV vertDest = posVertice(v);
		
		while (actualV != null) { // para todos los vértices
			NodoA antA = null , actualA = actualV.inicio;
			
			while (actualA != null && actualA.dest != vertDest) {
				antA = actualA;
				actualA = actualA.sigA;
			}
			if (actualA != null) { // existe arista
				if ( antA == null) // 1er arista
					actualV.inicio = actualV.inicio.sigA;
				else
					antA.sigA = actualA.sigA;			
			}
			
			actualV = actualV.sigV;
		}
		 
		// elimino vertice V
		NodoV ant = null, actual = inicio;
		while(actual.et != v) {
			ant = actual;
			actual = actual.sigV;
		}
		if (ant == null)
			inicio = inicio.sigV;
		else
			ant.sigV = actual.sigV;
		

	}

	@Override
	public ConjuntoTDA vertices() {
		// TODO Auto-generated method stub
		ConjuntoTDA resultado = new Conjunto();
		resultado.inicializarConjunto();
		NodoV actual = inicio;
		while (actual != null) {
			resultado.agregar(actual.et);
			actual = actual.sigV;
		}
		return resultado;
	}

	@Override
	public boolean existeArista(int v1, int v2) {
		NodoV verticeOrigen = posVertice(v1);
		NodoV verticeDestino = posVertice(v2);
		NodoA actual = verticeOrigen.inicio;
		while (actual!=null && actual.dest!=verticeDestino)
			 actual = actual.sigA;

		return actual!=null;
	}

	@Override
	public int pesoArista(int v1, int v2) {
		NodoV verticeOrigen = posVertice(v1);
		NodoV verticeDestino = posVertice(v2);
		NodoA actual = verticeOrigen.inicio;
		while (actual.dest!=verticeDestino)
			 actual = actual.sigA;

		return actual.peso;
	}

}
