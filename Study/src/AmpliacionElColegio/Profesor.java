
package ampliacionelcolegio;

public class Profesor extends Persona{
    private String especialidad;

    public Profesor() {
    }
    
    public Profesor(String espe, String nombre, String apellido, String dni){
        super(nombre,apellido,dni);
        this.especialidad=espe;
    }
    
    
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    
}
