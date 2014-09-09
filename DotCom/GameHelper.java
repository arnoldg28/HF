import java.io.*;
import java.util.*;

public class GameHelper{

	public static void main(String[] args){
		GameHelper helper = new GameHelper();
		helper.placeDotCom(3);
		helper.placeDotCom(3);
	}

	private static final String alphabet = "abcdefg";
	private int gridLength = 7;
	private int gridSize = 49;
	private int[] grid = new int[gridSize];
	private int comCount = 0;
	
	public String getUserInput(String prompt){
		String inputLine = null;
		System.out.print(prompt + " ");		
		try{
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if(inputLine.length()==0) return null;
		
		}catch(IOException e){
			System.out.println(e);
		}
		return inputLine.toLowerCase();	
	}
	
	public ArrayList<String> placeDotCom(int comSize){
	
		ArrayList<String> alphaCells = new ArrayList<String>();
		String[] alphacoords = new String[comSize];
		String temp = null;
		int[] coords = new int[comSize];
		int attempts = 0;
		boolean success = false;
		int location = 0;
	
		comCount++;
		int incr = 1;
		if((comCount % 2) == 1){
			incr = gridLength;
		}
		
		System.out.println("incr: "+incr);
		
		while(!success & attempts++ < 200){
			location = (int)(Math.random()*gridSize);
			System.out.println("Try: "+location);
			int x = 0;
				success = true;
				while(success && x < comSize){
					if(grid[location]==0){
						coords[x++] = location;
						location += incr;
						System.out.println(location);
						if(location>=gridSize){
							success = false;
						}
						if(x>0 && (location % gridLength == 0)){
							success = false;
						}
					}else{
						System.out.println("Used: "+location);
						success = false;
					}
				}
		}
		
		int x = 0;
		int row = 0;
		int column = 0;
		//System.out.println("\n");
		while(x<comSize){
			grid[coords[x]] = 1;
			row = (int)(coords[x]/gridLength);
			System.out.println("row: "+row);
			column = coords[x] % gridLength;
			System.out.println("column: "+column);
			temp = String.valueOf(alphabet.charAt(column));
			
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
			System.out.println(" coord "+x+" = "+alphaCells.get(x-1));
		}
		
		return alphaCells;
	}

}