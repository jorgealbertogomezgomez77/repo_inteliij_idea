package Clase8ElColegio;

public class Profesor extends Persona {
    private String especialidad;

    public Profesor() {

    }

    public Profesor(String nombre, String apellido, String DNI, String especialidad) {
        super(nombre, apellido, DNI);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
