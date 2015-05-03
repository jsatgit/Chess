define(['config'], function(Config) {
    function Grid() {
        var grid = []; 
        
        setupGrid(); 
        
        function setupGrid() {
            var n = Config.board.squareCount;
            for (var i = 0; i < n; ++i) {
                grid[i] = [];
            }
        }
        
        this.set = function(piece, x, y) {
            grid[x][y] = piece; 
        }
        
        this.get = function(x, y) {
            return grid[x][y];
        }
        
        this.reset = function(x, y) {
            grid[x][y] = undefined;
        }
    }

    return Grid;
});
