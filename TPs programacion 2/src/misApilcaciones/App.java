package misApilcaciones;
import misApis.ABBTDA;
import misApis.ColaPrioridadTDA;
import misImplementaciones.dinamico.ABB;
import misUtilidades.MetodosArbol;
import misUtilidades.MetodosColaPrioridad;
public class App {

	public static void main(String[] args) {
		MetodosArbol m=new MetodosArbol();
		ABBTDA arbol=new ABB();
		arbol.inicializarABB();
		arbol.agregar(5);
		arbol.agregar (3);
		arbol.agregar (2);
		arbol.agregar (7);
		arbol.agregar (8);
		arbol.agregar (9);
		arbol.agregar (10);
		ColaPrioridadTDA cola=m.colaDeArbol(arbol);
		while(!cola.colaVacia()) {
			System.out.println(cola.primero()+"/"+cola.prioridad());
			cola.desacolar();
			
		}

		


	}

}
