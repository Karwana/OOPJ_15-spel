package game15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame implements ActionListener {

    private GameBoard game;
    private JButton[][] buttons;

    public GameGUI() {
        game = new GameBoard();
        game.shuffle();
        buttons = new JButton[4][4];
        setLayout(new GridLayout(4,4));

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                buttons[row][column] = new JButton();
                buttons[row][column].addActionListener(this);
                add(buttons[row][column]);
            }
        }
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    static void main() {
        new GameGUI();
    }
}
