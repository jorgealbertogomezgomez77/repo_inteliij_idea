
package ampliacionelcolegio;

import ampliacionelcolegio.Alumno;
import ampliacionelcolegio.Profesor;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class Aula {
    private Hashtable<String, Alumno> tablaalumnos;
    private Profesor profesor;
    private String idaula;

    public Aula(Hashtable<String, Alumno> tablaalumnos, Profesor profesor, String idaula) {
        this.tablaalumnos = tablaalumnos;
        this.profesor = profesor;
        this.idaula = idaula;
    }

    public Hashtable<String, Alumno> getTablaalumnos() {
        return tablaalumnos;
    }

    public void setTablaalumnos(Hashtable<String, Alumno> tablaalumnos) {
        this.tablaalumnos = tablaalumnos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getIdaula() {
        return idaula;
    }

    public void setIdaula(String idaula) {
        this.idaula = idaula;
    }

    public Alumno buscarAlumno(String dni) {
        Alumno a = tablaalumnos.get(dni);
        return a;
    }

    public void addAlumno(Alumno al) {
        tablaalumnos.put(al.getDNI(), al);
    }

    public void delAlumno(String dni) {
        tablaalumnos.remove(dni);
    }

    public void imprimeAlumnos() {
        ArrayList<Alumno> lista = new ArrayList<Alumno>(tablaalumnos.values());

        Iterator<Alumno> it = lista.iterator();
        while (it.hasNext()) {
            Alumno a = it.next();
            a.imprimeAlumno();
        }
    }
}
