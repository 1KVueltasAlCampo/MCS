package ui;
import model.*;
import java.util.Scanner;
public class Menu{
	private final static int CREATE_A_USER = 1;
	private final static int SHOW_USERS = 2;
	private final static int CREATE_A_SONG = 3;
	private final static int SHOW_SONGS=4;
	private final static int CREATE_A_PLAYLIST=5;
	private final static int ADD_A_USER_TO_A_PLAYLIST=6;
	private final static int ADD_A_SONG_TO_A_PLAYLIST=7;
	private final static int SHOW_PLAYLISTS=8;
	private final static int EXIT=9;
	private MusicCollectAndShare mcs;
	private static Scanner sc = new Scanner(System.in);
	
	public Menu(){
		mcs=new MusicCollectAndShare();
	}
	public void showBeginningImage(){
		String image = "";
		image += "((((((((((((((((((((((((((((((((((((((((((((((((("+"\n";
		image += "((((((((((((((((/(((((((((((((((((((((((((((((((("+"\n";
		image += "(((/  .(((((((*  .((((((*        (((((/      /((("+"\n";
		image += "(((/   .((((((.  .(((((   ,((((((((((*  .((((((("+"\n";
		image += "(((/    /((((/   .((((/  ,(((((((((((.  /(((((((("+"\n";
		image += "(((/     ((((*   .((((*  ,(((((((((((/   (((((((("+"\n";
		image += "(((/  *  *(((     ((((*  ,((((((((((((,  .((((((("+"\n";
		image += "(((/  /.  ((*     ((((*  *(((((((((((((,   (((((("+"\n";
		image += "(((/  //  ,(  .   ((((*  *((((((((((((((/   /(((("+"\n";
		image += "(((/  *(*  ,  (   ((((*  *((((((((((((((((   /((("+"\n";
		image += "(((/  ,(/    ,(   /(((*  ,(((((((((((((((((   ((("+"\n";
		image += "(((/  .((    ((   /((((  .(((((((((((((((((.  /(("+"\n";
		image += "(((/  .((.  .((.  *((((,  *((((((((((((((((   /(("+"\n";
		image += "(((/  .((((((((.  *(((((   *((((/,/(((((((/   ((("+"\n";
		image += "(((/  .((((((((.  *((((((.        *((   .   .(((("+"\n";
		image += "(((((((((((((((/*/((((((((((///(((((((////((((((("+"\n";
		image += "((((((((((((((((((((((((((((((((((((((((((((((((("+"\n";
		image += "               ./(###((///((###(*                "+"\n";
		image += "           *#(,                   *((,           "+"\n";
		image += "        ,#/                           ((         "+"\n";
		image += "      .#*          .**/////*,.          ((       "+"\n";
		image += "     *(.      .//////////////////*       *#      "+"\n";
		image += "    .#,     *///////////////////////,     /(     "+"\n";
		image += "    /(    *///////////////////////////    .#.    "+"\n";
		image += "  ,/////,*/////////////////////////////,*////*.  "+"\n";
		image += "  /////////////////////////*,...,/////////////,  "+"\n";
		image += "  //////*,,,********,,.............,,,,,//////,  "+"\n";
		image += "  //////*.........//*........//*.......,//////,  "+"\n";
		image += "  //////*.........,,.........,,........,//////,  "+"\n";
		image += "   //////*..............................,//////, "+"\n";
		image += "   *///*  ........,/.........**.......  .*///,   "+"\n";
		image += "            .......,/*.....,/*.......            "+"\n";
		image += "               ........,,,,.......               "+"\n";
		image += "                    .........                    "+"\n";
		image += "\n";
		image += "*************************************************"+"\n";
		System.out.println(image);
	}
	public void showMenu(){
		System.out.println("______________________________________________________________");
		System.out.println("Enter 1 to create a user");
		System.out.println("Enter 2 to show app users");
		System.out.println("Enter 3 to create a song");
		System.out.println("Enter 4 to show the songs in the pool");
		System.out.println("Enter 5 to create a playlist");
		System.out.println("Enter 6 to add a user to the playlist");
		System.out.println("Enter 7 to add a song to the playlist");
		System.out.println("Enter 8 to show the playlists");
		System.out.println("Enter 9 to exit");
		System.out.println("______________________________________________________________");	
	}
	public void addAUser(){
		boolean aux = false;
		String password;
		String confirmPassword;
		System.out.println("Enter a username, remember your username is only the first word: ");
		String username=sc.next();
		System.out.println("Enter the user's age: ");
		int age = sc.nextInt();
		sc.nextLine();
		do{
		System.out.println("Enter a password: ");
		password=sc.nextLine();
		System.out.println("Confirm the password: ");
		confirmPassword=sc.nextLine();
		}
		while(!(password.equals(confirmPassword)));
		aux= mcs.createUser(username,password,age);
		System.out.println("The user ");
		checkRegister(aux);
	}
	public void checkRegister(boolean aux){
		if(aux){
			System.out.println("	was added successfully");
		}
		else{
			System.out.println("	could not be added, possibly due to an error");
		}
	}
	public void addASong(){
		int index = -1;
		System.out.println("Enter which user is going to add a song: ");
		String username = sc.nextLine();
		System.out.println("Enter password: ");
		String password = sc.nextLine();
		index = mcs.findUser(username,password);
		if(index != -1){
			createASong(username,password);
		}
		else {
			System.out.println("The song could not be added, invalid user or password ");
		}
	}
	public void createASong(String username,String password){
		boolean aux = false;
		System.out.println("Enter the name of the song: ");
		String songName = sc.nextLine();
		System.out.println("Enter the name of the artist or band of the song: ");
		String authorName = sc.nextLine();
		System.out.println("Enter the release date of the song in a DD/MM/YYYY format");
		String releaseDate = sc.nextLine();
		System.out.println("Enter the genre of the song, use 1 for rock, 2 for hiphop, 3 for classical music, 4 for reggae, 5 for salsa and 6 for metal: ");
		int genreIndicator = sc.nextInt();
		sc.nextLine();
		Duration songDuration=readTheDuration();
		aux = mcs.createSong(username,password,songName,authorName,releaseDate,genreIndicator,songDuration);
		System.out.println("The song ");
		checkRegister(aux);
	}
	public Duration readTheDuration(){
		System.out.println("Enter the duration of the song in a MM:SS format: ");
		String songDuration = sc.nextLine();
		int position = songDuration.indexOf(":");
		int minute = Integer.parseInt(songDuration.substring(0,position));
		songDuration = songDuration.substring(position+1);
		int second = Integer.parseInt(songDuration);
		Duration songLength = new Duration(minute,second);
		return songLength;
	}
	public void doOperation(int choice){
		switch(choice){
			case CREATE_A_USER:
				addAUser();
				break;
			case SHOW_USERS:
				System.out.println(mcs.getAllInfoOfUsers());
				break;
			case CREATE_A_SONG:
				addASong();
				break;
			case SHOW_SONGS:
				System.out.println(mcs.getAllInfoOfSongs());
				break;
			case CREATE_A_PLAYLIST:
			
				break;
			case ADD_A_USER_TO_A_PLAYLIST:

				break;
			case ADD_A_SONG_TO_A_PLAYLIST:

				break;
			case SHOW_PLAYLISTS:

				break;
			case EXIT:
				break;
			default:
				System.out.println("Please enter a valid option");
		}
	}
	public int readOption(){
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}
	public void startProgram(){
		int option=0;
		showBeginningImage();
		do{
			showMenu();
			option=readOption();
			doOperation(option);
		}while(option!=9);
	}
}