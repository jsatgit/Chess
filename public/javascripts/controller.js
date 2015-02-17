define(['view',
        'model',
        'game',
        'constants'], function(View, Model, Game, Const) {

    function capture(target, x, y) {
        Model.resetSquare(x, y);
        // TODO it checks even if the piece doesnt belong to you
        Game.pieceRemoved(target);
        View.remove(target); 
    }

    function handleTarget(x, y) {
        var target = Model.getPiece(x, y);
        if (target) {
            capture(target, x, y);
        }
        
    }

    function move(xSource, ySource, xDest, yDest, player) {
        handleTarget(xDest, yDest);
        var source = Model.getPiece(xSource, ySource);
        View.move(source, xDest, yDest); 
        Model.move(xSource, ySource, xDest, yDest);

        if (player == Const.HUMAN) {
            Game.humanMoved();
        } 
    }

    return {
        move : move
    }
});
