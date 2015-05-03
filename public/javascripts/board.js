define(['boardView',
        'grid',
        'pieceView'], function(BoardView, Grid, PieceView) {

    function Board(clickHandler, sides) {
        var boardView = new BoardView(clickHandler);
        var grid = new Grid();
        var sides = sides;

        function capture(target, x, y) {
            // TODO it checks even if the piece doesnt belong to you
            // combine all actions into one atomic operation

            grid.reset(x, y);
            PieceView.remove(target); 
            sides.remove(target);
        }

        function handleTarget(x, y) {
            var target = grid.get(x, y);
            if (target) {
                capture(target, x, y);
            }
        }
        
        // TODO need abstraction for below 
        // need better interfae
        this.movePiece = function(xSource, ySource, xDest, yDest) {
            handleTarget(xDest, yDest);

            var piece = grid.get(xSource, ySource); 
            grid.reset(xSource, ySource);
            grid.set(piece, xDest, yDest);
            PieceView.move(piece, xDest, yDest);
        }

        this.getPiece = function(x, y) {
            return grid.get(x, y);
        }
        
        this.append = function(piece, x, y) {
            boardView.append(piece, x, y) 
            grid.set(piece, x, y);
        }
    }

    return Board; 
});
