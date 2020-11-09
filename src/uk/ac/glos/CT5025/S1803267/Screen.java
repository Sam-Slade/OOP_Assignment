package uk.ac.glos.CT5025.S1803267;

// Import Board class;
import uk.ac.glos.CT5025.S1803267.varients.Board;

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
      int X = terminal.getTerminalSize().getColumns()/2 - (board.getSize());
      int Y = terminal.getTerminalSize().getRows()/2 - (board.getSize());
      for (int i=0 ; i < board.getSize() ; i++) {
        for (int j=0 ; j < board.getSize() ; j++) {
          try {
            temp = board.getAtLocation(i,j).getPieceSymbol();
          } catch (Exception e) {
            temp = 'X';
          }
          if (temp == 'X') {
              textGraphics.setCharacter(0, 0, '1');
            if (i%2 == 0 && j%2==0) {
              textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
              textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
              textGraphics.setCharacter(X+j*2, Y+i*2, '1');

            } else if (i%2==0) {
              textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
              textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
              textGraphics.setCharacter(X+j*2, Y+i*2, '0');

            } else if (i%2!=0 && j%2==0) {
              textGraphics.setForegroundColor(TextColor.ANSI.BLACK);
              textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
              textGraphics.setCharacter(X+j*2, Y+i*2, '0');

            } else {
              textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
              textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
              textGraphics.setCharacter(X+j*2, Y+i*2, '1');
            }
          } else {
            textGraphics.setCharacter(X+j*2, Y+i*2, temp);
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
