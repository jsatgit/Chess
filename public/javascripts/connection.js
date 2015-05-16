define([], function() {
    function Connection() {
        var sockAddr = "ws://" + window.location.host + "/socket";
        var socket = new WebSocket(sockAddr);
        var opened;
        var callbacks = [];

        socket.onopen = function() {
            socket.send("Hello World from front end.");
            opened = true;
        }
        
        socket.onclose = function() {
            socket.send("Socket closed.");
            opened = false;
        }

        socket.onmessage = function(message) {
            console.log(message.data);
            var json = JSON.parse(message.data);
            callbacks.forEach(function(func) {
                func(json); 
            });
        }

        this.isEstablished = function() {
            return opened; 
        }

        this.send = function(json) {
            var string = JSON.stringify(json);
            console.log("Sending: " + string);
            socket.send(string);
        }

        this.register = function(func) {
            callbacks.push(func); 
        }
    }

    return Connection;
});
