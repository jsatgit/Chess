require(['board',
		 'PieceBuilder',
         'controller',
         'view',
         'loader',
         'model',
         'game'], function(Board, PieceBuilder, Controller, View, Loader, Model, Game) {
		
    // TODO static methods and classes

    this.onPiecesLoaded = function() {
        Game.init(Model, Controller);
    } 

	function initPieces() {
		PieceBuilder.create("whitePawn", 0, 6);
		PieceBuilder.create("whitePawn", 1, 6);
		PieceBuilder.create("whitePawn", 2, 6);
		PieceBuilder.create("whitePawn", 3, 6);

		PieceBuilder.create("whitePawn", 4, 6);
		PieceBuilder.create("whitePawn", 5, 6);
		PieceBuilder.create("whitePawn", 6, 6);
		PieceBuilder.create("whitePawn", 7, 6);

		PieceBuilder.create("whiteRook",   0, 7);
		PieceBuilder.create("whiteKnight", 1, 7);
		PieceBuilder.create("whiteBishop", 2, 7);
		PieceBuilder.create("whiteQueen",  3, 7);

		PieceBuilder.create("whiteKing",   4, 7);
		PieceBuilder.create("whiteBishop", 5, 7);
		PieceBuilder.create("whiteKnight", 6, 7);
		PieceBuilder.create("whiteRook",   7, 7);

		PieceBuilder.create("blackPawn", 0, 1);
		PieceBuilder.create("blackPawn", 1, 1);
		PieceBuilder.create("blackPawn", 2, 1);
		PieceBuilder.create("blackPawn", 3, 1);

		PieceBuilder.create("blackPawn", 4, 1);
		PieceBuilder.create("blackPawn", 5, 1);
		PieceBuilder.create("blackPawn", 6, 1);
		PieceBuilder.create("blackPawn", 7, 1);

		PieceBuilder.create("blackRook",   0, 0);
		PieceBuilder.create("blackKnight", 1, 0);
		PieceBuilder.create("blackBishop", 2, 0);
		PieceBuilder.create("blackQueen",  3, 0);

		PieceBuilder.create("blackKing",   4, 0);
		PieceBuilder.create("blackBishop", 5, 0);
		PieceBuilder.create("blackKnight", 6, 0);
		PieceBuilder.create("blackRook",   7, 0);
	}

    Board.init();

    Model.init();

    Loader.subscribe(this);

	initPieces();

});
