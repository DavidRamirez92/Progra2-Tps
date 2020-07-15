package misApis;

public interface PilaTDA {
	void inicializarPila();//Inicia La Pila
	void apilar(int x);//agrega un elemento a la pila, necesita estar inicializada/
	void desapilar();//elimina un elemento de la pila, esta necesita no estar vacia
	boolean pilaVacia();//indica si una pila esta vacia, la misma debe estar inicializada
	int tope();//devuelve el elemento que se encuentra al tope de la pila, la pila debe estar inicializada, y la pila no vacia

}
