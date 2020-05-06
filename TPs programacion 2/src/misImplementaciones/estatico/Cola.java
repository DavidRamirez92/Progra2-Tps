package misImplementaciones.estatico;

import misApis.ColaTDA;

public class Cola implements ColaTDA {
	int []a;
	int indice;

	public void inicializarCola() {
		a=new int[100];
		indice=0;
	}


	public void acolar(int x) {
		for(int i=indice-1;i>=0;i--) {
			a[i+1]=a[i];
		}
		a[0]=x;
		indice++;
	}

	public void desacolar() {
		indice--;
	}

	public int primero() {
		return indice-1;
	}

	public boolean colaVacia() {
		return indice==0;
	}

}
