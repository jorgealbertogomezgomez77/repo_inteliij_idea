
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class GestorAutobuses {
    private Autobus[] autobuses;
    private String nombre;
    private Hashtable<String, ArrayList<Autobus>> tablaorigenes = new Hashtable<String, ArrayList<Autobus>>();
    private Hashtable<String, ArrayList<Autobus>> tabladestinos = new Hashtable<String, ArrayList<Autobus>>();

    public GestorAutobuses() {
        pasarOrigenes();
        pasarDestinos();
    }

    public GestorAutobuses(Autobus[] autobuses, String nombre) {
        this.autobuses = autobuses;
        this.nombre = nombre;
        pasarOrigenes();
        pasarDestinos();
    }

    public Autobus[] getAutobuses() {
        return autobuses;
    }

    public void setAutobuses(Autobus[] autobuses) {
        this.autobuses = autobuses;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void pasarOrigenes() {
        for (int i = 0; i < autobuses.length; i++) {
            ArrayList<Autobus> lista = tablaorigenes.get(autobuses[i].getOrigen());
            if (lista == null) {
                lista = new ArrayList<Autobus>();
                lista.add(autobuses[i]);
                tablaorigenes.put(autobuses[i].getOrigen(), lista);
            }
            else {
                lista.add(autobuses[i]);
                tablaorigenes.put(autobuses[i].getOrigen(), lista);
            }
        }
    }

    public void pasarDestinos() {
        for (int i = 0; i < autobuses.length; i++) {
            ArrayList<Autobus> lista = tabladestinos.get(autobuses[i].getDestino());
            if (lista == null) {
                lista = new ArrayList<Autobus>();
                lista.add(autobuses[i]);
                tabladestinos.put(autobuses[i].getDestino(), lista);
            }
            else {
                lista.add(autobuses[i]);
                tabladestinos.put(autobuses[i].getDestino(), lista);
            }
        }
    }

    public void imprimeTodo() {
        Iterator<ArrayList<Autobus>> it = tablaorigenes.values().iterator();
        while (it.hasNext()) {
            ArrayList<Autobus> lista = it.next();
            Iterator<Autobus> it2 = lista.iterator();
            while (it2.hasNext()) {
                Autobus a = it2.next();
                a.toString();
            }
        }
    }

    public ArrayList<Autobus> filtrarPorOrigen(String ciudad) {
        ArrayList<Autobus> lista = tablaorigenes.get(ciudad);
        Iterator<Autobus> it = lista.iterator();
        while (it.hasNext()) {
            Autobus a = it.next();
            a.toString();
        }
        return lista;
    }

    public ArrayList<Autobus> filtrarPorDestino(String ciudad) {
        ArrayList<Autobus> lista = tabladestinos.get(ciudad);
        Iterator<Autobus> it = lista.iterator();
        while (it.hasNext()) {
            Autobus a = it.next();
            a.toString();
        }
        return lista;
    }

    public void imprimeDuracion() {
        int sumatoria1 = 0;
        for (int i = 0; i < autobuses.length; i++) {
            sumatoria1 += autobuses[i].getDuracion();
        }
        System.out.println(sumatoria1);
    }

    public void buscarPasajero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre del sospechoso.");
        String nombre = sc.nextLine();
        System.out.println("Escribe el apellido del sospechoso.");
        String apellido = sc.nextLine();
        System.out.println("Escribe el destino del sospechoso.");
        String destino = sc.nextLine();
        ArrayList<Autobus> lista = tabladestinos.get(destino);
        boolean encontrado = false;
        Iterator<Autobus> it = lista.iterator();
        while (it.hasNext()) {
            Autobus a = it.next();
            Pasajero[] listapasajeros = a.getPasajeros();
            int i = 0;
            while ((encontrado == false) && (i < listapasajeros.length)) {
                if ((listapasajeros[i].getNombre().compareToIgnoreCase(nombre) == 0)
                    && (listapasajeros[i].getApellido().compareToIgnoreCase(apellido) == 0)) {
                    Pasajero p = listapasajeros[i];
                    encontrado = true;
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("Pasajero encontrado " + p.toString());
                    System.out.println("Mas informacion " + a.toString());
                }
                i++;
            }
        }
    }
}
