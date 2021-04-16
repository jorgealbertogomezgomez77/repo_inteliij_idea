package Clase17Debugger;

import java.util.ArrayList;

public class Clase17Debugger {
    public static void main(String[] args) {
        ArrayList<Alumno> lista = GeneradorAlumnos.generarAlumnos(30);
        Operaciones op = new Operaciones();
        op.imprimeInfo(lista);
        op.getNotaMedia(lista);
    }
}
