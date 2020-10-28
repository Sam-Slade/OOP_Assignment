package /uk/ac/glos/CT5025/S1803267/pieces;

public class Queen implements Piece {
  /* Queen piece class
   * Author: Sam Slade
   * ID: c06
   *
   * Desc: The Queen class is an implementation of the Piece
   * interface.
   */
  private final int COLOUR;
  private final int POINT_VALUE = 9;
  private int movesMade;

  public Queen (int colour) {
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
