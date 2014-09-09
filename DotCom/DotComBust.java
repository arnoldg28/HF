import java.util.ArrayList;

public class DotComBust{

	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses;
	
	public void setUpGame(){
	
		System.out.println(2%7);
	
		DotCom d1 = new DotCom();
		d1.setName("arnold.com");
		
		DotCom d2 = new DotCom();
		d2.setName("noni.com");
		
		DotCom d3 = new DotCom();
		d3.setName("pananong.com");
		
		dotComsList.add(d1);
		dotComsList.add(d2);
		dotComsList.add(d3);
		
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("arnold.com, noni.com, pananong.com");
		System.out.println("Try to sink them all in the fewest number of guesses");
		
		
		for(DotCom dotComToSet:dotComsList){
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}
	
	public void startPlaying(){
		while(!dotComsList.isEmpty()){
			String userGuess = helper.getUserInput("Enter Guess: ");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	public void checkUserGuess(String userGuess){
		
		numOfGuesses++;
		String result = "miss";
		
		for(DotCom dotCom:dotComsList){
			result = dotCom.checkYourself(userGuess);
			if(result.equals("hit")){
				break;
			}
			if(result.equals("kill")){
				dotComsList.remove(dotCom);
				break;
			}
		}
		
		System.out.println(result);
		
	}
	
	public void finishGame(){
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		if(numOfGuesses<=18){
			System.out.println("It only took you "+numOfGuesses + " guesses.");
			System.out.println("You got out before your option sank.");
		}else{
			System.out.println("It took you "+numOfGuesses + " guesses.");
			System.out.println("..|..");
		}
		
		
	}
	
	public static void main(String[] args){
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}

}