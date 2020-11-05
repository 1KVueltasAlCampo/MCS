package model;
public class MusicCollectAndShare{
	private User[] users = new User[10];
	private Song[] poolSongs = new Song[30];
	private Playlist[] playlistCollection = new Playlist[20];
	
	public MusicCollectAndShare(){
	}
	public boolean createUser(String username,String password,int age){
		for(int i=0;i<users.length;i++){
			if(users[i]==null){
				users[i]=new User(username,password,age);
				return true;
			}
		}
		return false;
	}
	public String getAllInfoOfUsers(){
		String info="";
		for(int i=0;i<users.length;i++){
			if(users[i]!=null){
					info += users[i].getUserInformation();
			}	
		}
		return info;
	}
	public String getAllInfoOfSongs(){
		String info="";
		for(int i=0;i<poolSongs.length;i++){
			if(poolSongs[i]!=null){
				info += poolSongs[i].getSongInformation();
			}
		}
		return info;
	}
	public boolean createPublicPlaylist(String playlistName,User playlistUser){
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]==null){
				playlistCollection[i]=new PublicPlaylist(playlistName,playlistUser);
				return true;
			}	
		}
		return false;
	}
	public boolean createSong(String name,String password,String title,String authorName,String releaseDate,int genre,Duration songDuration){
			for(int i=0;i<poolSongs.length;i++){
				if(poolSongs[i]==null){
					poolSongs[i]=new Song(title,authorName,releaseDate,genre,songDuration);
					newSongAddedTo(name,password);
					return true;
				}
			}	
		return false;
	}
	public int findUser(String name,String password){
		int index=-1;
		for(int i=0;i<users.length;i++){
			if(users[i]!=null){
				if((name.equalsIgnoreCase(users[i].getUserName()))&&(password.equalsIgnoreCase(users[i].getPassword()))){
					index=i;
				}
			}
		}
		return index;	
	}
	public void newSongAddedTo(String name,String password){
		users[findUser(name,password)].songsAdded++;
	}
}