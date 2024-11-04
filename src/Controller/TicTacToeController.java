package Controller;

import java.util.Scanner;
import Model.TicTacToeModel;
import View.TicTacToeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeController {
    private TicTacToeModel model;
    private TicTacToeView view;

    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        this.model = model;
        this.view = view;
        initializeListeners();
    }

    private void initializeListeners() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int row = i;
                final int col = j;
                view.addButtonClickListener(row, col, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick(row, col);
                    }
                });
            }
        }
    }

    private void handleButtonClick(int row, int col) {
        if (model.placeMark(row, col)) {
            view.setButtonText(row, col, String.valueOf(model.getCurrentPlayer()));
            if (model.checkWin()) {
                view.showMessage("Player " + model.getCurrentPlayer() + " wins!");
                resetGame();
                return;
            }
            if (model.isBoardFull()) {
                view.showMessage("The game is a draw!");
                resetGame();
                return;
            }
            model.changePlayer();
        }
    }

    private void resetGame() {
        model.initializeBoard();
        view.resetButtons();
    }
}
