package Clase17Debugger;

import java.util.ArrayList;
import java.util.Random;

public class GeneradorAlumnos {
    public static ArrayList<Alumno> generarAlumnos(int n) {
        String[] lnombres = {"José", "Juan", "Jacinto", "Jaime", "Javier", "Ana", "Rebeca", "Diana", "Antonia"};
        String[] lapellido = {"Díaz", "Garcís", "Smith", "Valefor", "Washintong", "Cubero", "Can", "Floid", "Garfun"};
        String[] lcurso = {"Primero", "Srgundo", "Tercero", "Cuarto"};
        ArrayList<Alumno> conjuntoalumnos = new ArrayList<Alumno>();

        for (int i = 0; i < n; i++) {
            Random r = new Random();
            int inombre = r.nextInt(lnombres.length);
            int iapellido = r.nextInt(lapellido.length);
            int icurso = r.nextInt(4);

            String DNI = Integer.toString((int)(Math.random() * 1000000));
            double notamedia = r.nextDouble() * 10;

            Alumno nuevoalumno = new Alumno(lnombres[inombre], lapellido[iapellido], DNI, lcurso[icurso], notamedia);
            conjuntoalumnos.add(nuevoalumno);

        }
        return conjuntoalumnos;
    }
}
