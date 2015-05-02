define([], function() {
    function ForwardOnly() {
    
    }

    function isInFront(test, current, colour) {
        // TODO need to make enum for colour
        // and get direction
        var res;
        if (colour) {
            res = test < current;     
        } else {
            res = test > current;
        }
        return res;
    }

    ForwardOnly.prototype.apply = function(x, y, colour, squares) {
        var result = [];
        squares.forEach(function(square) {
            if (isInFront(square.y, y, colour)) {
                result.push(square); 
            } 
        });
        return result;
    }

    return ForwardOnly;
});
