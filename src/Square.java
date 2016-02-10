import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Square extends Shape{
	public static String paintSquareCmd = "PAINT_SQUARE";
	public Cell centerCell;
	public int S;
	public int numPaintedCells;
	
	public Square() {
	}
	public Square(Square square) {
		this.centerCell = square.centerCell;
		this.S = square.S;
		this.numPaintedCells = square.numPaintedCells;
	}
	public int countNumOfCell(int[][] facadeInt) {
		int numOfCells = 0;
		int startRowInd = centerCell.rowInd-S;
		int startColumnInd = centerCell.columnInd-S;
		for(int r = startRowInd; r<startRowInd+2*S+1;r++){
			for(int c = startColumnInd; c<startColumnInd+2*S+1;c++){
				numOfCells = numOfCells+facadeInt[r][c];
			}
		}
		numPaintedCells = numOfCells;
		return numOfCells;
	}
	public void printSquare(int[][] facadeInt) throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
		
		int startRowInd = centerCell.rowInd-S;
		int startColumnInd = centerCell.columnInd-S;
		for(int r = startRowInd; r<startRowInd+2*S+1;r++){
			for(int c = startColumnInd; c<startColumnInd+2*S+1;c++){
				writer.print(facadeInt[r][c]);
			}
			writer.println();
		}
		writer.println();
		writer.close();
	}
	public boolean isEffective() {
		if(numPaintedCells>=(((S*2+1)*(S*2+1)-S*2)))
			return true;
		return false;
	}
}
