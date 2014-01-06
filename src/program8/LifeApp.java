package program8;

public class LifeApp extends javax.swing.JFrame {
	
	private LifeView _lifeView = new LifeView(35,35);
	private Controller _controller = new Controller(_lifeView.getModel(), _lifeView);
	
	public LifeApp (String title) {
		super(title);
		this.setSize(510, 565);
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.add(_lifeView, java.awt.BorderLayout.CENTER);
		this.add(_controller.getIoPanel(), java.awt.BorderLayout.SOUTH);
		this.setVisible(true);
	}

	public static void main (String [ ] args) {
		LifeApp app = new LifeApp ("Antonia Lewis's Game of Life");
	}
}