package misImplementaciones.estatico;

import misApis.ConjuntoTDA;

public class Conjunto implements ConjuntoTDA {
	int [] a;
	int cant;

	public void inicializarConjunto() {
		a=new int[100];
		cant=0;

	}

	public void agregar(int x) {
		 if(!this.pertenece(x)) {
		    	a[cant]=x;
		    	cant++;
		    }

	}

	public void sacar(int x) {
		int i=0;
		while(i<cant&&a[i]!=x) {
			i++;
			
		}
		if(i<cant) {
			a[i]=a[cant-1];
			cant--;
		}

	}

	public int elegir() {
		return a[cant-1];
	}


	public boolean conjuntoVacio() {
		return(cant==0);
	}

	
	public boolean pertenece(int x) {
		for(int i=0;i<cant;i++) {
			if(a[i]==x) 
			 return true;
		}
		
		return false;
	}

}
