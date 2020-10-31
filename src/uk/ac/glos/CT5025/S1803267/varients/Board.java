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
    if (pieceX < 0 or pieceX >= size or pieceY < 0 or pieceY >= size ) { // Check to see if the piece selected is on the board
      return false;
    } else if (moveX < 0 or moveX >= size or moveY < 0 or moveY >= size ) { // Check to see if move is on the board
      return false;
    } else if (board[pieceX][pieceY] == null) { // Check to see if there is a piece to be moved
      return false;
    } else {
      if ( board[pieceX][pieceY].checkValidMove(this, moveX, moveY) ) {
        board[moveX][moveY] = board[pieceX][pieceY];
        board[pieceX][pieceY] = null;
        return true;
      } else {
        return false;
      }
    }
  }


}
