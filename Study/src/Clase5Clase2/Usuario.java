package Clase5Clase2;

public class Usuario {
    private String nombre;
    private double ddisponible;
    private int idUsuario;
    private static int numUsuarios;

    public Usuario(String nombre, double ddisponible) {
        this.nombre = nombre;
        this.ddisponible = ddisponible;
        this.idUsuario = Usuario.getNumUsuarios();
        numUsuarios += 1;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDdisponible() {
        return ddisponible;
    }

    public void setDdisponible(double ddisponible) {
        this.ddisponible = ddisponible;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public static int getNumUsuarios() {
        return numUsuarios;
    }

    public static void setNumUsuarios(int numUsuarios) {
        Usuario.numUsuarios = numUsuarios;
    }

    public static void imprimenumUsuarios() {
        System.out.println("El número de usuarios es " + Usuario.getNumUsuarios());
    }

    public void donarTodoDinero() {
        PlataformaCrow.recogerDinero(this.ddisponible);
        this.setDdisponible(0.0);
    }
}
