package com.chess.app;
import java.util.List;

public class Display {
    private Board board;

    public Display(Board board) {
        this.board = board;
    }

    private void print(String s) {
        System.out.print(s);
    }

    public void newLine() {
        System.out.println("");
    }

    private String getBlackPiece(Piece piece) {
        if (piece instanceof Queen) {
            return "♕";
        } else if (piece instanceof Rook) {
            return "♖";
        } else if (piece instanceof Bishop) {
            return "♗";
        } else if (piece instanceof Knight) {
            return "♘";
        } else if (piece instanceof Pawn) {
            return "♙";
        } else if (piece instanceof King) {
            return "♔";
        } else {
            return "?";
        }
    }

    private String getWhitePiece(Piece piece) {
        if (piece instanceof Queen) {
            return "♛";
        } else if (piece instanceof Rook) {
            return "♜";
        } else if (piece instanceof Bishop) {
            return "♝";
        } else if (piece instanceof Knight) {
            return "♞";
        } else if (piece instanceof Pawn) {
            return "♟";
        } else if (piece instanceof King) {
            return "♚";
        } else {
            return "?";
        }
    }

    private String getPiece(Piece piece) {
        if (piece == null) {
            return "_";
        } else if (piece.isWhite()){
            return getWhitePiece(piece); 
        } else {
            return getBlackPiece(piece);
        }
    }
    
    public void showMoves(Player player) {
        for (Piece piece : player.getPieces()) {
            Moves moves = piece.getMoves();
            showMoves(moves);
            newLine();
        }
    }

    public void showMoves(Moves moves) {
        List<Location> capturing = moves.getCapturing();
        List<Location> passing = moves.getPassing();
        for (int i = 0; i < board.MAX_COLUMNS; ++i) {
            for (int j = 0; j < board.MAX_ROWS; ++j) {
                Location currentLocation = new Location(j, i);
                if (capturing.contains(currentLocation)) {
                    print("x"); 
                } else if (passing.contains(currentLocation)) {
                    print("+"); 
                } else {
                    String piece = getPiece(board.get(currentLocation));
                    print(piece);
                }
                print(" ");
            }
            newLine();
        }
    }

    public void show() {
        for (int i = 0; i < board.MAX_COLUMNS; ++i) {
            for (int j = 0; j < board.MAX_ROWS; ++j) {
                String piece = getPiece(board.get(new Location(j, i)));   
                print(piece);
                print(" ");
            }
            newLine();
        }
    }
}
