define([], function() {
    function Queen(colour, location, board) {
    
        function computeLinearMoves(getNext) {
            var testLocation = update(location);
            while(board.isValidLocation(testLocation)) {
                if (board.isOccupied(testLocation)) {
                    moves.forCapturing.push(testLocation);
                    break;
                } else {
                    moves.forPassing.push(testLocation);
                    testLocation = getNext(testLocation);
                }
            }
        }


        function computeMoves() {
            computeLinearMoves(upperRightDiagonal);
            computeLinearMoves(upperLeftDiagonal);
            computeLinearMoves(lowerRightDiagonal);
            computeLinearMoves(lowerLeftDiagonal);
            computeLinearMoves(rightRank);
            computeLinearMoves(leftRank);
            computeLinearMoves(upperFile);
            computeLinearMoves(lowerFile);
        }
        function initializeMoves() {
            moves.forCapturing = [];
            moves.forPassing = [];
        }

        this.getMoves = function() {
            initializeMoves();
            computeMoves();
            return moves;
        }
    }

    return Queen;
});
