package musaelqaq.chess_html;

public class GameSession {
    private ChessBoard board;
    private PlayerColor currentTurn;

    // validate & apply move
    public boolean tryMove(String move, PlayerColor player) {
        
        // Verifies it is the player's turn
        if (player != currentTurn) {
            return false;
        }

        return true;
    }
}
