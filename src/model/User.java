package model;
public class User {
	private String userName;
	private String password;
	private int age;
	private int songsAdded;
	private int categoryIndicator;
	private Category category;
	
	/**
	Constructor method of the class "User" <br>
	<b> pre: </b> <br>
	<b> post: </b> Create an object of type RestrictedPlaylist <br>
	@param userName String that indicates the name of the user. userName cannot contain spaces
	*/
	public User(String userName,String password,int age){
		this.userName = userName;
		this.password = password;
		this.age = age;
		categoryIndicator=1;
		category=Category.values()[categoryIndicator-1];
	}
	/**
	Return the username <br>
	<b> pre: </b> <br>
	<b> post: </b> The username is returned <br>
	@return userName
	*/
	public String getUserName(){
		return userName;
	}
	/**
	Change the username <br>
	<b> pre: </b> <br>
	<b> post: </b> The username is changed <br>
	@param userName String that indicates the username
	*/
	public void setUserName(String userName){
		this.userName=userName;
	}
	/**
	Return the password of the user <br>
	<b> pre: </b> <br>
	<b> post: </b> The password is returned <br>
	@return password
	*/
	public String getPassword(){
		return password;
	}
	/**
	Change the password of the user <br>
	<b> pre: </b> <br>
	<b> post: </b> The password is changed <br>
	@param password String that indicates the password of the user
	*/
	public void setPassword(String password){
		this.password=password;
	}
	/**
	Return the age of the user <br>
	<b> pre: </b> <br>
	<b> post: </b> The age is returned <br>
	@return age
	*/
	public int getAge(){
		return age;
	}
	/**
	Change the age of the user <br>
	<b> pre: </b> <br>
	<b> post: </b> The age is changed <br>
	@param age int that indicates the age of the user
	*/
	public void setAge(int age){
		this.age=age;
	}
	/**
	Change the category of the user <br>
	<b> pre: </b> <br>
	<b> post: </b> The category is changed <br>
	@param categoryIndicator int that indicates the category of the user
	*/
	public void setCategory(int categoryIndicator){
		category=Category.values()[categoryIndicator-1];
	}
	/**
	Adds 1 to the number of songs the user has added to the MCS <br>
	<b> pre: </b> <br>
	<b> post: </b> The number of songs uploaded by the user has been increased <br>
	*/
	public void songsAddedCounter(){
		songsAdded++;
	}
	/**
	Change the category according to how many songs the user has added <br>
	<b> pre: </b> <br>
	<b> post: </b> User category has been updated <br>
	*/
	public void changeCategory(){
		int levelCategory=0;
		if(songsAdded<3){
			levelCategory=1;
		}
		else if(songsAdded<10){
			levelCategory=2;
		}
		else if(songsAdded<30){
			levelCategory=3;
		}
		else{
			levelCategory=4;
		}
		setCategory(levelCategory);
	}
	/**
	Returns all the information of the user <br>
	<b> pre: </b> <br>
	<b> post: </b> Based on all the information of the user, a string with all the information is obtained <br>
	@return info
	*/
	public String getUserInformation(){
		changeCategory();
		String info = "";
		info += "*************  User **************"+"\n";
		info += "**  userName: "+getUserName()+"\n";
		info += "**  Age: "+getAge()+"\n";
		info += "**  Category: "+category.toString()+"\n";
		info += "***********************************"+"\n";
		return info;
	}
	
}