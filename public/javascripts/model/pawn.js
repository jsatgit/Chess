define([], function() {
    function Pawn(colour, location, board) {
        var colour      = colour; 
        var location    = location;
        var board       = board;
        var direction   = 1;
        var moved       = 0;

        if (colour == WHITE) {
            direction = 1;
        } else {
            direction = -1;
        }

        function getX() {
            return location.x;
        }
        
        function frontY(step) {
            return location.y + direction*step;
        }

        function rightX(step) {
            return location.x + step;
        }

        function leftX(step) {
            return location.x - step;
        }

        function getSquareInFront(step) {
            return {
                x : getX(),
                y : getFrontY(step)
            }; 
        }

        function getRightDiagonalSquare() {
            return {
                x : getRightX(1),
                y : getFrontY(1)
            };
        }

        function getLeftDiagonalSquare() {
            return {
                x : getLeftX(1),
                y : getFrontY(1)
            };
        }

        function getNonCaptureMoves() {
            var moves = [];
            if (board.isFree(getSquareInFront(1))) {
                moves.push(getSquareInFront(1));
            }
            if (hasNotMoved()) {
                moves.push(getSquareInFront(2)); 
            }
            return moves;
        }

        function getCaptureMoves() {
            var moves = [];
            if (board.isOccupied(getRightDiagonalSquare())) {
                moves.push(getRightDiagonalSquare());
            }
            if (board.isOccupied(getLeftDiagonalSquare())) {
                moves.push(getLeftDiagonalSquare());
            }
            return moves;
        }

        this.getMoves = function() {
            return {
                nonCaptureMoves : getNonCaptureMoves(),
                captureMoves    : getCaptureMoves()  
            };
        }
    }

    return Pawn;
});
