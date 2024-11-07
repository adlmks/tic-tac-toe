package TicTacToeMultiplayer;

import Strategy.GameContext;
import Strategy.WinStrategy;
import TicTacToe.TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeMultiplayer extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private String player1, player2;
    private boolean player1Turn = true;
    private GameContext gameContext;

    public TicTacToeMultiplayer(String player1, String player2, GameContext gameContext) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameContext = gameContext; // Assign the GameContext for win-checking

        setTitle("Парная игра");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        initializeButtons();
    }

    private void initializeButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton();
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 60));
                buttons[row][col].setFocusPainted(false);
                buttons[row][col].addActionListener(new ButtonClickListener(row, col));
                add(buttons[row][col]);
            }
        }
    }

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttons[row][col].getText().equals("")) {
                buttons[row][col].setText(player1Turn ? "X" : "O");
                if (checkForWin()) {
                    endGame(player1Turn ? player1 : player2); // Pass the winner's name
                } else if (isBoardFull()) {
                    endGame("Ничья!");
                }
                player1Turn = !player1Turn; // Switch turns
            }
        }
    }

    private boolean checkForWin() {
        // Convert the JButton board to a String[][] array
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText();
            }
        }
        // Use gameContext to check for a win
        return gameContext.checkForWin(board);
    }

    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void endGame(String winner) {
        String message = winner.equals("Ничья!") ? "Ничья!" : "Выиграл " + winner + "!";
        JOptionPane.showMessageDialog(this, message, "Игра окончена", JOptionPane.INFORMATION_MESSAGE);
        int result = JOptionPane.showConfirmDialog(this, "Хотите вернуться в меню выбора игры?", "Выбор игры", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            dispose();
            new TicTacToe().setVisible(true);
        } else {
            System.exit(0);
        }
    }
}
