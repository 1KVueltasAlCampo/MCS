package model;
public class PublicPlaylist extends Playlist implements UserRelatedMethods{
	private final static int playlistSize=10;
	private User[] playlistUsers;
	private double playlistRating;
	private int ratesAdded;
	public PublicPlaylist (String playlistName,User user,double playlistRating){
		super(playlistName);
		playlistUsers=new User[playlistSize];
		playlistUsers[0]=user;
		this.playlistRating = playlistRating;
		ratesAdded=1;
	}
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
	public void changeRating(double userRating){
		playlistRating+=userRating;
		ratesAdded++;
	}
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