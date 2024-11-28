package SystemOne;

import java.time.LocalDate;

public class Driver extends User
{
	
	
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
	 
	public void Info()
	{
		System.out.println("The trn of driver is :" + trn);
		System.out.println("The name of the driver is :" + name.getFirstName() + " " + name.getLastName());
		System.out.println("The date of birth of the driver :" + dob);
		
		System.out.println("The address of driver is :"+ addr);
		System.out.println("The email of driver is  :" + email);
		System.out.println("The contact number of driver is :"+ contactNum);
		System.out.println("The gender of driver is :" + gender);
	}
	
	 public String toCSV() 
	 {
	        return trn + "," + name.getFirstName() + "," + name.getLastName() + "," + dob + "," +
	               addr.getStreetNum() + "," + addr.getStreetName() + "," + addr.getCommunity() + "," +
	               addr.getParish() + "," + contactNum + "," + gender;
	 }

	
}
