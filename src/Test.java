import java.io.IOException;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;





public class Test {
  public static void main(String args[]){
    DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
    Terminal terminal = null;

    try {
      terminal = defaultTerminalFactory.createTerminal();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (terminal != null) {
        try {
          terminal.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
