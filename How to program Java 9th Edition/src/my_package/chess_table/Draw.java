
package my_package.chess_table;

import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        int rest_width = (int) (0.9 * width);
        int rest_height = (int) (0.9 * height);


        for (int i = 0; i <= 8; i++) {

            g.drawLine((width - rest_width) / 2 + i * rest_width / 8, (int)(0.05 * height),
                    (width - rest_width) / 2 + i * rest_width / 8, (int)(0.95 * height));

            g.drawLine((int)(0.05 * width), (height - rest_height) / 2 + i * rest_height / 8,
                    (int)(0.95 * width), (height - rest_height) / 2 + i * rest_height / 8);
        }
    }
}
