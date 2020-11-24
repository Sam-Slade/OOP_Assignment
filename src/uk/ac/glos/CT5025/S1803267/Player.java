package uk.ac.glos.CT5025.S1803267;

import uk.ac.glos.CT5025.S1803267.pieces.*;

import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.input.KeyStroke;

public class Player {
  private int[] cursorPos;
  private char colour;
  private int score;
  private final int BOARD_SIZE;
  private Piece selectPiece = null;
  private String name;

  public Player (int x, int y, char colour, int boardSize, String name) {
    this. name = name;
    this.score = 0;
    this.cursorPos = new int[] {x,  y};
    this.colour = colour;
    this.BOARD_SIZE = boardSize;
  }

  public int[] getCursorPos () {
    // Return the cursors current position

    return cursorPos;
  }

  public int[] updateCursorPos(KeyStroke key) {
    // Move the players cursor on the board

    int X, Y;

    if (key.getKeyType() == KeyType.ArrowUp) {
      Y = -1;
      X = 0;
    } else if (key.getKeyType() == KeyType.ArrowDown) {
      Y = 1;
      X = 0;
    } else if (key.getKeyType() == KeyType.ArrowLeft) {
      Y = 0;
      X = -1;
    } else if (key.getKeyType() == KeyType.ArrowRight) {
      Y = 0;
      X = 1;
    } else {
      Y = 0;
      X = 0;
    }

    if ( this.cursorPos[0] + X >= 0 && this.cursorPos[0] + X <= BOARD_SIZE-1 && this.cursorPos[1] + Y >= 0 && this.cursorPos[1] + Y <= BOARD_SIZE-1 ) {
      this.cursorPos[0] += X;
      this.cursorPos[1] += Y;
    }

    return this.cursorPos;
  }

  public boolean select (Board board) {
    // This function will only return true when a piece has been selected and moved
    // this function will need to be run twice to achieve the return value of true

    if ( selectPiece == null ) {
      // If piece isn't selected

      if ( board.getAtLocation(cursorPos[0], cursorPos[1]) != null ) {

        // Does the selected location have a piece in it

        Piece tempPiece = board.getAtLocation(cursorPos[0], cursorPos[1]);

        if ( tempPiece.getColour() == colour ) {
          // Is the selected piece the same colour as the player

          // Set selected piece to be the piece
          selectPiece = tempPiece;
        }
      }

      // Return false as there is no move to be made
      return false;

    } else { // if a piece is selected

      if ( board.getAtLocation(cursorPos[0], cursorPos[1]) != null ) {

        Piece tempPiece = board.getAtLocation(cursorPos[0], cursorPos[1]);
        if ( selectPiece.getPosition()[0] == cursorPos[0] && selectPiece.getPosition()[1] == cursorPos[1] ) {
          selectPiece = null;
          return false;
        }
      }
      
      int returnVal = board.movePiece(selectPiece.getPosition()[0], selectPiece.getPosition()[1], cursorPos[0], cursorPos[1]);
      if ( returnVal != -1 ) {
        score = score + returnVal;
        selectPiece = null;
        return true;
      }
      return false;
    }
  }

  public char getColour() {
    return colour;
  }

  public int getScore() {
    return score;
  }

  public String getName() {
    return name;
  }
}
