import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import com.chess.app.*;

/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        Board board = new Board();
        
        Player human = new Human(board);
        Player computer = new Computer(board);
        Game myGame = new Game()
            .withWhitePlayer(human)
            .withBlackPlayer(computer)
            .start();

        board.place(new Pawn(human, board), new Location(2,4));
        board.place(new Pawn(human, board), new Location(6,4));
        board.place(new Pawn(human, board), new Location(0,6));
        board.place(new Pawn(computer, board), new Location(7,4));
        board.place(new Rook(computer, board), new Location(5,4));
        board.place(new Rook(human, board), new Location(2,3));
        board.place(new Bishop(human, board), new Location(3,4));
        board.place(new Knight(human, board), new Location(3,3));
        board.place(new Queen(human, board), new Location(6,6));
        board.place(new King(human, board), new Location(1,1));

        Display display = new Display(board);

        display.show();
        display.newLine();

        display.showMoves(human);
        display.showMoves(computer);
    }

}
