package misUtilidades;

import misApis.ABBTDA;
import misImplementaciones.dinamico.ABB;

/**
 * @materia Programaci�n II
 * @Examen  parcial
 * @fecha   20/05/2020
 * @author  xxxxxx
 * @lu      xxxxxx
 * 
 * C�dificar un m�todo externo que:
 * A partir de un �rbol ABB origen, generar un �rbol nuevo de la siguiente manera:
 * El sub�rbol derecho del �rbol nuevo debe tener como ra�z, la ra�z del sub�rbol izquierdo del sub�rbol derecho del �rbol origen. 
 * Los elementos de los sub�rboles afectados deber�n agregarse al �rbol nuevo sin que se modifique su estructura. 
 * Ejemplo:
 * �rbol origen
 *										 30
 *								SAi30				40                     
 *											 35				SAd40
 * 							   		  SAi35      SAd35
 *                                 
 *  �rbol destino   
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
