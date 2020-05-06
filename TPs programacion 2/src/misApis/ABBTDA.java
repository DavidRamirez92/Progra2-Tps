package misApis;

public interface ABBTDA {
void inicializarABB();
int raiz();
ABBTDA hijoDer();
ABBTDA hijoIzq();
void agregar(int x);
void eliminar(int x);
boolean arbolVacio();
}
