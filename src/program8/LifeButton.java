package program8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class LifeButton extends javax.swing.JPanel implements ActionListener {
	private Controller _controller;
	private String _buttonText = "Start Animation";
	private boolean _animating = false;
	private JButton _aniButton;
	private String _action;

	// Below is code for the button that toggles Start/Stop Animation
	public LifeButton(Controller c) {
		super();
		_controller = c;
		this.setBackground(java.awt.Color.DARK_GRAY);
		_aniButton = new JButton(_buttonText);
		_aniButton.setActionCommand("A");
		_aniButton.addActionListener(this);
		this.add(_aniButton);

	}

	public void actionPerformed(ActionEvent e) {
		String _action = e.getActionCommand();
		System.out.println(_action);
		if (_action == "A") {
			_animating = !_animating;
			System.out.println(_animating);
			if (_animating) {
				_controller.startAnimation();
				_aniButton.setText("Stop Animation");
				_controller.setModify(false);
				repaint();
			} else {
				_controller.stopAnimation();
				_aniButton.setText("Start Animation");
				_controller.setModify(true);
				repaint();
			}
		}
	}

}
