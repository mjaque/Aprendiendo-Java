package aprendiendoJava;


public enum Singleton {
	INSTANCE;
   
	private Singleton(){
		System.out.println("Ejecutando constructor.");
	}
	
	public void metodo(){
		System.out.println("Ejecutando método.");
	}
}