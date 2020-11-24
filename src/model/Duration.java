package model;
public class Duration{
	private int minute;
	private int second;
	/**
	Constructor method of the class "Duration" <br>
	<b> pre: </b><br>
	<b> post: </b> Create an object of type Duration <br>
	*/
	public Duration(int minute,int second){
		this.minute=minute;
		this.second=second;
	}
	/**
	Return the minutes <br>
	<b> pre: </b> <br>
	<b> post: </b> The minutes are returned <br>
	@return minute
	*/
	public int getMinute(){
		return minute;
	}
	/**
	Change the minutes <br>
	<b> pre: </b> <br>
	<b> post: </b> The minutes are changed <br>
	@param minute int that indicates the minutes
	*/
	public void setMinute(int minute){
		this.minute=minute;
	}
	/**
	Return the seconds <br>
	<b> pre: </b> <br>
	<b> post: </b> The seconds are returned <br>
	@return second
	*/
	public int getSecond(){
		return second;
	}
	/**
	Change the seconds <br>
	<b> pre: </b> <br>
	<b> post: </b> The seconds are changed <br>
	@param second int that indicates the seconds
	*/
	public void setSecond(int second){
		this.second=second;
	}
	/**
	Returns all the information of the duration<br>
	<b> pre: </b> <br>
	<b> post: </b> Based on all the information of the duration, a string with all the information is obtained <br>
	@return info
	*/
	public String getDurationInfo(){
		String info = getMinute()+":"+getSecond();
		return info;
	}
}