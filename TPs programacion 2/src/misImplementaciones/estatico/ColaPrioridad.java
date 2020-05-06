package misImplementaciones.estatico;

import misApis.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {

	class  Elementos{
		int valor;
		int prioridad;
	}
	Elementos[] vector;
	int cant;
	public void inicializarColaPrioridad() {
		vector=new Elementos[100];
		cant=0;

	}


	public void acolarPrioridad(int x, int p) {
		if(cant!=0) {
			int i;
			for(i=cant-1;i>=0&&vector[i].prioridad>p;i--) {
				vector[i+1].valor=vector[i].valor;
				vector[i+1].prioridad=vector[i].prioridad;
				
			}
			vector[i+1].valor=x;
			vector[i+1].prioridad=p;
		}else{
			vector[0].valor=x;
			vector[0].prioridad=p;
		}
		cant++;

	}

	public void desacolar() {
		cant--;

	}

	public int primero() {
		return vector[cant-1].valor;
	}
	
	public int prioridad() {
		return vector[cant-1].prioridad;
	}

	public boolean colaVacia() {
		return cant==0;
	}

}
