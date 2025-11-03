package game15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame implements ActionListener {

    private GameBoard game;
    private JButton[][] buttons;
    private JButton newGameButton, themeButton;

    public GameGUI() {
        game = new GameBoard();
        game.shuffle();

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        newGameButton = new JButton("New Game");
        themeButton = new JButton("Theme");
        newGameButton.addActionListener(this);
        themeButton.addActionListener(this);
        topPanel.add(newGameButton);
        topPanel.add(themeButton);
        add(topPanel, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4,4));
        buttons = new JButton[4][4];

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].addActionListener(this);
                panel.add(buttons[row][col]);
            }
        }

        add(panel, BorderLayout.CENTER);


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
