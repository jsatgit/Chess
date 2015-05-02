define(['utils',
        'rules/pawn'], function(Utils, Pawn) {

    function init(model) {
        Pawn.init(model); 
    }

    function allowed(piece) {
        var type = Utils.type(piece);
        // TODO make into enum
        // can also optimize based on usage
        var positions;
        if (type == "Pawn") {
            positions = Pawn.allowed(piece);
        } else if (type == "Knight") {
            positions = Kngiht.allowed(piece); 
        } else if (type == "Bishop") {
            positions = Bishop.allowed(piece);
        } else if (type == "Rook") {
            positions = Rook.allowed(piece);
        } else if (type == "Queen") {
            positions = Queen.allowed(piece); 
        } else if (type == "King") {
            positions = King.allowed(piece); 
        } else {
            console.log("No such type of piece: " + type);
        }
        return positions;
    }

    return {
        init : init,
        allowed : allowed
    }
});
