package uk.ac.glos.CT5025.S1803267.pieces;

public interface Piece {
  /* Piece interface
   * Author: Sam Slade
   * ID: i01
   *
   * Desc: This interface is the basis of all the pieces
   * int the chess game. Each piece should be able to have
   * a colour set and be able to check if a move is valid.
   */

  // The piece checks to see if a move is valid and returns a boolean
  public boolean checkValidMove(Board board, String move);

  // Colours are stored as 0 for black and 1 for white
  public int getColour();

  // Add to the move counter stored for a piece
  public void addMove();

  public int getNumberOfMoves();

  public int getPointValue();
}
