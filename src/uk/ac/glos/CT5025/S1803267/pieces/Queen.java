package uk.ac.glos.CT5025.S1803267.pieces;

import uk.ac.glos.CT5025.S1803267.varients.Board;

public class Queen extends Piece {
  /* Queen piece class
   * Author: Sam Slade
   * ID: c07
   *
   * Desc: The Queen class is a child of the
   * Piece class
   */
  public Queen (int colour) {
    this.colour = colour;
    point_value = 9;
    movesMade = 0;
  }

  public boolean checkValidMove(Board board, int x, int y){
    return false;
  }
}
