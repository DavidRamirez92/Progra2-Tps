package misApis;

public interface ColaPrioridadTDA {
	void inicializarColaPrioridad();//inicializa la cola
	 void acolarPrioridad(int x,int p);//agrega un elemento a la cola, debe estar inicializada
	 void desacolar();//elimina un elemento de la cola, debe estar inicializada
	 int primero();//devuelve el primer elemento de la cola, no debe estar vacia
	 int prioridad();//devuelve la prioridad del elemento, no debe estar vacia
	 boolean colaVacia();//indica si la cola esta vacia, debe estar inicializada
}
