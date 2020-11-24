package uk.ac.glos.CT5025.S1803267;

import uk.ac.glos.CT5025.S1803267.pieces.*;

public class Move {
  // c13

  // Parent move
  public boolean hasParent;
  private Move parentMove;

  // Information about the piece moved
  private Board boardAfterMove;
  private int pieceX, pieceY, moveX, moveY;

  // Move value, used to calculate how good a move is
  private int moveValue;


  public Move(Board board, int pieceX, int pieceY, int moveX, int moveY) {
    boardAfterMove = new Board(board);
    boardAfterMove.movePiece(pieceX, pieceY, moveX, moveY);
    this.pieceX = pieceX;
    this.pieceY = pieceY;
    this.moveX = moveX;
    this.moveY = moveY;
  }

  // Getters and setters
  public void setParentMove(Move move) {
    hasParent = true;
    parentMove = move;
  }

  public Move getParentMove() {
    return parentMove;
  }

  public int[] getPiecePosition() {
    int[] pos = new int[2];
    pos[0] = pieceX;
    pos[1] = pieceY;

    return pos;
  }

  public int[] getMovePosition() {
    int[] pos = new int[2];
    pos[0] = moveX;
    pos[1] = moveY;

    return pos;
  }

  public void setMoveValue(int value) {
    moveValue = value;
  }

  public int getMoveValue() {
    return moveValue;
  }

  public Board getBoardAfterMove() {
    return boardAfterMove;
  }
}
