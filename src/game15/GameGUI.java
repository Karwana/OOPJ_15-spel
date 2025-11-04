package game15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame implements ActionListener {

    private GameBoard game;
    private JButton[][] buttons;
    private JButton newGameButton, themeButton;
    private Settings settings;

    public GameGUI() {
        game = new GameBoard();
        settings = new Settings();
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
                buttons[row][column].setFont(new Font("Comic Sans MS", Font.BOLD, 30));
                buttons[row][column].addActionListener(this);
                panel.add(buttons[row][column]);
            }
        }
        add(panel, BorderLayout.CENTER);

        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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

    private void applyColors() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                Tile tile = game.getTile(row, col);
                if (tile != null) {
                    buttons[row][col].setBackground(settings.getTileColor());
                    buttons[row][col].setForeground(settings.getTextColor());
                } else  {
                    buttons[row][col].setBackground(settings.getEmptyColor());
                }
            }
        }
        getContentPane().setBackground(settings.getBackgroundColor());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // New Game knapp
        if (e.getSource() == newGameButton) {
            game.setupBoard();
            game.shuffle();
            updateButtons();
            applyColors();
            return;
        }

        // Change Theme knapp
        if (e.getSource() == themeButton) {
            String[] options = {"Light", "Dark", "Colorful"};
            int choice = JOptionPane.showOptionDialog(
                    this, "Choose theme:", "Change Theme",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (choice == 0){
                settings.setLightTheme();
            } else if (choice == 1){
                settings.setDarkTheme();
            } else if (choice == 2){
                settings.setColorfulTheme();
            }
            applyColors();
            return;
        }

        // Kolla vilken bricka som klickades
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (e.getSource() == buttons[row][col]) {
                    // Försök flytta brickan
                    game.moveTile(row, col);
                    updateButtons();
                    applyColors();

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
