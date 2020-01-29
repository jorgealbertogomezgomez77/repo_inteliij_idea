

package lawebdelprogramador.www;

import java.util.logging.Logger;

/**
 * @author Ing. Jorge Alberto Gomez Gomez, January 30 of the 2019, 03:05 AM
 * @mail jorgealbertogomezgomez77@gmail.com
 */

/**public class Robot {

    public Robot() {

    }

    private String sX = "", sY = "";

    public void add(int x, int y) {
        if (sX.equals("") == true) {
            sX = jlRobot.getX() + "";
            sY = "" + jlRobot.getY();
        }
        if (sX.equalsIgnoreCase("") == true) {
            sX += x + "";
            sY += y + "";
        }
        else {
            sX += " " + x;
            sY += " " + y;
        }
        addCoordenadas_x(sX);
        addCoordenadas_y(sY);
    }

    private void addCoordenadas_x(String nuevas_coordenadas) {
        String[] mCoordenadas = nuevas_coordenadas.split(" ");
        mCoordenadas_x = new int[mCoordenadas.length];
        int i = 0;
        while (i <= mCoordenadas_x.length - 1) {
            mCoordenadas_x[i] = Integer.parseInt(mCoordenadas[i]);
            i++;
        }
    }

    private void addCoordenadas_y(String nuevas_coordenadas) {
        String[] mCoordenadas = nuevas_coordenadas.split(" ");
        mCoordenadas_y = new int[mCoordenadas.length];
        int i = 0;
        while (i <= mCoordenadas_y.length - 1) {
            mCoordenadas_y[i] = Integer.parseInt(mCoordenadas[i]);
            i++;
        }
    }

    public void borrar_coordenadas() {
        this.sX = "";
        this.sY = "";
        this.mCoordenadas_x = new int[0];
        this.mCoordenadas_y = new int[0];
    }

    private int[] mCoordenadas_x;
    private int[] mCoordenadas_y;

    private void msj(String datos) {
        System.out.println(datos);
    }

    public void moverse_adelante() {
        Thread h = new Thread() {
            int i = 0;
            public void run() {
                try {
                    if (i < mCoordenadas_x.length - 1) {
                        jlRobot.setBounds(mCoordenadas_x[i], mCoordenadas_y[i], 223, 226);
                        i++;
                        Thread.sleep(500);
                        run();
                    }
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(FRM_RTS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        h.start();
    }

    public void moverse_atras() {
        Thread h = new Thread() {
            int i = mCoordenadas_x.length - 1;
            public void run() {
                try {
                    if (i >= 0) {
                        jlRobot.setBounds(mCoordenadas_x[i], mCoordenadas_y[i], 223, 226);
                        i--;
                        Thread.sleep(500);
                        run();
                    }
                }
                catch (InterruptedException ex) {
                    Logger.getLogger(FRM_RTS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        h.start();
    }
}   // Fin de la clase.

 */




















