package misUtilidades;
import misImplementaciones.estatico.Conjunto;
import misImplementaciones.estatico.Pila;
public class MetodosConjunto {
	public static void pasarConjunto(Conjunto origen,Conjunto destino) {//pasa el contenido de un conjunto a otro;
		while(!origen.conjuntoVacio()) {
			destino.agregar(origen.elegir());
			origen.sacar(origen.elegir());
		}
	}
	public static void copiarConjunto(Conjunto origen, Conjunto destino) {//copia el contenido de un conjunto en otro
		Pila pilaAux1=new Pila();
		Pila pilaAux2=new Pila();
		pilaAux1.inicializarPila();
		pilaAux2.inicializarPila();
		while(!origen.conjuntoVacio()) {
			pilaAux1.apilar(origen.elegir());
			pilaAux2.apilar(origen.elegir());
			origen.sacar(origen.elegir());
	}
		while(!pilaAux1.pilaVacia()) {
			destino.agregar(pilaAux2.tope());
			pilaAux2.desapilar();
			origen.agregar(pilaAux1.tope());
			pilaAux1.desapilar();
			
		}

}
    public static boolean conjuntosIguales(Conjunto c1,Conjunto c2) {//determina si dos conjuntos son iguales (tiene en cuenta cantidad de elementos y el valor de estos asi como el orden)
    	while(!c1.conjuntoVacio()&&!c2.conjuntoVacio()&&c1.elegir()==c2.elegir()) {
    		c1.sacar(c1.elegir());
    		c2.sacar(c2.elegir());
    	}
    	if(c1.conjuntoVacio()&&c2.conjuntoVacio()) {
    		return true;
    	}else {
    		return false;
    	}
    }
    public static Conjunto interseccionConjuntos(Conjunto c1,Conjunto c2) {//devuelve un conjunto con la interseccion de dos elementos
    	Conjunto interseccion=new Conjunto();
    	interseccion.inicializarConjunto();
    	while(!c1.conjuntoVacio()) {
    		if(c2.pertenece(c1.elegir())){
    			interseccion.agregar(c1.elegir());
    		}
    		c1.sacar(c1.elegir());
    	}
    	return interseccion;
    }
    public static Conjunto unionConjuntos(Conjunto c1,Conjunto c2) {
    	Conjunto union=new Conjunto();
    	union.inicializarConjunto();
    	while(!c1.conjuntoVacio()) {
    		union.agregar(c1.elegir());
    		c1.sacar(c1.elegir());
    	}
    	while(!c2.conjuntoVacio()) {
    		union.agregar(c2.elegir());
    		c2.sacar(c2.elegir());
    	}
    	return union;
    }
    public static boolean inclusionConjunto(Conjunto hijo,Conjunto padre) {//boolean que determina si los elementos de hijo estan en padre
    	while(!hijo.conjuntoVacio()) {
    		if(!padre.pertenece(hijo.elegir())) {
    			return false;
    		}
    		hijo.sacar(hijo.elegir());
    	}
    	return true;
    }
    public static Conjunto diferenciaConjuntos(Conjunto c1,Conjunto c2) {//devuelve un conjunto con elementos de c1, que no estan en c2
    	Conjunto diferencia=new Conjunto();
    	diferencia.inicializarConjunto();
    	while(!c1.conjuntoVacio()) {
    		if(!c2.pertenece(c1.elegir())) {
    			diferencia.agregar(c1.elegir());
    		}
    		c1.sacar(c1.elegir());
    	}
    	return diferencia;
    }
    
    public static Conjunto diferenciaSimetrica(Conjunto c1,Conjunto c2) {//revuelve un conjunto que contiene los elementos de c1 que no estan en c2, y viceversa
    	Conjunto diferencia=new Conjunto();
    	diferencia.inicializarConjunto();
    	while(!c1.conjuntoVacio()) {
    		if(c2.pertenece(c1.elegir())) {
    			c2.sacar(c1.elegir());
    			
    		}else {
    			diferencia.agregar(c1.elegir());
    		}
    		c1.sacar(c1.elegir());
    	}
    	while(!c2.conjuntoVacio()) {
    		diferencia.agregar(c2.elegir());
    		c2.sacar(c2.elegir());
    	}
    	return diferencia;
    }
}