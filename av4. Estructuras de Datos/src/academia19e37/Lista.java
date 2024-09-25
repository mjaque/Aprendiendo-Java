package academia19e37;

public class Lista {
	NodoLista primero;

	public void add(int valor){
	
	}
	
	public int size(){
		//TODO:
		return 0;
	}
	
	public int get(int posicion){
		 
      	NodoLista actual = primero;
		
		for(int i = 0; i < posicion; i++){
          	actual = actual.siguiente;
		}
      	return actual.valor;
    }
	
	
	public boolean contains(int valor){
		//TODO:
		return false;
	}

}
