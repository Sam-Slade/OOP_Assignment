package uk.ac.glos.CT5025.S1803267.pieces;

import uk.ac.glos.CT5025.S1803267.Board;

public class Rook extends Piece {
  /* Rook piece class
   * Author: Sam Slade
   * ID: c04
   *
   * Desc: The Rook class is a child of the
   * Piece class
   */
  public Rook (char colour) {
    this.colour = colour;
    point_value = 5;
    movesMade = 0;
    symbol = 'R';
  }

  public Rook (Piece clone) {
    colour = clone.getColour();
    point_value = 0;
    movesMade = clone.getNumberOfMoves();
    symbol = 'R';
    setPosition(clone.getPosition());
  }

  public boolean checkValidMove(Board board, int x, int y) {
    if ( board.getAtLocation(x, y) != null ) {
      if ( board.getAtLocation(x, y).getColour() == colour) { // Can't move onto the same colour 
        return false;
      }
    } 

    if ( (x > this.x ^ x < this.x) ^ (y > this.y ^ y < this.y) ) { // using XOR to check that the rook can only move in one direction

      if ( x == this.x ) { // Check to see if rook is moving on the Y axis
        if ( this.y - y < 0 ) { // Is rook moving in the positive Y direction
          for (int i = this.y+1; i<y; i++) { // Loop through each space between rook and target location, if there's another piece, it's invalid
            if ( board.getAtLocation(x, i) != null ) {
              return false;
            }
          }
          // When the for loop ends, there will be no pieces between the rook and the move, making it valid
          return true; 

        } else { // Rook moving in negative Y direction
          for (int i = this.y-1; i>y; i--) { // Loop through each space between rook and target location, if there's another piece, it's invalid
            if ( board.getAtLocation(x, i) != null) { 
              return false;
            }
          }
          // When the for loop ends, there will be no pieces between the rook and the move, making it valid
          return true;
        }
      } else { // Rook is moving in the X axis
        if ( this.x - x < 0 ) { // Is rook moving in the positive X direction
          for (int i = this.x+1; i<x; i++) { // Loop through each space between rook and target location, if there's another piece, it's invalid
            if ( board.getAtLocation(i, y) != null) {
              return false;
            }
          }
          // When the for loop ends, there will be no pieces between the rook and the move, making it valid
          return true;
        } else {
          for (int i = this.x-1; i>x; i--) { // Loop through each space between rook and target location, if there's another piece, it's invalid
            if ( board.getAtLocation(i, y) != null) {
              return false;
            }
          }
          // When the for loop ends, there will be no pieces between the rook and the move, making it valid
          return true;
        }
      }
    } else {
    return false;
    }
  }
}
