package Facade;

import Strategy.GameContext;
import Strategy.TicTacToeWinStrategy;
import TicTacToeAI.TicTacToeAI;
import TicTacToeMultiplayer.TicTacToeMultiplayer;


// Facade class that simplifies starting the game
public class TicTacToeFacade {

    public void startSinglePlayerGame(String playerName) {
        // Initialize the game context and AI
        GameContext gameContext = new GameContext(new TicTacToeWinStrategy());
        TicTacToeAI gameAI = new TicTacToeAI(playerName, gameContext);
        gameAI.setVisible(true);
    }

    public void startMultiplayerGame(String player1, String player2) {
        // Initialize the game context and multiplayer setup
        GameContext gameContext = new GameContext(new TicTacToeWinStrategy());
        TicTacToeMultiplayer gameMultiplayer = new TicTacToeMultiplayer(player1, player2, gameContext);
        gameMultiplayer.setVisible(true);
    }
}