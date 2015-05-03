define(['clickHandler',
        'board', 
        'sides',
        'loader',
        'pieceBuilder'], function(ClickHandler, Board, Sides, Loader, PieceBuilder) {

    function ChessView() {
        var clickHandler = new ClickHandler();
        
        var sides = new Sides();

        var board = new Board(clickHandler, sides);

        clickHandler.setBoard(board);

        var loader = new Loader().withSubscription(this);

        var pieceBuilder = new PieceBuilder(board, sides, loader, clickHandler);

        pieceBuilder.build("whitePawn", 0, 6);
        pieceBuilder.build("whitePawn", 1, 6);
        pieceBuilder.build("whitePawn", 2, 6);
        pieceBuilder.build("whitePawn", 3, 6);

        pieceBuilder.build("whitePawn", 4, 6);
        pieceBuilder.build("whitePawn", 5, 6);
        pieceBuilder.build("whitePawn", 6, 6);
        pieceBuilder.build("whitePawn", 7, 6);

        pieceBuilder.build("whiteRook",   0, 7);
        pieceBuilder.build("whiteKnight", 1, 7);
        pieceBuilder.build("whiteBishop", 2, 7);
        pieceBuilder.build("whiteQueen",  3, 7);

        pieceBuilder.build("whiteKing",   4, 7);
        pieceBuilder.build("whiteBishop", 5, 7);
        pieceBuilder.build("whiteKnight", 6, 7);
        pieceBuilder.build("whiteRook",   7, 7);

        pieceBuilder.build("blackPawn", 0, 1);
        pieceBuilder.build("blackPawn", 1, 1);
        pieceBuilder.build("blackPawn", 2, 1);
        pieceBuilder.build("blackPawn", 3, 1);

        pieceBuilder.build("blackPawn", 4, 1);
        pieceBuilder.build("blackPawn", 5, 1);
        pieceBuilder.build("blackPawn", 6, 1);
        pieceBuilder.build("blackPawn", 7, 1);

        pieceBuilder.build("blackRook",   0, 0);
        pieceBuilder.build("blackKnight", 1, 0);
        pieceBuilder.build("blackBishop", 2, 0);
        pieceBuilder.build("blackQueen",  3, 0);

        pieceBuilder.build("blackKing",   4, 0);
        pieceBuilder.build("blackBishop", 5, 0);
        pieceBuilder.build("blackKnight", 6, 0);
        pieceBuilder.build("blackRook",   7, 0);

        var uiLoaded;

        this.isUiLoaded = function() {
            return uiLoaded;
        } 

        this.onAllPiecesLoaded = function() {
            console.log("UI Loaded!");
            uiLoaded = true;
        } 

        this.movePiece = function(xSrc, ySrc, xDest, yDest) {
            board.movePiece(xSrc, ySrc, xDest, yDest);
        }

    }		

    return ChessView;
});
