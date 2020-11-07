package model;
public class PublicPlaylist extends Playlist{
	private double playlistRating;
	private int ratesAdded;
	
	/**
	Constructor method of the class "PublicPlaylist" <br>
	<b> pre: </b><br>
	<b> post: </b> Create an object of type PublicPlaylist <br>
	@param playlistName String that indicates the name of the playlist.
	*/
	public PublicPlaylist (String playlistName){
		super(playlistName);
		this.playlistRating = playlistRating;
		playlistRating=0;
		ratesAdded=0;
	}
	
	/**
	Change the rating of a public playlist based on the songs it has <br>
	<b> pre: </b>It is only useful if there is at least one rate added in the playlist <br>
	<b> post: </b> Based on the ratings of the playlist, the average rating of the playlist is changed.<br>
	*/
	public void changeRating(double userRating){
		playlistRating+=userRating;
		ratesAdded++;
	}
	
	/**
	Returns all the information of the playlist <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on all the information in the playlist, a string with all the information is obtained <br>
	@return info
	*/
	@Override
	public String getPlaylistInfo(){
		String info = "";
		info += getBasicInformation();
		info += "**  Playlist type: Public"+"\n";
		info += "**  Rating: "+(playlistRating/ratesAdded)+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}