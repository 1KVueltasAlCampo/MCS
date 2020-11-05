package model;
public abstract class Playlist{ 
	private String name;
	private Duration playlistDuration;
	private int genresIndicator;
	private Genres[] playlistGenres;
	private Song[] song;
	private User[] users;	
	
	public Playlist(String name){
		this.name=name;
		genresIndicator=1;
		genres=Genres.values()[genresIndicator-1];
		playlistDuration=new Duration(0,0);
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int genresIndicator(){
		return genresIndicator;
	}
	public void setGenresIndicator (int genresIndicator){
		this.genresIndicator=genresIndicator;
	}
	public abstract String getPlaylistInfo();
}