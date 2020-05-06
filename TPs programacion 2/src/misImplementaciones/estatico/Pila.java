package misImplementaciones.estatico;

import misApis.PilaTDA;

public class Pila implements PilaTDA {
    int[]vector;
    int indice;
    
	public void inicializarPila() {
		vector=new int[100];
		indice=0;
		
	}

	public void apilar(int x) {
		vector[indice]=x;
		indice++;	 
	}
	public void desapilar() {
		indice--;
	}

	public boolean pilaVacia() {
		return (indice==0);
	}

	public int tope() {
		return(vector[indice-1]);
	}

}
