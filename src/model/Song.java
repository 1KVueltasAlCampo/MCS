package model;
public class Song{
	private String title;
	private String authorName;
	private String releaseDate;
	private int genreIndicator;
	private Genres songGenre;
	private Duration songDuration;
	
	/**
	Constructor method of the class "Song" <br>
	<b> pre: </b><br>
	<b> post: </b> Create an object of type PublicPlaylist <br>
	@param playlistName String that indicates the name of the playlist.
	*/
	public Song(String title,String authorName,String releaseDate,int genreIndicator,Duration songDuration){
		this.title=title;
		this.authorName=authorName;
		this.releaseDate = releaseDate;
		this.genreIndicator=genreIndicator;
		songGenre = Genres.values()[genreIndicator-1];
		this.songDuration=songDuration;
	}
	/**
	Return the title of the song <br>
	<b> pre: </b> <br>
	<b> post: </b> The title is returned <br>
	@return title
	*/
	public String getTitle(){
		return title;
	}
	/**
	Change the title of the song <br>
	<b> pre: </b> <br>
	<b> post: </b> The title is changed <br>
	@param title String that indicates the title
	*/
	public void setTitle(String title){
		this.title=title;
	}
	/**
	Return the name of the author or band of the song <br>
	<b> pre: </b> <br>
	<b> post: </b> The author's name is returned <br>
	@return authorName
	*/
	public String getAuthorName(){
		return authorName;
	}
	/**
	Change the name of the author or band of the song <br>
	<b> pre: </b> <br>
	<b> post: </b> The author's name is changed <br>
	@param title String that indicates the author's name
	*/
	public void setAuthorName(String authorName){
		this.authorName=authorName;
	}
	/**
	Return the song's release date <br>
	<b> pre: </b> <br>
	<b> post: </b> The song's release date is returned <br>
	@return releaseDate
	*/
	public String getReleaseDate(){
		return releaseDate;
	}
	/**
	Change the song's release date <br>
	<b> pre: </b> <br>
	<b> post: </b> The song's release date is changed <br>
	@param title String that indicates the song's release date
	*/
	public void setReleaseDate(String authorName){
		this.releaseDate=releaseDate;
	}
	/**
	Return the genre indicator of the song <br>
	<b> pre: </b> <br>
	<b> post: </b> The genre indicator of the song is returned <br>
	@return genreIndicator
	*/
	public int getGenreIndicator(){
		return genreIndicator;
	}
	/**
	Change the song's release date <br>
	<b> pre: </b> <br>
	<b> post: </b> The song's release date is changed <br>
	@param title int that indicates the song's release date
	*/
	public void setGenreIndicator(int genre){
		this.genreIndicator=genreIndicator;
	}
	/**
	Return the duration in minutes of the song <br>
	<b> pre: </b> <br>
	<b> post: </b> The duration in minutes of the song is returned <br>
	@return songDuration.getMinute
	*/
	public int getMinuteDuration(){
		return songDuration.getMinute();
	}
	/**
	Return the duration in seconds of the song <br>
	<b> pre: </b> <br>
	<b> post: </b> The duration in seconds of the song is returned <br>
	@return songDuration.getSecond
	*/
	public int getSecondDuration(){
		return songDuration.getSecond();
	}
	/**
	Returns all the information of the song <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on all the information of the song, a string with all the information is obtained <br>
	@return info
	*/
	public String getSongInformation(){
		String info = "";
		info += "**************  Song **************"+"\n";
		info += "**  Title: "+getTitle()+"\n";
		info += "**  Artist: "+getAuthorName()+"\n";
		info += "**  Duration: "+songDuration.getDurationInfo()+"\n";
		info += "**  Genre: "+songGenre.toString()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}