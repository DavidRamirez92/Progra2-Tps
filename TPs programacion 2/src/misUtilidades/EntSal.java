package misUtilidades;

import java.io.BufferedReader;
import java.io.FileReader;

import misApis.DiccionarioMultipleTDA;
import misApis.PilaTDA;

public class EntSal {
	public  void CargarPilaArch(PilaTDA destino){
		try {
	      FileReader arch = new FileReader("pila.csv");
	      BufferedReader buffer = new BufferedReader(arch);
	      int cual;
	      
	      String linea;
	      while((linea = buffer.readLine()) != null) {
 	  
	    	  cual = Integer.valueOf(linea); 
	    	  destino.apilar(cual);
	      }
	      arch.close();
	    }
	    catch(Exception e) {
	      System.out.println("Excepcion leyendo archivo "+ "pila.csv" + ": " + e);
	    }		
	}
	
	
	public  void CargarDiccionarioMArch(DiccionarioMultipleTDA destino){
		try {
	      FileReader arch = new FileReader("Materias.csv");
	      BufferedReader buffer = new BufferedReader(arch);
	      int nroCarrera;
	      int nroMateria;
	      String linea;
	      linea=buffer.readLine();
	      linea=buffer.readLine();
	      while(linea != null) {
	    	  String [] lista=linea.split(";");
	    	  nroCarrera=Integer.valueOf(lista[0]);
	    	  nroMateria=Integer.valueOf(lista[1]); 
	    	  destino.agregar(nroCarrera, nroMateria);
	      }
	      arch.close();
	    }
	    catch(Exception e) {
	      System.out.println("Excepcion leyendo archivo "+ "Materias.csv" + ": " + e);
	    }		
	}
}
