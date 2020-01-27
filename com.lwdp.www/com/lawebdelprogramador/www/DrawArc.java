
package lawebdelprogramador.www;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ing. Jorge Alberto Gomez Gomez, January 30 of the 2019, 03:32 PM
 * @mail jorgealbertogomezgomez77@gmail.com
 */

public class DrawArc extends JPanel {

    public void paintComponent(Graphics g) {
        g.drawArc(20, 20, 200, 200, 90, 90);
        g.drawArc(40, 40, 160, 160, 0, 180);
        g.drawArc(90, 60, 40, 40, 0, 270);
        g.drawLine(110, 80,110,80);
    }

    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Draw Arc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setSize(300, 200);

        DrawArc panel = new DrawArc();

        frame.add(panel);

        frame.setVisible(true);
    }
}
