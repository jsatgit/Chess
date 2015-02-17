define(['constants', 
        'utils'], function (Const, Utils) {
    var pieces = [];
    
    // TODO change this too
    var Model;
    var Controller;

    function rand(max) {
        return Math.floor(Math.random() * max);
    }

    function move() {
        var randIndex = rand(pieces.length);
        var randPiece = pieces[randIndex];
        var xSource = Utils.getXCoord(randPiece);
        var ySource = Utils.getYCoord(randPiece);
        var xDest = rand(8) 
        var yDest = rand(8);

        Controller.move(xSource, ySource, xDest, yDest);
        return true;
    }

    function remove(piece) {
        var index = pieces.indexOf(piece);
        pieces.splice(index, 1);
    }

    function init(colour, model, controller) {
        Model = model;
        Controller = controller;
        // TODO need better soln
        if (colour == Const.BLACK) {
            pieces = Model.getBlackPieces();         
        } else {
            pieces = Model.getWhitePieces();         
        }
    }

    return {
        init    : init,
        move    : move,
        remove  : remove
    }
});
