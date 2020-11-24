package uk.ac.glos.CT5025.S1803267.pieces;

import uk.ac.glos.CT5025.S1803267.Board;
import uk.ac.glos.CT5025.S1803267.Move;

public class King extends Piece {
  /* King piece class
   * Author: Sam Slade
   * ID: c08
   *
   * Desc: The King class is a child of the
   * piece class
   */

  public King (char colour) {
    this.colour = colour;
    point_value = 0;
    movesMade = 0;
    symbol = '*';
  }

  public King (Piece clone) {
    colour = clone.getColour();
    point_value = 0;
    movesMade = clone.getNumberOfMoves();
    symbol = '*';
    setPosition(clone.getPosition());
  }

  public boolean checkValidMove(Board board, int x, int y){
    if ( board.getAtLocation(x, y) != null ) {
      if (board.getAtLocation(x, y).getColour() == colour) {
        return false;
      } 
    }

    if ( x >= this.x-1 && x <= this.x+1 && y >= this.y-1 && y <= this.y+1 ) {
      if ( isMate(board, x, y) ) {
        return false;
      } else {
        return true;
      }
    }
    return false;
  }

  public boolean isMate(Board board) {
    Piece[] pieces;
    char oppColour;

    if ( colour == 'w' ) {
      oppColour = 'b';
    } else {
      oppColour = 'w';
    }

    pieces = board.getPiecesByColour(oppColour);
    Move[] movesArray;
    Piece tempPiece;
    Move tempMove;

    for (Piece i : pieces) {
      tempPiece = i;

      movesArray = tempPiece.getValidMoves(board);
      for (Move j : movesArray) {
        tempMove = j;
        if ( tempMove.getMovePosition()[0] == this.x && tempMove.getMovePosition()[1] == this.y ) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean isMate(Board board, int x, int y) {
    Piece[] pieces;
    char oppColour;

    if ( this.colour == 'w' ) {
      oppColour = 'b';
    } else {
      oppColour = 'w';
    }

    // Create a board where the king has moved to
    // check if it can be taken from that position
    Board tempBoard = new Board(board);
    tempBoard.removePiece(this.x, this.y);
    tempBoard.addPiece(this, x, y);



    pieces = board.getPiecesByColour(oppColour);
    Move[] movesArray;
    Piece tempPiece;
    Move tempMove;

    for (Piece i : pieces) {
      tempPiece = i;
      if ( !(tempPiece instanceof King) ) {
        movesArray = tempPiece.getValidMoves(tempBoard);
        for (Move j : movesArray) {
          tempMove = j;
          if ( tempMove.getMovePosition()[0] == x && tempMove.getMovePosition()[1] == y ) {
            return true;
          }
        }
      }
    }
    return false;
  }
}
