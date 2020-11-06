package model;
public class MusicCollectAndShare{
	private User[] users;
	private Song[] poolSongs;
	private Playlist[] playlistCollection;
	
	public MusicCollectAndShare(){
		users = new User[10];
		poolSongs = new Song[30];
		playlistCollection = new Playlist[20];
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
	public String getAllInfoOfPlaylists(){
		String info="";
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]!=null){
				info += playlistCollection[i].getPlaylistInfo();
			}
		}
		return info;
	}	
	public boolean createPlaylist(String playlistName,User playlistUser){
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]==null){
				playlistCollection[i]=new PrivatePlaylist(playlistName,playlistUser);
				return true;
			}	
		}
		return false;
	}
	public boolean createPlaylist(User playlistUser,String playlistName){
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]==null){
				playlistCollection[i]=new RestrictedPlaylist(playlistUser,playlistName);
				return true;
			}	
		}
		return false;
	}
	public boolean createPlaylist(String playlistName,User playlistUser,int calification){
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]==null){
				playlistCollection[i]=new PublicPlaylist(playlistName,playlistUser,calification);
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
	public User giveAUserWithIndex(int index){
		return users[index];
	}
	public void newSongAddedTo(String name,String password){
		users[findUser(name,password)].songsAdded++;
	}
}