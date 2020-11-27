package uk.ac.glos.CT5025.S1803267;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class FileManager {


  private BufferedWriter wBuffer;
  private BufferedReader rBuffer;
  private String mode;

  public FileManager (String mode, String file) {
    this.mode = mode;
    try {
      if ( mode == "read" ) {
        FileReader reader = new FileReader(file);
        rBuffer = new BufferedReader(reader);
      } else if ( mode == "write" ) {
        FileWriter writer = new FileWriter(file);
        wBuffer = new BufferedWriter(writer);
      } else {
        System.out.println("INVALID MODE GIVEN");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void close() {
    try {
      if ( this.mode == "read") {
        rBuffer.close();
      } else if ( this.mode == "write") {
        wBuffer.close();
      } else {
        System.out.println("INVALID MODE, CANNOT CLOSE BUFFER");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public String readLine(int line) {
    try {
      for ( int i=0; i < line; i++ ) {
        rBuffer.readLine();
      }
      return rBuffer.readLine();
    } catch(Exception e) {
      e.printStackTrace();
      return "";
    }
  }

  public String[] readWholeFile() {
    try {
      List<String> filesLines = new ArrayList<>();
      String line;
      while( (line = rBuffer.readLine()) != null ) {
        filesLines.add(line);
      }
      return filesLines.toArray(new String[filesLines.size()]);
    } catch (Exception e) {
      e.printStackTrace();
      return new String[] {""};
    }
  }

  public void writeLine(String line) {
    try {
      wBuffer.write(line);
      wBuffer.newLine();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void writeMultipleLines(String[] lines) {
    try {
      for (String line : lines) {
        this.writeLine(line);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
