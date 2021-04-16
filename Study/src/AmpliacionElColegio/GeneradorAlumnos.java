package ampliacionelcolegio;

import java.util.Hashtable;
import java.util.Random;

public class GeneradorAlumnos { 
    public static Hashtable<String,Alumno> generarAlumnos(int n){
        Hashtable<String,Alumno> tablaalumnos=new Hashtable<String,Alumno>();
        String[] lnombres={"Jose","Juan","Jacinto","Jaime","Javier","Ana","Rebeca","Diana","Antonia"};
        String[] lapellido={"Diaz","Garcia","Smith","Valefor","Whasintong","Cubero","Can","Floid","Garfun"};
        String[] lcursos={"Primero","Segundo","Tercero","Cuarto"};
        Alumno[] conjuntoalumnos = new Alumno[n];

            for(int i=0;i<n;i++){
               Random r = new Random();
               int inombre =r.nextInt(lnombres.length);
               int iapellido =r.nextInt(lapellido.length);
               
               String dni=Integer.toString((int)(Math.random()*1000000));
               double notamedia=r.nextDouble()*10;
               int icurso=r.nextInt(4);
               
               Alumno nuevoalumno=new Alumno(lcursos[icurso],notamedia,lnombres[inombre],lapellido[iapellido],dni);
               if(i==0){
                   Delegado d1=new Delegado(5.0,lcursos[icurso],notamedia,lnombres[inombre],lapellido[iapellido],dni);
                   conjuntoalumnos[i]=d1;
               }else{
                  conjuntoalumnos[i]=nuevoalumno; 
               }
               
            }
            
          for(int i=0;i<conjuntoalumnos.length;i++){
          tablaalumnos.put(conjuntoalumnos[i].getDNI(), conjuntoalumnos[i]);
      }
            return tablaalumnos;
    }
    
}
