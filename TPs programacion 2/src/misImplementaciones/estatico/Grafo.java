package misImplementaciones.estatico;

import misApis.ConjuntoTDA;
import misApis.GrafoTDA;

public class Grafo implements GrafoTDA {
	int [][] matrizAdy;
	int cantVert;


	public void inicializarGrafo() {
		cantVert=100;
		matrizAdy=new int[cantVert][cantVert];
		for(int or=0;or<cantVert;or++)
			for(int dest=0;dest<cantVert;dest++)
				matrizAdy[or][dest]=0;

	}


	public void agregarVertice(int v) {
		matrizAdy[v][v]=1;

	}


	public void eliminarVertice(int v) {
		matrizAdy[v][v]=0;
		for(int i=0;i<cantVert;i++) {
			matrizAdy[v][i]=matrizAdy[i][v]=0;
		}

	}
	public ConjuntoTDA vertices() {
		ConjuntoTDA verts=new Conjunto();
		verts.inicializarConjunto();
		for(int or=0;or<cantVert;or++)
			if(matrizAdy[or][or]==1)
				verts.agregar(or);
		return verts;
	}

	public void agregarArista(int v1, int v2, int peso) {
		matrizAdy [ v1 ] [ v2 ] = peso;
	}

	public void eliminarArista(int v1, int v2) {
		matrizAdy [ v1 ] [ v2 ] = 0 ;
	}

	public boolean existeArista(int v1, int v2) {
		return matrizAdy [ v1 ] [ v2 ] != 0;
	}

	public int pesoArista(int v1, int v2) {
		return matrizAdy [ v1 ] [ v2 ];
	}






}
