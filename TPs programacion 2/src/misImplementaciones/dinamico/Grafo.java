package misImplementaciones.dinamico;

import misApis.ConjuntoTDA;
import misApis.GrafoTDA;

public class Grafo implements GrafoTDA {

	class NodoV {
		int vertice;
		NodoArista iniArista;
		NodoV sigV;
	}

	class NodoArista {
		int peso;
		NodoV destino;
		NodoArista sigArista;
	}
	
	NodoV inicio;
	
	public void inicializarGrafo() {
		inicio = null;
	}
//precond, el vertice no debe existir
	public void agregarVertice(int v) {
		NodoV nuevo = new NodoV();
		nuevo.vertice = v;
		nuevo.iniArista = null;
		nuevo.sigV = inicio;
		inicio = nuevo;
	}

	public void eliminarVertice(int v) {
		ConjuntoTDA verticesOrigen=this.vertices();
		verticesOrigen.sacar(v);
		int vo;
		while(!verticesOrigen.conjuntoVacio()) {
			vo=verticesOrigen.elegir();
			verticesOrigen.sacar(vo);
			if(this.existeArista(vo,v))
				this.eliminarArista(vo,v);
		}
		NodoV actual = inicio, ant = null;		
		while ( actual != null && actual.vertice != v ) {
			ant = actual;
			actual = actual.sigV;
		}		
		if (ant == null)
			inicio = inicio.sigV;
		else
			ant.sigV = actual.sigV;
	}

	public ConjuntoTDA vertices() {
		ConjuntoTDA verts = new Conjunto();
		verts.inicializarConjunto();
		NodoV actualVert = inicio;		
		while ( actualVert != null ) {
			verts.agregar(actualVert.vertice);
			actualVert = actualVert.sigV;
		}		
		return verts;
	}//precond,los vertices existen
	public void agregarArista(int v1, int v2, int p) {
		NodoV verticeOrigen=posVertice(v1);
		NodoV verticeDestino=posVertice(v2);
		NodoArista actual=verticeOrigen.iniArista;
		while(actual!=null&&actual.destino!=verticeDestino) 
			actual=actual.sigArista;
		if(actual==null) {
			NodoArista nuevo=new NodoArista();
			nuevo.peso=p;
			nuevo.destino=verticeDestino;
			nuevo.sigArista=verticeOrigen.iniArista;
			verticeOrigen.iniArista=nuevo;
		}
		
	}

	public void eliminarArista(int v1, int v2) {
		NodoV origen = inicio ;		
		while ( origen.vertice != v1 )
			origen = origen.sigV;		

		NodoV destino = inicio ;
		while ( destino.vertice != v2 )
			destino = destino.sigV;

		NodoArista actualArista = origen.iniArista, antArista = null;
		while (actualArista.destino != destino) {
			antArista = actualArista;
			actualArista = actualArista.sigArista;
		}

		if ( antArista == null)
			origen.iniArista = origen.iniArista.sigArista;
		else
			antArista.sigArista = actualArista.sigArista;
	}

	public boolean existeArista(int v1, int v2) {
		NodoV origen = inicio ;		
		while ( origen.vertice != v1 )
			origen = origen.sigV;		

		NodoV destino = inicio ;
		while ( destino.vertice != v2 )
			destino = destino.sigV;

		NodoArista actualArista = origen.iniArista;
		while ( actualArista !=null && 
                    actualArista.destino != destino)
			actualArista = actualArista.sigArista;
		
		return  ( ( actualArista == null ) ? false : true );

	}

	public int pesoArista(int v1, int v2) {
		NodoV origen = inicio ;		
		while ( origen.vertice != v1 )
			origen = origen.sigV;
		
		NodoV destino = inicio ;
		while ( destino.vertice != v2 )
			destino = destino.sigV;

		NodoArista actualArista = origen.iniArista;
		while ( actualArista.destino != destino)  
			actualArista = actualArista.sigArista;
		
		return actualArista.peso;
	}
	private NodoV posVertice(int v) {
		NodoV actual=inicio;
		while(actual.vertice!=v)
			actual=actual.sigV;
		return actual;
	}

}
