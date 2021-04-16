package Clase18Genericos;

import Clase8ElColegio.Alumno;
import Clase8ElColegio.Aula;
import Clase8ElColegio.Director;

import java.util.Arrays;

public class Colegio {
    private Aula[] aulas;
    private Director director;
    private String nombre;

    public Colegio() {

    }

    public Colegio(Aula[] aulas, Director director, String nombre) {
        this.aulas = aulas;
        this.director = director;
        this.nombre = nombre;
    }

    public Aula[] getAulas() {
        return aulas;
    }

    public void setAulas(Aula[] aulas) {
        this.aulas = aulas;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNotaMediTotal() {
        double sumatotal = 0.0;
        for (int i = 0; i < aulas.length; i++) {
            sumatotal = sumatotal + aulas[i].getNotaMediaAula();
        }
        return (sumatotal / aulas.length + this.getDirector().getValoracion() * 0.3);
    }

    public Alumno getMejorAlumnoColegio() {
        Alumno mejor = new Alumno();
        double mejornota = 0.0;
        for (int i = 0; i < aulas.length; i++) {
            if (aulas[i].getMejor().getNotamedia() > mejornota) {
                mejor = aulas[i].getMejor();
                mejornota = mejor.getNotamedia();
            }
        }
        return mejor;
    }

    public void imprimirEstadistica() {
        System.out.println("Resumen de las estadisticas del colegio " + this.getNombre());
        System.out.println("El mejor alumno del colegio es:");
        Alumno mejor = this.getMejorAlumnoColegio();
        mejor.imprimeAlumno();

        if (this.getNotaMediTotal() > 5.0) {
            System.out.println("El colegio está listo para recibir la subencion co una nota media total de " + this.getNotaMediTotal());
        }
        else {
            System.out.println("Lo sentimos pero no podrá recibir subencion co una nota media total de " + this.getNotaMediTotal());

        }
    }

    @Override
    public String toString() {
        return "Colegio{" +
                "aulas=" + Arrays.toString(aulas) +
                ", director=" + director +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
