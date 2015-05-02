define([], function()) {

    function upper(location) {
        return location.y + direction;
    }

    function lower(location) {
        return location.y - direction;
    }

    function right(location) {
        return location.x + 1;
    }

    function left(location) {
        return location.x - 1;
    }

    var Directions = {
        this.upperRightDiagonal = function(location) {
            return {
                x : right(location.x);
                y : upper(location.y);
            }; 
        }

        this.upperLeftDiagonal = function(location) {
            return {
                x : left(location.x);
                y : upper(location.y);
            }; 
        }

        this.lowerRightDiagonal = function(location) {
            return {
                x : right(location.x);
                y : lower(location.y);
            }; 
        }

        this.lowerLeftDiagonal = function(location) {
            return {
                x : left(location.x);
                y : lower(location.y);
            }; 
        }

        this.rightRank = function(location) {
            return {
                x : right(location.x);
                y : location.y;
            }; 
        }

        this.leftRank = function(location) {
            return {
                x : left(location.x);
                y : location.y;
            }; 
        }

        this.upperFile = function(location) {
            return {
                x : location.x;
                y : upper(location.y);
            }; 
        }

        this.lowerFile = function(location) {
            return {
                x : location.x;
                y : lower(location.y);
            };
        }

    
    }

    return Directions;
}
