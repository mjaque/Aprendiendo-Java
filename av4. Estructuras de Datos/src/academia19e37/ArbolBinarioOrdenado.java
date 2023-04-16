package academia19e37;

public class ArbolBinarioOrdenado {
	  NodoBinario raiz;
	  
	  public boolean buscarPreOrder(int valor){
	    return buscarPreOrder(valor, raiz);
	  }
	  
	  public boolean buscarPreOrder(int valor, NodoBinario n){
	   if (n.valor == valor)
	      return true; 
	   
	   if(valor > n.valor)	//Por estar ordenado
		      return false; 
	    
	    if(buscarPreOrder(valor, n.nodoIzquierda))
	      return true; 
	    
	    if(buscarPreOrder(valor, n.nodoDerecha))
	      return true; 
	    
	    return false;
	  }

	}

