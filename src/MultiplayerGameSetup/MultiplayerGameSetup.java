package MultiplayerGameSetup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Strategy.GameContext;
import Strategy.TicTacToeWinStrategy;
import TicTacToeMultiplayer.TicTacToeMultiplayer;

public class MultiplayerGameSetup extends JFrame {

    public MultiplayerGameSetup(String player1, String player2, GameContext gameContext) {
        // Initialize and show the multiplayer game window directly
        new TicTacToeMultiplayer(player1, player2, gameContext).setVisible(true);
    }
}
