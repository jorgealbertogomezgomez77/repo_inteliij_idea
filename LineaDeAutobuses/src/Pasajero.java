
public class Pasajero {
    private String nombre;
    private String apellido;

    public Pasajero() {

    }

    public Pasajero(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Pasajero{" + "nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + '}';
    }
}
