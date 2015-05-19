package com.chess.app;
import java.util.List;
import java.util.ArrayList;

public class TargetComputer {
    private Board board;
    private Player opponent;
    private List<Piece>[][] targetMap;
    private Piece king;

    public TargetComputer(Board board) {
        this.board = board;
        this.targetMap = new ArrayList[Board.MAX_ROWS][Board.MAX_COLUMNS];
        for (int i = 0; i < Board.MAX_ROWS; ++i) {
            for (int j = 0; j < Board.MAX_COLUMNS; ++j) {
                targetMap[i][j] = new ArrayList<Piece>(); 
            }
        }
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public void setKing(Piece king) {
        this.king = king;
    }

    private void clearTargetMap() {
        for (int i = 0; i < Board.MAX_ROWS; ++i) {
            for (int j = 0; j < Board.MAX_COLUMNS; ++j) {
                targetMap[i][j].clear(); 
            }
        }
    }

    private void addOne(Piece piece, Location location) {
        targetMap[location.y][location.x].add(piece);
    }

    private void addAll(Piece piece, Moves captureMoves) {
        for (Location location: captureMoves.getCapturing()) {
            addOne(piece, location);
        }
    }

    private void compute(List<Piece> pieces) {
        clearTargetMap();
        for (Piece piece: pieces) {
            Moves captureMoves = piece.getCaptureMoves();
            addAll(piece, captureMoves);
        }
    }

    public void refresh() {
        compute(opponent.getPieces()); 
    }

    public boolean isTargeted(Location location) {
        return !targetMap[location.y][location.x].isEmpty();
    }

    public boolean isUnderCheck() {
        Location location = king.getLocation();
        return isTargeted(location); 
    }
}
