package academia19e37;

public class NodoHashTable {
	String clave;
	boolean usado;
	int valor;

	public NodoHashTable(){
		this.clave = "";
		this.valor = -1;
		this.usado = false;
	}
	
	public NodoHashTable(String clave, int valor) {
		this.clave = clave;
		this.valor = valor;
		this.usado = true;
	}

	//TODO: implement hash function
	public int hash(){
		return hash(this.clave, this.clave.length(), this.valor);
	}


	private int hash(String clave, int longitud, int valor) {
		if (longitud == 0)
			return 0;

		return (256*this.hash(clave, longitud-1, valor) + clave.charAt(longitud - 1))%valor;
	}
	
	
	 
		

	//TODO: write function to initHashList, which creates and inits an array of type HashEntry
	/* your code */

	//TODO: implement insert function to insert values into the hash list
	/* your code */

	//TODO: need to implement dump function for plotting the hash list
	/* your code */

	//TODO: implement remove function to remove values from the hash list
	/* your code */

	//TODO: implement get function to get the value stored under a special key
	/* your code */

}


