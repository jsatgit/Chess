define(['utils'], function(Utils) {
    function Setup(sides) {
        var sides = sides;

        function addPiecesToJson(pieces, jsonArray) {
            pieces.forEach(function(piece) {
                jsonArray.push({
                    type: Utils.type(piece),
                    colour: Utils.getColourEnum(piece),
                    location: {
                        x: Utils.getXCoord(piece),
                        y: Utils.getYCoord(piece)
                    }
                }); 
            });
        }

        this.json = function() {
            var config = {
                setup : {
                    pieces: [],
                    players: {
                        white: "human",
                        black: "human"
                    }
                }
            }; 

            addPiecesToJson(sides.getWhitePieces(), config.setup.pieces);
            addPiecesToJson(sides.getBlackPieces(), config.setup.pieces);

            return config;
        }
    }

    return Setup;
});
