import java.util.*;
import java.io.*;

public class JukeBoxHashSet{
	
	ArrayList<Song> songList = new ArrayList<Song>();
	
	public static final void main(String args[]){
		new JukeBoxHashSet().go();
	}
	
	
	public void go(){
		getSongs();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
		HashSet<Song> songSet = new HashSet<Song>();
		songSet.addAll(songList);
		System.out.println(songSet);
	}

	void getSongs(){
		try{
			File file = new File("songListMore.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=reader.readLine())!=null){
				addSong(line);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	void addSong(String lineToParse){
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0],tokens[1],tokens[2],tokens[3]);
		songList.add(nextSong);
	}
}