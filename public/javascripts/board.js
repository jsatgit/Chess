define(['assets/javascripts/vendor/snap.js',
		'clickHandler',
        'config',
        'utils'], function(Snap, ClickHandler, Config, Utils) {
	var board;
    
	function whites(i, j) {
		return (i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1);
	}
	
	function square(i, j, width, colour) {
		var square = board.rect(i*width, j*width, width, width);
		Utils.setCoords(square, i, j);
		square.attr(colour);
		ClickHandler.registerSquare(square);
	}

	function squares(squareWidth, squareCount, whiteSquare, blackSquare) {
		for (var i = 0; i < squareCount; ++i) {
			for (var j = 0; j < squareCount; ++j) {
				if (whites(i, j)) {
					square(i, j, squareWidth, whiteSquare);
				}
				else {
					square(i, j, squareWidth, blackSquare);
				}
			}
		}
	}

	function squareStyle(colour) {
		return {
			fill 		: colour,
			stroke 		: colour,
			strokeWidth : 0
		};
	}

	function init() {
		board = Snap(Config.board.width, Config.board.width);

		var whiteSquare = squareStyle(Config.board.whiteSquareColour);
		var blackSquare = squareStyle(Config.board.blackSquareColour);

		squares(Config.view.squareWidth, 
                Config.board.squareCount, 
                whiteSquare, 
                blackSquare);
	}

    function append(piece) {
        board.append(piece);
    }

	return {
        init    : init, 
        append  : append
    }
});
