import java.util.ArrayList;


public class Result {
	public Character[][] facade;
	public Boolean[][] cellIsChecked;
	int numOfCommands;
	ArrayList<Shape> finishedCommands;
	Shape curCommand;
	int numOfRows;
	int numOfColumns;
	Cell entryCell;
	
	public Result(int numOfRows, int numOfColumns, Character[][] facade) {
		this.numOfRows = numOfRows;
		this.numOfColumns = numOfColumns;
		this.facade = facade;
		cellIsChecked = new Boolean[numOfRows][numOfColumns];
		this.entryCell = findEntryPoint(0,0);
	}
	public boolean startHorRightLine(){
		return false;
	}
	public boolean startHorLeftLine(){
		return false;
	}
	public boolean startVertDownLine(){
		return false;
	}
	public boolean startVertUpLine(){
		return false;
	}
	
	private Cell findEntryPoint(int startRow, int startColumn) {
		for (int r = startRow; r<numOfRows;r++) {
			 for(int c = startColumn; c<numOfColumns; c++){
				 if(facade[r][c].equals('#'))
					 return new Cell(r,c);
			 }
		}
		return null;
	}
	
}
