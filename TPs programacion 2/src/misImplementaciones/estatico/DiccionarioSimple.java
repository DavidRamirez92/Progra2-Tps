package misImplementaciones.estatico;

import misApis.ConjuntoTDA;
import misApis.DiccionarioSimpleTDA;
import misImplementaciones.estatico.Conjunto;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
private class Elem{
	int cl, dato;
}
   Elem[] vector;
   int cant;
	public void inicializarDiccionario() {
		vector=new Elem[100];
		cant=0;
		
	}

	public void agregar(int clave, int valor) {
		int i=0;
		while(i<cant&&vector[i].cl!=clave)
			i++;
        if(i==cant) {
        	vector[i]=new Elem();
        	vector[i].cl=clave;
        	vector[i].dato=valor;
        	cant++;
        }else {
        	vector[i].dato=valor;
        }
	}

	public void eliminar(int clave) {
		int i=0;
		while(i<cant&&vector[i].cl!=clave)
			i++;
		if(i<cant) {
			vector[i]=vector[cant-1];
			cant--;
		}

	}
	
	public int recuperar(int clave) {
		int i=0;
		while(i<cant&&vector[i].cl!=clave) 
			i++;
		return vector[i].dato;
	}

	public ConjuntoTDA Claves() {
		Conjunto claves=new Conjunto();
		claves.inicializarConjunto();
		for(int i=0;i<cant;i++) {
			claves.agregar(vector[i].cl);
		}
		return claves;
	}

	
}
