define(['snap',
        'config',
        'utils'], function(Snap, Config, Utils) {

    function BoardView(clickHandler) {
        var clickHandler = clickHandler;
        var board = Snap(Config.board.width, Config.board.width);
        var whiteSquareStyle = getStyleByColour(Config.board.whiteSquareColour);
        var blackSquareStyle = getStyleByColour(Config.board.blackSquareColour);
        var highlighting = [];

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
        
        function getCapturingStyleByColour(colour) {
            return {
                fill 		: colour,
                stroke 		: colour,
                strokeWidth : 2,
                "fill-opacity": 0
            };
        }

        this.append = function(piece) {
            board.append(piece);
        }

        this.highlightPassingMove = function(colour, x, y) {
            var width = Config.view.squareWidth;
            var circle = board.circle((x + 0.5)*width, (y + 0.5)*width, width/16);
            circle.attr(getStyleByColour(colour));
            highlighting.push(circle);
        }
        
        this.highlightCapturingMove = function(colour, x, y) {
            var width = Config.view.squareWidth;
            var rectangle = board.rect(x*width, y*width, width, width);
            rectangle.attr(getCapturingStyleByColour(colour));
            highlighting.push(rectangle);
        }

        this.removeHighlighting = function(passingMoves) {
            highlighting.forEach(function(circle) {
                circle.remove(); 
            });
            highlighting = [];
        }
    }

    return BoardView;
});
