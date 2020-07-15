package misUtilidades;

import misApis.ABBTDA;
import misApis.ColaPrioridadTDA;
import misApis.ConjuntoTDA;
import misApis.DiccionarioMultipleTDA;
import misApis.DiccionarioSimpleTDA;
import misApis.GrafoTDA;
import misImplementaciones.dinamico.ColaPrioridad;
import misImplementaciones.dinamico.Conjunto;
import misImplementaciones.dinamico.DiccionarioMultiple;
import misImplementaciones.dinamico.DicionarioSimple;

public class MetodosGrafo {
	public ConjuntoTDA verticesAdyacentesDobles (GrafoTDA g,int v) {//probar si es correcto
		int vertice;
		int otroVertice;
		ConjuntoTDA vertices=g.vertices();
		vertices.sacar(v);
		ConjuntoTDA verticesOrig=new Conjunto();
		ConjuntoTDA verticesAdy=new Conjunto();
		ConjuntoTDA aux=new Conjunto();
		aux.inicializarConjunto();
		verticesAdy.inicializarConjunto();
		verticesOrig.inicializarConjunto();
		while(!vertices.conjuntoVacio()) {
			vertice=vertices.elegir();
			vertices.sacar(vertice);
			if(g.existeArista(v, vertice))
				verticesOrig.agregar(vertice);
			
		}
		vertices=g.vertices();
		vertices.sacar(v);
		while(!vertices.conjuntoVacio()) {
			vertice=vertices.elegir();
			vertices.sacar(vertice);
			while(!verticesOrig.conjuntoVacio()) {
				otroVertice=verticesOrig.elegir();
				verticesOrig.sacar(otroVertice);
				aux.agregar(otroVertice);
				if(g.existeArista(otroVertice,vertice))
					verticesAdy.agregar(vertice);
			}
			while(!aux.conjuntoVacio()) {
				otroVertice=aux.elegir();
				aux.sacar(otroVertice);
				verticesOrig.agregar(otroVertice);
			}
			
		}
		
		return verticesAdy;
	}
	
	public int mayorCostoArista(GrafoTDA grafo,int vertice) {//correcto, determina cual es la arista saliente de mayor costo de un vertice
		int vertice2;
		ColaPrioridadTDA cola=new ColaPrioridad();
		cola.inicializarColaPrioridad();
		ConjuntoTDA vertices=grafo.vertices();
		while(!vertices.conjuntoVacio()) {
			vertice2=vertices.elegir();
			vertices.sacar(vertice2);
			if(grafo.existeArista(vertice,vertice2))
					cola.acolarPrioridad(vertice2,grafo.pesoArista(vertice, vertice2));
			
		}
		return cola.prioridad();
		
	}
	
	public ConjuntoTDA verticePredecesor(GrafoTDA grafo,int vertice) {
		ConjuntoTDA vertices=grafo.vertices();
		ConjuntoTDA verticesPredecesor=new Conjunto();
		verticesPredecesor.inicializarConjunto();
		vertices.sacar(vertice);
		int vertice2;
		while(!vertices.conjuntoVacio()) {
			vertice2=vertices.elegir();
			vertices.sacar(vertice2);
			if(grafo.existeArista(vertice2, vertice))
				verticesPredecesor.agregar(vertice2);
			
			
		}
		return verticesPredecesor;
	}
	
	public ConjuntoTDA verticesAislados(GrafoTDA grafo) {//funciona, devuelve un conjunto con los vertices aislados de un grafo
		ConjuntoTDA vertices=grafo.vertices();
		ConjuntoTDA otrosVertices;
		ConjuntoTDA verticesAislados=new Conjunto();
		verticesAislados.inicializarConjunto();
		boolean tieneVertice;
		int vertice,otroVertice;
		while(!vertices.conjuntoVacio()) {
			vertice=vertices.elegir();
			vertices.sacar(vertice);
			otrosVertices=grafo.vertices();
			tieneVertice=false;
			while(!otrosVertices.conjuntoVacio()&&tieneVertice==false) {
				otroVertice=otrosVertices.elegir();
				otrosVertices.sacar(otroVertice);
				if(grafo.existeArista(vertice, otroVertice)||grafo.existeArista(otroVertice, vertice)) {
					tieneVertice=true;
				}
			}
			if(tieneVertice==false)
				verticesAislados.agregar(vertice);
			
		}
		return verticesAislados;
	}

	public ConjuntoTDA verticesPuente(GrafoTDA grafo,int v1,int v2) {//funciona, devuelve conjunto con vertices puente entre v1, y v2
		ConjuntoTDA vertices=grafo.vertices();
		ConjuntoTDA verticesPuente=new Conjunto();;
		verticesPuente.inicializarConjunto();
		int vertice;
		vertices.sacar(v1);
		vertices.sacar(v2);
		while(!vertices.conjuntoVacio()) {
			vertice=vertices.elegir();
			vertices.sacar(vertice);
			if(grafo.existeArista(v1, vertice)&&grafo.existeArista(vertice, v2))
				verticesPuente.agregar(vertice);
			if(grafo.existeArista(v2, vertice)&&grafo.existeArista(vertice, v1))
				verticesPuente.agregar(vertice);

		}

		return verticesPuente;
	}
	public int gradoVertice(GrafoTDA grafo,int v) {//funciona, muestra el grado de un vertice dado (cant. d aristas salientes, - cant entrantes)
		ConjuntoTDA vertices=grafo.vertices();
		vertices.sacar(v);
		int grado=0;
		int vertice;
		while(!vertices.conjuntoVacio()) {
			vertice=vertices.elegir();
			vertices.sacar(vertice);
			if(grafo.existeArista(v, vertice))
				grado-=grafo.pesoArista(v, vertice);//cambio el ++ , por el peso de la arista para probar un modelo de final
			if(grafo.existeArista(vertice, v))
				grado+=grafo.pesoArista(vertice, v);//cambio el --,por el peso de la arista para probar un model de final


		}
		return grado;
	}
	
	public void examenGodio(GrafoTDA grafo,ABBTDA arbol) {//recibe un grafo y un arbol, segrega si los vertices que existen en el arbol como nodos, tiene el mismo valor. (grafo:aristas entrantes - salientes) (arbol=hijos izq - hijos Der)
		MetodosArbol ma=new MetodosArbol();
		ConjuntoTDA vertices=grafo.vertices();
		ConjuntoTDA verticesEnArbol=new Conjunto();//1
		verticesEnArbol.inicializarConjunto();
		int elemento;
		int gradoVertice;
		int gradoArbol;
		while(!vertices.conjuntoVacio()) {
			elemento=vertices.elegir();
			vertices.sacar(elemento);
			if(ma.encontrarValorArbol(arbol, elemento))
				verticesEnArbol.agregar(elemento);

			}
		while(!verticesEnArbol.conjuntoVacio()) {
			elemento=verticesEnArbol.elegir();
			verticesEnArbol.sacar(elemento);
			gradoVertice=this.gradoVertice(grafo, elemento);
			gradoArbol=ma.calculoHijos(arbol, elemento);
			if(gradoVertice==gradoArbol) {
				System.out.println("el elemento "+elemento+" tiene el mismo grado "+gradoVertice+" en el Vertice y en el Arbol");
			}else {
				System.out.println("el elemento "+elemento+" NO tiene el mismo valor, el Vertice es Grado: "+gradoVertice+" y el Arbol es Grado: "+gradoArbol);
			}
		}
		
		
		
	}

	
	
	
}

	

