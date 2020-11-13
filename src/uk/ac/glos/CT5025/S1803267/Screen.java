package uk.ac.glos.CT5025.S1803267;


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

  public Screen (Terminal terminal, TextGraphics textGraphics) {
    this.terminal = terminal;
    this.textGraphics = textGraphics;
  }

  public void drawBoard(Board board) throws InterruptedException {
    try {
      char temp;
      int X = terminal.getTerminalSize().getColumns()/2 - (board.getSize()*xSize)/2;
      int Y = terminal.getTerminalSize().getRows()/2 - (board.getSize()*ySize)/2;
      TerminalPosition terminalPosition;
      TerminalSize squareSize = new TerminalSize(xSize,ySize);
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
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
