package uk.ac.glos.CT5025.S1803267.variants;

// Get the Board class
import uk.ac.glos.CT5025.S1803267.Board;

public interface ChessVariant {
  /* The Chess Variant interface
   * Author: Sam Slade
   * ID: i1
   *
   * Desc:
   * This interface is the blue print for the other chess
   * variants. It outlines the methods each should have and 
   * defines the end points that the rest of the game can use
   */

  // Creates the board and returns it.
  public Board setUp();

}
