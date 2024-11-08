package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import GameModeSelection.GameModeSelection;

public class TicTacToe extends JFrame {

    public TicTacToe() {
        setTitle("Выбор режима игры");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JButton singlePlayerButton = new JButton("Одиночная игра (с ИИ)");
        JButton multiplayerButton = new JButton("Парная игра");
        JButton exitButton = new JButton("Выход");

        singlePlayerButton.addActionListener(e -> {
            String playerName = JOptionPane.showInputDialog("Введите имя игрока:");
            JFrame aiGame = GameModeSelection.createGameMode("single", playerName, null);
            if (aiGame != null) {
                aiGame.setVisible(true);
                dispose(); // Close the main menu
            }
        });

        multiplayerButton.addActionListener(e -> {
            String player1 = JOptionPane.showInputDialog("Введите имя первого игрока:");
            String player2 = JOptionPane.showInputDialog("Введите имя второго игрока:");
            JFrame multiplayerGame = GameModeSelection.createGameMode("multiplayer", player1, player2);
            if (multiplayerGame != null) {
                multiplayerGame.setVisible(true);
                dispose(); // Close the main menu
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

        add(singlePlayerButton);
        add(multiplayerButton);
        add(exitButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToe().setVisible(true));
    }
}
