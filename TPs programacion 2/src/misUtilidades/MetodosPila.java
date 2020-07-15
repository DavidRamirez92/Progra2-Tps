package misUtilidades;
import misImplementaciones.estatico.Pila;
import misApis.ColaTDA;
import misApis.PilaTDA;
import misImplementaciones.dinamico.Cola;
import misImplementaciones.estatico.Conjunto;

public class MetodosPila {

	public static void llenarPila(Pila origen) {//llena una pila con los elementos desde el 0 al 5
		for(int i=0;i<=5;i++){
			origen.apilar(i);

		}
	}

	public static void vaciarPila(Pila origen) {//vacia una pila
		while(!origen.pilaVacia()) {
			origen.desapilar();
		}

	}

	public static void mostrarPila(Pila pila) {//Muestra el contenido de una pila sin destruirlo
		Pila aux=new Pila();
		aux.inicializarPila();
		while(!pila.pilaVacia()) {
			System.out.println(pila.tope());
			aux.apilar(pila.tope());
			pila.desapilar();
		}
		MetodosPila.pasarPila(pila,aux);

	}

	public static void pasarPila(Pila origen,Pila destino) {//pasa el contenido de una pila a otra invirtiendo el orden
		while(!origen.pilaVacia()) {//Lineal
			destino.apilar(origen.tope());
			origen.desapilar();
		}
	}

	public static void copiarPila(Pila origen,Pila destino) {//Pasa el contenido de una pila a otra manteniendo el orden/ Costo Lineal =>2*N
		Pila aux=new Pila();//costo espacial 1, por la estructura
		aux.inicializarPila();
		MetodosPila.pasarPila(origen, aux);//Lineal
		MetodosPila.pasarPila(aux, destino);//Lineal

	}

	public static void invertirPila(Pila origen) {//invierte el contenido de una pila dentro de si misma/Costo Lineal =>3*N
		Pila aux1=new Pila();//Costo espacial 
		aux1.inicializarPila();
		Pila aux2=new Pila();//Costo espacial
		aux2.inicializarPila();
		MetodosPila.pasarPila(origen, aux1);//Lineal
		MetodosPila.pasarPila(aux1, aux2);//Lineal
		MetodosPila.pasarPila(aux2, origen);//Lineal
	}

	public static boolean pilasIguales(Pila p1,Pila p2) {//devuelve V o F si las dos pilas pasadas como parametro son iguales/Costo Lineal =>3*N
		Pila aux1=new Pila();
		Pila aux2=new Pila();
		aux1.inicializarPila();
		aux2.inicializarPila();
		if(MetodosPila.elementosPila(p1)==MetodosPila.elementosPila(p2)) {
			while(!p1.pilaVacia()&&!p2.pilaVacia()&&p1.tope()==p2.tope()) {//Lineal
				aux1.apilar(p1.tope());
				aux2.apilar(p2.tope());
				p1.desapilar();
				p2.desapilar();
			}
			if(!p1.pilaVacia()) {
				MetodosPila.pasarPila(aux1, p1);//Lineal
				MetodosPila.pasarPila(aux2, p2);//lineal
				return false;
			}else {
				MetodosPila.pasarPila(aux1, p1);//Lineal
				MetodosPila.pasarPila(aux2, p2);//Lineal
				return true;

			}
		}else {
			return false;
		}
	}

	public static int elementosPila(Pila origen) {//cuenta cuantos elementos hay en la pila
		int i=0;
		Pila aux=new Pila();
		aux.inicializarPila();
		while(!origen.pilaVacia()) {
			aux.apilar(origen.tope());
			origen.desapilar();
			i++;

		}
		MetodosPila.pasarPila(aux, origen);
		return i;
	}

	public static int sumaElementos(Pila origen) {//suma los elementos de una pila y devuelve el resultado
		int suma=0;
		Pila aux=new Pila();
		aux.inicializarPila();
		while(!origen.pilaVacia()) {
			aux.apilar(origen.tope());
			suma+=origen.tope();
			origen.desapilar();
		}
		MetodosPila.pasarPila(aux, origen);
		return suma;
	}

	public static boolean pilaEnpila(Pila hijo, Pila padre) {//verifica si una pila Hijo forma parte de una pila Padre.No destruye los elementos de las pilas
		Pila auxHijo=new Pila();
		Pila auxPadre1=new Pila();
		Pila auxPadre2=new Pila();
		auxHijo.inicializarPila();
		auxPadre1.inicializarPila();
		auxPadre2.inicializarPila();
		while(!padre.pilaVacia()) {
			if(hijo.tope()==padre.tope()) {
				while(hijo.tope()==padre.tope()&&!hijo.pilaVacia()&&!padre.pilaVacia()) {
					auxHijo.apilar(hijo.tope());
					hijo.desapilar();
					auxPadre2.apilar(padre.tope());
					padre.desapilar();
				}
				if(hijo.pilaVacia()) {
					while(!auxPadre2.pilaVacia()) {
						padre.apilar(auxPadre2.tope());
						auxPadre2.desapilar();
					}
					while(!auxPadre1.pilaVacia()) {
						padre.apilar(auxPadre1.tope());
						auxPadre1.desapilar();
					}
					while(!auxHijo.pilaVacia()) {
						hijo.apilar(auxHijo.tope());
						auxHijo.desapilar();
					}
					return true;
					
				}else {
					while(!auxHijo.pilaVacia()) {
						hijo.apilar(auxHijo.tope());
						auxHijo.desapilar();
						padre.apilar(auxPadre2.tope());
						auxPadre2.desapilar();
					}
				}
			}
			auxPadre1.apilar(padre.tope());
			padre.desapilar();
		}
		while(!auxPadre1.pilaVacia()) {
			padre.apilar(auxPadre1.tope());
			auxPadre1.desapilar();
		}
		return false;
		
	}

	public static void eliminarRepetidos(Pila p) {//Elimina los elementos repetidos de una Pila utilizando un conjunto
		Conjunto aux=new Conjunto();
		aux.inicializarConjunto();
		while(!p.pilaVacia()) {
			aux.agregar(p.tope());
			p.desapilar();
		}
		while(!aux.conjuntoVacio()) {
		     p.apilar(aux.elegir());
		}
	}
	
	public boolean pilaCapicua(PilaTDA p) {//funciona, devuelve boolean si una pila es capicua o no
		PilaTDA aux=new Pila();
		aux.inicializarPila();
		ColaTDA cola=new Cola();
		cola.inicializarCola();
		boolean capicua=true;
		while(!p.pilaVacia()) {
			aux.apilar(p.tope());
			cola.acolar(p.tope());
			p.desapilar();
		}
		while(!aux.pilaVacia()) {
			if(aux.tope()!=cola.primero())
				capicua=false;
			aux.desapilar();
			cola.desacolar();
		}
		return capicua;

	}

}

	


