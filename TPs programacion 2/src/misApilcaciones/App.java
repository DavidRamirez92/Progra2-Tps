package misApilcaciones;
import misApis.ABBTDA;
import misApis.ColaPrioridadTDA;
import misApis.ConjuntoTDA;
import misApis.GrafoTDA;
import misApis.PilaTDA;
import misImplementaciones.dinamico.ABB;
import misImplementaciones.dinamico.ColaPrioridad;
import misImplementaciones.dinamico.Grafo;
import misImplementaciones.dinamico.Pila;
import misUtilidades.ExamenFinal;
import misUtilidades.MetodosArbol;
import misUtilidades.MetodosArbol2;
import misUtilidades.MetodosGrafo;
import misUtilidades.MetodosPila;
public class App {

	public static void main(String[] args) {
		ConjuntoTDA vertices;
		boolean arista;
		GrafoTDA grafo=new Grafo();
		int elemento;
		grafo.inicializarGrafo();
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarArista(1, 2,5);
		grafo.eliminarVertice(1);
		arista=grafo.existeArista(1, 2);
		System.out.println(arista);

	}
}


