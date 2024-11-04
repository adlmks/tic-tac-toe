package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TicTacToeView extends JFrame {
    private JButton[][] buttons;

    public TicTacToeView() {
        buttons = new JButton[3][3];
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("-");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 60));
                buttons[i][j].setFocusPainted(false);
                add(buttons[i][j]);
            }
        }
    }

    public void setButtonText(int row, int col, String text) {
        buttons[row][col].setText(text);
    }

    public void addButtonClickListener(int row, int col, ActionListener listener) {
        buttons[row][col].addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void resetButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("-");
            }
        }
    }
}
