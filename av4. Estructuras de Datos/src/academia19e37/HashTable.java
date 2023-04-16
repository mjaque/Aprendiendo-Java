package academia19e37;

public class HashTable {
	
	NodoHashTable vector[];
	
	public HashTable(int tam){
		//Inicialización de la tabla
		this.vector = new NodoHashTable[tam];
		for (int i = 0; i < tam; i++)
			this.vector[i] = new NodoHashTable();
	}
	
	public boolean insert(String clave, int valor){
		NodoHashTable nodo = new NodoHashTable(clave, valor);
		int hash = nodo.hash();
		if (vector[hash].usado){
			hash++;
			if (vector[hash].usado)
				return false;
		}	
		vector[hash] = nodo;
		
		return true;
	}
	
	public void dump(){
		for(int i = 0; i < vector.length; i++){
			NodoHashTable n = vector[i];
			if (n.usado)
				System.out.println(i + " -> " + n.clave + ": " + n.valor);
		}
	}

}
