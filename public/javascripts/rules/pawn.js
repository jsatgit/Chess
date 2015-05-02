define(['rules/rules/rules',
        'utils',
        'rules/rules/forwardOnly',
        'rules/rules/oneSquare'], function(Rules, Utils, ForwardOnly, OneSquare) {
    var rules;

    function init(model) {
        rules = new Rules(model);
        rules.add(new ForwardOnly)
             .add(new OneSquare)
             //.add(new TwoSquaresOnFirstMove)
             //.add(new Enpassant)
             //.add(new Collisions)
    }

    // TODO enpassant
    function allowed(piece) {
        var x = Utils.getXCoord(piece);
        var y = Utils.getYCoord(piece);
        var colour = Utils.isWhite(piece);
        return rules.apply(x, y, colour); 
    }
    
    return {
        init : init,
        allowed : allowed
    }
});
