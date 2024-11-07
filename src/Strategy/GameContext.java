// GameContext.java
package Strategy;

public class GameContext {
    private WinStrategy winStrategy;

    // Constructor to set the initial win strategy
    public GameContext(WinStrategy winStrategy) {
        this.winStrategy = winStrategy;
    }

    // Method to change the win strategy at runtime
    public void setWinStrategy(WinStrategy winStrategy) {
        this.winStrategy = winStrategy;
    }

    // Method to check for a win using the current win strategy
    public boolean checkForWin(String[][] board) {
        return winStrategy.checkForWin(board);
    }
}
