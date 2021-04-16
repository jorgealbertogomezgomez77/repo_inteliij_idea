package Clase8ElColegio;

import java.util.Random;

public class GeneradorAlumnos {
    public static Alumno[] generarAlumnos(int n) {
        String[] lnombres = {"José", "Juan", "Jacinto", "Jaime", "Javier", "Ana", "Rebeca", "Diana", "Antonia"};
        String[] lapellido = {"Díaz", "Garcís", "Smith", "Valefor", "Washintong", "Cubero", "Can", "Floid", "Garfun"};
        String[] lcurso = {"Primero", "Srgundo", "Tercero", "Cuarto"};
        Alumno[] conjuntoalumnos = new Alumno[n];

        for (int i = 0; i < n; i++) {
            Random r = new Random();
            int inombre = r.nextInt(lnombres.length);
            int iapellido = r.nextInt(lapellido.length);
            int icurso = r.nextInt(4);

            String DNI = Integer.toString((int)(Math.random() * 1000000));
            double notamedia = r.nextDouble() * 10;

            Alumno nuevoalumno = new Alumno(lnombres[inombre], lapellido[iapellido], DNI, lcurso[icurso], notamedia);
            if (i == 0) {
                Delegado d1 = new Delegado(lnombres[inombre], lapellido[iapellido], DNI, lcurso[icurso], notamedia, 5.0 );
                conjuntoalumnos[i] = d1;
            }
            else {
                conjuntoalumnos[i] = nuevoalumno;
            }
        }
        return conjuntoalumnos;
    }
}
