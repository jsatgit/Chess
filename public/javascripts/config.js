define(['constants'], function(Const) {
	var board = {
		width 				: 500,
		squareCount 		: 8,
		whiteSquareColour 	: "#F0D9B5",
		blackSquareColour 	: "#B58863"
	};

	var piece = {
		width : 45
	};

    // TODO change into calculated
    // some depend on others
    var view = {
        squareWidth : board.width/board.squareCount,
        pieceScaler : board.width/(piece.width * board.squareCount),
        moveTime    : 250
    };

    var game = {
    }

	return {
		board : board,
		piece : piece,
        view  : view,
        game  : game
	};
});
