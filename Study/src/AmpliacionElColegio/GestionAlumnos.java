
package ampliacionelcolegio;

public class GestionAlumnos {
    Colegio colegio;

    public GestionAlumnos(Colegio colegio) {
        this.colegio = colegio;
    }
    
    public Alumno buscarAlumno(String DNI) {
        return colegio.buscarAlumno(DNI);
    }
    
    public void addAlumno(String curso, double notamedia, String nombre, String apellido, String DNI, int aula ) {
        Alumno a = new Alumno(curso, notamedia, nombre, apellido, DNI);
        Aula aulaaux = colegio.getAulas()[aula];
        aulaaux.addAlumno(a);
    }
    
    public void borrarAlumno(String DNI) {
        colegio.borrarAlumno(DNI);
    }
}
