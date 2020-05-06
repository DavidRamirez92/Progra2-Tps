package misImplementaciones.estatico;

import misApis.ConjuntoTDA;
import misApis.DiccionarioMultipleTDA;

public class DiccionarioMultiple implements DiccionarioMultipleTDA {
 class Elem{
	int cl;
	int cant;
	int[]valores;
}
	Elem[]listaClaves;
	int cantClaves;
	public void inicializarDiccionario() {
		listaClaves=new Elem[100];
		cantClaves=0;

	}

	public void agregar(int clave, int valor) {
		int i=0;
		while(i<cantClaves&&listaClaves[i].cl!=clave) 
			i++;
		if(i==cantClaves) {
			listaClaves[i]=new Elem();
			listaClaves[i].cl=clave;
			listaClaves[i].cant=0;
			listaClaves[i].valores=new int[100];
			cantClaves++;
		}
		int j=0;
		while(j<listaClaves[i].cant&&listaClaves[i].valores[j]!=valor)
			j++;
		if(j==listaClaves[i].cant) {
			listaClaves[i].valores[j]=valor;
			listaClaves[i].cant+=1;
		}
	}
			

	public void eliminar(int clave) {
		int i=0;
		while(i<cantClaves&&listaClaves[i].cl!=clave) 
			i++;
		if(i<cantClaves) {
			listaClaves[i]=listaClaves[cantClaves-1];
			cantClaves--;
		}

	}


	public void eliminarValor(int clave, int valor) {
		int i=0;
		while(1<cantClaves&&listaClaves[i].cl!=clave)
				i++;
		if(i<cantClaves) {
			int j=0;
			while(j<listaClaves[i].cant&&listaClaves[i].valores[j]!=valor) 
				j+=1;
			if(j<listaClaves[i].cant) {
				listaClaves[i].valores[j]=listaClaves[i].valores[listaClaves[i].cant-1];
				listaClaves[i].cant--;
			}
			
		}
		if(listaClaves[i].cant==0)
			eliminar(clave);

	}


	public ConjuntoTDA recuperarValores(int clave) {
		ConjuntoTDA valores=new Conjunto();
		valores.inicializarConjunto();
		for(int i=0;i<listaClaves[clave].cant;i++) {
			valores.agregar(listaClaves[clave].valores[i]);
		}
		return valores;
	}

	public ConjuntoTDA claves() {
		ConjuntoTDA c=new Conjunto();
		c.inicializarConjunto();
		for(int i=0;i<cantClaves;i++) {
			c.agregar(listaClaves[i].cl);
		}
		return c;
	}

}
