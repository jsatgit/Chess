define(['utils'], function(Utils) {
    function Sides() {
        var whitePieces = [];
        var blackPieces = [];

        this.add = function(piece) {
            if (Utils.isWhite(piece)) {
                whitePieces.push(piece);
            } else {
                blackPieces.push(piece);
            } 
        }

        this.remove = function(piece) {
            if (Utils.isWhite(piece)) {
                Utils.removeFromArray(whitePieces, piece);
            } else {
                Utils.removeFromArray(blackPieces, piece);
            } 
        }
            
        this.getWhitePieces = function() {
            return whitePieces;
        }

        this.getBlackPieces = function() {
            return blackPieces; 
        }
    }

    return Sides;
});
