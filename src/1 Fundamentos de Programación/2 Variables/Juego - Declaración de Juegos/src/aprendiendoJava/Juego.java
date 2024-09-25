package aprendiendoJava;

/**
* Un partido de tenis queda definido por: el nombre completo de ambos jugadores, el ganador, el resultado obtenido, su duración y la fecha en que se jugó. Realiza la declaración y asignación de variables para definir el partido entre Rafael Nadal y Novak Djokovic que se celebró el 3 de junio de 2008, que duró 4,3 horas y cuyo resultado final fue de 3 sets a 2 para Rafael Nadal.
*/

public class Juego {
	//Juego del Ahorcado
	String palabra = "secreto";
	String letrasPropuestas = "aeioustr";
	
	//Tres en Raya
	char posicion1 = 'O';
	char posicion2 = 'X';
	char posicion3 = 'X';
	char posicion4 = 'O';
	char posicion5 = 'X';
	char posicion6 = '_';
	char posicion7 = '_';
	char posicion8 = '_';
	char posicion9 = '_';
	
	//Parchís
	int posRoja1 = 0;	//En casa
	int posRoja2 = 20;
	int posRoja3 = 32;
	int posRoja4 = 100;	//En centro
	int posVerde1 = 5;
	int posVerde2 = 3;
	int posVerde3 = 23;
	int posVerde4 = 100;
	int posAzul1 = 0;
	int posAzul2 = 0;
	int posAzul3 = 5;
	int posAzul4 = 23;
	int posAmarilla1 = 0;
	int posAmarilla2 = 100;
	int posAmarilla3 = 100;
	int posAmarilla4 = 42;
	String turno = "Verde";
	
	//Poker - Cerrado
	double dineroJug1 = 299.78;
	double dineroJug2 = 23.32;
	double dineroJug3 = 399.22;
	double dineroJug4 = 234.30;
	//C-Corazones, P-Picas, T-Tréboles, D-Diamantes
	String manoJug1 = "1C-10P-4T-4D-JD";
	String manoJug2 = "5D-5T-5P-DD-KT";
	String manoJug3 = "1P-1T-Jo-KD-KC";
	String manoJug4 = "2T-3T-4C-5P-6P";
	double bote = 50.45;
	
}