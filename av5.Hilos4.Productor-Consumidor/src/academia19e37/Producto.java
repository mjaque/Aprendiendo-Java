package academia19e37;

public class Producto{
	private static int contador = 1;
	
	private int id;

	public Producto(){
		this.id = contador++;
	}

	public int getId(){
		return this.id;
	}
}
