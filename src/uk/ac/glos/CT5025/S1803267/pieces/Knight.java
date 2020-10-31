package /uk/ac/glos/CT5025/S1803267/pieces;

public class Knight extends Piece {
  /* Knight piece class
   * Author: Sam Slade
   * ID: c04
   *
   * Desc: The Knight class is a child of the
   * piece class
   */
  private final int COLOUR;
  private final int POINT_VALUE = 3;
  private int movesMade;

  public Knight (int colour) {
    this.COLOUR = colour;
    movesMade = 0;
  }

  public boolean checkValidMove(Board board, String move){
    return false;
  }
}
