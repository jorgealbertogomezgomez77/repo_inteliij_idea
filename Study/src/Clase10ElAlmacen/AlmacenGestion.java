package Clase10ElAlmacen;

import java.util.ArrayList;

public class AlmacenGestion {
    Producto[] almacen;

    public AlmacenGestion() {

    }

    public AlmacenGestion( Producto[] almacen) {
        this.almacen = almacen;
    }

    public Producto[] getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Producto[] almacen) {
        this.almacen = almacen;
    }

    public void OrdenarAlmacenPorValor() {
        Producto aux = new Producto();
        for (int i = 0; i < this.getAlmacen().length; i++) {
            for (int j = 0; j < this.getAlmacen().length; j++) {
                if (this.getAlmacen()[j].getValor() > this.getAlmacen()[j].getValor()) {
                    aux = this.getAlmacen()[j];
                    this.getAlmacen()[j] = this.getAlmacen()[j + 1];
                    this.getAlmacen()[j + 1] = aux;
                }
            }
        }
    }

    public void OrdenarAlmacenPorPeso() {
        Producto aux = new Producto();
        for (int i = 0; i < this.getAlmacen().length; i++) {
            for (int j = 0; j < this.getAlmacen().length; j++) {
                if (this.getAlmacen()[j].getPeso() > this.getAlmacen()[j + 1].getPeso()) {
                    aux = this.getAlmacen()[j];
                    this.getAlmacen()[j] = this.getAlmacen()[j + 1];
                    this.getAlmacen()[j + 1] = aux;
                }
            }
        }
    }

    public Producto BuscarProductoSecuencial (String id) {
        Producto p = new Producto();
        for (int i = 0; i < this.getAlmacen().length - 1; i++) {
            if (this.getAlmacen()[i].getID().compareTo(id) == 0) {
                p = this.getAlmacen()[i];
            }
        }
        return p;
    }

    public Producto BuscarProductoBinaria(String id) {
        int inf = 0;
        int sup = this.getAlmacen().length - 1;
        boolean encontrado = false;
        while ((encontrado == false) && (sup >= inf)) {
            int central = (inf + sup) / 2;
            if (this.getAlmacen()[central].getID() == id) {
                encontrado = true;
                return this.getAlmacen()[central];
            }
            else if (id.compareTo(this.getAlmacen()[central].getID()) > 0){
                inf = central + 1;
            }
            else {
                sup = central - 1;
            }
        }
        return null;
    }

    public void imprimeListaProductos() {
        for (int i = 0; i < this.getAlmacen().length; i++) {
            this.getAlmacen()[i].imprime();
        }
    }

    public Producto[] prepararPedidoTC(int n) {
        this.OrdenarAlmacenPorValor();
        ArrayList<Producto> lStock = new ArrayList<Producto>();
        int i = this.getAlmacen().length - 1;
        int j = 0;
        while ((i >= 0) && (j < n)) {
            if (this.getAlmacen()[i].getClase().compareTo("A") == 0) {
                lStock.add(this.getAlmacen()[i]);
                this.getAlmacen()[i].setAsignado(true);
                j++;
            }
            i--;
        }

        Producto[] resultado = new Producto[lStock.size()];
        lStock.toArray(resultado);
        return resultado;
    }

    public Producto[] prepararPedidoSM(int n) {
        this.OrdenarAlmacenPorValor();
        ArrayList<Producto> lStock = new ArrayList<Producto>();
        int i = this.getAlmacen().length - 1;
        int j = 0;
        while ((i >= 0) && (j < n)) {
            if (this.getAlmacen()[i].isAsignado() == false) {
                lStock.add(this.getAlmacen()[i]);
                this.getAlmacen()[i].setAsignado(true);
                j++;
            }
            i--;
        }

        Producto[] resultado = new Producto[lStock.size()];
        lStock.toArray(resultado);
        return resultado;
    }

}
