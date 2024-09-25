package academia19e37;

public class LIFO {
	NodoLista cabeza = null;

	public void push(int valor) {
		NodoLista n = new NodoLista();
		n.valor = valor;
		n.siguiente = cabeza;
		cabeza = n;
	}

	public int pop() {
		int resultado = cabeza.valor;
		cabeza = cabeza.siguiente;
		return resultado;
	}
	
	
}
