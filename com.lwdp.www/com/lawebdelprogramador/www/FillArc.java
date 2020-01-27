
package lawebdelprogramador.www;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * @author Ing. Jorge Alberto Gomez Gomez, January 30 of the 2019, 12:43 PM
 * @mail jorgealbertogomezgomez77@gmail.com
 */

public class FillArc extends JPanel {

    public void paintComponent(Graphics g) {
        Graphics2D g2 =  (Graphics2D) g;

        // Fill Arc2D.
        g2.setPaint(Color.red);
        g2.fill(new Arc2D.Double(20, 20, 200, 100, 90, 180, Arc2D.OPEN));
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Fill Arc Example ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setSize(300, 200);

        FillArc panel = new FillArc();

        frame.add(panel);

        frame.setVisible(true);
    }
}
