define([], function() {
    function Connection() {
        var sockAddr = "ws://" + window.location.host + "/socket";
        var socket = new WebSocket(sockAddr);
        var opened;
        var callbacks = {
            select: [],
            move: [], 
            error: []
        };
        var ready;

        this.registerReady = function(callback) {
            ready = callback; 
        }

        socket.onopen = function() {
            socket.send("[CONNECTION REQUEST]");
            opened = true;
            ready(); 
        }
        
        socket.onclose = function() {
            socket.send("[CONNECTION RESPONSE]");
            opened = false;
        }

        function callFunction(callbacks, json) {
            callbacks.forEach(function(func) {
                func(json); 
            });
        }
            
        socket.onmessage = function(message) {
            console.log("[RESPONSE]: " + message.data);
            var json = JSON.parse(message.data);
            if (json.select) {
                callFunction(callbacks["select"], json.select); 
            } else if (json.move) {
                callFunction(callbacks["move"], json.move); 
            } else if (json.error){
                callFunction(callbacks["error"], json.error) 
            }
        }

        this.isEstablished = function() {
            return opened; 
        }

        this.send = function(json) {
            var string = JSON.stringify(json);
            console.log("[REQUEST]: " + string);
            socket.send(string);
        }

        this.register = function(name, func) {
            callbacks[name].push(func);
        }
    }

    return Connection;
});
