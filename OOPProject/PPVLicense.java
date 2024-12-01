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

public class PPVLicense 
{
	//Attributes
	private int trn;
	private String badgeNum;
	private LocalDate badgeIssueDate;
	private LocalDate badgeDueDate;
	private String badgeParish;
	
	//Default Constructor
	public PPVLicense()
	{
		trn = 123456789;
		badgeNum = "PL0001";
		badgeIssueDate = LocalDate.parse("2022-01-01");
		badgeDueDate = badgeIssueDate.plusYears(4);
		badgeParish = "Kingston";
	}
	
	//Primary Constructor
	public PPVLicense(int trn, String badgeNum, LocalDate badgeIssueDate, LocalDate badgeDueDate, String badgeParish)
	{
		this.trn = trn;
		this.badgeNum = badgeNum;
		this.badgeIssueDate = badgeIssueDate;
		this.badgeDueDate = badgeDueDate;
		this.badgeParish = badgeParish;
	}
	
	//Copy Constructor
	public PPVLicense(PPVLicense ppv)
	{
		this.trn = ppv.trn;
		this.badgeNum = ppv.badgeNum;
		this.badgeIssueDate = ppv.badgeIssueDate;
		this.badgeDueDate = ppv.badgeDueDate;
		this.badgeParish = ppv.badgeParish;
	}
	
	//toString Method
	public String toString()
	{
		String output;
		output = "The driver trn is " + trn;
		output += "\nThe badge number is :" + badgeNum;
		output += "\nThe badge issue date is :" + badgeIssueDate;
		output += "\nThe badge due date is :" + badgeDueDate;
		output += "\nThe badge parish is " + badgeParish;
		System.out.println(output);
		return output;
	}
	
	//ToCSV Method
	public String toCSV() 
	 {
	        return trn + "," + badgeNum + "," + badgeIssueDate + "," + badgeDueDate + "," + badgeParish;
	 }
	

}
