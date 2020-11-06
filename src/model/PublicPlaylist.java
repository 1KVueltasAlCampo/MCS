package model;
public class PublicPlaylist extends Playlist{
	private final static int playlistSize=10;
	private User[] playlistUsers;
	private int[] playlistRating;
	public PublicPlaylist (String playlistName,User user,int rating){
		super(playlistName);
		playlistRating = new int[playlistSize];
		playlistRating[0] = rating;
		playlistUsers=new User[playlistSize];
		playlistUsers[0]=user;
	}
	public boolean addAUserToPlaylist(User appUser){
		for(int i=0;i<playlistUsers.length;i++){
			if(playlistUsers[i]==null){
					playlistUsers[i]=appUser;
					return true;
				}
		}
		return false;
	}
	@Override
	public String getPlaylistInfo(){
		String info = "";
		info += getBasicInformation();
		info += "**  Playlist type: Public"+"\n";
		return info;
	}
}