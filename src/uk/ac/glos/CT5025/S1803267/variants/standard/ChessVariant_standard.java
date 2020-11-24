package uk.ac.glos.CT5025.S1803267.variants.standard;

import uk.ac.glos.CT5025.S1803267.Board;
import uk.ac.glos.CT5025.S1803267.Move;
import uk.ac.glos.CT5025.S1803267.pieces.*;

import uk.ac.glos.CT5025.S1803267.variants.ChessVariant;

public class ChessVariant_standard implements ChessVariant {
  /* Standard chess variant class
   * Author: Sam Slade
   * ID: c12
   *
   * Desc: 
   * This class holds the set up and rules for a standard chess game
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

    // Tell each piece where they are on the board
    for (int y = 0; y < BOARD_SIZE; y++) { 
      for (int x = 0; x < BOARD_SIZE; x++) {
        if ( board.getAtLocation(x, y) != null ) {
          board.getAtLocation(x, y).setPosition(x, y);
        }
      }
    }

    return board;
  }

  public boolean checkmated(Board board, char colour) {

    // Get the king
    King king = new King(colour);
    boolean kingFound = false;
    Piece[] pieces = board.getPiecesByColour(colour);
    for (Piece piece : pieces) {
      if ( piece instanceof King ) {
        king = new King(piece);
        kingFound = true;
      }
    }

    if (!kingFound) {
      return true;
    } else if ( !(king.isMate(board)) ) {
      // king is not in mate
      return false;
    }

    Move[] moves;
    for (Piece piece : pieces ) {
      moves = piece.getValidMoves(board);
      System.out.println("Moves available: " + moves.length);
      for (Move move : moves) {
        if ( !(king.isMate(move.getBoardAfterMove())) ) {
          return false;
        }
      }
    }
    return true;
  }
}
