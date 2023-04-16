// ¿Eres capaza de encontrar el máximo?

package academia19e37;

import java.util.Random;

public class Dojo4{
	
  	public static void main(String[] args) {
      
      //Un array es una "lista ordenada"
      int[] lista;				//Se declaran así
      lista = new int[10];		//Acabamos de inicializar la lista con 10 posiciones
      							//Las posiciones van del 0 al 9
      
      //Hacemos referencia a cada posición así:
      lista[3] = 4;		//Asignamos un 4 a la cuarta posición.
      
      System.out.println("En la cuarta posición de la lista está el valor: " + lista[3]);
      
      //Vamos a utilizar la lista para guardar las puntuaciones de 10 jugadores
      //que creamos aleatoriamente.
      
      Random r = new Random();
      
      for (int i = 0; i < lista.length; i++)	//lista.length nos da el tamaño de la lista	
		lista[i] = r.nextInt(101);				//Asignamos a cada posición de la lista un valor aleatorio de 0 a 100
      
      int ganador = -1;
      
      //Mostramos la lista
      for (int i = 0; i < lista.length; i++)
    	  
      
      //---------------------------------------------------------------------------------
      //¿Eres capaz de encontrar la posición del jugador que ha ganado?
      
      
      
      //---------------------------------------------------------------------------------
      
      System.out.println("Ha ganado el jugador " + ganador);	
      
      
    }

}