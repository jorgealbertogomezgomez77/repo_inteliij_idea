package Clase5Clase2;

public class Clase5Clase2 {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Juan", 300.0);
        Usuario u2 = new Usuario("Antonio", 1.5);
        Usuario u3 = new Usuario("Juan", 500.0);
        Usuario.imprimenumUsuarios();
        System.out.println("El usuario 2 tiene el ID " + u2.getIdUsuario());
        PlataformaCrow p1 = new PlataformaCrow("Save the Whalés");
        PlataformaCrow p2 = new PlataformaCrow("Save the Sun");
        u1.donarTodoDinero();
        u2.donarTodoDinero();
        u3.donarTodoDinero();
        PlataformaCrow.imprimedineroTotal();
        p1.asignarDinero(500.0);
        p2.asignarDinero(1.5);
        PlataformaCrow.imprimedineroTotal();
    }
}
