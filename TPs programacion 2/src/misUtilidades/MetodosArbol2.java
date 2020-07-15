package misUtilidades;
import misImplementaciones.dinamico.*;
import misApis.*;
public class MetodosArbol2 {
	public int cantElemArbol(ABBTDA arbol) {// correcto, cantidad de elementos del arbol
		if(arbol.arbolVacio()) {
			return 0;
		}else {


			return 1+cantElemArbol(arbol.hijoIzq())+cantElemArbol(arbol.hijoDer());
		}

	}
	public int cantElemParesArbol(ABBTDA arbol) {//correcto cantidad de elementos pares del arbol
		if(arbol.arbolVacio()) {
			return 0;
		}else {
			if( arbol.raiz()%2==0){
				return(1+cantElemParesArbol(arbol.hijoIzq())+cantElemParesArbol(arbol.hijoDer()));
			}else {
				return(cantElemParesArbol(arbol.hijoIzq())+cantElemParesArbol(arbol.hijoDer()));
			}

		}

	}
	public int sumaElemImparesArbol(ABBTDA arbol) {//correcto, devuelve la suma de los elementos impares del arbol
		if(arbol.arbolVacio()) {
			return 0;
		}else {
			if( arbol.raiz()%2==1){
				return(arbol.raiz()+sumaElemImparesArbol(arbol.hijoIzq())+sumaElemImparesArbol(arbol.hijoDer()));
			}else {
				return(sumaElemImparesArbol(arbol.hijoIzq())+sumaElemImparesArbol(arbol.hijoDer()));
			}

		}

	}
	public int valorMinimoArbol (ABBTDA arbol) {//correcto, devuelve el valor minimo del arbol
		if(arbol.hijoIzq().arbolVacio()) {
			return arbol.raiz();
		}else {
			return valorMinimoArbol(arbol.hijoIzq());
		}

	}
	public int valorMaximoArbol (ABBTDA arbol) {//correcto, devuelve el valor maximo del arbol
		if(arbol.hijoDer().arbolVacio()) {
			return arbol.raiz();
		}else {
			return valorMaximoArbol(arbol.hijoDer());
		}
	}
	public int profundidadElemento(ABBTDA arbol, int elem) {//correcto, devuelve la profunidad de un elemento del arbol
		if(arbol.raiz()==elem) {
			return 0;
		}else {
			if(elem>arbol.raiz()) {
				return 1+profundidadElemento(arbol.hijoDer(),elem);
			}else {
				return 1+profundidadElemento(arbol.hijoIzq(),elem);
			}

		}

	}
	public int alturaArbol(ABBTDA arbol) {//correcto,devuelve la altura de un arbol
		int alturaIzq=0,alturaDer=0;
		if(arbol.hijoIzq().arbolVacio()&&arbol.hijoDer().arbolVacio()) {
			return 0;
		}else{
			if(!arbol.hijoIzq().arbolVacio()&&!arbol.hijoDer().arbolVacio()) {
				alturaIzq+=1+alturaArbol(arbol.hijoIzq());
				alturaDer+=1+alturaArbol(arbol.hijoDer());

			}else {
				if(!arbol.hijoIzq().arbolVacio()) {
					alturaIzq+=1+alturaArbol(arbol.hijoIzq());
				}else {
					alturaDer+=1+alturaArbol(arbol.hijoDer());
				}

			}

		}
		if(alturaIzq>alturaDer) {
			return alturaIzq;
		}else {
			return alturaDer;
		}

	}
	public int valorAcendenteCercano(ABBTDA arbol, int valor) {//correcto, devuelve el padre del valor solicitado
		if(!arbol.hijoIzq().arbolVacio()){
			if(arbol.hijoIzq().raiz()==valor)
				return arbol.raiz();
		}
		if(!arbol.hijoDer().arbolVacio()) {
			if(arbol.hijoDer().raiz()==valor)
				return arbol.raiz();
		}
		if(valor>arbol.raiz())
			return valorAcendenteCercano(arbol.hijoDer(),valor);
		return valorAcendenteCercano(arbol.hijoIzq(),valor);	
	}
	
	public void vaciarArbol(ABBTDA arbol) {// correcto, vacia el arbol
		if(!arbol.arbolVacio()) {
			vaciarArbol(arbol.hijoIzq());
			vaciarArbol(arbol.hijoDer());
			arbol.eliminar(arbol.raiz());

		}
	}
	public DiccionarioSimpleTDA dicConArbol(ABBTDA arbol) {//correcto, devuelve un diccionario con el valor y la condicion de equilibrio del arbol
		DiccionarioSimpleTDA dic=new DicionarioSimple();
		DiccionarioSimpleTDA dicIzq=new DicionarioSimple();
		DiccionarioSimpleTDA dicDer=new DicionarioSimple();
		ConjuntoTDA aux=new Conjunto();
		int valor;
		dic.inicializarDiccionario();
		if(arbol.arbolVacio()) {
			return dic;
		}else {

			dic.agregar(arbol.raiz(),condicionEquilibrio(arbol));
			dicIzq=dicConArbol(arbol.hijoIzq());
			dicDer=dicConArbol(arbol.hijoDer());
			aux=dicIzq.Claves();
			while(!aux.conjuntoVacio()) {
				valor=aux.elegir();
				aux.sacar(valor);
				dic.agregar(valor,dicIzq.recuperar(valor));

			}
			aux=dicDer.Claves();
			while(!aux.conjuntoVacio()) {
				valor=aux.elegir();
				aux.sacar(valor);
				dic.agregar(valor,dicDer.recuperar(valor));

			}
			return dic;

		}


	}
	public int condicionEquilibrio(ABBTDA arbol) {//correcto, devuelve la condicion de equilibrio de un arbol
		if(arbol.hijoIzq().arbolVacio()&&arbol.hijoDer().arbolVacio()) 
			return 0;
		if(!arbol.hijoIzq().arbolVacio()&&arbol.hijoDer().arbolVacio())
			return (1+(alturaArbol(arbol.hijoIzq())));
		if(!arbol.hijoDer().arbolVacio()&&arbol.hijoIzq().arbolVacio())
			return (1+(alturaArbol(arbol.hijoDer())));
		int alturaIzq=alturaArbol(arbol.hijoIzq());
		int alturaDer=alturaArbol(arbol.hijoDer());
		if(alturaIzq>alturaDer)
			return alturaIzq-alturaDer;
		return alturaDer-alturaIzq;


	}
public ColaTDA elementosEnNivel(ABBTDA arbol,int nivel) {//correcto, devuelve una cola con la cantidad de elementos en un nivel dado
	ColaTDA cola=new Cola();
	ColaTDA izq,der;
	cola.inicializarCola();
	if(arbol.arbolVacio()) 
		return cola;
	else {
		if(nivel==0) {
			cola.acolar(arbol.raiz());
			return cola;
			
		}else {
			izq=elementosEnNivel(arbol.hijoIzq(),nivel-1);
			der=elementosEnNivel(arbol.hijoDer(),nivel-1);
			while(!izq.colaVacia()) {
				cola.acolar(izq.primero());
				izq.desacolar();
			}
			while(!der.colaVacia()) {
				cola.acolar(der.primero());
				der.desacolar();
			}
			return cola;
		}
			
		
	}
}

public boolean fibonacci(int valor,int a,int b) {//fibonacci recursivo
	if(valor==1||valor==2)
		return true;
	int c=a+b;
	if(valor==c)
		return true;
	else if(c>valor)
		return false;
	b=a;
	return fibonacci(valor,c,b);
		
				
}

public void eliminarFib(ABBTDA arbol) {
	if(!arbol.arbolVacio()) {
		if(fibonacci(arbol.raiz(),1,1))
			while(fibonacci(arbol.raiz(),1,1))
			arbol.eliminar(arbol.raiz());
		eliminarFib(arbol.hijoIzq());
		eliminarFib(arbol.hijoDer());
	}
}
public void mostrarOrdenado(ABBTDA arbol) {
	if(!arbol.arbolVacio()) {
		mostrarOrdenado(arbol.hijoIzq());
		System.out.println(arbol.raiz());
		mostrarOrdenado(arbol.hijoDer());
	}
}

public boolean arbolesIguales(ABBTDA a,ABBTDA b) {//funciona (hasta donde lo pude probar) devuelve un boolean si un arbol es igual a otro
	if(a.arbolVacio()&&b.arbolVacio()) {
		return true;

	}else {
		if(a.arbolVacio()&&!b.arbolVacio()) {
			return false;
		}
		if(!a.arbolVacio()&&b.arbolVacio()) {
			return false;
		}
		if(a.raiz()==b.raiz()) {
			boolean iguales;
			iguales= arbolesIguales(a.hijoIzq(),b.hijoIzq());
			if (iguales==false)
				return iguales;
			 iguales= arbolesIguales(a.hijoDer(),b.hijoDer());
			return iguales;
		}
		return false;
		}
			
		}
		
	}
	

