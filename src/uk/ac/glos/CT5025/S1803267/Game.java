package uk.ac.glos.CT5025.S1803267;

// Import Board class and pieces 
import uk.ac.glos.CT5025.S1803267.varients.Board;
import uk.ac.glos.CT5025.S1803267.pieces.*;

// IOException to handle exceptions caused by lanterna
import java.io.IOException;

// The lanterna library is used to create the game window and
// manage graphics
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Game {
  /* Game class
   * Author: Sam Slade
   * ID: c01
   *
   * Desc: The Game class is the entry point and game
   * state manager of the whole program.
   */

  final String TITLE = "Chess?";
  String[] menu = {"option1<", "option2", "bacon", "exit"};
  int cursorPos = 0;

  public void moveCursorUp() {
    if (cursorPos > 0) {

      menu[cursorPos] = menu[cursorPos].substring(0, (menu[cursorPos].length()-1));
      cursorPos -= 1;
      menu[cursorPos] = menu[cursorPos] + "<";
    }
  }

  public void moveCursorDown() {
    if (cursorPos < (menu.length-1)) {
      menu[cursorPos] = menu[cursorPos].substring(0, (menu[cursorPos].length()-1));
      cursorPos += 1;
      menu[cursorPos] = menu[cursorPos] + "<";
    }
  }

  public static void main(String[] args) throws InterruptedException{

    Game game = new Game();
    
    Board board = new Board(8);



    /*
    DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
    Terminal terminal = null;
    try {

      // Create terminal object
      terminal = defaultTerminalFactory.createTerminal();

      // Set ownership of the terminal to not allow
      // other programs to write to the screen
      terminal.enterPrivateMode();
      terminal.clearScreen();
      terminal.setCursorVisible(false);

      // Text graphics object used to write to the screen
      final TextGraphics textGraphics = terminal.newTextGraphics();
      textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
      textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
      KeyStroke keyStroke = terminal.readInput();

      while(keyStroke.getKeyType() != KeyType.Escape) {
        terminal.clearScreen();
        // Draw game title
        textGraphics.putString(terminal.getTerminalSize().getColumns()/2-(game.TITLE.length()/2), 5, game.TITLE, SGR.BOLD);

        if (keyStroke.getKeyType() == KeyType.ArrowUp) {
          game.moveCursorUp();
        } else if (keyStroke.getKeyType() == KeyType.ArrowDown){
          game.moveCursorDown();
        }

        for (int i = 0; i < game.menu.length; i++) {
          textGraphics.putString(terminal.getTerminalSize().getColumns()/2-(game.menu[i].length()/2), 6+i, game.menu[i]);
        }
        terminal.flush();
        keyStroke = terminal.readInput();
      }



    }
    catch(IOException e) {
      e.printStackTrace();
    }
    finally {
      if(terminal != null) {
        try {
          terminal.close();
        }
        catch(IOException e) {
          e.printStackTrace();
        }
      }
    }
    */
  }
}
