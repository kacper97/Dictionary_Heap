package models;

public class Pair implements Comparable<Pair>{
	
	public String spanish;
	public String english;
	
	public Pair(String spanish, String english){
		this.spanish = spanish;
		this.english = english;
	}
	
	public String getSpanish() {
		return spanish;
	}
	
	public void setSpanish(String spanish) {
		this.spanish = spanish;
	}
	
	public String getEnglish() {
		return english;
	}
	
	public void setEnglish(String english) {
		this.english = english;
	}
	
	//Compares this object with the specified object for order. Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object. 
	public int compareTo(Pair E) {
		if (this.spanish.compareTo(E.spanish) == -1){
			return 1;
		}
		else if(this.spanish.compareTo(E.spanish) == 1){
			return -1;
		}
		return 0;
	}
	
	//Returns a string representation of the object
	@Override
	public String toString()
	{
		return " Pair [" + spanish + " : " + english+ "] \n";
	}
}
