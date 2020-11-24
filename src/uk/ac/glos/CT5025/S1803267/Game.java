package uk.ac.glos.CT5025.S1803267;

// Import Board class and pieces 
import uk.ac.glos.CT5025.S1803267.pieces.*;

// Import chess variants
import uk.ac.glos.CT5025.S1803267.variants.ChessVariant;
import uk.ac.glos.CT5025.S1803267.variants.standard.ChessVariant_standard;

// Import random number generator
import java.util.Random;

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
  String[] menu = {"Single player", "Two players", "Load game", "View Scoreboard", "Quit"};
  int cursorPos = 0;
  private boolean running = false;

  public static void main(String[] args) throws InterruptedException{

    // Start the game object
    Game game = new Game();
    game.setRunning();

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

      Screen screen = new Screen(terminal, textGraphics);


      KeyStroke keyStroke;
      while (game.getRunning()) {

        terminal.clearScreen();

        // MENU
        screen.drawTitle(game.TITLE);
        screen.drawMainMenu(game.cursorPos, game.menu);


        keyStroke = terminal.readInput();

        // Exit game;
        if ( keyStroke.getKeyType() == KeyType.Escape ) {
          game.setNotRunning();
        } else if ( keyStroke.getKeyType() == KeyType.ArrowUp && game.cursorPos > 0 ) {
          game.cursorPos -= 1;
        } else if ( keyStroke.getKeyType() == KeyType.ArrowDown && game.cursorPos < game.menu.length-1 ) {
          game.cursorPos += 1;
        } else if ( keyStroke.getKeyType() == KeyType.Enter) {
          // Item in the menu has been selected

          if (game.cursorPos == game.menu.length-1) { // Quit game
            game.setNotRunning();

          } else if ( game.cursorPos == 0 ) { // Single player

            ChessVariant_standard standard = new ChessVariant_standard();
            Board board = standard.setUp();
            Move move;

            Player player;
            Opponent cpu;

            Random r = new Random();

            if (r.nextInt(10)%2 == 0) {
              player = new Player( 4, 0, 'w', 8, "Player");
              cpu = new Opponent('b', 3, "CPU");
              screen.setPlayers("Player", "CPU");

            } else {
              player = new Player(4, 7, 'b', 8, "Player");
              cpu = new Opponent('w', 3, "CPU");
              screen.setPlayers("CPU", "Player");
              move = cpu.makeMove(board);
              board.movePiece(move.getPiecePosition()[0], move.getPiecePosition()[1], move.getMovePosition()[0], move.getMovePosition()[1]);
            }

            while ( keyStroke.getKeyType() != KeyType.Escape ) {

              screen.drawBoard(board);
              screen.drawNameAndScore(board, player);
              screen.drawNameAndScore(board, cpu);
              screen.drawPlayerCursor(board, player);

              if ( standard.checkmated(board, 'w') ) {
                System.out.println("White checkmated");
                screen.matedMessage("White");
                terminal.readInput();
                break;
              } else if ( standard.checkmated(board, 'b') ) {
                System.out.println("Black checkmated");
                screen.matedMessage("Black");
                terminal.readInput();
                break;
              }

              keyStroke = terminal.readInput();

              if ( keyStroke.getKeyType() == KeyType.Enter ) {
                if ( player.select(board) ) {
                  move = cpu.makeMove(board);
                  board.movePiece(move.getPiecePosition()[0], move.getPiecePosition()[1], move.getMovePosition()[0], move.getMovePosition()[1]);
                }
              } else {
                player.updateCursorPos(keyStroke);
              }
            }
          } else if ( game.cursorPos == 1 ) { // 2 player
            ChessVariant_standard standard = new ChessVariant_standard();
            Board board = standard.setUp();
            Move move;

            Player player1;
            Player player2;
            int whosMove = 1;

            Random r = new Random();

            if (r.nextInt(10)%2 == 0) {
              player1 = new Player(4, 0, 'w', 8, "Player 1");
              player2 = new Player(4, 7, 'b', 8, "Player 2");
              screen.setPlayers("Player 1", "Player 2");

            } else {
              player1 = new Player(4, 7, 'b', 8, "Player 1");
              player2 = new Player(4, 0, 'w', 8, "Player 2");
              screen.setPlayers("Player 2", "Player 1");
            }

            while ( keyStroke.getKeyType() != KeyType.Escape ) {
              screen.drawBoard(board);
              screen.drawNameAndScore(board, player1);
              screen.drawNameAndScore(board, player2);
              if ( whosMove == 1 ) {
                screen.drawPlayerCursor(board, player1);
              } else {
                screen.drawPlayerCursor(board, player2);
              }
              
              if ( standard.checkmated(board, 'w') ) {
                screen.matedMessage("White");
                terminal.readInput();
              } else if ( standard.checkmated(board, 'b') ) {
                screen.matedMessage("Black");
                terminal.readInput();
              }

              keyStroke = terminal.readInput();
              
              if ( keyStroke.getKeyType() == KeyType.Enter ) {
                if ( whosMove == 1 ) {
                  if ( player1.select(board) ){
                    whosMove = 2;
                  }
                } else {
                  if ( player2.select(board) ) {
                    whosMove = 1;
                  }
                }
              } else {
                if ( whosMove == 1 ) {
                  player1.updateCursorPos(keyStroke);
                } else {
                  player2.updateCursorPos(keyStroke);
                }
              }



            }

          } else if ( game.cursorPos == 2 ) { // Load game
          } else if ( game.cursorPos == 3 ) { // Score board
          }

        }
        
        /*
        move = playerW.makeMove(board);
        board.movePiece(move.getPiecePosition()[0], move.getPiecePosition()[1], move.getMovePosition()[0], move.getMovePosition()[1]);
        screen.drawBoard(board);
        keyStroke = terminal.readInput();

        move = playerB.makeMove(board);
        board.movePiece(move.getPiecePosition()[0], move.getPiecePosition()[1], move.getMovePosition()[0], move.getMovePosition()[1]);
        screen.drawBoard(board);
        keyStroke = terminal.readInput();
        */
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
  }

  public boolean getRunning() {
    return running;
  }

  public void setRunning() {
    running = true;
  }

  public void setNotRunning() {
    running = false;
  }
}
