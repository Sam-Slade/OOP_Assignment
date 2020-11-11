package uk.ac.glos.CT5025.S1803267.pieces;

import uk.ac.glos.CT5025.S1803267.Board;
import java.lang.Math;

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
  }

  public boolean checkValidMove(Board board, int x, int y){
    int xCounter;
    int yCounter;
    if ( board.getAtLocation(x, y).getColour() == colour ) {
      return false;
     
    // Check diagonals
    } else if ( Math.abs(x-this.x) == Math.abs(y-this.y) ) {

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

      for (int i=this.y; Math.abs(i) < Math.abs(y-this.y); i = i + yCounter) {
        for (int j=this.x; Math.abs(j) < Math.abs(x-this.x); j = j + xCounter) {
          if ( board.getAtLocation(j, i) != null ) {
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
        
        for (int i = this.y+yCounter; Math.abs(i)<Math.abs(y); i = i + yCounter) {
          if ( board.getAtLocation(this.x, i) != null ) {
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

        for (int i = this.x+xCounter; Math.abs(i)<Math.abs(x); i = i + xCounter) {
          if ( board.getAtLocation(i, this.y) != null ) {
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
