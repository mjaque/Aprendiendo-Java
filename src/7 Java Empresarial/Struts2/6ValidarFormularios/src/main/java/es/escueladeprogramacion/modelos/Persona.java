package es.escueladeprogramacion.modelos;

public class Persona {
    private String nombre;
    private String apellidos;
    private String email;
    private int edad;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setAge(int edad) {
        this.edad = edad;
    }

    public String toString() {
        return "Nombre: " + getNombre() + " Apellidos:  " + getApellidos() + 
        " Email:      " + getEmail() + " Edad:      " + getEdad() ;
    }
}
