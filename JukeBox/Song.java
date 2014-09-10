class Song implements Comparable<Song>{
	private String title;
	private String artist;
	private String rating;
	private String bpm;
	
	Song(String t, String a, String r, String b){
		title = t;
		artist= a;
		rating = r;
		bpm = b;
	}
	
	//This is for JukeBoxHashSet
	
	@Override
	public boolean equals(Object song){
		Song s = (Song)song;
		return getTitle().equals(s.getTitle());
	}
	
	public int hashCode(){
		return title.hashCode();
	}

	public int compareTo(Song s){
		return title.compareTo(s.getTitle());
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getArtist(){
		return artist;
	}
	
	public String getRating(){
		return rating;
	}
	
	public String getBPM(){
		return bpm;
	}
	
	public String toString(){
		return title+":"+artist;
	}
	
}