package /uk/ac/glos/CT5025/S1803267/pieces;

public class Rook implements Piece {
  /* Rook piece class
   * Author: Sam Slade
   * ID: c03
   *
   * Desc: The Rook class is an implementation of the Piece
   * interface.
   */
  private final int COLOUR;
  private final int POINT_VALUE = 5;
  private int movesMade;

  public Rook (int colour) {
    this.COLOUR = colour;
    movesMade = 0;
  }

  public boolean checkValidMove(Board board, String move){
    return false;
  }

  public int getColour() {
    return COLOUR;
  }

  public void addMove() {
    movesMade += 1;
  }

  public int getNumberOfMoves() {
    return movesMade;
  }

  public int getPointValue() {
    return POINT_VALUE;
  }
  
}
