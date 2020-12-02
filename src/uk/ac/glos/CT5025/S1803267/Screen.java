package uk.ac.glos.CT5025.S1803267;

import uk.ac.glos.CT5025.S1803267.scoring.*;

// The lanterna library is used to create the game window and
// manage graphics
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

// IOException to handle exceptions caused by lanterna
import java.io.IOException;


public class Screen {
  /* The screen drawing class
   * Author: Sam Slade
   * ID: c11
   *
   * Desc: This class will draw to the screen and looks
   * after drawing the game board and etc.
   */

  private Terminal terminal;
  private TextGraphics textGraphics;
  private int xSize = 5;
  private int ySize = 3;
  private String wPlayer;
  private String bPlayer;

  public Screen (Terminal terminal, TextGraphics textGraphics) {
    this.terminal = terminal;
    this.textGraphics = textGraphics;
  }

  public void setPlayers(String wPlayer, String bPlayer) {
    this.wPlayer = wPlayer;
    this.bPlayer = bPlayer;
  }
  public void drawBoard(Board board) throws InterruptedException {
    try {

      terminal.clearScreen();

      char temp;
      int X = terminal.getTerminalSize().getColumns()/2 - (board.getSize()*xSize)/2;
      int Y = terminal.getTerminalSize().getRows()/2 - (board.getSize()*ySize)/2;
      TerminalPosition terminalPosition;
      TerminalSize squareSize;

      /*
      //Draw player names
      textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
      textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);

      textGraphics.putString(X, Y-2, wPlayer, SGR.BOLD);
      textGraphics.putString(X, Y+1+board.getSize()*ySize , bPlayer, SGR.BOLD);
      */

      // Draw outline of chess board
      textGraphics.setForegroundColor(TextColor.ANSI.BLUE);
      textGraphics.setBackgroundColor(TextColor.ANSI.BLUE);
      terminalPosition = new TerminalPosition(X-1, Y-1);
      squareSize = new TerminalSize(2 + board.getSize() * xSize, 2 +  board.getSize() * ySize);
      textGraphics.drawRectangle(terminalPosition, squareSize, '#');

      // Setup to draw chessboard squares 
      squareSize = new TerminalSize(xSize, ySize);

      for (int i=0 ; i < board.getSize() ; i++) {
        for (int j=0 ; j < board.getSize() ; j++) {
          try {
            temp = board.getAtLocation(j,i).getPieceSymbol();
          } catch (Exception e) {
            temp = 'X';
          }
          if (i%2 == 0 && j%2==0) {
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
            terminalPosition = new TerminalPosition(X+j*xSize, Y+i*ySize);
            textGraphics.fillRectangle(terminalPosition, squareSize, 'w');

            textGraphics.setForegroundColor(TextColor.ANSI.BLACK);

          } else if (i%2==0) {
            textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
            textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
            terminalPosition = new TerminalPosition(X+j*xSize, Y+i*ySize);
            textGraphics.fillRectangle(terminalPosition, squareSize, 'b');

            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
          } else if (i%2!=0 && j%2==0) {
            textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
            textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
            terminalPosition = new TerminalPosition(X+j*xSize, Y+i*ySize);
            textGraphics.fillRectangle(terminalPosition, squareSize, 'w');

            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
          } else {
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
            terminalPosition = new TerminalPosition(X+j*xSize, Y+i*ySize);
            textGraphics.fillRectangle(terminalPosition, squareSize, 'w');

            textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
          }
          if ( temp != 'X' ) {
            if ( board.getAtLocation(j,i).getColour() == 'b' ) {
              textGraphics.enableModifiers(SGR.UNDERLINE);
            } else {
              textGraphics.disableModifiers(SGR.UNDERLINE);
            }
            textGraphics.setCharacter(X+2+j*xSize, Y+1+i*ySize, temp);
          } 
        }
      }
      
      terminal.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void drawPlayerCursor(Board board, Player player) throws InterruptedException {
    try {

      int [] cursorPos = player.getCursorPos(); 

      int X = terminal.getTerminalSize().getColumns()/2 - (board.getSize()*xSize)/2;
      int Y = terminal.getTerminalSize().getRows()/2 - (board.getSize()*ySize)/2;

      textGraphics.setForegroundColor(TextColor.ANSI.RED);
      textGraphics.setBackgroundColor(TextColor.ANSI.RED);

      textGraphics.setCharacter(X+cursorPos[0]*xSize, Y+cursorPos[1]*ySize, 'C');
      textGraphics.setCharacter(X+xSize-1+cursorPos[0]*xSize, Y+cursorPos[1]*ySize, 'C');
      textGraphics.setCharacter(X+cursorPos[0]*xSize, Y+ySize-1+cursorPos[1]*ySize, 'C');
      textGraphics.setCharacter(X+xSize-1+cursorPos[0]*xSize, Y+ySize-1+cursorPos[1]*ySize, 'C');

      terminal.flush();

    } catch ( Exception e ) {
      e.printStackTrace();
    }
  }

  public void drawNameAndScore(Board board, Player player) throws InterruptedException {
    try {

      int X = terminal.getTerminalSize().getColumns()/2 - (board.getSize()*xSize)/2;
      int Y = terminal.getTerminalSize().getRows()/2 - (board.getSize()*ySize)/2;

      //Draw player names
      textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
      textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);

      if (player.getColour() == 'w') {
        textGraphics.putString(X, Y-2, player.getName() + " - " + player.getScore(), SGR.BOLD);
      } else {
        textGraphics.putString(X, Y+1+board.getSize()*ySize , player.getName() + " - " + player.getScore(), SGR.BOLD);
      }
      terminal.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void drawNameAndScore(Board board, Opponent player) throws InterruptedException {
    try {

      int X = terminal.getTerminalSize().getColumns()/2 - (board.getSize()*xSize)/2;
      int Y = terminal.getTerminalSize().getRows()/2 - (board.getSize()*ySize)/2;

      //Draw player names
      textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
      textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);

      if (player.getColour() == 'w') {
        textGraphics.putString(X, Y-2, player.getName(), SGR.BOLD);
      } else {
        textGraphics.putString(X, Y+1+board.getSize()*ySize , player.getName(), SGR.BOLD);
      }
      terminal.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public void drawTitle(String title) throws InterruptedException {
    try {
      textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
      textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
      textGraphics.putString(terminal.getTerminalSize().getColumns()/2 - title.length()/2, 3, title, SGR.BOLD);
      terminal.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void drawMainMenu(int cursorPos, String[] menu) throws InterruptedException {
    try {
      textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
      textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
      
      String temp;
      for (int i=0; i<menu.length; i++) {
        if ( cursorPos == i ) {
          temp = ">" + menu[i] + "<";
        } else {
          temp = menu[i];
        }

        textGraphics.putString(terminal.getTerminalSize().getColumns()/2 - temp.length()/2, 5+i, temp, SGR.BOLD);
      }

      terminal.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void matedMessage(String colour) throws InterruptedException {
    try {

      String message = colour + " has been checkmated!";

      int X = terminal.getTerminalSize().getColumns()/2 - message.length()/2;

      textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
      textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);

      textGraphics.putString(X, 3, message, SGR.BOLD);

      terminal.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void drawScoreboard(Score[] scores) {
    try {
      terminal.clearScreen();
      String title = "Top Scores";
      int X = terminal.getTerminalSize().getColumns()/2 - title.length()/2;
      
      textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
      textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);

      textGraphics.putString(X, 3, title, SGR.BOLD);
      int iterations;

      if (scores.length < 10) {
        iterations = scores.length;
      } else {
        iterations = 10;
      }

      // Have to do this, other wise the compiler
      // yells that iT mAy NoT bE iNiTiAlIsEd.
      String nameString = "";
      String scoreString = "";
      String outcomeString = "";
      String outputString;
      for ( int i = 0; i < iterations; i++) {
        outputString = "";

        nameString = scores[i].getName();
        while (nameString.length() < 10) {
          nameString = nameString + " ";
        } 

        scoreString = "" + scores[i].getScore();
        while (scoreString.length() < 3) {
          scoreString = "0" + scoreString;
        }

        outcomeString = scores[i].getOutcome();
        while (outputString.length() < 4) {
          outputString = outputString + " ";
        }
        
        outputString = nameString + " - " + scoreString + " - " + outputString; 

        X = terminal.getTerminalSize().getColumns()/2 - outputString.length()/2;
        textGraphics.putString(X, 5+i, outputString);
      }

      terminal.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
