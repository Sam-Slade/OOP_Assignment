package uk.ac.glos.CT5025.S1803267.pieces;

import uk.ac.glos.CT5025.S1803267.Board;

public class Knight extends Piece {
  /* Knight piece class
   * Author: Sam Slade
   * ID: c05
   *
   * Desc: The Knight class is a child of the
   * piece class
   */

  public Knight (char colour) {
    this.colour = colour;
    point_value = 3;
    movesMade = 0;
    symbol = 'K';
  }

  public Knight (Piece clone) {
    colour = clone.getColour();
    point_value = 3;
    movesMade = clone.getNumberOfMoves();
    symbol = 'K';
    setPosition(clone.getPosition());
  }

  public boolean checkValidMove(Board board, int x, int y){
    if (board.getAtLocation(x, y) != null) {
      if (board.getAtLocation(x, y).getColour() == colour) { // Can't move on to a piece of it's own colour
        return false;
      }
    }
    if ( ( (x == this.x+2 || x == this.x-2) && (y == this.y+1 || y == this.y-1) ) || ( (x == this.x+1 || x == this.x-1) && (y == this.y+2 || y == this.y-2) ) ) { // A knight can only ever make 8 moves and this logic allows for only those 8
      return true;
    } else {
      return false;
    }
  }
}
