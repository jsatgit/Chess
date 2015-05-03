package com.chess.app;
import java.util.List;
import java.util.ArrayList;

public class TargetComputer {
    private Board board;
    private List<Piece>[][] targetMap;

    public TargetComputer(Board board) {
        this.board = board;
        this.targetMap = new ArrayList[Board.MAX_ROWS][Board.MAX_COLUMNS];
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
}
