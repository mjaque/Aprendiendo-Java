package academia19e37;

public class Conjunto {
	
	private int[] datos = new int[100]; 
	private int indice = 0;
	
	public void add(int valor){
		//Hay que comprobar si ya está
		
		this.datos[this.indice++] = valor;
	}
	
	public int size(){
		//TODO:
		return 0;
	}
	
	public int get(){
		//TODO:
		return 0;		
	}
	
	public boolean contains(int valor){
		//TODO:
		return false;
	}

}
