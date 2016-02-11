import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class app {

	public static void main(String[] args) throws FileNotFoundException {
		 FileReader fileReader = new FileReader(new File("input.in"));
		 BufferedReader br = new BufferedReader(fileReader);
		 Input input = new Input();
		 String line = null;
		 line = br.readLine();
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

	}

}
