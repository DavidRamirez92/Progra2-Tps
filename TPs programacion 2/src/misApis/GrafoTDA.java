package misApis;

public interface GrafoTDA {
	void inicializarGrafo();
	void agregarVertice(int v);//debe estar inicializado y no existir el vertice
	void eliminarVertice(int v);//debe estar incializado y no exisitir el vertice
	ConjuntoTDA vertices();//debe estar inicializado
	void agregarArista(int v1,int v2,int peso);//debe estar inicializado,no debe exisitr la arista entre los vertices v1 y v2 y ambos vertices deben existir
	void eliminarArista(int v1,int v2);//debe estar inicializado,debe existir la arista entre los vertices v1 y v2
	boolean existeArista(int v1, int v2);// debe estar inicializado y existir ambos vertices
	int pesoArista(int v1, int v2);//debe estar inicializado, existir arista entre los vertices v1 y v2
	

}
