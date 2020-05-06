package misImplementaciones.dinamico;

import misApis.ConjuntoTDA;
import misApis.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {

	class NodoClave{
		int clave;
		NodoValor inicioVal;
		NodoClave sigClave;
	}
	class NodoValor{
		int valor;
		NodoValor sigvalor;
	}
	NodoClave inicioClave;
	
	public void inicializarDiccionario() {
		inicioClave=null;

	}
	
	private NodoClave buscarClave(int c) {//Lineal
		NodoClave actual=inicioClave;
		while(actual!=null&&actual.clave!=c) {//Lineal
			actual=actual.sigClave;
		}
		return actual;
	}
	private NodoValor buscarValor(NodoValor inicio,int x) {//Lineal
		NodoValor actual=inicio;
		while(actual!=null&&actual.valor!=x)//Lineal
			actual=actual.sigvalor;
		return actual;
	}

	public void agregar(int clave, int valor) {//Lineal
		NodoClave actualClave=buscarClave(clave);
		if(actualClave==null) {
			NodoClave nuevoClave=new NodoClave();
			nuevoClave.clave=clave;
			nuevoClave.inicioVal=null;
			nuevoClave.sigClave=inicioClave;
			inicioClave=nuevoClave;
			actualClave=nuevoClave;
		}
		NodoValor actualValor=buscarValor(actualClave.inicioVal,valor);
			if(actualValor==null) {
				NodoValor nuevoValor=new NodoValor();
				nuevoValor.valor=valor;
				nuevoValor.sigvalor=actualClave.inicioVal;
				actualClave.inicioVal=nuevoValor;
				
			}
		}

	public void eliminar(int clave) {//Lineal
		NodoClave actual=inicioClave, ant=null;
		while(actual!=null&&actual.clave!=clave) {//Lineal
			ant=actual;
			actual=actual.sigClave;
		}
		if(actual!=null) {
			if(ant==null) {
				inicioClave=inicioClave.sigClave;
			}else 
				ant.sigClave=actual.sigClave;
		}

	}

	public void eliminarValor(int clave, int valor) {
		NodoClave actualClave=buscarClave(clave);//buscarClave es Lineal
		if(actualClave!=null) {
			NodoValor actual=actualClave.inicioVal,ant=null;
			while(actual!=null&&actual.valor!=valor) {
				ant=actual;
				actual=actual.sigvalor;
			}
			if(actual!=null) {
				if(ant==null)
					actualClave.inicioVal=actualClave.inicioVal.sigvalor;
				else
					ant.sigvalor=actual.sigvalor;
				if(actualClave.inicioVal==null)
					eliminar(actualClave.clave);//Lineal
			}
		}

	}

	public ConjuntoTDA recuperarValores(int clave) {//lineal =>2*N
		ConjuntoTDA resultado=new Conjunto();
		resultado.inicializarConjunto();
		NodoClave actualClave=buscarClave(clave);
		if(actualClave!=null) {
			NodoValor actual=actualClave.inicioVal;
			while(actual!=null) {
				resultado.agregar(actual.valor);
				actual=actual.sigvalor;
			}
			
		}
		return resultado;
	}


	public ConjuntoTDA claves() {
		ConjuntoTDA resultado=new Conjunto();
		resultado.inicializarConjunto();
		NodoClave actual=inicioClave;
		while(actual!=null) {
			resultado.agregar(actual.clave);
			actual=actual.sigClave;
		}
		return resultado;
	}

}
