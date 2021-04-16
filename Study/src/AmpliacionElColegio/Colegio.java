
package ampliacionelcolegio;

import ampliacionelcolegio.Aula;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Colegio {
    private static Aula[] aulas;
    private static Director director;
    private static String nombre;

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
    
    public Alumno buscarAlumno(String dni){
        boolean encontrado=false;
        Alumno a=null;
        int i=0;
        while((i<aulas.length)&&(encontrado==false)){
            a=aulas[i].buscarAlumno(dni);
            if (a!=null){
                encontrado=true;
            }
            i++;
        }
        return a;
    }
    
    
    public void borrarAlumno(String dni){
        boolean encontrado=false;
        Alumno a=null;
        int i=0;
        while((i<aulas.length)&&(encontrado==false)){
            a=aulas[i].buscarAlumno(dni);
            if (a!=null){
                aulas[i].delAlumno(dni);
                encontrado=true;
            }
            i++;
        }
 
    }
    
    public void imprimeAlumnosColegio(PrintWriter salida){
        //salida.println("-------------------------------------------");
        int i=0;
        
        while((i<aulas.length)){
            salida.println("--------------------------------Lista de alumnos de el aula "+aulas[i].getIdaula()+"--------------------------------");
            ArrayList<Alumno> lista=new ArrayList<Alumno>(aulas[i].getTablaalumnos().values());
            Iterator<Alumno> it=lista.iterator();
            while(it.hasNext()){
                Alumno a=it.next();
                salida.println(a.imprimeAlumno2());
            }
            i++;
        }
       
    }
    
 /* public double getNotaMediaTotal(){
      double sumatotal=0.0;
      for(int i=0 ;i<aulas.length;i++){
        sumatotal=sumatotal+aulas[i].getNotaMediaAula();          
    }
      return (sumatotal/aulas.length)+(this.getDirector().getValoracion()*0.3);
  }
  
  public Alumno getMejorAlumnoColegio(){
      Alumno mejor=new Alumno();  
      double mejornota=0.0;
      for(int i=0 ;i<aulas.length;i++){
          if(aulas[i].getMejor().getNotamedia()>mejornota){
              mejor=aulas[i].getMejor();
              mejornota=mejor.getNotamedia();
          }
      }
      return mejor;
  }
  
  public void imprimirEstadistica(){
      System.out.println("Resumen de las estadisticas del Colegio"+this.getNombre());
      System.out.print("el Mejor Alumno del Colegio es: ");
      Alumno mejor=this.getMejorAlumnoColegio();
      mejor.imprimeAlumno();
      
      if(this.getNotaMediaTotal()>5.0){
           System.out.print("El Colegio esta listo para recibir la subencion con una nota media total de "+this.getNotaMediaTotal());                 
      }else{
          System.out.print("lo sentimos mucho pero no podra recibir la subencion con una nota media total de "+this.getNotaMediaTotal());      
      }
      
      
  }
  */  
    
}
