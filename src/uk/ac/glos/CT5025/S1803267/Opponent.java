package uk.ac.glos.CT5025.S1803267;

import uk.ac.glos.CT5025.S1803267.pieces.*;
import java.util.*;

public class Opponent {
  /* Opponent class 
   * Author: Sam Slade
   * ID: c10
   *
   * Desc: 
   * This class is the blueprint for the
   * different AI opponents in the game. This abstract 
   * class also implements some of the basic functions
   * the AI opponents need
   */

  protected char colour;
  protected char opponentsColour;
  protected int generateMovesIterations;
  protected String name;
  protected int score;

  public Opponent(char colour, int generateMovesIterations, String name) {
    this.score = 0;
    this.name = name;
    this.generateMovesIterations = generateMovesIterations;
    this.colour = colour;
    if ( colour == 'w' ) {
      opponentsColour = 'b';
    } else {
      opponentsColour = 'w';
    }
    
  }

  public Move makeMove(Board board) {
    Move[] moves = generateMoves(board);
    moves = evaluateMoves(moves);
    Move move = getBestMove(moves);

    while ( move.hasParent ) {
      System.out.println("" + colour + ": " + move.getMoveValue());
      move = move.getParentMove();
    }
    return move;
  }

  private Move[] generateMoves(Board board) {
    List<Move> moves = new ArrayList<>(); 
    Move[] movesArray;
    Piece[] piecesByColour;
    Piece tempPiece;
    Move tempMove;
    King king = new King(colour);

    piecesByColour = board.getPiecesByColour(colour);
    for (Piece i : piecesByColour) {
      tempPiece = i;

      if (tempPiece instanceof King) {
        king = new King(tempPiece);
      }

      movesArray = tempPiece.getValidMoves(board);
      movesArray = evaluateMoves(movesArray);
      for (Move j : movesArray) {
        tempMove = j;
        if ( !(king.isMate(tempMove.getBoardAfterMove())) ) {
          moves.add(tempMove);
        }
      }
    }
    
    for (int i = 0; i < generateMovesIterations-1; i++) {
      if ( i%2 == 0 ) {
        moves = generateMoves(moves, opponentsColour);
      } else {
        moves = generateMoves(moves, colour);
      }
    }

    return moves.toArray(new Move[moves.size()]);
  }

  private List<Move> generateMoves(List<Move> moves, char whosMove) {
    List<Move> newMoves = new ArrayList<>(); 
    Move[] movesArray;
    Piece[] piecesByColour;
    Piece tempPiece;
    Move tempMove;
    for (Move i : moves) {
      tempMove = i;
      piecesByColour = tempMove.getBoardAfterMove().getPiecesByColour(whosMove);
      for (Piece j : piecesByColour) {
        tempPiece = j;
        movesArray = tempPiece.getValidMoves(tempMove.getBoardAfterMove());
        movesArray = evaluateMoves(movesArray);
        for (Move k : movesArray) {
          k.setParentMove(tempMove);
          k.setMoveValue(k.getMoveValue() + tempMove.getMoveValue());
          newMoves.add(k);
        }
      }
    }
    return newMoves;
  }

  private Move[] evaluateMoves(Move[] moves) {
    int value;
    Piece tempPiece;
    Move tempMove;
    Board tempBoard;
    for (Move move : moves) {
      value = 0;
      tempBoard = move.getBoardAfterMove();
      
      for ( int y=0; y < tempBoard.getSize(); y++ ) {
        for (int x=0; x < tempBoard.getSize(); x++ ) {
          if ( tempBoard.getAtLocation(x, y) != null ) {
            tempPiece = tempBoard.getAtLocation(x, y);
            if ( tempPiece.getColour() == colour ) {
              value += getValueOfPiece(tempPiece)*2;
            } else {
              value -= getValueOfPiece(tempPiece);
            }
          }
        }
      }
      move.setMoveValue(value);
    }

    return moves;
  }

  private Move getBestMove(Move[] moves) {
    Move bestMove = moves[0];
    for (Move i : moves) {
      if ( i.getMoveValue() > bestMove.getMoveValue() ) {
        bestMove = i;
      }
    }
    return bestMove;
  }

  private int getValueOfPiece(Piece piece) {
    if ( piece instanceof Pawn ) {
      return 10;
    } else if ( piece instanceof Knight || piece instanceof Bishop) {
      return 30;
    } else if ( piece instanceof Rook ) {
      return 50;
    } else if ( piece instanceof Queen ) {
      return 90;
    } else if (piece instanceof King ) {
      return 999;
    } else {
      return 0;
    }
  }

  public char getColour () {
    return colour;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }
}
