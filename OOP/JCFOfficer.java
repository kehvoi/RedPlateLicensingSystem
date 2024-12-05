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

//JCFOfficer inherits from the abstract class User 
public class JCFOfficer extends User
{
	//Attributes
	private int policeBadgeNum;
	private String policeStation;
	
	//Default Constructor
	public JCFOfficer()
	{
		super();
		policeBadgeNum = 0;
		policeStation = "";
	}
	
	//Primary Constructor
	public JCFOfficer(int trn, Name name, LocalDate dob, Address addr, String email, String contactNum, String gender, int policeBadgeNum, String policeStation)
	{
		super(trn,name, dob, addr,email,contactNum,gender);
		this.policeBadgeNum = policeBadgeNum;
		this.policeStation = policeStation;
	}
	
	//Copy Constructor
	public JCFOfficer(JCFOfficer jcf)
	{
		super(jcf);
		this.policeBadgeNum = jcf.policeBadgeNum;
		this.policeStation = jcf.policeStation;
	}
	
	//Info() Method
	//Overrides Info() Method that belongs to class User

	public void Info()
	{
		System.out.println("The trn of driver is :" + trn);
		System.out.println("The name of the jcf officer is :" + name.getFirstName() + " " + name.getLastName());
		System.out.println("The date of birth of the jcf officer :" + dob);
		System.out.println("The address of jcf officer is :"+ addr.getStreetNum() + "," + addr.getStreetName() + "," + addr.getParish());
		System.out.println("The email of jcf officer is  :" + email);
		System.out.println("The contact number of jcf officer is :"+ contactNum);
		System.out.println("The gender of jcf officer is :" + gender);
		System.out.println("The jcf officer badge number is :" + policeBadgeNum);
		System.out.println("The jcf officer police station is at :" + policeStation);
	}
	
	//toCSV Method
	
	public String toCSV() 
	 {
	        return name.getFirstName() + "," + name.getLastName() + "," + policeBadgeNum + "," + policeStation;
	 }
	
	//DisplayTicketOfficer() Method
	//This method is called in Class Main to display 
	//specific attributes of JCFOfficer. This is found in the TIOCS part of system
	public void DisplayTicketOfficer()
	{
		System.out.println("The name of the jcf officer is :" + name.getFirstName() + " " + name.getLastName());
		System.out.println("The jcf officer badge number is  :" + policeBadgeNum);
		System.out.println("The jcf officer police station is at  :" + policeStation);
	}
	
	//Overloading Method DisplayTicketOfficer
	public void DisplayTicketOfficer(Name name)
	{
		System.out.println("The name of the jcf officer is :" + name.getFirstName() + " " + name.getLastName());
		
	}
}
