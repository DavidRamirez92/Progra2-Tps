package misUtilidades;

import misApis.ABBTDA;
import misImplementaciones.dinamico.ABB;

/**
 * @materia Programación II
 * @Examen  parcial
 * @fecha   20/05/2020
 * @author  xxxxxx
 * @lu      xxxxxx
 * 
 * Códificar un método externo que:
 * A partir de un árbol ABB origen, generar un árbol nuevo de la siguiente manera:
 * El subárbol derecho del árbol nuevo debe tener como raíz, la raíz del subárbol izquierdo del subárbol derecho del árbol origen. 
 * Los elementos de los subárboles afectados deberán agregarse al árbol nuevo sin que se modifique su estructura. 
 * Ejemplo:
 * Árbol origen
 *										 30
 *								SAi30				40                     
 *											 35				SAd40
 * 							   		  SAi35      SAd35
 *                                 
 *  Árbol destino   
 *                                            30 
 *                                    SAi30                 35                      
 *                                                 SAi35              40
 *                                                      	    SAd35	   SAd40
 **/
public class ExamenRodrigo {
	public void agregarPreOrden(ABBTDA origen,ABBTDA destino) {
		if(!origen.arbolVacio()) {
			destino.agregar(origen.raiz());
			agregarPreOrden(origen.hijoIzq(),destino);
			agregarPreOrden(origen.hijoDer(),destino);
		}
	}
	public void arbolModificado(ABBTDA origen,ABBTDA destino) {
		destino.agregar(origen.raiz());//30
		destino.agregar(origen.hijoDer().hijoIzq().raiz());//35
		destino.agregar(origen.hijoDer().raiz());//40
		this.agregarPreOrden(origen.hijoIzq(),destino);
		this.agregarPreOrden(origen.hijoDer().hijoIzq().hijoIzq(), destino);
		this.agregarPreOrden(origen.hijoDer().hijoIzq().hijoDer(), destino);
		this.agregarPreOrden(origen.hijoDer().hijoDer(), destino);
		
	}
	

}
