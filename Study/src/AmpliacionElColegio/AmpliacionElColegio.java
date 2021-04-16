
package ampliacionelcolegio;

import java.util.Hashtable;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class AmpliacionElColegio {
    public static void main(String[] args) {
        Hashtable<String, Alumno> conjuntoalumnos = GeneradorAlumnos.generarAlumnos(20);
        Hashtable<String, Alumno> tablaalumnos = new Hashtable<String, Alumno>();
        
        //vamos a tener 3 Aulas cada ua con su profesor y alumnos e id
        Profesor p1 = new Profesor("Matematicas", "Juan","Ortiz", "001110");
        Aula a1 = new Aula(conjuntoalumnos, p1,"Aula 101");
        
        Profesor p2 = new Profesor("Ingles", "Jhon","Smith","001220");
        Aula a2 = new Aula(GeneradorAlumnos.generarAlumnos(20), p2,"Aula 102");
        
        Profesor p3 = new Profesor("Fisica", "Timmy","Proton","023220");
        Aula a3 = new Aula(GeneradorAlumnos.generarAlumnos(20), p3,"Aula 103");

        Aula[] almacenaulas = new Aula[3];
        almacenaulas[0] = a1;
        almacenaulas[1] = a2;
        almacenaulas[2] = a3;

        Director d1 = new Director(9.0, "Don", "Delinguer", "121212A");

        Colegio c1 = new Colegio(almacenaulas,d1,"Aprender");
        
        ColegioGUI cu = new ColegioGUI(c1);
        cu.setVisible(true);
        cu.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
