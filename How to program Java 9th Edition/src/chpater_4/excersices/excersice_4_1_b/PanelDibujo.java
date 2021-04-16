
package chpater_4.excersices.excersice_4_1_b;

import javax.swing.*;
import java.awt.*;

public class PanelDibujo extends JPanel {

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int count = 30;
        int count2 = 30;

        for (int i = 1; i <= 30; i++) {
            g.drawLine(0, 0, i * width / 30, --count * height / 30);
        }

        for (int i = 1; i <= 30; i++) {
            g.drawLine(width, height, i * width / 30, --count2 * height / 30);
        }

        for (int i = 1; i <= 30; i++) {
            g.drawLine(width, 0, i * width / 30, i * height / 30);
        }

        for (int i = 1; i <= 30; i++) {
            g.drawLine(0, height, i * width / 30, i * height / 30);
        }
    }
}
