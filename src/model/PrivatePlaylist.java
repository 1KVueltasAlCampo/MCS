package model;
public class PrivatePlaylist extends Playlist{
	public PrivatePlaylist (String name,User user){
		super(name,genresIndicator,genres,playlistDuration);
		users = new User[1];
		users[0]=user;
	}	
}