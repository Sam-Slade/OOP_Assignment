package uk.ac.glos.CT5025.S1803267;

import uk.ac.glos.CT5025.S1803267.pieces.Piece;
import java.util.*;

public class Board {
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
    board = new Piece[size][size];
  }

  public int getSize() {
    return size;
  }

  public void addPiece(Piece piece, int x, int y) {
    board[y][x] = piece;
  }

  public Piece getAtLocation(int x, int y) {
    return board[y][x];
  }

  public void removePiece(int x, int y) {
    board[y][x] = null;
  }

  public Piece[] getPiecesByColour(char colour) {
    List<Piece> temp = new ArrayList<>();
    for (int y = 0; y < size; y++) {
      for (int x = 0; x < size; x++) {
        if ( board[y][x] != null ) {
          if ( board[y][x].getColour() == colour ) {
            temp.add(board[y][x]);
          }
        }
      }
    }
    return temp.toArray(new Piece[temp.size()]);
  }

  public boolean movePiece(int pieceX, int pieceY, int moveX, int moveY) {
    if (pieceX < 0 || pieceX >= size || pieceY < 0 || pieceY >= size ) { // Check to see if the piece selected is on the board
      return false;
    } else if (moveX < 0 || moveX >= size || moveY < 0 || moveY >= size ) { // Check to see if move is on the board
      return false;
    } else if (board[pieceY][pieceX] == null) { // Check to see if there is a piece to be moved
      return false;
    } else {
      if ( board[pieceY][pieceX].checkValidMove(this, moveX, moveY) ) {
        board[moveY][moveX] = board[pieceY][pieceX];
        board[moveY][moveX].addMove();
        board[pieceY][pieceX] = null;
        return true;
      } else {
        return false;
      }
    }
  }


}
