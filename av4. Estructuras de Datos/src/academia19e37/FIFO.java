package academia19e37;

public class FIFO {
	NodoListaDobleEnlace primero = null;	//El primer elemento que tiene que salir
	NodoListaDobleEnlace ultimo = null;	//El último elemento que ha entrado
	
	/*
	 * Pone un elemento en la lista
	 */
	public void push(int valor){
		//Crear un nodo con el nuevo valor
		NodoListaDobleEnlace n = new NodoListaDobleEnlace();
		n.valor = valor;
		n.siguiente = ultimo;
		n.anterior = null;
		ultimo.anterior = n;
		
		ultimo = n;
	}
	
	/*
	 * Saca un elemento de la lista
	 */
	public int pop(){
		int resultado = primero.valor;
		
		//Reorganizamos "punteros"
		primero.anterior.siguiente = null;
		primero = primero.anterior;
		
		return resultado;
	}
}
