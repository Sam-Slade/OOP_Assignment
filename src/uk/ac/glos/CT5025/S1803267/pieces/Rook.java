package uk.ac.glos.CT5025.S1803267.pieces;

import uk.ac.glos.CT5025.S1803267.varients.Board;

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
  }

  public boolean checkValidMove(Board board, int x, int y){
    return false;
  }
}
