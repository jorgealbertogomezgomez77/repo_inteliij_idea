
package my_package.a;

import javax.swing.*;
import java.awt.*;

public class drawpanel extends JPanel {

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        int height = getHeight();
        int width = getWidth();

        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                g.drawLine(0, i * height/10, j * width/10, 0);
                g.drawLine(width, i * height/10, j * width/10, 0);
                g.drawLine(0, i * height/10, j * width/10, height);
                g.drawLine(width, i * height/10, j * width/10, height);
            }
        }
    }
}
