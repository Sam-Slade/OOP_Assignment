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
  private final int COLOUR;
  private final int POINT_VALUE = 5;
  private int movesMade;

  public Rook (int colour) {
    this.COLOUR = colour;
    movesMade = 0;
  }

  public boolean checkValidMove(Board board, int x, int y){
    return false;
  }
}
