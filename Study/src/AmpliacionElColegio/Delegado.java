
package ampliacionelcolegio;

public class Delegado extends Alumno{
    double valoracion;

    public Delegado(){
        
    }
    
    public Delegado(double valora,String curso, double notamedia, String nombre, String apellido, String dni){
        super(curso,notamedia,nombre,apellido,dni);
        this.valoracion=valora;
        
    }
            
    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
    
    
}
