package model;
public class MusicCollectAndShare{
	private User[] users;
	private Song[] poolSongs;
	private Playlist[] playlistCollection;
	
	/**
	Constructor method of the class "MusicCollectAndShare" <br>
	<b> pre: </b><br>
	<b> post: </b> Create an object of type MusicCollectAndShare <br>
	*/
	public MusicCollectAndShare(){
		users = new User[10];
		poolSongs = new Song[30];
		playlistCollection = new Playlist[20];
	}
	
	/**
	Create a user in the MCS <br>
	<b> pre: </b> <br>
	<b> post: </b>Returns true if the user was created correctly, false if  it doesn't <br>
	@param userName String that indicates the name of the user. userName cannot contain spaces
	@param password String that indicates the password of the user
	@param age Integer that indicates the age of the user
	@return true or false
	*/
	public boolean createUser(String username,String password,int age){
		for(int i=0;i<users.length;i++){
			if(users[i]==null){
				users[i]=new User(username,password,age);
				return true;
			}
		}
		return false;
	}
	
	/**
	Returns all information of all the users <br>
	<b> pre: </b> <br>
	<b> post: </b>Based on all the information of all the users in the MCS, a string with all the information of all the users is obtained <br>
	@return info
	*/
	public String getAllInfoOfUsers(){
		String info="";
		for(int i=0;i<users.length;i++){
			if(users[i]!=null){
					info += users[i].getUserInformation();
			}	
		}
		return info;
	}
	
	/**
	Returns all information of all the songs <br>
	<b> pre: </b> <br>
	<b> post: </b>Based on all the information of all the songs in the MCS, a string with all the information of all the songs is obtained <br>
	@return info
	*/
	public String getAllInfoOfSongs(){
		String info="";
		for(int i=0;i<poolSongs.length;i++){
			if(poolSongs[i]!=null){
				info += poolSongs[i].getSongInformation();
			}
		}
		return info;
	}
	
	/**
	Returns all information of all the playlists <br>
	<b> pre: </b> <br>
	<b> post: </b>Based on all the information of all the playlists in the MCS, a string with all the information of all the playlists is obtained <br>
	@return info
	*/
	public String getAllInfoOfPlaylists(){
		String info="";
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]!=null){
				info += playlistCollection[i].getPlaylistInfo();
			}
		}
		return info;
	}	
	
	/**
	Create a private playlist in the MCS <br>
	<b> pre: </b> Use "playlistName" as first parameter if you want to add a PrivatePlaylist <br>
	<b> post: </b>Returns true if the playlist was created correctly, false if it doesn't <br>
	@param playlistName String that indicates the name of the playlist.
	@param playlistUser An user, it must be one from the playlistCollection of the MCS
	@return true or false
	*/
	public boolean createPlaylist(String playlistName,User playlistUser){
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]==null){
				playlistCollection[i]=new PrivatePlaylist(playlistName,playlistUser);
				return true;
			}	
		}
		return false;
	}
	/**
	Create a  restricted playlist in the MCS <br>
	<b> pre: </b> Use "playlistUser" as first parameter if you want to add a RestrictedPlaylist<br>
	<b> post: </b>Returns true if the playlist was created correctly, false if it doesn't <br>
	@param playlistUser An user, it must be one from the playlistCollection of the MCS
	@param playlistName String that indicates the name of the playlist.
	@return true or false
	*/
	public boolean createPlaylist(User playlistUser,String playlistName){
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]==null){
				playlistCollection[i]=new RestrictedPlaylist(playlistUser,playlistName);
				return true;
			}	
		}
		return false;
	}
	
	/**
	Create a public playlist in the MCS <br>
	<b> pre: </b> <br>
	<b> post: </b>Returns true if the playlist was created correctly, false if it doesn't <br>
	@param playlistName String that indicates the name of the playlist.
	@return true or false
	*/
	public boolean createPlaylist(String playlistName){
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]==null){
				playlistCollection[i]=new PublicPlaylist(playlistName);
				return true;
			}	
		}
		return false;
	}
	
	/**
	Create a song in the MCS <br>
	<b> pre: </b> <br>
	<b> post: </b>Returns true if the song was created correctly, false if it doesn't <br>
	@param name String that indicates the name of the user that is going to add a song
	@param password String that indicates the password of the already mentioned user
	@param title String that indicates the title of the song that is going to be added
	@param authorName String that indicates the name of the artist or band of the song
	@param releaseDate String that indicates the release date of the song.releaseDate must be a date with a format DD/MM/YYYY
	@param genre An int that indicates the genre of the song. 1 <= genre <= 6
	@param songDuration A duration object that indicates the duration of the song
	@return true or false
	*/
	public boolean createSong(String name,String password,String title,String authorName,String releaseDate,int genre,Duration songDuration){
			for(int i=0;i<poolSongs.length;i++){
				if(poolSongs[i]==null){
					poolSongs[i]=new Song(title,authorName,releaseDate,genre,songDuration);
					users[findUser(name,password)].songsAddedCounter();
					return true;
				}
			}	
		return false;
	}
	
	/**
	Finds a user of the MCS <br>
	<b> pre: </b>It is only useful if there is at least one user in the MCS. <br>
	<b> post: </b> Returns an int, if it is "-1" then the user doesn't exist. If is another number, indicates the position in which the user is <br>
	@param name String that indicates the name of the user
	@param password String that indicates the password of the user
	@return index
	*/
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
	
	/**
	Finds a song of the MCS <br>
	<b> pre: </b>It is only useful if there is at least one song in the MCS. <br>
	<b> post: </b> Returns an int, if it is "-1" then the song doesn't exist. If is another number, indicates the position in which the song is <br>
	@param title String that indicates the title of the song
	@return index
	*/
	public int findSong(String title){
		int index=-1;
		for(int i=0;i<poolSongs.length;i++){
			if(poolSongs[i]!=null){
				if((title.equalsIgnoreCase(poolSongs[i].getTitle()))){
					index=i;
				}
			}
		}
		return index;	
	}
	
	/**
	Finds a playlist of the MCS <br>
	<b> pre: </b>It is only useful if there is at least one playlist in the MCS. <br>
	<b> post: </b> Returns an int, if it is "-1" then the playlist doesn't exist. If is another number, indicates the position in which the playlist is <br>
	@param playlistName String that indicates the name of the playlist
	@return index
	*/
	public int findPlaylist(String playlistName){
		int index=-1;
		for(int i=0;i<playlistCollection.length;i++){
			if(playlistCollection[i]!=null){
				if((playlistName.equalsIgnoreCase(playlistCollection[i].getPlaylistName()))){
					index=i;
				}
			}
		}
		return index;
	}
	
	/**
	Given an index, identify what type of playlist it is <br>
	<b> pre: </b> <br>
	<b> post: </b> Returns an int, if is 1 the playlist is a Private playlist, if is 2 the playlist is a restricted playlist, if is 3 the playlist is a public playlist <br>
	@param index int that indicates what playlist do you want to know its type.
	@return 1 or 2 or 3
	*/
	public int playlistInstanceOf(int index){
		if(playlistCollection[index] instanceof PrivatePlaylist){
			return 1;
		}
		else if(playlistCollection[index] instanceof RestrictedPlaylist){
			return 2;
		}
		return 3;
	}
	
	/**
	Given an index and a user, add that user to the playlist with that "index" <br>
	<b> pre: </b> <br>
	<b> post: </b> Returns true if the user was successfully added to playlist, false if not<br>
	@param index int that indicates what playlist do you want to add a user.
	@param appUser An user, it must be one from the playlistCollection of the MCS
	@return true or false
	*/
	public boolean castAndAddAUserToPlaylist(int index,User appUser){
		boolean aux=false;
		if(playlistInstanceOf(index)==2){
			RestrictedPlaylist rP = (RestrictedPlaylist) playlistCollection[index];
			aux=rP.addAUserToPlaylist(appUser);
			playlistCollection[index]= rP;
		}
		return aux;
	}
	
	/**
	Given an index and a song, add that song to the playlist with that "index" <br>
	<b> pre: </b> <br>
	<b> post: </b> Returns true if the song was successfully added to playlist, false if not<br>
	@param index int that indicates what playlist do you want to add a aong.
	@param appSong A Song, it must be one from the poolSongs of the MCS
	@return true or false
	*/
	public boolean giveASongToAPlaylist(int index,Song appSong){
		boolean aux=false;
		aux=playlistCollection[index].addASongToPlaylist(appSong);
		return aux;
	}
	
	/**
	Given an index and a rating, add that song to the public playlist with that "index" <br>
	<b> pre: </b> <br>
	<b> post: </b> Returns true if the rating was successfully added to the public playlist, false if not<br>
	@param index int that indicates what playlist do you want to add a rating.
	@param appSong A double that indicates what rating does the user give to the playlist
	*/
	public void giveARateToAPublicPlaylist(int index,double userRating){
		if(playlistInstanceOf(index)==3){
			PublicPlaylist pP= (PublicPlaylist) playlistCollection[index];
			pP.changeRating(userRating);
			playlistCollection[index]=pP;
		}
	}
	
	/**
	Given an index, return a User <br>
	<b> pre: </b> <br>
	<b> post: </b> Returns the user with the index indicated <br>
	@param index int that indicates what user are you going to return.
	@return users[index]
	*/
	public User giveAUserWithIndex(int index){
		return users[index];
	}
	
	/**
	Given an index, return a Song <br>
	<b> pre: </b> <br>
	<b> post: </b> Returns the Song with the index indicated <br>
	@param index int that indicates what Song are you going to return.
	@return poolSongs[index]
	*/
	public Song giveASongWithIndex(int index){
		return poolSongs[index];
	}
}