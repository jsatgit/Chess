define(['snap',
        'utils',
        'config'], function(Snap, Utils, Config) {

    var PieceView = {};

    function getMatrix(x, y) {
		var mat = new Snap.Matrix();
		mat.translate(x*Config.view.squareWidth, y*Config.view.squareWidth);
		mat.scale(Config.view.pieceScaler);
        return mat;
    }

    PieceView.place = function(piece, x, y) {
        Utils.setCoords(piece, x, y);
        var mat = getMatrix(x, y);
		piece.animate({transform: mat}, 0);
    }

    PieceView.move = function(piece, x, y) {
        Utils.setCoords(piece, x, y);
        var mat = getMatrix(x, y);
        piece.animate({transform: mat}, Config.view.moveTime);
    }

    PieceView.remove = function(piece) {
        piece.remove();
    }

    return PieceView; 
});
