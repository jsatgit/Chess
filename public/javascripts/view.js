define(['assets/javascripts/vendor/snap.js',
        'utils',
        'config'], function(Snap, Utils, Config) {

    function getMatrix(x, y) {
		var mat = new Snap.Matrix();
		mat.translate(x*Config.view.squareWidth, y*Config.view.squareWidth);
		mat.scale(Config.view.pieceScaler);
        return mat;
    }

    function place(piece, x, y) {
        Utils.setCoords(piece, x, y);
        var mat = getMatrix(x, y);
		piece.animate({transform: mat}, 0);
    }

    function move(piece, x, y) {
        Utils.setCoords(piece, x, y);
        var mat = getMatrix(x, y);
        piece.animate({transform: mat}, Config.view.moveTime);
    }

    function remove(piece) {
        piece.remove();
    }

    return {
        place   : place,
        move    : move,
        remove  : remove
    };
});
