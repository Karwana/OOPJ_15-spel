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
        themeButton = new JButton("Change Theme");
        newGameButton.addActionListener(this);
        themeButton.addActionListener(this);
        topPanel.add(newGameButton);
        topPanel.add(themeButton);
        add(topPanel, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4,4));
        buttons = new JButton[4][4];

        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                buttons[row][column] = new JButton();
                buttons[row][column].setFont(new Font("Comic Sans MS", Font.BOLD, 32));
                buttons[row][column].addActionListener(this);
                panel.add(buttons[row][column]);
            }
        }
        add(panel, BorderLayout.CENTER);

        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        updateButtons();
    }

    private void updateButtons() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                Tile tile = game.getTile(row, col);
                if (tile != null) {
                    buttons[row][col].setText(Integer.toString(tile.getNumber()));
                }
                else {
                    buttons[row][col].setText("");
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // New Game knapp
        if (e.getSource() == newGameButton) {
            game.setupBoard();
            game.shuffle();
            updateButtons();
            return;
        }

        // Change Theme knapp
        if (e.getSource() == themeButton) {
            // Lägg till färgval senare
            return;
        }

        // Kolla vilken bricka som klickades
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (e.getSource() == buttons[row][col]) {
                    // Försök flytta brickan
                    game.moveTile(row, col);
                    updateButtons();

                    // Kolla om vunnet
                    if (game.isGameWon()) {
                        JOptionPane.showMessageDialog(this, "VICTORY!");
                    }
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new GameGUI();
    }
}
