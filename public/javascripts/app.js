define(['domReady',
        'jquery',
        'chessView',
        'connection',
        'setup'], function(domReady, $, ChessView, Connection, Setup) {
    
    var connection = new Connection();

    var chessView = new ChessView(connection);

    function onReady(module) {
        if (chessView.isUiLoaded() && connection.isEstablished()) {
            var setup = new Setup(chessView.getSides());
            connection.send(setup.json());
        }
    }

    connection.registerReady(onReady);
    chessView.registerReady(onReady);


});
