package misUtilidades;

import misApis.ABBTDA;
import misApis.ColaPrioridadTDA;
import misImplementaciones.dinamico.ABB;
import misImplementaciones.dinamico.ColaPrioridad;

public class MetodosArbol {
	
	
	public void vaciarArbol(ABBTDA arbol) {
		if(!arbol.arbolVacio()) {
			vaciarArbol(arbol.hijoIzq());
			vaciarArbol(arbol.hijoDer());
			arbol.eliminar(arbol.raiz());
		}
	}
	public boolean encontrarValorArbol(ABBTDA arbol,int valor){
		if(arbol.arbolVacio()) {
			return false;
		}else if(arbol.raiz()==valor) {
			return true;
		}else if(arbol.raiz()>valor) {
			return this.encontrarValorArbol(arbol.hijoIzq(),valor);
		}else
			return this.encontrarValorArbol(arbol.hijoDer(), valor);
	}
	
	public void mostrarOrdenado (ABBTDA arbol){
		if(!arbol.arbolVacio()){
			mostrarOrdenado(arbol.hijoIzq());
			System.out.println(arbol.raiz());
			mostrarOrdenado(arbol.hijoDer());
		}
	}

	public void mostrarPreOrden(ABBTDA arbol){
		if(!arbol.arbolVacio()){
			System.out.println(arbol.raiz());
			mostrarPreOrden(arbol.hijoIzq());
			mostrarPreOrden(arbol.hijoDer());
		}



	}

	public void mostrarPostOrden(ABBTDA arbol){
		if(!arbol.arbolVacio()){
			mostrarPostOrden(arbol.hijoIzq());
			mostrarPostOrden(arbol.hijoDer());
			System.out.println(arbol.raiz());
		}
	}
	public int elementosMismoNivel(ABBTDA arbol, int nivel){
		if(arbol.arbolVacio()){
			return 0;
		}else{
			if(nivel == 0){
				return 1;
			}else
				return elementosMismoNivel(arbol.hijoIzq(),nivel-1) + elementosMismoNivel(arbol.hijoDer(),nivel-1);
		}
	}

	public int cantidadElementos(ABBTDA arbol){
		if(!arbol.arbolVacio()){
			return 1 + cantidadElementos(arbol.hijoIzq()) +cantidadElementos(arbol.hijoDer());
		}
		return 0;
	}


	private int AcumImparesElem(ABBTDA a) {
		if(a.arbolVacio()){
			return 0;
		}else{
			if(a.raiz()%2 == 1){
				return a.raiz() + AcumImparesElem(a.hijoIzq()) + AcumImparesElem(a.hijoDer());
			}else{
				return AcumImparesElem(a.hijoIzq()) + AcumImparesElem(a.hijoDer());
			}
		}
	}

	private int cantElemTotal(ABBTDA a) {
		if(a.arbolVacio()){
			return 0;
		}
		return (1 + cantElemTotal(a.hijoIzq()) + cantElemTotal(a.hijoDer()));
	}

	public int minimo(ABBTDA a) {
		if (a.hijoIzq().arbolVacio()) {
			return a.raiz();
		} else if (a.hijoIzq().arbolVacio() && a.hijoDer().arbolVacio()) {
			return a.raiz();
		} else {
			return minimo(a.hijoIzq());
		}
	}

	public int profundidad(ABBTDA a, int dato) {
		if (a.raiz() == dato) {
			return 0;
			// si el dato es mayot va a estar en el lado derecho del arbol
		} else if (a.raiz() < dato) {
			return 1 + profundidad(a.hijoDer(), dato);
		} else {
			// si es menor va a estar a la izq
			return 1 + profundidad(a.hijoIzq(), dato);
		}
	}

	public int altura(ABBTDA arbol){
		if(arbol.arbolVacio()){
			return 0;
		}else if(!arbol.hijoDer().arbolVacio() || !arbol.hijoIzq().arbolVacio()){
			int alturaDer = altura(arbol.hijoDer());
			int alturaIzq = altura(arbol.hijoIzq());
			if(alturaDer > alturaIzq){
				return alturaDer +1;
			}else{
				return alturaIzq +1;
			}
		} else {
			return 0;
		}
	}

	public int diferenciaAltura(ABBTDA a) {
		if(a.hijoIzq().arbolVacio()&&a.hijoDer().arbolVacio())
			return 0;
		if(!a.hijoIzq().arbolVacio()&&a.hijoDer().arbolVacio())
			return 1+(this.altura(a.hijoIzq()));
		if(!a.hijoDer().arbolVacio()&&a.hijoIzq().arbolVacio())
			return 1+(this.altura(a.hijoDer()));
		int alturaI=this.altura(a.hijoIzq());
		int alturaD=this.altura(a.hijoDer());
		if(alturaI>alturaD) {
			return (alturaI-alturaD);
		}else
			return(alturaD-alturaI);
	}
	
	public ColaPrioridadTDA colaDeArbol(ABBTDA a) {
		ColaPrioridadTDA cola=new ColaPrioridad();
		cola.inicializarColaPrioridad();
		if(!a.arbolVacio()) {
			cola.acolarPrioridad(this.diferenciaAltura(a),a.raiz());
			ColaPrioridadTDA colaI=colaDeArbol(a.hijoIzq());
			ColaPrioridadTDA colaD=colaDeArbol(a.hijoDer());
			while(!colaI.colaVacia()) {
				cola.acolarPrioridad(colaI.primero(),colaI.prioridad());
				colaI.desacolar();
			}
			while(!colaD.colaVacia()) {
				cola.acolarPrioridad(colaD.primero(),colaD.prioridad());
				colaD.desacolar();
			}

		}

		return cola;
	}

	public int cantHojas(ABBTDA arbol) {
		if(arbol.arbolVacio()){
			return 0;
		}else{
			if(arbol.hijoDer().arbolVacio() && arbol.hijoDer().arbolVacio()){
				return 1;
			}else{
				return cantHojas(arbol.hijoDer()) + cantHojas(arbol.hijoIzq());
			}
		}
	}
	public boolean arbolIgual(ABBTDA arbol, ABBTDA arbol2) {
		if(arbol.arbolVacio() && arbol2.arbolVacio()){
			return true;
		}else{
			if(arbol.raiz() == arbol2.raiz()){
				if(arbolIgual(arbol.hijoDer(),arbol2.hijoDer())){
					return  arbolIgual(arbol.hijoIzq(),arbol2.hijoIzq());
				}else
					return false;
			}else{
				return false;
			}
		}
	}
	
	
}