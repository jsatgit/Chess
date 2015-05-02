define(['constants'], function(Const) {
    function setCoords(item, x, y) {
        item.attr("xCoord", x); 
        item.attr("yCoord", y); 
    }
	
    function getXCoord(element) {
        return element.attr("xCoord");
    }
    
    function getYCoord(element) {
        return element.attr("yCoord");
    }

    String.prototype.startsWith = function (str){
        return this.indexOf(str) == 0;
    };

    function isWhite(piece) {
        var id = piece.attr("id");
        return id.startsWith("white");
    }

    // TODO perhaps integrate this into the piece
    function type(piece) {
        var id = piece.attr("id");
        return id.substr(5, id.length - 5);
    }

    function getAllSquares() {
        if (!this.squares) {
            this.squares = [];
            // TODO change this 8 to a constant
            for (var i = 0; i < 8; ++i) {
                for (var j = 0; j < 8; ++j) {
                    this.squares.push({x:i,y:j});
                } 
            }
        }
        return this.squares;
    }

	return {
        setCoords       : setCoords,
        getXCoord       : getXCoord,
        getYCoord       : getYCoord,
        isWhite         : isWhite,
        getAllSquares   : getAllSquares,
        type            : type
	};
});
