import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class PaintFacadeApp {
	static Character[][] facade;
	static int[][] facadeInt;
	static ArrayList<Integer> sizes = new ArrayList<Integer>();// 0 - height, 1 - width

	public static void main(String[] args) throws IOException {
		 FileReader fileReader = new FileReader(new File(args[0]));
		 BufferedReader br = new BufferedReader(fileReader);
		 String line = null;
		 String[] sizesStr;
		 line = br.readLine();
		 Character curChar;
		 if(line!=null){
			 sizesStr = line.split(" ");
			 for(String curSize : sizesStr){
				 int size = Integer.parseInt(curSize);
				 if(size!=0)
					 sizes.add(size);
				 if(sizes.size()==2)
					 break;
			 }
		 }
		 
		 facade = new  Character[sizes.get(0)][sizes.get(1)];
		 facadeInt = new  int[sizes.get(0)][sizes.get(1)];
		 for (int i = 0; i<sizes.get(0);i++) {
			 line = br.readLine();
			 for(int j = 0; j<sizes.get(1); j++){
				 curChar = line.charAt(j);
				 facade[i][j] = curChar;
				 if(curChar.equals('#'))
					 facadeInt[i][j] = 1;
			 }
		 }
		 printIntFacade();
//		 findOptimalDecision();
		 Square curSquare = findEffectiveSquare();
		 System.out.println(curSquare.numPaintedCells);
		 System.out.println(curSquare.S*2+1);
		 
	}
	private static Square findEffectiveSquare() throws FileNotFoundException, UnsupportedEncodingException {
		int maxSquareSize = sizes.get(0)<sizes.get(1)?sizes.get(0):sizes.get(1);
		if(maxSquareSize%2==0)
			maxSquareSize--;
		Square curSquare = null;
		for(int i = maxSquareSize; i >=3; i = i-2){
			curSquare = findSquare(i);
			if(curSquare!=null && curSquare.isEffective())
				break;
		}
		return curSquare;
	}
	private static Square findSquare(int i) throws FileNotFoundException, UnsupportedEncodingException {
		Square square;
		Square maxSquare = null;
		int maxNumOfCell = 0;
		int curNumOfCell = 0;
		for(int r = i/2;r<sizes.get(0)-i/2;r++){
			for(int c = i/2;c<sizes.get(1)-i/2;c++){
				square = new Square();
				square.S = (i-1)/2;
				square.centerCell = new Cell(r,c);
				curNumOfCell = square.countNumOfCell(facadeInt);
//				square.printSquare(facadeInt);
				if(curNumOfCell>maxNumOfCell){
					maxNumOfCell = curNumOfCell;
					maxSquare = new Square(square);
				}
			}
		}
		return maxSquare;
	}
	private static void findOptimalDecision() {
		Result res = new Result(sizes.get(0), sizes.get(1), facade);
		if(res.entryCell==null)
			return;
		
		nextIteration(res);
	}

	private static void nextIteration(Result res) {
		if(res.curCommand==null){
			
		}
		
		
		// TODO Auto-generated method stub
		
	}


	private static void printFacade() {
		 for (int i = 0; i<sizes.get(0);i++) {
			 for(int j = 0; j<sizes.get(1); j++){
				 System.out.print( facade[i][j]);
			 }
			 System.out.println("");
		 }
	}
	private static void printIntFacade() {
		 for (int i = 0; i<sizes.get(0);i++) {
			 for(int j = 0; j<sizes.get(1); j++){
				 System.out.print( facadeInt[i][j]);
			 }
			 System.out.println("");
		 }
	}
}
