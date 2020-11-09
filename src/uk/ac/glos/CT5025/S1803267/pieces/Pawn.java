package uk.ac.glos.CT5025.S1803267.pieces;

import uk.ac.glos.CT5025.S1803267.varients.Board;

public class Pawn extends Piece {
  /* Pawn piece class
   * Author: Sam Slade
   * ID: c03
   *
   * Desc: The Pawn class is a child of the
   * Piece class
   */

  private int movesMade;

  public Pawn (char colour) {
    this.colour = colour;
    point_value = 1;
    symbol = 'P';
    movesMade = 0;
  }

  public boolean checkValidMove(Board board, int x, int y){

    // Trying to move onto same colour
    if (board.getAtLocation(x, y).getColour() == colour) {
      return false;
    } else if (colour == 'w') { // Is the pawn white?
      if (this.y > y) { // Cant move backwards
        return false;
      } else if (board.getAtLocation(x,y).getColour() != colour) { // If making a taking move
        if ( (x == this.x+1 || x == this.x-1) && (y == this.y+1) ) {
          return true;
        } else {
          return false;
        }
      } else { // Making a normal move
        if (movesMade == 0) {
          if( (x == this.x) && (y == this.y+1 || y == this.y+2) ) { // First move
            return true;
          } else {
            return false;
          }
        } else {
          if( (x == this.x) && (y == this.y+1) ) { // Subsequent moves
            return true;
          } else {
            return false;
          }
        }
      }
    } else { // Pawn is black
      if (this.y < y) { // Can't move backwards
        return false;
      } else if (board.getAtLocation(x,y).getColour() != colour) {
        if ( (x == this.x+1 || x == this.x-1) && (y == this.y-1) ) {
          return true;
        } else {
          return false;
        }
      } else { // Making normal move
        if (movesMade == 0) {
          if ( (x == this.x) && (y == this.y-1 || y == this.y-2) ) {
            return true;
          } else {
            return false;
          }
        } else {
          if ( (x == this.x) && (y == this.y-1) ) { // Subsequent moves
            return true;
          } else {
            return false;
          }
        }
      }
    }
  }
}
