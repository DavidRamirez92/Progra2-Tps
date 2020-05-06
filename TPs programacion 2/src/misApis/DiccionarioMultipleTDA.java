package misApis;

public interface DiccionarioMultipleTDA {
	void inicializarDiccionario();//inicializa el diccionario
	void agregar(int clave,int valor);//agrega una clave(si esta no existe) y un elemento al diccionario, el mismo debe estar inicializado
	void eliminar(int clave);//Elimina la clave y todos los valores asociada a esta
	void eliminarValor(int clave,int valor);//dada una clave elimina el elemento solicitado del diccionario y si queda vacia la clave, la elimina tambien, el diccionario debe estar inicializado
	ConjuntoTDA recuperarValores(int clave);//dada una clave, devuelve todos los valores asociados a esa clave, el diccionario debe estar inicializado 
	ConjuntoTDA claves();//Lista todas las claves del diccionario, el mismo debe estar inicializado
}
