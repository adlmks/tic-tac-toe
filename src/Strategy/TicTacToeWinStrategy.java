package Strategy;


public class TicTacToeWinStrategy implements WinStrategy {
    @Override
    public boolean checkForWin(String[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) &&
                    board[i][0].equals(board[i][2]) &&
                    !board[i][0].equals("")) {
                return true;
            }
            if (board[0][i].equals(board[1][i]) &&
                    board[0][i].equals(board[2][i]) &&
                    !board[0][i].equals("")) {
                return true;
            }
        }
        if (board[0][0].equals(board[1][1]) &&
                board[0][0].equals(board[2][2]) &&
                !board[0][0].equals("")) {
            return true;
        }
        return board[0][2].equals(board[1][1]) &&
                board[0][2].equals(board[2][0]) &&
                !board[0][2].equals("");
    }
}
