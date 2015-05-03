define(['domReady',
        'jquery',
        'chessView',
        ], function(domReady, $, ChessView) {

    var chessView = new ChessView();

    $("#startGame").click(function() {
        if (chessView.isUiLoaded()) {
            console.log("Starting game");
        }
    });
});
