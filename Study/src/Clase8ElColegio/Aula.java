package Clase8ElColegio;

import java.text.DecimalFormat;
import java.util.SplittableRandom;

public class Aula {
    private Alumno[] alumnos;
    private Profesor profesor;
    private String idaula;

    public Aula() {

    }

    public Aula(Alumno[] alumnos, Profesor profesor, String idaula) {
        this.alumnos = alumnos;
        this.profesor = profesor;
        this.idaula = idaula;
    }

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public String getIdaula() {
        return idaula;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void setIdaula(String idaula) {
        this.idaula = idaula;
    }

    public double getNotaMediaAula() {
        //DecimalFormat format = new DecimalFormat("00.00");
        double sumatotal = 0.0;
        for (int i = 0; i < this.getAlumnos().length; i++) {
            // Conversión descendente.
            if (alumnos[i] instanceof Delegado) {
                Delegado d1 = (Delegado)alumnos[1];
                sumatotal = sumatotal + (0.1 * d1.getValoracion());
                sumatotal = sumatotal + alumnos[i].getNotamedia();
            }
            else {
                sumatotal = sumatotal + alumnos[i].getNotamedia();
            }
        } // Acaba nuestro for.
        return sumatotal / alumnos.length;
    }

    public void imprimeListadoAlumnos() {
        System.out.println("--------------------------------------" + this.getIdaula() + "-------------------------------------------");
        System.out.println();
        for (int i = 0; i < alumnos.length; i++) {
            alumnos[i].imprimeAlumno();
        }
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
    }

    public Alumno getMejor() {
        Alumno mejor = new Alumno();
        double mejornota = 0.0;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i].getNotamedia() > mejornota) {
                mejornota = alumnos[i].getNotamedia();
                mejor = alumnos[i];
            }
        }
        return mejor;
    }
}
