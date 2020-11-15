package uk.ac.glos.CT5025.S1803267;

import uk.ac.glos.CT5025.S1803267.pieces.*;
import java.util.*;

public class Opponent {
  /* Opponent abstract class 
   * Author: Sam Slade
   * ID: c10
   *
   * Desc: 
   * This abstract class is the blueprint for the
   * different AI opponents in the game. This abstract 
   * class also implements some of the basic functions
   * the AI opponents need
   */

  protected int generateMovesIterations;

  /*
  public Move makeMove(Board board) {
    Move move = new Move();
    return move;
  }
  */

  public Move[] generateMoves(Board board, char whosMove) {
    List<Move> moves = new ArrayList<>(); 
    Move[] movesArray;
    Piece[] piecesByColour;
    Piece tempPiece;
    Move tempMove;
    piecesByColour = board.getPiecesByColour(whosMove);

    for (Piece i : piecesByColour) {
      tempPiece = i;
      movesArray = tempPiece.getValidMoves(board);
      for (Move j : movesArray) {
        tempMove = j;
        System.out.println("beep");
        moves.add(tempMove);
        System.out.println("boop");
      }
    }
    return moves.toArray(new Move[moves.size()]);
  }
}
