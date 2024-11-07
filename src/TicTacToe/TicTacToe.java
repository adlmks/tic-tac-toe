package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Facade.TicTacToeFacade;
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
                TicTacToeFacade gameFacade = new TicTacToeFacade();
                gameFacade.startSinglePlayerGame(playerName); // Use facade to start the game
                dispose(); // Close the menu
            }
        });

        multiplayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String player1 = JOptionPane.showInputDialog("Введите имя первого игрока:");
                String player2 = JOptionPane.showInputDialog("Введите имя второго игрока:");
                TicTacToeFacade gameFacade = new TicTacToeFacade();
                gameFacade.startMultiplayerGame(player1, player2); // Use facade to start the game
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
