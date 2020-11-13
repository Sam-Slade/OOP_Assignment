package uk.ac.glos.CT5025.S1803267.variants.standard;

import uk.ac.glos.CT5025.S1803267.Board;
import uk.ac.glos.CT5025.S1803267.pieces.*;

import uk.ac.glos.CT5025.S1803267.variants.ChessVariant;

public class ChessVariant_standard implements ChessVariant {
  /*
   */

  private final int BOARD_SIZE = 8;

  public Board setUp() {
    Board board = new Board(BOARD_SIZE);

    // Set up pawns
    for (int i = 0; i < BOARD_SIZE; i++) {
      board.addPiece(new Pawn('w'), i, 1);
      board.addPiece(new Pawn('b'), i, BOARD_SIZE-2);
    }

    // Set up Rooks
    board.addPiece(new Rook('w'), 0, 0);
    board.addPiece(new Rook('w'), BOARD_SIZE-1, 0);
    board.addPiece(new Rook('b'), 0, BOARD_SIZE-1);
    board.addPiece(new Rook('b'), BOARD_SIZE-1, BOARD_SIZE-1);

    // Set up Knights
    board.addPiece(new Knight('w'), 1, 0);
    board.addPiece(new Knight('w'), BOARD_SIZE-2, 0);
    board.addPiece(new Knight('b'), 1, BOARD_SIZE-1);
    board.addPiece(new Knight('b'), BOARD_SIZE-2, BOARD_SIZE-1);


    // Set up Bishops
    board.addPiece(new Bishop('w'), 2, 0);
    board.addPiece(new Bishop('w'), BOARD_SIZE-3, 0);
    board.addPiece(new Bishop('b'), 2, BOARD_SIZE-1);
    board.addPiece(new Bishop('b'), BOARD_SIZE-3, BOARD_SIZE-1);


    // Set up Queens
    board.addPiece(new Queen('w'), BOARD_SIZE-5, 0);
    board.addPiece(new Queen('b'), BOARD_SIZE-5, BOARD_SIZE-1);


    // Set up Kings
    board.addPiece(new King('w'), BOARD_SIZE-4, 0);
    board.addPiece(new King('b'), BOARD_SIZE-4, BOARD_SIZE-1);



    return board;
  }
}
