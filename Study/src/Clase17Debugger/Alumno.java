package Clase17Debugger;


public class Alumno extends Persona {
    private String curso;
    private double notamedia;

    public Alumno() {

    }

    public Alumno(String nombre, String apellido, String DNI, String curso, double notamedia) {
        super(nombre, apellido, DNI);
        this.curso = curso;
        this.notamedia = notamedia;
    }

    public String getCurso() {
        return curso;
    }

    public double getNotamedia() {
        return notamedia;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setNotamedia(double notamedia) {
        this.notamedia = notamedia;
    }

    public void imprimeAlumno() {
        super.imprime();
        System.out.print(" Curso: " + this.getCurso() + " Nota Media: " + this.getNotamedia());
    }
}
