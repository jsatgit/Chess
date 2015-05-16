package controllers;

import play.*;
import play.mvc.*;
import play.libs.F.Callback;
import play.libs.F.Callback0;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import static play.mvc.WebSocket.Out;
import static play.mvc.WebSocket.In;

import views.html.*;
import com.chess.app.MessageHandler; 
import com.chess.app.ChessSession;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render());
    }

    public static WebSocket<String> socket() {
        return new WebSocket<String>() {
            public void onReady(final In<String> in, final Out<String> out) {

                final ChessSession chessSession = new ChessSession(out);

                in.onMessage(new Callback<String>() {
                    public void invoke(String message) {
                        JsonNode response = chessSession.handle(message);
                        out.write(response.toString());
                    }
                });

                in.onClose(new Callback0() {
                    public void invoke() {
                        System.out.println("Disconnected");
                    }
                });

                System.out.println("Estblished connection with front end");

            }
        };
    }
}
