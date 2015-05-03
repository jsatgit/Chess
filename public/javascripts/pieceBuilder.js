define(['snap',
		'config',
        'pieceView'], function(Snap, Config, PieceView) {

    function PieceBuilder(board, sides, loader, clickHandler) {
        
        var board = board;
        var sides = sides;
        var loader = loader;
        var clickHandler = clickHandler;

        function getPath(name) {
            return "/assets/images/chesspieces/" + name + ".svg";
        }

        function onLoaded(name, svg) {
            var piece = svg2Piece(name, svg);
            var pos = loader.dequeue(name);

            sides.add(piece);
            board.append(piece, pos.x, pos.y);
            clickHandler.registerPiece(piece);
            PieceView.place(piece, pos.x , pos.y);

            // TODO what about loaded promoted pieces
            loader.notify(name);
        }

        function svg2Piece(name, svg) {
            return svg.select("#" + name);
        }
        
        this.build = function(name, x, y) {
            loader.enqueue(name, x, y);
            var path = getPath(name);
            Snap.load(path, function(svg) {
                onLoaded(name, svg);
            });
            return name;
        }
    }
	
	return PieceBuilder; 
})
