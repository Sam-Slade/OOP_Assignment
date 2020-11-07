package uk.ac.glos.CT5025.S1803267.pieces;

import uk.ac.glos.CT5025.S1803267.varients.Board;

public class Bishop extends Piece {
  /* Bishop piece class
   * Author: Sam Slade
   * ID: c06
   *
   * Desc: The Bishop class is a child of the
   * Piece class
   */
  public Bishop (int colour) {
    this.colour = colour;
    point_value = 1;
    movesMade = 0;
  }

  public boolean checkValidMove(Board board, int x, int y){
    return false;
  }
}
