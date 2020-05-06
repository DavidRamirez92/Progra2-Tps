package misImplementaciones.dinamico;

import misApis.ConjuntoTDA;
import misApis.DiccionarioSimpleTDA;

public class DicionarioSimple implements DiccionarioSimpleTDA {
class Nodo{
	int valor;
	int clave;
	Nodo sig;
}
	Nodo origen;
	public void inicializarDiccionario() {
		origen=null;

	}
	private Nodo posClave(int clave) {
		Nodo aux=origen;
		while(aux!=null&aux.clave!=clave) {
			aux=aux.sig;
		}
		return aux;
	}

	public void agregar(int clave, int valor) {
		Nodo clavePos=posClave(clave);
		if(clavePos==null) {
			clavePos=new Nodo();
			clavePos.clave=clave;
			clavePos.sig=origen;
			origen=clavePos;
		}
		clavePos.valor=valor;

	}

	public void eliminar(int clave) {
		if(origen!=null) {
			if(origen.clave==clave) {
				origen=origen.sig;
			}else {
				Nodo aux=origen;
				while(aux.sig!=null&&aux.sig.clave!=clave)
					aux=aux.sig;
				if(aux.sig!=null) {
					aux.sig=aux.sig.sig;
				}
			}
		}

	}


	public int recuperar(int clave) {
		Nodo aux=posClave(clave);
		return aux.valor;
	}

	public ConjuntoTDA Claves() {
		Conjunto claves=new Conjunto();
		claves.inicializarConjunto();
		Nodo aux=origen;
		while(aux!=null){
			claves.agregar(aux.valor);
			aux=aux.sig;
		}
		return claves;
	}

}
