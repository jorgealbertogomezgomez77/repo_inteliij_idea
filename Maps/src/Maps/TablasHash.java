package Maps;

import java.util.ArrayList;
import java.util.Hashtable;

public class TablasHash {
    Hashtable<String, Producto> tabla = new Hashtable<String, Producto>();

    public Hashtable<String, Producto> getTabla() {
        return tabla;
    }

    public void setTabla(Hashtable<String, Producto> tabla) {
        this.tabla = tabla;
    }

    public void pasarTabla(Producto[] vp) {
        for (int i = 0; i < vp.length; i++) {
            tabla.put(vp[i].getID(), vp[i]);
        }
    }

    public ArrayList<Producto> listaProd() {
        Iterable<Producto> listares = tabla.values();
        ArrayList<Producto> resultado = new ArrayList<Producto>();
        for (Producto p: listares) {
            resultado.add(p);
        }
        return resultado;
    }

    public Producto getP(String key) {
        return tabla.get(key);
    }
}
