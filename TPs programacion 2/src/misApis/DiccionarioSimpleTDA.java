package misApis;
import misApis.ConjuntoTDA;
public interface DiccionarioSimpleTDA {
	void inicializarDiccionario();//Inicializa el Diccionario
	   void agregar(int clave, int valor);//Agrega un valor al diccionario, necesita estar inicializado
	   void eliminar (int clave);//elimina un elemento del diccionario, necesita estar inicializado
	   int recuperar(int clave);//recupera un elemento del diccionario, necesita que el diccionario no este vacio
	   ConjuntoTDA Claves();//lista las claves que forman parte del conjunto, necesita que el diccionario no este vacio 
}
