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
	
	
	public Controller(LifeModel m, LifeView v){

		_model = m;
		_view = v;
		
		timer = new Timer(100, this);
		timer.setInitialDelay(100);  
		
		_button = new LifeButton(this);
	}

	@Override
	public JPanel getIoPanel() {
		return (JPanel)_button;
	}

	@Override
	public void startAnimation() {
		timer.start(); 
		
	}

	@Override
	public void stopAnimation() {
		timer.stop(); 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//_view.Play();
		_model.updateGame();
		_view.Play();
		// Below is some delay code I found on stack exchange. I couldn't seem to get one working with timer.
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ie) {
            System.out.println("Caught");
        }

		
	}
	
	public void setModify(Boolean b){
		_view.setModify(b);
	}


}
