package /uk/ac/glos/CT5025/S1803267/pieces;

public class King implements Piece {
  /* King piece class
   * Author: Sam Slade
   * ID: c07
   *
   * Desc: The King class is an implementation of the Piece
   * interface.
   */
  private final int COLOUR;
  private final int POINT_VALUE = 0;
  private int movesMade;

  public King (int colour) {
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

  public boolean isMate(Board board) {
    return false;
  }

  public boolean isCheckMate(Board board) {
    return false;
  }
  
}
