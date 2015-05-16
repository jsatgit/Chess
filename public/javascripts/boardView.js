define(['snap',
        'config',
        'utils'], function(Snap, Config, Utils) {

    function BoardView(clickHandler) {
        var clickHandler = clickHandler;
        var board = Snap(Config.board.width, Config.board.width);
        var whiteSquareStyle = getStyleByColour(Config.board.whiteSquareColour);
        var blackSquareStyle = getStyleByColour(Config.board.blackSquareColour);

        setupSquares(); 

        function isWhiteSquare(i, j) {
            return (i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1);
        }

        function setupSquare(i, j, style) {
            var width = Config.view.squareWidth;
            var square = board.rect(i*width, j*width, width, width);
            Utils.setCoords(square, i, j);
            square.attr(style);
            clickHandler.registerSquare(square);
        }

        function setupSquares() {
            var squareCount = Config.board.squareCount;
            for (var i = 0; i < squareCount; ++i) {
                for (var j = 0; j < squareCount; ++j) {
                    if (isWhiteSquare(i, j)) {
                        setupSquare(i, j, whiteSquareStyle);
                    } else {
                        setupSquare(i, j, blackSquareStyle);
                    }
                }
            }
        }

        function getStyleByColour(colour) {
            return {
                fill 		: colour,
                stroke 		: colour,
                strokeWidth : 0
            };
        }

        this.append = function(piece) {
            board.append(piece);
        }

        this.highlightPassing = function(x, y) {
            setupSquare(x, y, {
                fill : "green",
                stroke : "green",
                strokeWidth: 0
            }); 
        }
    }

    return BoardView;
});
