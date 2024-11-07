package Model;

import java.util.ArrayList;
import java.util.List;

public class TicTacToeModel {
    private char[][] board;
    private char currentPlayer;
    private List<TicTacToeObserver> observers;

    public TicTacToeModel() {
        board = new char[3][3];
        currentPlayer = 'X';
        observers = new ArrayList<>();
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        notifyObservers();
    }

    public void addObserver(TicTacToeObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TicTacToeObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (TicTacToeObserver observer : observers) {
            observer.update(board, currentPlayer);
        }
    }

    public boolean placeMark(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
            board[row][col] = currentPlayer;
            notifyObservers();
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                    (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        notifyObservers();
    }
}
