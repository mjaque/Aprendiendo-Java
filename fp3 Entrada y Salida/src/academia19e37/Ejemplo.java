package academia19e37;

/**
	Presentación de valores por pantalla con formato
*/

public class Ejemplo{

	public static void main(String[] args) {
		int i = 2;
		double r = Math.sqrt(i);
		
		/*System.out.format
			%d - int.
			%f - float.
			%s - String.
			%n - Salto de línea específico del sistema local. \n siempre genera \u000A.
			%x - Hexadecimal.
			%tB - Formatea un entero con el nombre del mes en el sistema local.
		*/
		System.out.format("La raíz cuadrada de %d is %f.%n", i, r);
		
		//Salida por el canal de error
		System.err.format("La raíz cuadrada de %d is %f.%n", i, r);
		
		//Formateo complejo
		System.out.format("%f, %1$+020.10f %n", Math.PI);
		/*
			% - inicio del formateador.
			1$ - índice del argumento.
			+0 - flags:
				+: indica que se usará siempre signo.
				0: usa carácter 0 para rellenar.
				-: relleno por la izquierda
				,: utilizar separador de miles local.
			20 - anchura (opcional). Se rellena a la izquierda con espacios.
			.10 - precisión (opcional). Indica el número de decimales o la máxima anchura.
			f - conversión.
		*/
		
		System.out.format("%f, %1$-4.3f %n", Math.PI);
		System.out.format("%f, %1$-4.3f %n", 0.3);
		
		
	}
	
}
 
