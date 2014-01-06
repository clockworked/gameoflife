package program8;

public class LifeView extends javax.swing.JPanel{
	private final int DIAMETER = 10; 
	private final int OFFSET = 14;
	private SmartRectangle [][] _theMobs;
	private SmartRectangle [][] _background;
	private boolean [][] _life;
	private int _columns, _rows;
	private boolean _modify = true;
	private LifeModel _model;

	public LifeView (int c, int r) {
		super();
		_columns = c;
		_rows = r;
		this.setBackground(java.awt.Color.gray);
		// Create LifeModel and send a copy of self
		_model = new LifeModel(c,r,this);
		// initialize the arrays to start amount and create the smart rectangles, set the parallel array to dead
		_theMobs = new SmartRectangle[c][r];
		_background = new SmartRectangle[c][r];
		_life = new boolean[c][r];
		
		//Set up the rectangles and the parallel array for live values (Starting all dead)
		 for(int i = 0; i <_rows;i++){
			 for(int j = 0; j < _columns; j++){
				 _theMobs[i][j] = new SmartRectangle(java.awt.Color.black);
				 _theMobs[i][j].setSize(DIAMETER, DIAMETER);
				 _theMobs[i][j].setLocation((i)*OFFSET, (j)*OFFSET);
				 _life[i][j] = false;
		   }
		 }
		 
		 //Set up the background squares
		 for(int i = 0; i <_rows;i++){
			 for(int j = 0; j < _columns; j++){
				 _background[i][j] = new SmartRectangle(java.awt.Color.white);
				 _background[i][j].setSize(DIAMETER+2, DIAMETER+2);
				 _background[i][j].setLocation(((i)*OFFSET)-1, ((j)*OFFSET)-1);
		   }
		 }
		 
		 
		
		// adding the mouse listener to the panel
		this.addMouseListener(new MyMouseListener());
	
	}
	
	public void paintComponent (java.awt.Graphics aBrush) {
		super.paintComponent(aBrush);
		java.awt.Graphics2D betterBrush = 
				(java.awt.Graphics2D) aBrush;
		
		 for(int i = 0; i <_rows;i++){
			 for(int j = 0; j < _columns; j++){
				_background[i][j].fill(betterBrush);
		   }
		 }
		
		 for(int i = 0; i <_rows;i++){
			 for(int j = 0; j < _columns; j++){
				 if(_life[i][j])_theMobs[i][j].fill(betterBrush);
		   }
		 }
		 
		 
	
	}
	
	public void Play () {
		repaint();
	}
	
	public boolean[][] getLifeVals () {
		return _life;
	}
	
	public void setLifeVals (boolean[][] values) {
		_life = values;
	}
	
//	// Below is my Mouse Listener class, which deals with mouse events and extends MouseAdapter
	 private class MyMouseListener extends java.awt.event.MouseAdapter {

		   public void mouseClicked(java.awt.event.MouseEvent e){
			   // When you click a point, toggle that points life value and repaint. 
			   System.out.println("You have clicked point " + (int)(e.getX() / OFFSET) + " , " + (int)(e.getY() / OFFSET) );
				   if (_modify && (int)(e.getX() / OFFSET) < _rows && (int)(e.getY() / OFFSET) < _columns){
					   _life[(int)(e.getX() / OFFSET)][(int)(e.getY() / OFFSET)] = !_life[(int)(e.getX() / OFFSET)][(int)(e.getY() / OFFSET)];
					   
				   }
				   repaint();
			   }		  
	 }
	 
	 public LifeModel getModel(){
		 return _model;
		 
	 }
	 
	 public void setModify(boolean b){
		 _modify = b;
	 }

}

