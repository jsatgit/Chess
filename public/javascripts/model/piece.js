define([], function() {
    function Piece(colour, location, board) {
        var colour  = colour; 
        var location = location;
        var board = board;
        var direction = 1;
        var moved = 0;
        var moves;

        if (colour == WHITE) {
            direction = 1;
        } else {
            direction = -1;
        }
    }

    return Piece;
});
