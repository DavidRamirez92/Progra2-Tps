package misImplementaciones.dinamico;

import misApis.PilaTDA;

public class Pila implements PilaTDA {

	private class Nodo{
		int v;
		Nodo sig;
	}
	Nodo primero;
	public void inicializarPila() {
		primero=null;
	}

	public void apilar(int x) {
		Nodo nuevo=new Nodo();
		nuevo.sig=primero;
		primero=nuevo;

	}
	public void desapilar() {
		primero=primero.sig;

	}

	public boolean pilaVacia() {
		return (primero==null);
	}

	public int tope() {
		return primero.v;
	}

}
