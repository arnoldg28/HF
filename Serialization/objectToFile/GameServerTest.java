import java.io.*;

public class GameServerTest{

	public static final void main(String[] args){
	
		GameCharacter one = new GameCharacter(50, "Elf", new String[]{"bow", "sword", "dust"});
		//GameCharacter two = new GameCharacter(200, "Troll", new String[]{"bare hands", "big axe"});
		//GameCharacter three = new GameCharacter(120, "Magician", new String[]{"spells", "invisibility"});
		
		//Personal question: what is I serialize the same object three times?
		//If I de-serialized it would it be one object or three in the heap?
		
		try{
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
			os.writeObject(one);
			os.writeObject(one);
			os.writeObject(one);
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		one = null;
		//two = null;
		//three = null;
		
		try{
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
			GameCharacter oneRestore = (GameCharacter)is.readObject();
			oneRestore.type = "test";// After serialization it know that it has the same object.
			GameCharacter twoRestore = (GameCharacter)is.readObject();
			GameCharacter threeRestore = (GameCharacter)is.readObject();
			
			System.out.println(oneRestore.getType());
			System.out.println(twoRestore.getType());
			System.out.println(threeRestore.getType());
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}

class GameCharacter implements Serializable{
	int power;
	String type;
	String[] weapons;
	
	public GameCharacter(int p, String t, String[] w){
		power = p;
		type = t;
		weapons = w;
	}
	
	public int getPower(){
		return power;
	}
	
	public String getType(){
		return type;
	}
	
	public String getWeapons() {
		String weaponList="";
		for (int i =0; i<weapons.length; i++) {
			weaponList+= weapons[i]+ " ";
		}
		return weaponList;
	}
}