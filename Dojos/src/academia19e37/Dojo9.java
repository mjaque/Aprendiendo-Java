package academia19e37;

public class Dojo9 {
	
	public static void main(String[] args) {
//		Dada una matriz de números enteros de dimensiones 4x4, diseñar un algoritmo que 
//		recorra los cuatro bloques de 2x2 que se forman mostrando su valor en el orden indicado:
//			- Bloque 1: a(0,0), a(0,1), a(1,0), a(1,1).
//			- Bloque 2: a(0,2), a(0,3), a(1,2), a(1,3).
//			- Bloque 3: a(2,0), a(2,1), a(3,0), a(3,1).
//			- Bloque 4: a(2,2), a(2,3), a(3,2), a(3,3).
		
		int[][] a = new int[4][4];
		
		//Rellenamos la matriz
		int c = 1;
		for (int i = 0; i < 16; i++)
			a[i/4][i%4] = c++;
		
		for (int i = 0; i < 4; i++){
			for (int j = 0; j < 4; j++)
				System.out.print(a[i][j] + "  ");
			System.out.println();
		}
		
		for (int i = 0; i < 4; i++)		//Cuatro bloques
			for (int j = 0; j < 4; j++)	//Cuatro elementos por bloque
				System.out.println(a[j/2 + (i/2) * 2][j%2 + (i%2) * 2]);
	}

}
