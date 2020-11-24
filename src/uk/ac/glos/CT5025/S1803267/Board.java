package uk.ac.glos.CT5025.S1803267;

import uk.ac.glos.CT5025.S1803267.pieces.*;
import java.util.*;

public class Board {
  /* Board super class
   * Author: Sam Slade * ID: c09
   *
   * Desc: The board super class creates the basic
   * functionality for the different chess boards
   */

  private int size;
  private Piece[][] board;
  private int half;

  // Standard initialization
  public Board (int size) {
    this.size = size;
    board = new Piece[size][size];
  }

  // Overloaded initialization
  public Board(Board clone) {
    this.size = clone.size;
    board = new Piece[size][size];
    for (int y=0; y < clone.getSize(); y++) {
      for (int x=0; x< clone.getSize(); x++) {
        if (clone.getAtLocation(x,y) != null) {
          board[y][x] = clonePiece(clone.getAtLocation(x,y));
        }
      }
    }
  }

  private Piece clonePiece(Piece piece) {
    if ( piece instanceof Pawn ) {
      return new Pawn(piece);
    } else if ( piece instanceof Knight ) {
      return new Knight(piece);
    } else if (piece instanceof Bishop) {
      return new Bishop(piece);
    } else if ( piece instanceof Rook ) {
      return new Rook(piece);
    } else if ( piece instanceof Queen ) {
      return new Queen(piece);
    } else{
      return new King(piece);
    }
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

  public int movePiece(int pieceX, int pieceY, int moveX, int moveY) {
    // movePiece function used to move pieces within the board array
    // This function uses return codes:
    //
    // returns -1 -> Move cannot be made
    // returns X -> Moves was made and X is the score from the move, 0 <= X <= n

    if (pieceX < 0 || pieceX >= size || pieceY < 0 || pieceY >= size ) { // Check to see if the piece selected is on the board
      return -1;
    } else if (moveX < 0 || moveX >= size || moveY < 0 || moveY >= size ) { // Check to see if move is on the board
      return -1;
    } else if (board[pieceY][pieceX] == null) { // Check to see if there is a piece to be moved
      return -1;
    } else {
      if ( board[pieceY][pieceX].checkValidMove(this, moveX, moveY) ) {
        int returnVal;
        if ( board[moveY][moveX] != null ) {
          returnVal = board[moveY][moveX].getPointValue();
        } else {
          returnVal = 0;
        }
        board[moveY][moveX] = board[pieceY][pieceX];
        board[moveY][moveX].addMove();
        board[moveY][moveX].setPosition(moveX, moveY);
        removePiece(pieceX, pieceY);
        return returnVal;
      } else {
        return -1;
      }
    }
  }
}
