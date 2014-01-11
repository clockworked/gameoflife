package program8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Controller implements GameController, ActionListener {
	private Timer timer;
	private LifeModel _model;
	private LifeView _view;
	private LifeButton _button;

	// Constructor sets passed in model and view to instance variables and
	// creates a new timer & button
	public Controller(LifeModel m, LifeView v) {

		_model = m;
		_view = v;

		timer = new Timer(100, this);
		timer.setInitialDelay(100);

		_button = new LifeButton(this);
	}

	public JPanel getIoPanel() {
		return (JPanel) _button;
	}

	public void startAnimation() {
		timer.start();

	}

	public void stopAnimation() {
		timer.stop();

	}

	// With every tick, update the game, redraw and pause for 1 second
	public void actionPerformed(ActionEvent e) {
		_model.updateGame();
		_view.Play();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			System.out.println("Caught");
		}

	}

	public void setModify(Boolean b) {
		_view.setModify(b);
	}

}
