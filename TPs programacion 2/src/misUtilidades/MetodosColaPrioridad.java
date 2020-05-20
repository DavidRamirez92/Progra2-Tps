package misUtilidades;
import misImplementaciones.estatico.ColaPrioridad;
import misApis.ColaPrioridadTDA;
import misApis.ABBTDA;
public class MetodosColaPrioridad {
	public static void pasarColaPrioridad(ColaPrioridad origen,ColaPrioridad destino) {//pasa una cola con prioridad a otra
		while(!origen.colaVacia()) {
			destino.acolarPrioridad(origen.primero(),origen.prioridad());
			origen.desacolar();
		}
	}
	public static void copiarColaPrioridad(ColaPrioridad origen,ColaPrioridad destino) {
		ColaPrioridad aux=new ColaPrioridad();
		aux.inicializarColaPrioridad();
		while(!origen.colaVacia()) {
			destino.acolarPrioridad(origen.primero(),origen.prioridad());
			aux.acolarPrioridad(origen.primero(),origen.prioridad());
			origen.desacolar();
		}
		MetodosColaPrioridad.pasarColaPrioridad(aux, origen);
	}
	
	public static boolean colasPrioridadIguales(ColaPrioridad c1,ColaPrioridad c2) {//compara elementos y claves de dos Colas con prioridad, vacia ambas colas al comparar
		while(!c1.colaVacia()&&!c2.colaVacia()&&c1.primero()==c2.primero()&&c1.prioridad()==c2.prioridad()) {
			c1.desacolar();
			c2.desacolar();
		}
		if(c1.colaVacia()&&c2.colaVacia()) {
			return true;
		}else {return false;
		}
	}

	
	}
