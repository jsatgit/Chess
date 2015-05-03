define([], function() {

    function Loader() {
        var queue = {};

        var target = {
            "whiteQueen"    : 1,
            "whiteKing"     : 1,
            "whiteRook"     : 2,
            "whiteBishop"   : 2,
            "whiteKnight"   : 2,
            "whitePawn"     : 8,
            "blackQueen"    : 1,
            "blackKing"     : 1,
            "blackRook"     : 2,
            "blackBishop"   : 2,
            "blackKnight"   : 2,
            "blackPawn"     : 8
        };

        var subscribers = [];
        
        function subscribe(subscriber) {
            subscribers.push(subscriber);
        }

        // TODO make this more efficient
        function isDone() {
            for (var piece in target) {
                if (target[piece] > 0) {
                    return false;
                }
            }
            return true;
        }

        function done() {
            subscribers.forEach(function(sub) {
                sub.onAllPiecesLoaded();
            });
        }
        
        this.enqueue = function(name, x, y) {
            if (name in queue) {
                queue[name].push({x:x, y:y});
            } else {
                queue[name] = [{x:x, y:y}];
            }
        }

        this.dequeue = function(name) {
            if (name in queue) {
                return queue[name].pop();
            }
        }

        this.notify = function(pieceName) {
            target[pieceName] -= 1;
            if (isDone()) {
                done();
            }     
        }

        this.withSubscription = function(subscriber) {
            subscribe(subscriber);
            return this;
        }
    
    }

    return Loader; 
});
