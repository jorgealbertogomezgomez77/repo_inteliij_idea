
import java.util.Random;

public class GeneradorPasajeros {
    
    public static Pasajero[] generarPasajeros(int n) {
        String[] lnombres={"Jose","Juan","Jacinto","Jaime","Javier","Ana","Rebeca","Diana","Antonia"};
        String[] lapellido={"Diaz","Garcia","Smith","Valefor","Whasintong","Cubero","Can","Floid","Garfun"};
        Pasajero[] conjuntopasajeros = new Pasajero[n];

        for(int i = 0; i < n; i++) {
            Random r = new Random();
            int inombre =r.nextInt(lnombres.length);
            int iapellido =r.nextInt(lapellido.length);
            Pasajero p = new Pasajero(lnombres[inombre], lapellido[iapellido]);
            conjuntopasajeros[i] = p;
        }
        return conjuntopasajeros;
    }
}
