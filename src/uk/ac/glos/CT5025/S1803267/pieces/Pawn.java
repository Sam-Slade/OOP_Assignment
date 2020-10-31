package /uk/ac/glos/CT5025/S1803267/pieces;

public class Pawn extends Piece {
  /* Pawn piece class
   * Author: Sam Slade
   * ID: c03
   *
   * Desc: The Pawn class is a child of the
   * Piece class
   */
  private final int COLOUR;
  private final int POINT_VALUE = 1;
  private int movesMade;

  public Pawn (int colour) {
    this.COLOUR = colour;
    movesMade = 0;
  }

  public boolean checkValidMove(Board board, int x, int y){
    return false;
  }
}
