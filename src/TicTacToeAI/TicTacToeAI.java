package TicTacToeAI;

import java.util.List;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Strategy.GameContext;
import TicTacToe.TicTacToe;

public class TicTacToeAI extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private String playerName;
    private boolean playerTurn = true; // True for player, false for AI
    private GameContext gameContext; // Game context with the win strategy

    public TicTacToeAI(String playerName, GameContext gameContext) {
        this.playerName = playerName;
        this.gameContext = gameContext;
        setTitle("Одиночная игра с ИИ");
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

    // Add this method to allow the adapter to trigger the player's move
    public void makePlayerMove(int row, int col) {
        if (buttons[row][col].getText().equals("") && playerTurn) {
            buttons[row][col].setText("X");
            playerTurn = false; // Switch to AI's turn
            if (gameContext.checkForWin(getBoardState())) {
                endGame(playerName);
            } else if (isBoardFull()) {
                endGame("Ничья!");
            } else {
                aiMove();
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
            makePlayerMove(row, col); // Use the new method
        }
    }

    private void aiMove() {
        List<int[]> emptyCells = new ArrayList<>();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (buttons[row][col].getText().equals("")) {
                    emptyCells.add(new int[]{row, col});
                }
            }
        }

        if (!emptyCells.isEmpty()) {
            int randomIndex = (int) (Math.random() * emptyCells.size());
            int[] chosenCell = emptyCells.get(randomIndex);
            buttons[chosenCell[0]][chosenCell[1]].setText("O");
            playerTurn = true;

            if (gameContext.checkForWin(getBoardState())) {
                endGame("ИИ");
            }
        }
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

    private String[][] getBoardState() {
        String[][] board = new String[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = buttons[row][col].getText();
            }
        }
        return board;
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
