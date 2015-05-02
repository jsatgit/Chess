define(['utils'], function(Utils) {
    var model;
    var rules = [];

    // TODO change the name of the folder
    function Rules(model) {
        model = model; 
    }

    Rules.prototype.add = function(rule) {
        rules.push(rule); 
        return this;
    }

    Rules.prototype.apply = function(x, y, colour) {
        // TODO put squares somewhere else
        var squares = Utils.getAllSquares();
        rules.forEach(function(rule) {
            squares = rule.apply(x, y, colour, squares);
        });
        return squares;
    }

    return Rules;
});
