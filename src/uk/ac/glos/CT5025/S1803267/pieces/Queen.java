package /uk/ac/glos/CT5025/S1803267/pieces;

public class Queen extends Piece {
  /* Queen piece class
   * Author: Sam Slade
   * ID: c07
   *
   * Desc: The Queen class is a child of the
   * Piece class
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
}
