import Controller.*;
import Model.*;
import View.*;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TicTacToeModel model = new TicTacToeModel();
                TicTacToeView view = new TicTacToeView();
                new TicTacToeController(model, view);
                view.setVisible(true);
            }
        });
    }
}

