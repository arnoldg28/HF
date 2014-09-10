import java.util.*;
import java.io.*;

//This version uses a custom comparator
public class JukeBox3{
	
	ArrayList<Song> songList = new ArrayList<Song>();
	
	public static final void main(String args[]){
		new JukeBox3().go();
	}
	
	public class ArtistComparator implements Comparator<Song>{
		public int compare(Song one, Song two){
			return one.getArtist().compareTo(two.getArtist());
		}
	}
	
	public void go(){
		getSongs();
		System.out.println(songList);
		ArtistComparator aComparator = new ArtistComparator();
		Collections.sort(songList,aComparator);
		System.out.println(songList);
	}

	void getSongs(){
		try{
			File file = new File("songList3.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line=reader.readLine())!=null){
				System.out.println(line);
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