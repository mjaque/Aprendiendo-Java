package aprendiendoJava;

/**
* Declaración de Variables de Distintos Tipos Primitivos
*/
public class Ejercicio {

	//Entero (int). 
	//Desde -2147483648 a 2147483647
	//Valor por defecto: 0
	//Ocupa: 32 bits.
	//Formato: complemento a 2
	int numero = 17, negativo = -4002;
	
	//Coma Flotante (float). 
	//Desde -3.4028235E38 a 3.4028235E38
	//Valor por defecto: 0.0f
	//Máxima precisión: 1.4E-45
	//Ocupa: 32 bits.
	//Formato: IEE 754
	float decimal = 17.834f, decimalNegativo = -17394.0302f, cientifico = 6.673E-11f, enteroDecimal = 13f;
	
	//Doble Precisión (double). 
	//Desde -1.7976931348623157E308 a 1.7976931348623157E308
	//Valor por defecto: 0.0d
	//Máxima precisión: 4.9E-324
	//Ocupa: 64 bits.
	//Formato: IEE 754
	double doblePrecision = 28373732.38383737d, dobleCientifico = 0.1234567890123456789E234d;
	
	//Carácter (char)
	//Valor por defecto: '\u0000'
	//Ocupa: 16 bits.
	//Formato: Unicode
	char letra = 'A', digito = '9', caracter = '%', especial = '\n';
	
	//Booleano (boolean)
	//Valor por defecto: false
	//Ocupa: sin precisar.
	boolean verdad = true, falso = false;
	
	//Texto (String)
	//Valor por defecto: null
	String nombre = "Miguel Jaque"; //No es técnicamente un "tipo primitivo".
	
	//Octeto (byte). 
	//Desde -128 a 127
	//Valor por defecto: 0
	//Ocupa: 8 bits.
	//Formato: complemento a 2
	byte unByte = 13, otroByte = -5;
	
	//Corto (short). 
	//Desde -32768 a 32767
	//Valor por defecto: 0
	//Ocupa: 16 bits.
	//Formato: complemento a 2	
	short unCorto = -32768, otroCorto = 32767;
	
	//Largo (long). 
	//Desde -9223372036854775808 a 9223372036854775807 [-2^63 a 2^63 - 1]
	//Valor por defecto: 0
	//Ocupa: 64 bits.
	//Formato: complemento a 2		
	long unLargo = 19345L; long otroLargo = 9223372036854775807L;
	
	//Literales en otras bases (pueden utilizarse con cualquier tipo numérico)
	int hexadecimal = 0x1a, binario = 0b11010;
	byte byteHexadecimal = 0x0a, byteBinario = 0b11010;
	
	public static void main(String[] args){
		System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
		System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
		System.out.println("Float.MAX_VALUE = " + Float.MAX_VALUE);
		System.out.println("Float.MIN_VALUE = " + Float.MIN_VALUE);
		System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);
		System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE);
		System.out.println("Byte.MAX_VALUE = " + Byte.MAX_VALUE);
		System.out.println("Byte.MIN_VALUE = " + Byte.MIN_VALUE);
		System.out.println("Short.MAX_VALUE = " + Short.MAX_VALUE);
		System.out.println("Short.MIN_VALUE = " + Short.MIN_VALUE);
		System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
		System.out.println("Long.MIN_VALUE = " + Long.MIN_VALUE);
	}
	
}