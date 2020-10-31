package /uk/ac/glos/CT5025/S1803267/pieces;

public class King extends Piece {
  /* King piece class
   * Author: Sam Slade
   * ID: c07
   *
   * Desc: The King class is a child of the
   * piece class
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

  public boolean isMate(Board board) {
    return false;
  }

  public boolean isCheckMate(Board board) {
    return false;
  }
  
}
