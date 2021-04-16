
public class Ejecutame {
    public static void main(String[] args) {
        GestorAutobuses ga = new GestorAutobuses(GeneradorDeAutobuses.generarAutobuses(300), "ElPatoS.A");
        ga.imprimeTodo();
        System.out.println("---------------------------------------------------------------");
        ga.filtrarPorDestino("Cuenca");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Sospechoso localizado.");
        System.out.println(ga.getAutobuses()[50].getPasajeros()[15].toString());
        ga.buscarPasajero();
        //ga.filtrarPorDestino("Madrid");
        //ga.buscarPasajero();
    }
}
