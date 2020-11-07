package model;
public abstract class Playlist{ 
	private String playlistName;
	private Duration playlistDuration;
	private Genres playlistGenre;
	private Song[] playlistSongs;
	
	/**
	Constructor method of the abstract class "Playlist" <br>
	<b> pre: </b> This constructor should never be used. <br>
	<b> post: </b> <br>
	@param playlistName String that indicates the name of the playlist.
	*/
	public Playlist(String playlistName){
		this.playlistName=playlistName;
		playlistSongs = new Song[30];
		playlistGenre=Genres.values()[6];
		playlistDuration=new Duration(0,0);
	}
	
	/**
	@return The name of the playlist
	*/
	public String getPlaylistName(){
		return playlistName;
	}
	
	/**
	@param playlistName String that indicates the name of the playlist. playlistName cannot contain spaces
	*/
	public void setPlaylistName(String playlistName){
		this.playlistName=playlistName;
	}
	
	/**
	Checks the existence of a genre in the playlist songs <br>
	<b> pre: </b>It is only useful if there is at least one song in the playlist <br>
	<b> post: </b>Returns true if the the indicated genre exists, false if  it doesn't <br>
	@param genreIndicator Integer number representing one of the possible genres for songs. 1 <= genreIndicator <= 7
	@return true or false
	*/
	public boolean checkGenreExistence(int genreIndicator) {
		for(int i=0;i<playlistSongs.length;i++){
			if((playlistSongs[i]!= null)&&(genreIndicator==(playlistSongs[i].getGenreIndicator())-1)){
				return true;
			}
		}
		return false;
	}
	
	/**
	Indicates what genres the playlist has depending on the songs it contains <br>
	<b> pre: </b>It is only useful if there is at least one song in the playlist <br>
	<b> post: </b> A string containing the genres of the playlist is obtained <br>
	@return info
	*/
	public String putGenres(){
		String info = "";
		for(int i=0;i<6;i++){
			if(checkGenreExistence(i)){
				info += Genres.values()[i]+",";
			}
			else{
				info+= "";
			}
		}	
		return info;
	}
	
	/**
	Change the duration of a playlist based on the songs it has <br>
	<b> pre: </b>It is only useful if there is at least one song in the playlist <br>
	<b> post: </b>Based on the songs in the playlist, the duration of the playlist is changed. <br>
	*/
	public void changeDuration(){
		int seconds = 0;
		int minutes = 0;
		int aux=0;
		for(int i=0;i<playlistSongs.length;i++){
			if(playlistSongs[i]!=null){
				seconds += playlistSongs[i].getSecondDuration();
				minutes += playlistSongs[i].getMinuteDuration();
			}	
		}
		aux = seconds%60;
		minutes += seconds/60;
		seconds = aux;
		playlistDuration.setMinute(minutes);
		playlistDuration.setSecond(seconds);
	}
	
	/**
	Returns the basic information of the playlist <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on the information that all playlists must have, a string with all the basic information is obtained <br>
	@return info
	*/
	public String getBasicInformation(){
		changeDuration();
		String info="";
		info += "**************  Playlist **************"+"\n";
		info += "**  Title: "+getPlaylistName()+"\n";
		info += "**  Duration: "+playlistDuration.getDurationInfo()+"\n";
		info += "**  Genre: ";
		if(playlistSongs[0]!=null){
			info += putGenres()+"\n";	
		}
		else {
			info += playlistGenre.toString()+"\n";
		}
		return info;
	}
	
	/**
	Checks the existence of a song in the playlist <br>
	<b> pre: </b>It is only useful if there is at least one song in the playlist. <br>
	<b> post: </b> Returns true if the the indicated song exists, false if  it doesn't <br>
	@param poolSong A Song, it must be one from the pool of songs of the MCS
	@return true or false
	*/
	public boolean songExists(Song poolSong){
		for(int i=0;i<playlistSongs.length;i++){
			if(playlistSongs[i]!=null){
				if((poolSong.getTitle()).equalsIgnoreCase(playlistSongs[i].getTitle())){
					return true;
				}		
			}			
		}
		return false;	
	}
	
	/**
	Add a song to the playlist <br>
	<b> pre: </b><br>
	<b> post: </b> Returns true if the song was added to the playlist, false if not <br>
	@param poolSong A Song, it must be one from the pool of songs of the MCS
	@return true or false
	*/
	public boolean addASongToPlaylist(Song poolSong){
		if(!(songExists(poolSong))){
			for(int i=0;i<playlistSongs.length;i++){
				if(playlistSongs[i]==null){
					playlistSongs[i]=poolSong;
					return true;
				}	
			}
		}	
		return false;
	}
	public abstract String getPlaylistInfo();
}