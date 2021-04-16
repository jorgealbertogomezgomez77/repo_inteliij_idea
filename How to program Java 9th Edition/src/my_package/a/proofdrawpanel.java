
package my_package.a;

import javax.swing.*;

public class proofdrawpanel {

    public static void main(String[] args) {

        drawpanel vito = new drawpanel();

        JFrame yelena = new JFrame();

        yelena.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        yelena.add(vito);
        yelena.setSize(601, 601);
        yelena.setVisible(true);
    }
}
