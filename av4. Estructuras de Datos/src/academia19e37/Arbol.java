package academia19e37;

public class Arbol {
	NodoArbol raiz;

	public void add(int valor, NodoArbol n){
	      NodoArbol m = new NodoArbol();
	      m.valor = valor; 
	      n.hijos.add(m); 
		}

	public boolean buscar(int valor) {
		return buscar(valor, raiz);
	}

	// Esta es recursiva
	private boolean buscar(int valor, NodoArbol n) {
		if (n.valor == valor)
			return true;
		for (NodoArbol a : n.hijos) {
			if (buscar(valor, a))
				return true;
		}
		return false;
	}
}
