package model;
public class PrivatePlaylist extends Playlist{
	
	/**
	Constructor method of the class "PrivatePlaylist" <br>
	<b> pre: </b><br>
	<b> post: </b> Create an object of type PrivatePlaylist <br>
	@param playlistName String that indicates the name of the playlist.
	@param user A user, it must be one from the playlistCollection of the MCS
	*/
	private User privateUser;
	public PrivatePlaylist(String playlistName,User user){
		super(playlistName);
		privateUser = user;
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
		info += "**  Playlist type: Private"+"\n";
		info += "**  Owner of the playlist: "+privateUser.getUserName()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
}