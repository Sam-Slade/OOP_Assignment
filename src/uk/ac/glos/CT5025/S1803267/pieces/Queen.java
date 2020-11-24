package uk.ac.glos.CT5025.S1803267.pieces;

import uk.ac.glos.CT5025.S1803267.Board; import java.lang.Math;

public class Queen extends Piece {
  /* Queen piece class
   * Author: Sam Slade
   * ID: c07
   *
   * Desc: The Queen class is a child of the
   * Piece class
   */
  public Queen (char colour) {
    this.colour = colour;
    point_value = 9;
    movesMade = 0;
    symbol = 'Q';
  }

  public Queen (Piece clone) {
    colour = clone.getColour();
    point_value = 9;
    movesMade = clone.getNumberOfMoves();
    symbol = 'Q';
    setPosition(clone.getPosition());

  }

  public boolean checkValidMove(Board board, int x, int y){
    int xCounter;
    int yCounter;

    if ( board.getAtLocation(x, y) != null ) {
      if ( board.getAtLocation(x, y).getColour() == colour ) {
        return false;
      } 
    }
    
    // Check diagonals
    if ( Math.abs(x-this.x) == Math.abs(y-this.y) ) {

      if ( x - this.x > 0 ) {
        xCounter = 1;
      } else {
        xCounter = -1;
      }

      if ( y - this.y > 0) {
        yCounter = 1;
      } else {
        yCounter = -1;
      }

      for (int i=yCounter; Math.abs(i) < Math.abs(y-this.y); i = i + yCounter) {
        for (int j=xCounter; Math.abs(j) < Math.abs(x-this.x); j = j + xCounter) {
          if ( board.getAtLocation(this.x+j, this.y+i) != null ) {
            return false;
          }
        }
      }
      return true;

    // Check cardinal moves
    } else if ( ((x < this.x)^(x > this.x))^((y < this.y)^(y > this.y)) ) {
      if ( x == this.x ) {

        if ( y - this.y > 0 ) {
          yCounter = 1;
        } else {
          yCounter = -1;
        }
        
        for (int i = yCounter; Math.abs(i)<Math.abs(y-this.y); i = i + yCounter) {
          if ( board.getAtLocation(this.x, this.y + i) != null ) {
            return false;
          }
        }
        return true;

      } else {

        if ( x - this.x > 0 ) {
          xCounter = 1;
        } else {
          xCounter = -1;
        }

        for (int i = xCounter; Math.abs(i)<Math.abs(x-this.x); i = i + xCounter) {
          if ( board.getAtLocation(this.x + i, this.y) != null ) {
            return false;
          }
        }
        return true;
      }
    } else {
      return false;
    }
  }
}
