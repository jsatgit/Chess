define(['utils',
        'constants'], function(Utils) {

    function ClickHandler() {

        var sourceSelected;
        var board;

        function unSelectSource() {
            sourceSelected = undefined;
       }

        function selectSource(x, y) {
            sourceSelected = {x:x, y:y};
        }

        // TODO clean up
        function occupiedSquareClick(x, y) {
            if (sourceSelected) {
                if (sourceSelected.x == x && sourceSelected.y == y) {
                    return;
                }
                // TODO weird look
                var source = sourceSelected;
                unSelectSource();
                board.movePiece(source.x, source.y, x, y);
            } else {
                selectSource(x, y);
            }
        }

        function freeSquareClick(x, y) {
            if (sourceSelected) {
                var source = sourceSelected;
                unSelectSource();
                board.movePiece(source.x, source.y, x, y);
            }
        }
        
        function pieceClick() {
            var x = Utils.getXCoord(this); 
            var y = Utils.getYCoord(this); 
            occupiedSquareClick(x, y);
        }

        function squareClick() {
            /* if the square contains a piece
             * it is a piece click; if it contains 
             * just the square its a square click 
             */
            var x = Utils.getXCoord(this); 
            var y = Utils.getYCoord(this); 

            // TODO should the click handler even be touching the model
            var piece = board.getPiece(x, y);
            if (piece) {
                occupiedSquareClick(x, y);
            } else {
                freeSquareClick(x, y);
            }
        }

        this.registerPiece = function(piece) {
            piece.click(pieceClick);
        }

        this.registerSquare = function(square) {
            square.click(squareClick);
        }

        // TODO find better solution
        this.setBoard = function(aBoard) {
            board = aBoard;
        }
        
    }

    return ClickHandler;

});
