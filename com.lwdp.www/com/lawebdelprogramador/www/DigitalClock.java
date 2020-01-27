
package lawebdelprogramador.www;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ing. Jorge Alberto Gomez Gomez, January 30 of the 2019, 04:55 PM
 * @mail jorgealbertogomezgomez77@gmail.com
 */

public class DigitalClock {

    public static void main(String[] args) {

        ClockLabel dateLabel = new ClockLabel("date");
        ClockLabel timeLabel = new ClockLabel("time");
        ClockLabel dayLabel = new ClockLabel("day");

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame f = new JFrame("Digital Clock");
        f.setSize(300, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(3, 1));

        f.add(dateLabel);
        f.add(timeLabel);
        f.add(dayLabel);

        f.getContentPane().setBackground(Color.black);

        f.setVisible(true);
    }
}

class ClockLabel extends JLabel implements ActionListener {

    String type;
    SimpleDateFormat sdf;

    public ClockLabel(String type) {
        this.type = type;
        setForeground(Color.green);

        switch (type) {
            case "date":
                sdf = new SimpleDateFormat("  MMM dd yyyy");
                setFont(new Font("sans-serif", Font.PLAIN, 12));
                setHorizontalAlignment(SwingConstants.LEFT);
                break;
            case "time":
                sdf = new SimpleDateFormat("hh:mm:ss a");
                setFont(new Font("sans-serif", Font.PLAIN, 40));
                setHorizontalAlignment(SwingConstants.CENTER);
                break;
            case "day":
                sdf = new SimpleDateFormat("EEEE  ");
                setFont(new Font("sans-serif", Font.PLAIN, 16));
                setHorizontalAlignment(SwingConstants.RIGHT);
                break;
            default:
                sdf = new SimpleDateFormat();
                break;
        }
        Timer t = new Timer(1000, this);
        t.start();
    }
    public void actionPerformed(ActionEvent ae) {
        Date d = new Date();
        setText(sdf.format(d));
    }
}
