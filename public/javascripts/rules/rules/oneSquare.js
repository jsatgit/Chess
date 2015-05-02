define([], function() {
    function OneSquare() {
    }

    function isOneSquare(destX, destY, sourceX, sourceY, colour) {
        if (colour) {
            return (sourceY - destY == 1) && (Math.abs(sourceX - destX) == 1); 
        } else {
            return (destY - sourceY == 1) && (Math.abs(sourceX - destX) == 1);
        }
    }

    OneSquare.prototype.apply = function(x, y, colour, squares) {
        var result = [];
        squares.forEach(function(square) {
            if (isOneSquare(square.y, square.x, y, x,  colour)) {
                result.push(square); 
            } 
        });
        return result;
    }

    return OneSquare; 
});
