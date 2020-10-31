package uk.ac.glos.CT5025.S1803267.pieces;

public class Piece {
  /* Piece super class
   * Author: Sam Slade
   * ID: c0j
   *
   * Desc: This super class is the basis of all the pieces
   * int the chess game. Each piece should be able to have
   * a colour set and be able to check if a move is valid.
   */

  private final int COLOUR;
  private final int POINT_VALUE;
  private int movesMade;

  // The piece checks to see if a move is valid and returns a boolean
  public boolean checkValidMove(Board board, int x, int y) {
    return false;
  }

  // Colours are stored as 0 for black and 1 for white
  public int getColour() {
    return this.colour;
  }

  // Add to the move counter stored for a piece
  public void addMove() {
    movesMade += 1;
  }

  public int getNumberOfMoves() {
    return movesMade;
  }

  public int getPointValue() {
    return POINT_VALUE;
  }
}
