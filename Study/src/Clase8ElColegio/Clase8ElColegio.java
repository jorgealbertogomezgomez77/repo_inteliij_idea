package Clase8ElColegio;

public class Clase8ElColegio {
    public static void main(String[] args) {
        //Uso el Generador de Alumnos
        // el primer alumno es el delegado y tiene una valoracion de 5 sobre su curso
        Alumno[] conjuntoalumnos = GeneradorAlumnos.generarAlumnos(20);
        //vamos a tener 3 Aulas cada ua con su profesor y alumnos e id
        Profesor p1 = new Profesor("Juan","Ortiz", "001110","Matematicas");
        Aula a1 = new Aula(conjuntoalumnos, p1,"Aula 101");
        a1.imprimeListadoAlumnos();
        Profesor p2 = new Profesor("Jhon","Smith","001220", "Ingles");
        Aula a2 = new Aula(GeneradorAlumnos.generarAlumnos(20), p2,"Aula 102");
        a2.imprimeListadoAlumnos();
        Profesor p3 = new Profesor("Timmy","Proton","023220", "Fisica");
        Aula a3 = new Aula(GeneradorAlumnos.generarAlumnos(20), p3,"Aula 103");
        a3.imprimeListadoAlumnos();

        Aula[] almacenaulas = new Aula[3];
        almacenaulas[0] = a1;
        almacenaulas[1] = a2;
        almacenaulas[2] = a3;

        Director d1 = new Director("Don", "Delinguer", "121212A", 9.0);

        Colegio c1 = new Colegio(almacenaulas,d1,"Colegio Chupi");
        c1.imprimirEstadistica();
     /*   Alumno a1 = new Alumno("Juan", "Perez", "322435", "tercero", 9.8);
        Alumno[] almacenaalumnoas = new Alumno[1];
        almacenaalumnoas[0] = a1;
        Profesor p1 = null;
        Aula aula1 = new Aula(almacenaalumnoas, p1, "101");
        aula1.imprimeListadoAlumnos();*/
    }
}
