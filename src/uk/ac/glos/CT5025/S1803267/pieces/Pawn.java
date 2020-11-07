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

  public Pawn (int colour) {
    this.colour = colour;
    point_value = 1;
    symbol = 'P';
    movesMade = 0;
  }

  public boolean checkValidMove(Board board, int x, int y){
    return false;
  }
}
