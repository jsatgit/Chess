define(['config', 
        'human', 
        'computer',
        'constants',
        'utils',
        'moves'], function(Config, Human, Computer, Const, Utils, Moves) {
    
    var whitePlayer;
    var blackPlayer;
    var currentPlayer;

    function pieceRemoved(piece) {
        if (Utils.isWhite(piece)) {
            whitePlayer.remove(piece);
        } else {
            blackPlayer.remove(piece);
        }
    }

    // TODO move board setup near here
    function init(model, controller) {
        whitePlayer = Human;
        blackPlayer = Computer;
        Moves.init(model);
        Computer.init(Const.BLACK, model, controller);
        currentPlayer = whitePlayer;
    }

    function play() {
        while(true) {
            if (currentPlayer.move()) {
                // computer
                switchTurns();
            } else {
                // human
                break;
            }
        }
    }

    function switchTurns() {
        if (currentPlayer == whitePlayer) {
            currentPlayer = blackPlayer;
        } else {
            currentPlayer = whitePlayer;
        }
    }

    // TODO this assumes humans go first
    function humanMoved(piece) {
        switchTurns();
        play();
    }

    return {
        init            : init,
        play            : play,
        humanMoved      : humanMoved,
        pieceRemoved    : pieceRemoved
    }
});
