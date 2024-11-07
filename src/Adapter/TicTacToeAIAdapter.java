package Adapter;

import TicTacToeAI.*;

// Adapter class to adapt TicTacToeAI to the Game interface
public class TicTacToeAIAdapter implements Game {
    private TicTacToeAI ticTacToeAI;  // The adaptee

    public TicTacToeAIAdapter(TicTacToeAI ticTacToeAI) {
        this.ticTacToeAI = ticTacToeAI;
    }

    @Override
    public void makeMove(int row, int col) {
        // Delegate the move to the TicTacToeAI logic
        ticTacToeAI.makePlayerMove(row, col);
    }
}
