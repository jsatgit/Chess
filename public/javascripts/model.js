define(['controller',
        'constants',
        'config',
        'utils',
        'constants'], function(Controller, Constants, Config, Utils, Const) {
    var board;
    var blackPieces = [];
    var whitePieces = [];

    function init() {
        board = [];
        var n = Config.board.squareCount;
        for (var i = 0; i < n; ++i) {
            board[i] = [];
        }
    }

    function store(piece) {
        if (Utils.isWhite(piece)) {
            whitePieces.push(piece);
        } else {
            blackPieces.push(piece);
        } 
    }
    
    // TODO need abstraction for below 
    // need better interfae
    function resetSquare(x, y) {
        board[x][y] = undefined;
    }
    
    function setPiece(piece, x, y) {
        board[x][y] = piece; 
    }

    function getPiece(x, y) {
        return board[x][y];
    }

    function move(xSource, ySource, xDest, yDest) {
        var piece = getPiece(xSource, ySource); 
        resetSquare(xSource, ySource);
        setPiece(piece, xDest, yDest);
    }
    
    function getWhitePieces() {
        return whitePieces;
    }

    function getBlackPieces() {
        return blackPieces; 
    }

    return {
        init            : init,
        setPiece        : setPiece,
        getPiece        : getPiece,
        resetSquare     : resetSquare,
        move            : move,
        store           : store,
        getBlackPieces  : getBlackPieces,
        getWhitePieces  : getWhitePieces
    }
});
