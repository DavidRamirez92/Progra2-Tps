package misApis;

public interface ColaTDA {
 void inicializarCola();//inicializa la cola
 void acolar(int x);//agrega un elemento a la cola, la misma debe estar inicializada
 void desacolar();//elimina un elemento de la cola, la misma debe estar inicializada
 int primero();//devuelve el primer elemento en la Cola, la misma no debe estar vacia
 boolean colaVacia();//devuelve si la Cola esta vacia, la misma debe estar inicializada
}
