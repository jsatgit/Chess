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

	return {
        setCoords       : setCoords,
        getXCoord       : getXCoord,
        getYCoord       : getYCoord,
        isWhite         : isWhite
	};
});
