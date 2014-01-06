package program8;
import javax.swing.JPanel;

public interface GameController {
	JPanel getIoPanel(); 
            // returns JPanel containing Button(s) 
	void startAnimation(); // starts animation
	void stopAnimation(); // stops animation
}
