package academia19e37;

public class Persona {
	String nombre;
	Integer clave;
	
	public Persona(String nombre, int clave) {
		this.nombre = nombre;
		this.clave = clave;
	}

	@Override
	public int hashCode() {
		int result;
		
		result = Math.abs((clave * nombre.hashCode()) % 100);
		
		return result;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", clave=" + clave + "]";
	}

}
