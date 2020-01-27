
package lawebdelprogramador.www;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DMenT extends JFrame implements Runnable {

    MyCanvas canvas = new MyCanvas();
    Thread animation;
    private int timer = 200;

    public DMenT(String caption) {
        super(caption);
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());

        Container buttonPane = new Container();
        buttonPane.setLayout(new FlowLayout());
        buttonPane.add(exit);

        pane.add("North", buttonPane);
        pane.add("Center", canvas);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                dispose();
                System.exit(0);
            }
        });
        setBounds(10, 10, 400, 200);
        setVisible(true);

        animation = new Thread(this);
        animation.start();
    }

    public void run() {
        if (animation == null) {
            return;
        }
        Thread me = Thread.currentThread();
        while (me == animation) {
            try {
                canvas.skip();
                animation.sleep(timer);
            }
            catch (InterruptedException exception) {
                System.out.println(exception);
            }
        }
    }

    public static void main(String[] args) {
        DMenT app = new DMenT("DmenT was here: D");
    }
}

class MyCanvas extends Canvas {

    public static final int RIGHT = 1;
    public static final int LEFT = -1;
    private int x = 10;
    private int y = 10;
    private String mail = "Mr_DMenT@hotmail.com";
    private int direction = RIGHT;
    private int steaps = 10;
    private FontMetrics fm;

    public MyCanvas() {
        super();
    }

    public void paint(Graphics g) {
        g.drawString(mail, x, y);
        fm = g.getFontMetrics();
    }

    public void skip() {
        if (fm == null) {
            return;
        }
        x += (steaps * direction);
        int w = fm.stringWidth(mail);
        Dimension d = getSize();
        int cw = d.width;
        if (x + w > cw) {
            x = cw - w;
            direction = LEFT;
        }
        else if (x < 0){
            x = 0;
            direction = RIGHT;
        }
        repaint();
    }
}


