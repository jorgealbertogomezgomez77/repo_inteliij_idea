package Clase7ComHerPol;

public class Clase7ComHerPol {
    public static void main(String[] args) {
        Persona p1 = new Persona("Juan ", "Martínez ", "12345678 ");
        Futbolista f1 = new Futbolista();
        f1.setNombre("Pepe ");
        f1.setValor(2.155);
        f1.setPosicion("Delantero");
        f1.setApellido("Hernández");
        f1.setDNI("93062801526");


        p1.imprime();
        f1.imprime();

        Persona P2;
        P2 = f1;
        P2.imprime();
    }
}
