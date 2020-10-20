package uk.ac.glos.CT5025.S1803267;

// Imports
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
// Importing the buffer strategy
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


public class Screen extends Canvas implements Runnable {
  /* Screen Class
   * Author: Sam Slade
   * ID: 02
   * 
   * Desc :
   * This class is the screen frame and is used the 
   * manager of the buffer strategy in the game.
   */

  // Screen Size setup
  public static int width = 300;
  public static int height = width/16*9;
  public static int scale = 2;

  public Screen () {
    Dimension size = new Dimension(width*scale, height*scale);
    setPreferredSize(size);
  }

  public void run () {
  }

}
