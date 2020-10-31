package /uk/ac/glos/CT5025/S1803267/pieces;

public class Bishop extends Piece {
  /* Bishop piece class
   * Author: Sam Slade
   * ID: c05
   *
   * Desc: The Bishop class is a child of the
   * Piece class
   */
  private final int COLOUR;
  private final int POINT_VALUE = 1;
  private int movesMade;

  public Bishop (int colour) {
    this.COLOUR = colour;
    movesMade = 0;
  }

  public boolean checkValidMove(Board board, String move){
    return false;
  }
}
