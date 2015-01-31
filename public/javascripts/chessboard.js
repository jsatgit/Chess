var board;

// make part of config
var boardSize = 500;
var pieceSz = 45;
var gridLen = 8;
var sqSz = boardSize/gridLen;

function whites(i, j) {
	return (i % 2 == 0 && j % 2 == 0) || (i % 2 == 1 && j % 2 == 1);
}

whiteSq = {
	fill: "#F0D9B5",
	stroke: "#F0D9B5",
	strokeWidth: 0
};

blackSq = {
	fill: "#B58863",
	stroke: "#B58863",
	strokeWidth: 0
};

function createSquare(i, j, size, colour) {
	var sq = board.rect(i, j, size, size);
	sq.attr(colour);
	return sq;
}

function createSqId(i, j) {
	return i.toString() + "," + j.toString();
}

function parseSqId(id) {
	var pos = id.split(",");
	return {x:pos[0], y:pos[1]};
}

function createSquares(size) {
	for (var i = 0; i < gridLen; ++i) {
		for (var j = 0; j < gridLen; ++j) {
			var sq;
			if (whites(i, j)) {
				sq = createSquare(i*sqSz, j*sqSz, sqSz, whiteSq);
			}
			else {
				sq = createSquare(i*sqSz, j*sqSz, sqSz, blackSq);
			}
			var id = createSqId(i, j);
			sq.attr({id: id});
			sq.click(boardClick);
		}
	}
}
	
function init2dArr(arr) {
	for (var i = 0; i < gridLen; ++i) {
		var col = [];
		for (var j = 0; j < gridLen; ++j) {
			col.push("");	
		}
		arr.push(col);	
	}
}

function LocMap() {
	var self = this;

	self.id2coord = {};
	self.coord2id = [];
	
	init2dArr(self.coord2id);
	
	self.set = function(id, x, y) {
		self.id2coord[id] = {x:x, y:y};
		self.coord2id[x][y] = id;
	}
	
	self.getCoord = function(id) {
		return self.id2coord[id];
	}

	self.getId = function(x, y) {
		return self.coord2id[x][y];
	}

	self.rem = function(id) {
		var pos = self.getCoord(id);
		delete self.id2coord[id];
		self.coord2id[pos.x][pos.y] = "";
	}
}

var locMap = new LocMap(); 

function place(id, x, y) {
	locMap.set(id, x, y);

	// make this more efficient
	var mat = new Snap.Matrix();
	mat.translate(x*sqSz, y*sqSz);
	mat.scale(sqSz/pieceSz);

	var piece = board.select("#" + id);
	piece.animate({transform: mat}, 0);
}

function move(id, x, y) {
	locMap.set(id, x, y);

	var mat = new Snap.Matrix();
	mat.translate(x*sqSz, y*sqSz);
	mat.scale(sqSz/pieceSz);

	var moveTime = 250;	
	var piece = board.select("#" + id);
	piece.animate({transform: mat}, moveTime);
}

function State() {
	var self = this;
	
	self.activePiece = "";

	self.setActive = function(id) {
		self.activePiece = id;
	}
	
	self.getActive = function() {
		return self.activePiece;
	}

	self.reset = function() {
		self.activePiece = "";
	}
}

var state = new State();

// wrap the select function

function kill(id) {
	var piece = board.select("#" + id);	
	locMap.rem(id);
	// cleanup piecebuilder?
	piece.remove();
}

function handleAttack(x, y) {
	var target = locMap.getId(x, y);
	var killer = state.getActive();
	if (killer == target) {
		return;
	}
	if (target) {
		kill(target);
	}
}

function pieceClick(id) {
	var piece = state.activePiece;
	if (piece) {
		var curPos = locMap.getCoord(id);
		handleAttack(curPos.x, curPos.y);
		move(piece, curPos.x, curPos.y);
		state.reset();
	} else {
		state.setActive(id);				
	}
}

function boardClick() {
	var id = this.attr("id");
	var dest = parseSqId(id);
	var piece = state.getActive();
	if (piece) {
		handleAttack(dest.x, dest.y);
		move(piece, dest.x, dest.y);	
		state.reset();
	}
}


function PieceBuilder() {
	var self = this;
	
	self.idMap = {};

	self.posMap = {};

	self.genId = function(name) {
		if (name in self.idMap) {
			(self.idMap[name])++;
		} else {
			self.idMap[name] = 0;
		}
		var idx = self.idMap[name];			
		return name + idx.toString();
	}

	self.savePos = function(id, x, y) {
		self.posMap[id] = {x:x, y:y};
	}

	self.loadPos = function(id) {
		return self.posMap[id];
	}
	
	self.load = function(name, id) {
		var imgName = "/assets/images/chesspieces/" + name + ".svg";
		Snap.load(imgName, function(svg) {
			// too dense
			var pos = self.loadPos(id);
			var piece = svg.select("#" + name);	
			piece.attr({id: id});
			piece.click(function() {
				pieceClick(id);
			});
			board.append(piece);
			place(id, pos.x, pos.y);
		});
	}

	self.create = function(name, x, y) {
		var id = self.genId(name);
		self.savePos(id, x, y);
		self.load(name, id);
	}
}

function initPieces() {
	var pb = new PieceBuilder();
	pb.create("whitePawn", 0, 6);
	pb.create("whitePawn", 1, 6);
	pb.create("whitePawn", 2, 6);
	pb.create("whitePawn", 3, 6);
	
	pb.create("whitePawn", 4, 6);
	pb.create("whitePawn", 5, 6);
	pb.create("whitePawn", 6, 6);
	pb.create("whitePawn", 7, 6);
	
	pb.create("whiteRook", 	 0, 7);
	pb.create("whiteKnight", 1, 7);
	pb.create("whiteBishop", 2, 7);
	pb.create("whiteQueen",  3, 7);
	
	pb.create("whiteKing", 	 4, 7);
	pb.create("whiteBishop", 5, 7);
	pb.create("whiteKnight", 6, 7);
	pb.create("whiteRook", 	 7, 7);
	
	pb.create("blackPawn", 0, 1);
	pb.create("blackPawn", 1, 1);
	pb.create("blackPawn", 2, 1);
	pb.create("blackPawn", 3, 1);
	
	pb.create("blackPawn", 4, 1);
	pb.create("blackPawn", 5, 1);
	pb.create("blackPawn", 6, 1);
	pb.create("blackPawn", 7, 1);
	
	pb.create("blackRook", 	 0, 0);
	pb.create("blackKnight", 1, 0);
	pb.create("blackBishop", 2, 0);
	pb.create("blackQueen",  3, 0);
	
	pb.create("blackKing", 	 4, 0);
	pb.create("blackBishop", 5, 0);
	pb.create("blackKnight", 6, 0);
	pb.create("blackRook", 	 7, 0);
}


function Board(size) {
	board = Snap(size, size);
	createSquares(size);
}

function main() {
	Board(boardSize);
	initPieces();	
}

main();
