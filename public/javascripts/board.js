define(['boardView',
        'grid',
        'pieceView',
        'utils'], function(BoardView, Grid, PieceView, Utils) {

    function Board(clickHandler, sides, connection) {
        var boardView = new BoardView(clickHandler);
        var grid = new Grid();
        var sides = sides;
        var connection = connection;
        var currentPassingMoves;
        var currentCapturingMoves;

        connection.register("select", onSelect);
        connection.register("move", onMoved);

        function highlight(moves, colour) {
            moves.locations.forEach(function(location) {
                moves.highlightFunction(colour, location.x, location.y); 
            });
        }

        function onSelect(selection) {
            var piece = grid.get(selection.source.x, selection.source.y);
            var colour = Utils.getColour(piece); 
            currentPassingMoves = { 
                locations: selection.moves.passing, 
                highlightFunction: boardView.highlightPassingMove
            };
            highlight(currentPassingMoves, colour);
            currentCapturingMoves = { 
                locations: selection.moves.capturing, 
                highlightFunction: boardView.highlightCapturingMove
            };
            highlight(currentCapturingMoves, colour);
        }

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

        function checkDestination(xDest, yDest) {
            return currentPassingMoves.locations.some(function(location) {
                return (location.x === xDest && location.y === yDest);
            });
        }

        function onMoved(move) {
            var xSource = move.src.x;
            var ySource = move.src.y;
            var xDest = move.dest.x;
            var yDest = move.dest.y;

            handleTarget(xDest, yDest);
            var piece = grid.get(xSource, ySource); 
            grid.reset(xSource, ySource);
            grid.set(piece, xDest, yDest);
            PieceView.move(piece, xDest, yDest);
        }
        
        // TODO need abstraction for below 
        // need better interface
        this.move = function(xSource, ySource, xDest, yDest) {
            var allowedMove = checkDestination(xDest, yDest);
            if (allowedMove) {
                connection.send({
                    move: {
                        src: {
                            x: xSource,
                            y: ySource
                        }, dest: {
                            x: xDest,
                            y: yDest
                        }
                    } 
                });
            }
            boardView.removeHighlighting(currentPassingMoves.locations);
            currentPassing = undefined;
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
