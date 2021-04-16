package tetris;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Tetris extends JFrame{
    JLabel statusbar;

    public Tetris() {
        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);
        tablero board = new tablero(this);
        add(board);
        board.start();

        setSize(200,400);
        setTitle("Tetris http://javayotros.blogspot.com/");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JLabel getStatusbar() {
        return statusbar;
    }

    public static void main(String[] args) {
        Tetris game = new Tetris();
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }
}