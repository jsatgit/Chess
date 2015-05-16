package com.chess.app;
import java.util.List;
import play.Logger;

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
            //return "♕";
            return "BQ";
        } else if (piece instanceof Rook) {
            //return "♖";
            return "BR";
        } else if (piece instanceof Bishop) {
            //return "♗";
            return "BB";
        } else if (piece instanceof Knight) {
            //return "♘";
            return "BN";
        } else if (piece instanceof Pawn) {
            //return "♙";
            return "BP";
        } else if (piece instanceof King) {
            //return "♔";
            return "BK";
        } else {
            return "?";
        }
    }

    private String getWhitePiece(Piece piece) {
        if (piece instanceof Queen) {
            //return "♛";
            return "WQ";
        } else if (piece instanceof Rook) {
            //return "♜";
            return "WR";
        } else if (piece instanceof Bishop) {
            //return "♝";
            return "WB";
        } else if (piece instanceof Knight) {
            //return "♞";
            return "WN";
        } else if (piece instanceof Pawn) {
            //return "♟";
            return "WP";
        } else if (piece instanceof King) {
            //return "♚";
            return "WK";
        } else {
            return "?";
        }
    }

    private String getPiece(Piece piece) {
        if (piece == null) {
            return "__";
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
                    print("xx"); 
                } else if (passing.contains(currentLocation)) {
                    print("++"); 
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
