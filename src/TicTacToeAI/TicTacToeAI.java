package TicTacToeAI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import TicTacToe.TicTacToe;

public class TicTacToeAI extends JFrame {
    private JButton[][] buttons = new JButton[3][3];
    private String playerName;
    private boolean playerTurn = true; // true - ход игрока, false - ход ИИ

    public TicTacToeAI(String playerName) {
        this.playerName = playerName;
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

    private class ButtonClickListener implements ActionListener {
        private int row, col;

        public ButtonClickListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (playerTurn && buttons[row][col].getText().equals("")) {
                buttons[row][col].setText("X"); // Игрок делает ход
                playerTurn = false; // Переключаем ход на ИИ
                if (!checkForWin()) {
                    makeIIMove(); // ИИ делает ход
                }
            }
        }
    }

    private void makeIIMove() {
        Random rand = new Random();
        while (true) {
            int row = rand.nextInt(3);
            int col = rand.nextInt(3);
            if (buttons[row][col].getText().equals("")) {
                buttons[row][col].setText("O"); // ИИ делает ход
                playerTurn = true; // Возвращаем ход игроку
                checkForWin();
                break;
            }
        }
    }

    private boolean checkForWin() {
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                    buttons[i][0].getText().equals(buttons[i][2].getText()) &&
                    !buttons[i][0].getText().equals("")) {
                String winner = buttons[i][0].getText().equals("X") ? playerName : "ИИ";
                endGame("Выиграл " + winner + "!");
                return true;
            }
            if (buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                    buttons[0][i].getText().equals(buttons[2][i].getText()) &&
                    !buttons[0][i].getText().equals("")) {
                String winner = buttons[0][i].getText().equals("X") ? playerName : "ИИ";
                endGame("Выиграл " + winner + "!");
                return true;
            }
        }
        if (buttons[0][0].getText().equals(buttons[1][1].getText()) &&
                buttons[0][0].getText().equals(buttons[2][2].getText()) &&
                !buttons[0][0].getText().equals("")) {
            String winner = buttons[0][0].getText().equals("X") ? playerName : "ИИ";
            endGame("Выиграл " + winner + "!");
            return true;
        }
        if (buttons[0][2].getText().equals(buttons[1][1].getText()) &&
                buttons[0][2].getText().equals(buttons[2][0].getText()) &&
                !buttons[0][2].getText().equals("")) {
            String winner = buttons[0][2].getText().equals("X") ? playerName : "ИИ";
            endGame("Выиграл " + winner + "!");
            return true;
        }
        if (isBoardFull()) {
            endGame("Ничья!");
        }
        return false;
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

    private void endGame(String message) {
        // Показываем сообщение о победителе
        JOptionPane.showMessageDialog(this, message, "Игра окончена", JOptionPane.INFORMATION_MESSAGE);

        // Запрос на возврат в меню выбора игры
        int option = JOptionPane.showConfirmDialog(this, "Хотите вернуться в меню выбора игры?", "Возврат в меню", JOptionPane.YES_NO_OPTION);

        if (option == JOptionPane.YES_OPTION) {
            // Возврат в меню выбора
            new TicTacToe().setVisible(true); // Открываем меню выбора игры
            dispose(); // Закрыть текущее окно игры
        } else {
            System.exit(0); // Закрыть приложение, если пользователь не хочет возвращаться в меню
        }
    }

    private void resetGame() {
        // Очистка кнопок и сброс состояния игры
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText(""); // Очистка текста на кнопках
            }
        }
        playerTurn = true; // Возвращаем ход игроку
    }
}
