define(['assets/javascripts/vendor/snap.js',
		'config',
		'clickHandler',
        'view',
        'loader',
        'board',
        'model'], function(Snap, Config, ClickHandler, View, Loader, Board, Model) {

	function getPath(name) {
		return "/assets/images/chesspieces/" + name + ".svg";
	}

	function onLoaded(name, svg) {
		var piece = svg2Piece(name, svg);
		var pos = Loader.dequeue(name);

        // TODO gather together
		ClickHandler.registerPiece(piece);
        Board.append(piece);
		View.place(piece, pos.x, pos.y);
        Model.setPiece(piece, pos.x, pos.y);
        Model.store(piece);

        // TODO what about loaded promoted pieces
        Loader.notify(name);
	}

	function svg2Piece(name, svg) {
		return svg.select("#" + name);
	}
    
	function create(name, x, y) {
		Loader.enqueue(name, x, y);
		var path = getPath(name);
		Snap.load(path, function(svg) {
			onLoaded(name, svg);
		});
		return name;
	}
	
	return {
        create  : create
    }
})
