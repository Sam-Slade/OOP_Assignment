package uk.ac.glos.CT5025.S1803267.pieces;

import uk.ac.glos.CT5025.S1803267.varients.Board;

public class King extends Piece {
  /* King piece class
   * Author: Sam Slade
   * ID: c08
   *
   * Desc: The King class is a child of the
   * piece class
   */

  public King (char colour) {
    this.colour = colour;
    point_value = 0;
    movesMade = 0;
  }

  public boolean checkValidMove(Board board, int x, int y){
    if (board.getAtLocation(x, y).getColour() == colour) {
      return false;
    } else if ( x >= this.x-1 && x <= this.x+1 && y >= this.y-1 && y <= this.y+1 ) {
      return !isMate(board, x, y);
    } else {
      return false;
    }
  }

  public boolean isMate(Board board) {
    return false;
  }

  public boolean isMate(Board board, int x, int y) {
    return false;
  }

  public boolean isCheckMate(Board board) {
    return false;
  }
}
