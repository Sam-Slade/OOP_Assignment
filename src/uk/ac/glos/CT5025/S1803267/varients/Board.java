package uk.ac.glos.CT5025.S1803267.varients;

import uk.ac.glos.CT5025.S1803267.pieces;

public class Board () {
  /* Board super class
   * Author: Sam Slade
   * ID: c09
   *
   * Desc: The board super class creates the basic
   * functionality for the different chess boards
   */

  private int size;
  private Piece[][] board;

  public Board (int size) {
    this.size = size;
    board = Piece[size][size];
  }

  public void addPiece(Piece piece, int x, int y) {
    board[x][y] = piece;
  }

  public void removePiece(int x, int y) {
    board[x][y] = null;
  }

  public boolean movePiece(int pieceX, int pieceY, int moveX, int moveY) {
    return false;
  }


}
