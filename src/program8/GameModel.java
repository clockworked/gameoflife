package program8;

public interface GameModel {
		int getHeight();  // returns number of rows
		int getWidth();  // returns number of columns
		boolean isCellAlive(int i, int j);  
	        // true if cell (i,j) is alive, false otherwise
		void setCellAlive(int i, int j);
		   // sets cell(i,j) to alive
		void setCellDead(int i, int j); 
	        // sets cell(i,j) to dead
	     void updateGame(); // sets game state to next generation 


}
