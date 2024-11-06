package GameModeSelection;

import javax.swing.*;
import java.awt.*;

import MultiplayerGameSetup.*;
import TicTacToeAI.*;

public class GameModeSelection extends JFrame {

    public GameModeSelection() {
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
            JFrame gameMode = createGameMode("single", playerName, null);
            if (gameMode != null) {
                gameMode.setVisible(true);
                dispose(); // Закрыть меню выбора
            }
        });

        multiplayerButton.addActionListener(e -> {
            JFrame gameMode = createGameMode("multiplayer", null, null);
            if (gameMode != null) {
                gameMode.setVisible(true);
                dispose(); // Закрыть меню выбора
            }
        });

        exitButton.addActionListener(e -> System.exit(0));

        add(singlePlayerButton);
        add(multiplayerButton);
        add(exitButton);

        setVisible(true);
    }

    // Factory method to create the game mode instance
    private JFrame createGameMode(String mode, String player1, String player2) {
        switch (mode.toLowerCase()) {
            case "single":
                return new TicTacToeAI(player1); // Create single-player mode with AI
            case "multiplayer":
                return new MultiplayerGameSetup(); // Create multiplayer setup
            default:
                JOptionPane.showMessageDialog(this, "Неверный режим игры!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameModeSelection::new);
    }
}
