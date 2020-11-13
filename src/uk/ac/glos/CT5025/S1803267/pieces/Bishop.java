package uk.ac.glos.CT5025.S1803267.pieces;

import uk.ac.glos.CT5025.S1803267.Board;
import java.lang.Math;

public class Bishop extends Piece {
  /* Bishop piece class
   * Author: Sam Slade
   * ID: c06
   *
   * Desc: The Bishop class is a child of the
   * Piece class
   */
  public Bishop (char colour) {
    this.colour = colour;
    point_value = 1;
    movesMade = 0;
    symbol = 'B';
  }

  public boolean checkValidMove(Board board, int x, int y){
    if ( board.getAtLocation(x, y) != null ) {
      if ( board.getAtLocation(x, y).getColour() == colour ){ // Cant move onto same colour
        return false;
      } 
    }

    if ( Math.abs(x-this.x) != Math.abs(y-this.y) ) { // Move must be diagonal
      return false;
    } else {

      // Is move in the positive or negative X direction
      int xCounter;
      if ( x - this.x > 0 ) {
        xCounter = 1;
      } else {
        xCounter = -1;
      }

      // Is move in the positive or negative Y direction 
      int yCounter;
      if ( y - this.y > 0) {
        yCounter = 1;
      } else {
        yCounter = -1;
      }

      // Loop through the diagonal, make sure the bishop has line of sight to the move
      for (int i=this.y; Math.abs(i) < Math.abs(y-this.y); i = i + yCounter) {
        for (int j=this.x; Math.abs(j) < Math.abs(x-this.x); j = j + xCounter) {
          if ( board.getAtLocation(j, i) != null) {
            return false;
          }
        }
      }
      // If this point is reached, move must be true
      return true;
    }
  }
}
