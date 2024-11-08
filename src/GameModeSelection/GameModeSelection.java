package GameModeSelection;

import javax.swing.*;
import MultiplayerGameSetup.MultiplayerGameSetup;
import TicTacToeAI.TicTacToeAI;
import Strategy.GameContext;
import Strategy.TicTacToeWinStrategy;

public class GameModeSelection {

    public static JFrame createGameMode(String mode, String player1, String player2) {
        GameContext gameContext = new GameContext(new TicTacToeWinStrategy());

        switch (mode.toLowerCase()) {
            case "single":
                return new TicTacToeAI(player1, gameContext); // Create single-player mode with AI
            case "multiplayer":
                return new MultiplayerGameSetup(player1, player2, gameContext); // Create multiplayer setup
            default:
                JOptionPane.showMessageDialog(null, "Неверный режим игры!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return null;
        }
    }
}
