package tests.pieces;

import uk.ac.glos.CT5025.S1803267.pieces.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PieceTests{

  @Test
  @DisplayName("Clone the bishop piece")
  void bishopClone() {
    Bishop bishop = new Bishop('w');
    bishop.setPosition(1,1);

    Bishop clone = new Bishop(bishop);
    
    assertTrue(clone instanceof Bishop);
    assertEquals(bishop.getColour(), clone.getColour());
    assertEquals(bishop.getNumberOfMoves(), clone.getNumberOfMoves());
    assertEquals(bishop.getPosition()[0], clone.getPosition()[0]);
    assertEquals(bishop.getPosition()[1], clone.getPosition()[1]);
  }
  
  @Test
  @DisplayName("Clone the King piece")
  void kingClone() {
    King king = new King('w');
    king.setPosition(1,1);

    King clone = new King(king);
    
    assertTrue(clone instanceof King);
    assertEquals(king.getColour(), clone.getColour());
    assertEquals(king.getNumberOfMoves(), clone.getNumberOfMoves());
    assertEquals(king.getPosition()[0], clone.getPosition()[0]);
    assertEquals(king.getPosition()[1], clone.getPosition()[1]);
  } 
  
  @Test
  @DisplayName("Clone the Knight piece")
  void knightClone() {
    Knight knight = new Knight('w');
    knight.setPosition(1,1);

    Knight clone = new Knight(knight);
    
    assertTrue(clone instanceof Knight);
    assertEquals(knight.getColour(), clone.getColour());
    assertEquals(knight.getNumberOfMoves(), clone.getNumberOfMoves());
    assertEquals(knight.getPosition()[0], clone.getPosition()[0]);
    assertEquals(knight.getPosition()[1], clone.getPosition()[1]);
  } 
  
  @Test
  @DisplayName("Clone the pawn piece")
  void pawnClone() {
    Pawn pawn = new Pawn('w');
    pawn.setPosition(1,1);

    Pawn clone = new Pawn(pawn);
    
    assertTrue(clone instanceof Pawn);
    assertEquals(pawn.getColour(), clone.getColour());
    assertEquals(pawn.getNumberOfMoves(), clone.getNumberOfMoves());
    assertEquals(pawn.getPosition()[0], clone.getPosition()[0]);
    assertEquals(pawn.getPosition()[1], clone.getPosition()[1]);
  }

  @Test
  @DisplayName("Clone the queen piece")
  void queenClone() {
    Queen queen = new Queen('w');
    queen.setPosition(1,1);

    Queen clone = new Queen(queen);
    
    assertTrue(clone instanceof Queen);
    assertEquals(queen.getColour(), clone.getColour());
    assertEquals(queen.getNumberOfMoves(), clone.getNumberOfMoves());
    assertEquals(queen.getPosition()[0], clone.getPosition()[0]);
    assertEquals(queen.getPosition()[1], clone.getPosition()[1]);
  }

  @Test
  @DisplayName("Clone the rook piece")
  void rookClone() {
    Rook rook = new Rook('w');
    rook.setPosition(1,1);

    Rook clone = new Rook(rook);
    
    assertTrue(clone instanceof Rook);
    assertEquals(rook.getColour(), clone.getColour());
    assertEquals(rook.getNumberOfMoves(), clone.getNumberOfMoves());
    assertEquals(rook.getPosition()[0], clone.getPosition()[0]);
    assertEquals(rook.getPosition()[1], clone.getPosition()[1]);
  }

}

