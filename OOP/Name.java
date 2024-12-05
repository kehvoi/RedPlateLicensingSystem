package System;

/*
Group Members:
	Chevannese Ellis, 2301109
	Kehvoi Thompson, 2304224
	Janae Bernard, 2209025
	Karlicia Sutherland, 2302691
	Kay-Ann Green, 2110490
	
	Day/Time of Practical Class: Wed3pm
*/

public class Name {

	//Attributes
	private String firstName;
	private String lastName;
	
	//Default Constructor
	
	public Name()
	{
		firstName = "";
		lastName = "";
	}
	
	//Primary Constructor
	
	public Name(String firstName,String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//Copy Constructor
	
	public Name(Name na)
	{
		this.firstName = na.firstName;
		this.lastName = na.lastName;
	}
	
	//Generating Getters and Setters
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	//toString Method
	public String toString()
	{
		String output;
		
		output = "The fullname is :" + firstName + " " + lastName;
		System.out.println(output);
		return output;
	}

}
