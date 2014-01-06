package program8;

public class LifeModel implements GameModel{
	private boolean [][] _cells;
	private boolean [][] _nextCells;
	private int _height;
	private int _width;
	private int _neighbors;
	private LifeView _view;

	// Constructor without viewer for testing purposes
	public LifeModel(int height, int width) {
		_height = height;
		_width = width;
		_cells = new boolean[_height][_width];
		_nextCells = new boolean[_height][_width];

		// set all values to DEAD
		for(int i = 0; i <this.getHeight();i++){
			for(int j = 0; j < this.getWidth(); j++){
				setCellDead(i,j);
			}
		}
	}
	// Constructor with viewer
	public LifeModel(int height, int width, LifeView v) {
		_height = height;
		_width = width;
		_view = v;
		_cells = new boolean[_height][_width];
		_nextCells = new boolean[_height][_width];

		// set all values to DEAD
		for(int i = 0; i <this.getHeight();i++){
			for(int j = 0; j < this.getWidth(); j++){
				setCellDead(i,j);
			}
		}
	}


	public int getHeight() {
		return this._height;

	}

	public int getWidth() {
		return this._width;
	}

	public boolean isCellAlive(int i, int j) {
		return _cells[i][j];
	}

	public void setCellAlive(int i, int j) {
		_cells[i][j]= true;

	}

	public void setCellDead(int i, int j) {
		_cells[i][j]= false;

	}

	public void updateGame() {
		int seti = 0;
		int setj = 0;
		// Create temp array and set values to false
		_cells = _view.getLifeVals();
		// Show cells is used in debugging
		showCells();
		_nextCells=new boolean[getHeight()][getWidth()];
		for(int i = 0; i <this.getHeight();i++){
			for(int j = 0; j < this.getWidth(); j++){
				//_nextCells[i][j] = _cells[i][j];
				_nextCells[i][j] = false;
			}
		}
		

		// End of Copying. Start of Checking for neighbors
		for(int i = 0; i <this.getHeight();i++){
			for(int j = 0; j < this.getWidth(); j++){
				// Count the neighbors!
				_neighbors = countingNeighbors(i,j);

				// checking for game conditions to set current true or false
				if (isCellAlive(i,j)){//looks on current, find alive
					//Fewer than 2 live neighbors? Die.
					if(_neighbors < 2)
					{ _nextCells[i][j]= false;}
					// Currently Alive? 2 or 3 neighbors? Stay Alive.
					else if( (_neighbors == 2) ||( _neighbors ==3)){
						_nextCells[i][j]= true;
						System.out.println(i+"  "+j);
						System.out.println(_nextCells[i][j]);
						seti = i;
						setj = j;
					}
					// If more than 3 neighbors, die.
					else{
						_nextCells[i][j] = false;
						if( (i == seti) && (j == setj))
						{
							System.out.println(">3case" +i+"  "+j + ":" + _nextCells[i][j]);
						}
					}
				}//alive rules over
				// Dead? Have 3 neighbors? Live!
				else //starting dead
				{
					if( (_neighbors ==3))
					{
						_nextCells[i][j]=true;
						//System.out.println(i+"  "+j);
					}
					else
					{
						_nextCells[i][j]=false;
						if( (i == seti) && (j == setj))
						{
							System.out.println("deadcase " +i+"  "+j + ":" + _nextCells[i][j]);
						}
					}

					// reset neighbors for the next round
					//	_neighbors = 0;
				}//end of dead rule application
			}//inner loop checking all cells
		}//outer loop checking all cells
		System.err.println("end of update");
		showCells2();
		_view.setLifeVals(_nextCells); 


	}

	private void showCells2() {
		System.out.println("THIS IS NEXT CELLS");
		for(int i = 0; i <this.getHeight();i++){
			for(int j = 0; j < this.getWidth(); j++){
				if(_nextCells[j][i]) System.out.print(1);
				else System.out.print(0);
			}
			System.out.println();
		}
		System.out.println("-----------");

	}
	private void showCells() {
		for(int i = 0; i <this.getHeight();i++){
			for(int j = 0; j < this.getWidth(); j++){
				if(_cells[j][i]) System.out.print(1);
				else System.out.print(0);
			}
			System.out.println();
		}
		System.out.println("-----------");

	}
	public int countingNeighbors(int i,int j){
		int neighbors = 0;
		try{
			if(_cells[i-1][j-1]){
				neighbors++;
				// System.out.println("top left");
			}
		}
		catch(Exception e){
			// Nada numero uno
		}
		try{
			//System.out.println("2");
			if(_cells[i-1][j]) neighbors++;
		}
		catch(Exception e){
			// Nothing #2
		}

		try{
			// System.out.println("3");
			if(_cells[i-1][j+1]) neighbors++;

		}
		catch(Exception e){
			// Nothing # 3!
		}

		try{
			// System.out.println("4");
			if(_cells[i][j-1]) neighbors++;

		}
		catch(Exception e){
			// Nothing # 4!
		}

		try{
			//System.out.println("5");
			if(_cells[i][j+1]) neighbors++;

		}
		catch(Exception e){
			// Nothing # 5!
		}

		try{
			// System.out.println("6");
			if(_cells[i+1][j-1]) neighbors++;

		}
		catch(Exception e){
			// Nothing # 6!
		}

		try{
			// System.out.println("7");
			if(_cells[i+1][j]) neighbors++;

		}
		catch(Exception e){
			// Nothing # 7!
		}

		try{
			// System.out.println("8");
			if(_cells[i+1][j+1]) neighbors++;

		}
		catch(Exception e){
			// Nothing # 8!
		}
		if (neighbors > 0) System.out.println(i + " " + j + " Currently has " + neighbors + " neighbors");

		return neighbors;	 

	}
}