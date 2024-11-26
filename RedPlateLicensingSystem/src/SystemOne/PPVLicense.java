package SystemOne;

import java.time.LocalDate;

public class PPVLicense 
{
	//Attributes
	private String badgeNum;
	private LocalDate badgeIssueDate;
	private LocalDate badgeDueDate;
	private String badgeParish;
	
	//Default Constructor
	public PPVLicense()
	{
		badgeNum = "";
		badgeIssueDate = LocalDate.now();
		badgeDueDate = badgeIssueDate.plusYears(4);
		badgeParish = "";
	}
	
	//Primary Constructor
	public PPVLicense(String badgeNum, LocalDate badgeIssueDate, LocalDate badgeDueDate, String badgeParish)
	{
		this.badgeNum = badgeNum;
		this.badgeIssueDate = badgeIssueDate;
		this.badgeDueDate = badgeDueDate;
		this.badgeParish = badgeParish;
	}
	
	//Copy Constructor
	public PPVLicense(PPVLicense ppv)
	{
		this.badgeNum = ppv.badgeNum;
		this.badgeIssueDate = ppv.badgeIssueDate;
		this.badgeDueDate = ppv.badgeDueDate;
		this.badgeParish = ppv.badgeParish;
	}
	
	//toString Method
	public String toString()
	{
		String output;
		output = "The badge number is :" + badgeNum;
		output += "The badge issue date is :" + badgeIssueDate;
		output += "The badge due date is :" + badgeDueDate;
		System.out.println(output);
		return output;
	}
	

}
