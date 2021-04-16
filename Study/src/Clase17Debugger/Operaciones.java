package Clase17Debugger;

import java.util.ArrayList;
import java.util.Iterator;

public class Operaciones {
    public void imprimeInfo(ArrayList<Alumno> lista) {
        Iterator<Alumno> it = lista.iterator();
        while (it.hasNext()) {
            Alumno a = it.next();
            a.imprimeAlumno();
        }
    }

    public void getNotaMedia(ArrayList<Alumno> lista) {
        Iterator<Alumno> it2 = lista.iterator();
        double notatotal = 0;
        while (it2.hasNext()) {
            Alumno a = it2.next();
            notatotal = a.getNotamedia() + notatotal;
        }
        System.out.println("La nota media es de " + notatotal / lista.size());
    }
}
