package model;
public class RestrictedPlaylist extends Playlist{
	
	public RestrictedPlaylist (String name,User user){
		super(name,genresIndicator,genres,playlistDuration); 
		user = new User[5];
		users[0]=user;
	}
	public boolean addUser(String username,String password,int age,int ){
		for(int i=0;i<pilots.length;i++){
			if(pilots[i]==null){
				pilots[i]=new Pilot(name,age,scuderia,scores);
				return true;
			}
		}
		return false;
	}
		
	
}