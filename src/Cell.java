
public class Cell extends Shape {
	public static String eraseCellCmd = "ERASE_CELL";
	public int rowInd;
	public int columnInd;
	public Cell(){}
	public Cell(int r, int c) {
		rowInd = r;
		columnInd = c;
	}
}
