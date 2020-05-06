package misUtilidades;
import misImplementaciones.estatico.Cola;
import misImplementaciones.estatico.Pila;
public class MetodosCola {
	public static void invertirCola(Cola c) {//invierte el contenido de una cola dentro de si misma
		Pila aux=new Pila();
		aux.inicializarPila();
	while(!c.colaVacia()) {
		aux.apilar(c.primero());
		c.desacolar();
	}
	while(!aux.pilaVacia()) {
		c.acolar(aux.tope());
		aux.desapilar();
	}
}
	
	public static void PasarColaInvertida(Cola origen,Cola destino) {//pasa el contenido de una cola a la otra, invirtiendo el orden/Costo Lineal=>2*N
		   Pila aux=new Pila();
		   aux.inicializarPila();
		   while(!origen.colaVacia()) {//Lineal
			   aux.apilar(origen.primero());
			   origen.desacolar();
		   }
		   while(!aux.pilaVacia()) {//Lineal
			   destino.acolar(aux.tope());
			   destino.desacolar();
		   }
		}
	
	public static void CopiarCola(Cola origen,Cola destino) {//Copia la cola enviada como origen, en la cola destino conservando los elementos/	Costo Lineal 2*N
		Cola aux=new Cola();
		aux.inicializarCola();
		while(!origen.colaVacia()) {//Lineal
			aux.acolar(origen.primero());
			destino.acolar(origen.primero());
			origen.desacolar();
		}
		while(!aux.colaVacia()) {//Lineal
			origen.acolar(aux.primero());
			aux.desacolar();
		}
	}
	
	public static void InvertirCola(Cola cola) {//invierte los contenidos de una Cola//Costo Lineal =>L1
		Pila aux=new Pila();
		aux.inicializarPila();
		while(!cola.colaVacia()) {//ineal
			aux.apilar(cola.primero());
			cola.desacolar();
	}
		while(!aux.pilaVacia()) {//Lineal
			cola.acolar(aux.tope());
			aux.desapilar();
		}
		
}
	
	public static boolean ColasIguales(Cola c1,Cola c2) {//compara 2 colas y determina si son iguales, destruyendo los elementos de ambas/ Costo Lineal=>N
		while(!c1.colaVacia()&&!c2.colaVacia()&&c1.primero()==c2.primero()) {//Lineal
			c1.desacolar();
			c2.desacolar();
		}
		if(!c1.colaVacia()||!c2.colaVacia()) {
		return false;
		
	}else {
		return true;
	}
}

   public static int contarElementosCola(Cola c) {//cuenta cuantos elementos tiene la Cola
	   int contador=0;
	   Cola aux=new Cola();
	   aux.inicializarCola();
	   while(!c.colaVacia()){
		   aux.acolar(c.primero());
		   c.desacolar();
		   contador++;
	   }
	   while(!aux.colaVacia()) {
		   c.acolar(aux.primero());
		   aux.desacolar();
	   }
	   return contador;
	   
   }
	
	public static void repartirCola(Cola c,Cola c1,Cola c2) {//reparte el contenido de una cola C, en c1 y c2 en 2 mitades
    	int cant=MetodosCola.contarElementosCola(c);
    	for(int i=0;i<cant/2;i++) {
    		c1.acolar(c.primero());
    		c.desacolar();
    	}
    	while(!c.colaVacia()) {
    		c2.acolar(c.primero());
    		c.desacolar();
    	}
    	
    }

   public static int secuenciaMasLarga(Cola c) {//devuelve la secuencia mas larga separada por ceros en la cola
	   int masLarga=0;
	   int secuenciaActual=0;
	   while(!c.colaVacia()) {
		   if(c.primero()!=0) {
			   while(c.primero()!=0&&!c.colaVacia()) {
				   secuenciaActual++;
				   c.desacolar();
			   }
			   if(secuenciaActual>masLarga) {
				   masLarga=secuenciaActual;
			   }
			   secuenciaActual=0;
		   }
		   if(!c.colaVacia()) 
			   c.desacolar();
	   }
	   return masLarga;
   }
}