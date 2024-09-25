package es.escueladeprogramacion.modelos;

public class AlmacenMensajes {
    
    private String mensaje;
    
    public AlmacenMensajes() {
        this.setMensaje("¡Hola Mundo!");
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    @Override
    public String toString() {
        return "El mensaje es \"" + mensaje + "\".";
    }

}