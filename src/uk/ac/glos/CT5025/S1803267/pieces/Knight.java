package uk.ac.glos.CT5025.S1803267.pieces;

import uk.ac.glos.CT5025.S1803267.varients.Board;

public class Knight extends Piece {
  /* Knight piece class
   * Author: Sam Slade
   * ID: c05
   *
   * Desc: The Knight class is a child of the
   * piece class
   */

  public Knight (int colour) {
    this.colour = colour;
    point_value = 3;
    movesMade = 0;
  }

  public boolean checkValidMove(Board board, int x, int y){
    return false;
  }
}
