define(['constants'], function(Const) {

    // TODO remove and diversify

    var Utils = {};

    Utils.setCoords = function(item, x, y) {
        item.attr("xCoord", x); 
        item.attr("yCoord", y); 
    }
	
    Utils.getXCoord = function(element) {
        return parseInt(element.attr("xCoord"));
    }
    
    Utils.getYCoord = function(element) {
        return parseInt(element.attr("yCoord"));
    }

    String.prototype.startsWith = function (str){
        return this.indexOf(str) == 0;
    };

    Utils.isWhite = function(piece) {
        var id = piece.attr("id");
        return id.startsWith("white");
    }
    
    Utils.getColour = function(piece) {
        if (Utils.isWhite(piece)) {
            return "white";
        } else {
            return "black";
        }
    }
    
    Utils.getColourEnum = function(piece) {
        if (Utils.isWhite(piece)) {
            return "WHITE";
        } else {
            return "BLACK";
        }
    }

    // TODO perhaps integrate this into the piece
    Utils.type = function(piece) {
        var id = piece.attr("id");
        return id.substr(5, id.length - 5);
    }

    Utils.getAllSquares = function() {
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
        
    Utils.removeFromArray = function(array, item) {
        var index = array.indexOf(item);
        if (index > -1) {
            array.splice(index, 1);
        }
    }

    return Utils;
});
