define(['controller',
        'utils',
        'model',
        'constants'], function(Controller, Utils, Model, Const) {
    var sourceSelected;

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
            Controller.move(source.x, source.y, x, y, Const.HUMAN);
        } else {
            selectSource(x, y);
        }
    }

    function freeSquareClick(x, y) {
        if (sourceSelected) {
            var source = sourceSelected;
            unSelectSource();
            Controller.move(source.x, source.y, x, y, Const.HUMAN);
        }
    }

	function squareClick() {
        /* if the square contains a piece
         * it is a piece click; if it contains 
         * just the square its a square click 
         */
        var x = Utils.getXCoord(this); 
        var y = Utils.getYCoord(this); 

        // TODO should the click handler even be touching the model
        var piece = Model.getPiece(x, y);
        if (piece) {
            occupiedSquareClick(x, y);
        } else {
            freeSquareClick(x, y);
        }
	}

	function pieceClick() {
        var x = Utils.getXCoord(this); 
        var y = Utils.getYCoord(this); 
        occupiedSquareClick(x, y);
	}
	
	function registerPiece(piece) {
		piece.click(pieceClick);
	}

	function registerSquare(square) {
		square.click(squareClick);
	}

	return {
		registerPiece 	: registerPiece,
		registerSquare 	: registerSquare
	};
});
