package misApis;

public interface ConjuntoTDA {
	void inicializarConjunto();//inicializa el conjunto
	void agregar(int x);//agrega un elemento al conjunto, necesita estar inicializado
	void sacar(int x);//saca un elemento del conjunto, necesita estar inicializado
	int elegir();//elige un elemento al azar del conjunto, necesita que el conjunto no este vacio
	boolean conjuntoVacio();//informa si el conjunto esta vacio, necesita que este inicializado el mismo
	boolean pertenece(int x);//informa si el parametro pasado pertenece al conjunto, necesita estar inicializado
}
