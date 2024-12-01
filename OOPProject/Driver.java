package System;

import java.time.LocalDate;

/*
Group Members:
	Chevannese Ellis, 2301109
	Kehvoi Thompson, 2304224
	Janae Bernard, 2209025
	Karlicia Sutherland, 2302691
	Kay-Ann Green, 2110490
	
	Day/Time of Practical Class: Wed3pm
*/

//Driver inherits from the abstract class User
public class Driver extends User
{
	//No attributes from Driver Class
	
	//Default Constructor
	
	public Driver()
	{
		trn = 100000011;
		name = new Name("King","Charles");
		dob = LocalDate.parse("1995-09-09");
		addr = new Address(456, "Mountain View Avenue", "Westermoreland");
		email = "king.charles@yahoo.com";
		contactNum = "8762493133";
		gender = "Male";
	}
	
	//Primary Constructor
	public Driver(int trn,Name name, LocalDate dob,  Address addr, String email, String contactNum, String gender)
	{
		super(trn,name, dob, addr,email,contactNum,gender);
	}
	
	//Copy Constructor
	public Driver(Driver dri)
	{
		super(dri);
	
	}
	
	
	//Info() Method
	//Overrides Info() Method that belongs to class User
	public void Info()
	{
		System.out.println("The trn of driver is :" + trn);
		System.out.println("The name of the driver is :" + name.getFirstName() + " " + name.getLastName());
		System.out.println("The date of birth of the driver :" + dob);
		
		System.out.println("The address of driver is :"+  addr.getStreetNum() + "," + addr.getStreetName() + "," + addr.getParish());
		System.out.println("The email of driver is  :" + email);
		System.out.println("The contact number of driver is :"+ contactNum);
		System.out.println("The gender of driver is :" + gender);
	}
	
	//toCSV Method
	 public String toCSV() 
	 {
	        return trn + "," + name.getFirstName() + "," + name.getLastName() + "," + dob + "," +
	               addr.getStreetNum() + "," + addr.getStreetName() + "," +
	               addr.getParish() + "," + email + "," + contactNum + "," + gender;
	 }
	 
	 //DisplayTicketDriver Method
	//This method is called in Class Main to display 
	//specific attributes of Driver. This is found in the TIOCS part of system
	 
	 public void DisplayTicketDriver()
	 {
		 System.out.println("The trn of driver is :" + trn);
		 System.out.println("The name of the driver is :" + name.getFirstName() + " " + name.getLastName());
		 System.out.println("The date of birth of the driver :" + dob);
		 System.out.println("The address of driver is :"+  addr.getStreetNum() + "," + addr.getStreetName() + "," + addr.getParish());
		 System.out.println("The contact number of driver is :"+ contactNum);
	 }
}
