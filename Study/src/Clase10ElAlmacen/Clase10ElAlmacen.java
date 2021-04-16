package Clase10ElAlmacen;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Clase10ElAlmacen {
    public static void main(String[] args) throws IOException {
        Producto[] lp = GeneradorProductos.generarProductos(100);
        AlmacenGestion ag = new AlmacenGestion(lp);
        Producto[] s1 = ag.prepararPedidoTC(25);
        Producto[] s2 = ag.prepararPedidoSM(25);
        TiendaPrimeraMano t1 = new TiendaPrimeraMano("EmpresaSoftPlanet", s1);
        TiendaSegundaMano t2 = new TiendaSegundaMano("EmpresaSoftExpress", s2);
        ag.imprimeListaProductos();
        t1.imprimeEstadisticas();
        //t2.imprimeEstadisticas();
        FileWriter escritor = new FileWriter("EstadisticasTSM.txt");
        PrintWriter pw = new PrintWriter(escritor);
        t2.imprimeEstadisticas(pw);
        pw.close();
    }
}
