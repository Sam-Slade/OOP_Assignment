package uk.ac.glos.CT5025.S1803267.pieces;

import uk.ac.glos.CT5025.S1803267.varients.Board;

public abstract class Piece {
  /* Piece super class
   * Author: Sam Slade
   * ID: c0j
   *
   * Desc: This super class is the basis of all the pieces
   * int the chess game. Each piece should be able to have
   * a colour set and be able to check if a move is valid.
   */

  protected char colour;
  protected int point_value;
  protected int movesMade;
  protected char symbol = 'X';
  protected int x;
  protected int y;

  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // The piece checks to see if a move is valid and returns a boolean
  public boolean checkValidMove(Board board, int x, int y) {
    return false;
  }

  public void setColour(char colour) {
    this.colour = colour;
  }

  // Colours are stored as 0 for black and 1 for white
  public char getColour() {
    return colour;
  }

  // Add to the move counter stored for a piece
  public void addMove() {
    movesMade += 1;
  }

  public int getNumberOfMoves() {
    return movesMade;
  }

  public int getPointValue() {
    return point_value;
  }

  public char getPieceSymbol() {
    return symbol;
  }
}
