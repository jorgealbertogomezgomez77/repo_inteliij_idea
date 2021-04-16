
package ampliacionelcolegio;

public class Director extends Persona{
    private double valoracion;

    public Director() {
    }

    public Director(double valoracion, String nombre, String apellido, String DNI) {
        super(nombre, apellido, DNI);
        this.valoracion = valoracion;
    }

    
    
    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
    
    
    
}
