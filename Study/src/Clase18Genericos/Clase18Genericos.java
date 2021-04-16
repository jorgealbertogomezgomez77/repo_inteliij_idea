package Clase18Genericos;

import java.util.ArrayList;

public class Clase18Genericos {
    public static void main(String[] args) {
        ArrayList<Colegio> alumnos = new ArrayList<Colegio>();
        OperacionesIMB op = new OperacionesIMB();
        Alumno co1 = new Alumno();
        Alumno co2 = new Alumno();
        co1.setCurso("Primero de mamología");
        co2.setCurso("Primero de tetología");
        op.insertarElemento(alumnos, co1);
        op.insertarElemento(alumnos, co2);
        op.imprimirElemento(alumnos);
        op.borrarElemento(alumnos, co1);
        op.imprimirElemento(alumnos);

    }
}
