
package ampliacionelcolegio;

import java.text.DecimalFormat;

public class Alumno extends Persona{
    private String curso;
    private double notamedia;

    public Alumno() {
    }

    public Alumno(String curso, double notamedia, String nombre, String apellido, String DNI) {
        super(nombre, apellido, DNI);
        this.curso = curso;
        this.notamedia = notamedia;
        
    }

    
    
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getNotamedia() {
        return notamedia;
    }

    public void setNotamedia(double notamedia) {
        this.notamedia = notamedia;
    }
     public void imprimeAlumno(){
         super.imprime();
         System.out.print(" Curso: "+this.getCurso()+" Nota Media: "+this.getNotamedia());
         System.out.println();
     }
     
       public String imprimeAlumno2(){
         String resultado="";
         resultado+=super.toString();
         DecimalFormat decimales=new DecimalFormat("00.00");
         resultado+=" Curso: "+this.getCurso()+" Nota Media: "+decimales.format(this.getNotamedia());
         return resultado;
     }

 
     
     
    
}
