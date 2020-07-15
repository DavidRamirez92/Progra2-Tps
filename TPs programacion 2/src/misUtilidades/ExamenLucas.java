package misUtilidades;

import misApis.ColaTDA;
import misApis.ConjuntoTDA;
import misImplementaciones.dinamico.Cola;
import misImplementaciones.dinamico.Conjunto;

/**
 * @materia Programación II
 * @Examen  parcial
 * @fecha   20/05/2020
 * @author  xxxxxx
 * @lu      xxxxxx
 * Códificar un método externo que:
 * Dada una cola con secuencias de números, separadas por el valor 0, genere otra cola con las secuencias de números
 * donde al menos uno de sus valores pertenezca a otra secuencia. Todas las secuencias tienen valores únicos.
 * Ejemplo:
 * Cola origen  1 2 3 0 6 22 0 7 9 4 2 0 2 0  
 * Cola destino 1 2 3 0 7 9 4 2 0 2 0 
 **/
/*
 * 
 * Una cola con prioridad es un conjunto de valores con una prioridad asociado a cada uno. No se perimten valores repetidos.
 * Si se quisiese acolar un valor ya existente, la prioridad de éste pasará a ser la más grande de la cola.
 * a - Indicar cómo relaciona la implementación con la interfase ColaPrioridadTDA en el código.
 * b - Declarar las variables de clases requeridas y clase/s de nodo/s requerido/s para la implementación desarrollada.
 * c - Codificar los siguientes métodos: inicializarCola, acolarPrioridad y desacolar indicando precondiciones para éstos. 
 *     
 * Se sabe que la cola no tiene más de 100 valores. 
 **/
public class ExamenLucas {
	public ColaTDA colaFiltrada(ColaTDA origen) {
		boolean elementoIgual;
		ColaTDA aux1=new Cola();
		aux1.inicializarCola();
		ColaTDA aux2=new Cola();
		aux2.inicializarCola();
		ColaTDA destino=new Cola();
		destino.inicializarCola();
		ConjuntoTDA conjunto=new Conjunto();
		conjunto.inicializarConjunto();
		int elemento;
		while(origen.primero()!=0) {
			destino.acolar(origen.primero());
			origen.desacolar();
		}
		destino.acolar(origen.primero());
		origen.desacolar();
		while(!origen.colaVacia()) {
			elementoIgual=false;
			while(!destino.colaVacia()) {
				conjunto.agregar(destino.primero());
				aux1.acolar(destino.primero());
				destino.desacolar();
			}
			while(!aux1.colaVacia()) {
				destino.acolar(aux1.primero());
				aux1.desacolar();
			}
			while(origen.primero()!=0) {
				elemento=origen.primero();
				if(conjunto.pertenece(elemento))
					elementoIgual=true;
				aux2.acolar(origen.primero());
				origen.desacolar();
			}
			if(!elementoIgual==true) {
				while(!aux2.colaVacia()) {
					destino.acolar(aux2.primero());
					aux2.desacolar();
				}
				destino.acolar(origen.primero());
				origen.desacolar();
			}else {
				while(!aux2.colaVacia())
					aux2.desacolar();

			}

		}
		return destino;
	}
	
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
		while(actual!=null&&actual.p>=p&&actual.v!=x) {
			ant=actual;
			actual=actual.sig;
		}
		if(actual.v!=x) {
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
		}else {
			Nodo nuevo=new Nodo();
			nuevo.p=inicio.p+1;
			nuevo.v=x;
			nuevo.sig=inicio;
			inicio=nuevo;
			
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
