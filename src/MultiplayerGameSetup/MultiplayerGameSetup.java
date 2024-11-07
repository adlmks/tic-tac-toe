package MultiplayerGameSetup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Strategy.GameContext;
import Strategy.TicTacToeWinStrategy;
import TicTacToeMultiplayer.TicTacToeMultiplayer;

public class MultiplayerGameSetup extends JFrame {
    private JTextField player1Name;
    private JTextField player2Name;

    public MultiplayerGameSetup() {
        setTitle("Парная игра");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label1 = new JLabel("Имя игрока 1:");
        label1.setBounds(50, 30, 100, 30);
        add(label1);

        player1Name = new JTextField();
        player1Name.setBounds(150, 30, 200, 30);
        add(player1Name);

        JLabel label2 = new JLabel("Имя игрока 2:");
        label2.setBounds(50, 80, 100, 30);
        add(label2);

        player2Name = new JTextField();
        player2Name.setBounds(150, 80, 200, 30);
        add(player2Name);

        JButton startButton = new JButton("Начать игру");
        startButton.setBounds(100, 130, 200, 30);
        add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name1 = player1Name.getText();
                String name2 = player2Name.getText();

                // Create GameContext with TicTacToeWinStrategy
                GameContext gameContext = new GameContext(new TicTacToeWinStrategy());

                // Open the multiplayer game with player names and GameContext
                dispose(); // Close the setup window
                new TicTacToeMultiplayer(name1, name2, gameContext).setVisible(true); // Open multiplayer game
            }
        });
    }
}
