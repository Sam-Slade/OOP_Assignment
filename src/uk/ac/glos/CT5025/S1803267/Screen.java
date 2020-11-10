package uk.ac.glos.CT5025.S1803267;

// Import Board class;
import uk.ac.glos.CT5025.S1803267.varients.Board;

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
   * ID: c12
   *
   * Desc: This class will draw to the screen and looks
   * after drawing the game board and etc.
   */

  private Terminal terminal;
  private TextGraphics textGraphics;

  public Screen (Terminal terminal, TextGraphics textGraphics) {
    this.terminal = terminal;
    this.textGraphics = textGraphics;
  }

  public void drawBoard(Board board) throws InterruptedException {
    try {
      char temp;
      int X = terminal.getTerminalSize().getColumns()/2 - (board.getSize()*3)/2;
      int Y = terminal.getTerminalSize().getRows()/2 - (board.getSize());
      TerminalPosition terminalPosition;
      TerminalSize squareSize = new TerminalSize(3,2);
      for (int i=0 ; i < board.getSize() ; i++) {
        for (int j=0 ; j < board.getSize() ; j++) {
          try {
            temp = board.getAtLocation(i,j).getPieceSymbol();
          } catch (Exception e) {
            temp = 'X';
          }
          if (i%2 == 0 && j%2==0) {
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
            terminalPosition = new TerminalPosition(X+j*3, Y+i*2);
            textGraphics.drawRectangle(terminalPosition, squareSize, 'w');

          } else if (i%2==0) {
            textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
            textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
            terminalPosition = new TerminalPosition(X+j*3, Y+i*2);
            textGraphics.drawRectangle(terminalPosition, squareSize, 'b');

          } else if (i%2!=0 && j%2==0) {
            textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
            textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
            terminalPosition = new TerminalPosition(X+j*3, Y+i*2);
            textGraphics.drawRectangle(terminalPosition, squareSize, 'w');

          } else {
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
            terminalPosition = new TerminalPosition(X+j*3, Y+i*2);
            textGraphics.drawRectangle(terminalPosition, squareSize, 'w');
          }
          if ( temp != 'X' ) {
            textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
            textGraphics.enableModifiers(SGR.UNDERLINE);
            textGraphics.setCharacter(X+1+j*3, Y+1+i*2, '^');
          } 
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
