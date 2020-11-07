package model;
public class RestrictedPlaylist extends Playlist implements UserRelatedMethods{
	private final static int PLAYLIST_SIZE=5;
	private User[] playlistUsers;
	
	/**
	Constructor method of the class "RestrictedPlaylist" <br>
	<b> pre: </b><br>
	<b> post: </b> Create an object of type RestrictedPlaylist <br>
	@param user A user, it must be one from the playlistCollection of the MCS
	@param playlistName String that indicates the name of the playlist.
	*/
	public RestrictedPlaylist (User user,String playlistName){
		super(playlistName); 
		playlistUsers = new User[PLAYLIST_SIZE];
		playlistUsers[0]=user;
	}
	
	/**
	Checks the existence of a user in the playlist <br>
	<b> pre: </b>It is only useful if there is at least one user in the playlist. <br>
	<b> post: </b> Returns true if the the indicated user exists, false if it doesn't <br>
	@param poolSong A user, it must be one from the playlistCollection of the MCS
	@return true or false
	*/
	public boolean userExists(User appUser){
		for(int i=0;i<playlistUsers.length;i++){
			if(playlistUsers[i] != null){
				if((appUser.getUserName()).equalsIgnoreCase(playlistUsers[i].getUserName())){
					return true;
				}		
			}	
		}
		return false;
	}
	
	/**
	Add a user to the playlist <br>
	<b> pre: </b><br>
	<b> post: </b> Returns true if the user was added to the playlist, false if not <br>
	@param poolSong An user, it must be one from the playlistCollection of the MCS
	@return true or false
	*/
	public boolean addAUserToPlaylist(User appUser){
		if(!(userExists(appUser))){
			for(int i=0;i<playlistUsers.length;i++){
				if(playlistUsers[i]==null){
					playlistUsers[i]=appUser;
					return true;
				}
			}
		}	
		return false;
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
		info += "**  Playlist type: Restricted"+"\n";
		info += "**  Users with access: ";
		for(int i=0;i<playlistUsers.length;i++){
			if(playlistUsers[i]!=null){
				info+= playlistUsers[i].getUserName()+", ";
			}	
		}
		info += "\n"+"***********************************"+"\n";
		return info;
	}
}