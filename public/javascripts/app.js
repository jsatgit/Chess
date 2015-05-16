define(['domReady',
        'jquery',
        'chessView',
        'connection'], function(domReady, $, ChessView, Connection) {
    
    var connection = new Connection();

    var chessView = new ChessView(connection);

    $("#startGame").click(function() {
        if (chessView.isUiLoaded() && connection.isEstablished()) {
            connection.send(chessView.getConfig());
        }
    });

});
