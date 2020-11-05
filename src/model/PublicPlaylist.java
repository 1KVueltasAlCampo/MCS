package model;
public class PublicPlaylist extends Playlist{
	private User[] publicUsers;
	
	public PublicPlaylist (String name,User user){
		super(name);
		publicUsers=new User[10];
		publicUsers[0]=user;
	}
	@Override
	public String getPlaylistInfo(){
		String info="pito";
		return info;
	}
}