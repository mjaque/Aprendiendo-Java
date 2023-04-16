package academia19e37;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo {
	NodoGrafo cualquiera;
	  
	  public void add(int valor, NodoGrafo n){
	  NodoGrafo m = new NodoGrafo();
	  m.valor = valor;
	  n.p.add(m);
	  }
	  
	  public boolean buscar(int valor){
	  Set<NodoGrafo> cerrados = new HashSet<>();
	  List<NodoGrafo> abiertos = new ArrayList<>();
	    
	    if(cualquiera.valor == valor)
	      return true; 
	    abiertos.addAll(cualquiera.p);
	    
	    while (!abiertos.isEmpty()){
	    	NodoGrafo a = abiertos.get(0);
	    	if(a.valor == valor)
	     	 return true;
	  		cerrados.add(a);
	    
	 	   for(NodoGrafo b : a.p)
	     	 if (!cerrados.contains(b))
	      	  abiertos.add(b);
	    
	   		 abiertos.remove(0);
	    }
	    return false;
	    
	  }

	}
