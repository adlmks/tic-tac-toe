package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Adapter.Game;
import Adapter.TicTacToeAIAdapter;
import Facade.TicTacToeFacade;
import Strategy.GameContext;
import Strategy.TicTacToeWinStrategy;
import TicTacToeAI.TicTacToeAI;
import TicTacToeMultiplayer.TicTacToeMultiplayer;

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

        singlePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String playerName = JOptionPane.showInputDialog("Введите имя игрока:");
                GameContext gameContext = new GameContext(new TicTacToeWinStrategy());
                TicTacToeAI aiGame = new TicTacToeAI(playerName, gameContext);  // Initialize the AI game
                aiGame.setVisible(true);  // Display the game window
                dispose(); // Close the menu
            }
        });


        multiplayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String player1 = JOptionPane.showInputDialog("Введите имя первого игрока:");
                String player2 = JOptionPane.showInputDialog("Введите имя второго игрока:");
                GameContext gameContext = new GameContext(new TicTacToeWinStrategy());
                new TicTacToeMultiplayer(player1, player2, gameContext).setVisible(true);
                dispose(); // Close the menu
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(singlePlayerButton);
        add(multiplayerButton);
        add(exitButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToe().setVisible(true));
    }
}

