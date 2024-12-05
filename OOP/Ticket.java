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

public class Ticket {
	
	//Attributes
		private int trn;
		private int ticketNum;
		
		private LocalDate ticketIssueDate;
		private LocalDate ticketDueDate;
		private int offenseCode;
		private String offenseDesc;
		private String ticketPayStatus;
		private int fineAmt;
		
		private LocalDate courtDate;
		private Address courtLocation;
		private int totalUnpaidTic;
		private int totalFineAmt;
		private boolean warrant;
			
		//Default Constructor
		public Ticket()
		{
			trn = 0;
			ticketNum = 0;
			
			ticketIssueDate = LocalDate.now();
	    	ticketDueDate =  ticketIssueDate.plusWeeks(3);
			offenseCode = 0;
			offenseDesc = "";
			ticketPayStatus = "";
			fineAmt = 0;
			
			courtDate = ticketDueDate.plusWeeks(1);
			courtLocation = new Address();
			totalUnpaidTic = 0;
			totalFineAmt = 0;
			warrant = false;
		}
		
		//Primary Constructor
		public Ticket(int trn,int ticketNum,  LocalDate ticketIssueDate, LocalDate ticketDueDate,
				int offenseCode, 
				String offenseDesc, String ticketPayStatus,int fineAmt, LocalDate courtDate,
				Address courtLocation, int totalUnpaidTic, int totalFineAmt, boolean warrant)
		{
			this.trn = trn;
			this.ticketNum = ticketNum;
			
			this.ticketIssueDate = ticketIssueDate;
			this.ticketDueDate = ticketDueDate;
			this.offenseCode = offenseCode;
			this.offenseDesc = offenseDesc;
			this.ticketPayStatus = ticketPayStatus;
			this.fineAmt = fineAmt;
			
			this.courtDate = courtDate;
			this.courtLocation = courtLocation;
			this.totalUnpaidTic = totalUnpaidTic;
			this.totalFineAmt = totalFineAmt;
			this.warrant = warrant;
		}
		
		//Copy Constructor
		public Ticket(Ticket tic)
		{
			this.trn = tic.trn;
			this.ticketNum = tic.ticketNum;
			
			this.ticketIssueDate = tic.ticketIssueDate;
			this.ticketDueDate = tic.ticketDueDate;
			this.offenseCode = tic.offenseCode;
			this.offenseDesc = tic.offenseDesc;
			this.ticketPayStatus = tic.ticketPayStatus;
			this.fineAmt = tic.fineAmt;
			
			this.courtDate = tic.courtDate;
			this.courtLocation = tic.courtLocation;
			this.totalUnpaidTic = tic.totalUnpaidTic;
			this.totalFineAmt = tic.totalFineAmt;
			this.warrant = tic.warrant;
			
		}
		
		//Generating Getters and Setters

		public int getTrn() {
			return trn;
		}

		public void setTrn(int trn) {
			this.trn = trn;
		}

		public int getTicketNum() {
			return ticketNum;
		}

		public void setTicketNum(int ticketNum) {
			this.ticketNum = ticketNum;
		}

		public LocalDate getTicketIssueDate() {
			return ticketIssueDate;
		}

		public void setTicketIssueDate(LocalDate ticketIssueDate) {
			this.ticketIssueDate = ticketIssueDate;
		}

		public LocalDate getTicketDueDate() {
			return ticketDueDate;
		}

		public void setTicketDueDate(LocalDate ticketDueDate) {
			this.ticketDueDate = ticketDueDate;
		}

		public int getOffenseCode() {
			return offenseCode;
		}

		public void setOffenseCode(int offenseCode) {
			this.offenseCode = offenseCode;
		}

		public String getOffenseDesc() {
			return offenseDesc;
		}

		public void setOffenseDesc(String offenseDesc) {
			this.offenseDesc = offenseDesc;
		}

		public String getTicketPayStatus() {
			return ticketPayStatus;
		}

		public void setTicketPayStatus(String ticketPayStatus) {
			this.ticketPayStatus = ticketPayStatus;
		}

		public int getFineAmt() {
			return fineAmt;
		}

		public void setFineAmt(int fineAmt) {
			this.fineAmt = fineAmt;
		}

		public LocalDate getCourtDate() {
			return courtDate;
		}

		public void setCourtDate(LocalDate courtDate) {
			this.courtDate = courtDate;
		}

		public Address getCourtLocation() {
			return courtLocation;
		}

		public void setCourtLocation(Address courtLocation) {
			this.courtLocation = courtLocation;
		}

		public int getTotalUnpaidTic() {
			return totalUnpaidTic;
		}

		public void setTotalUnpaidTic(int totalUnpaidTic) {
			this.totalUnpaidTic = totalUnpaidTic;
		}

		public int getTotalFineAmt() {
			return totalFineAmt;
		}

		public void setTotalFineAmt(int totalFineAmt) {
			this.totalFineAmt = totalFineAmt;
		}

		public boolean isWarrant() {
			return warrant;
		}

		public void setWarrant(boolean warrant) {
			this.warrant = warrant;
		}
		
		//toString display method
		

		public String toString()
		{
			String output;
			output = "\nThe trn is :" +trn;
			output += "The ticket number is : " + ticketNum;
			
			output += "\nThe ticket was issued on : " + ticketIssueDate;
			output += "\nThe ticket due date is : " + ticketDueDate;
			output += "\nThe ticket offense code is : " + offenseCode;
			output += "\nThe ticket offense description is : " + offenseDesc;
			output += "\nWas the ticket paid? : " + ticketPayStatus;
			output += "\nThe fine amount is :" + fineAmt;
			
			output += "\nThe court date is : " + courtDate;
			output += "\nThe court location is :" + courtLocation.getStreetNum() + "," + courtLocation.getStreetName() + "," + courtLocation.getParish();
			output += "\nThe total unpaid ticket is :" + totalUnpaidTic;
			output += "\nThe total fine amount is :" + totalFineAmt;
			output += "\nWas a warrant issued? : " + warrant;
			
			System.out.println(output);
			return output;
		}
		
		//toCSV Method
		public String toCSV()
		{
			return trn + "," + ticketNum + "," + ticketIssueDate + "," + ticketDueDate+ "," +  offenseCode+ "," + offenseDesc + 
					"," +  ticketPayStatus + "," +fineAmt + "," + courtDate + "," 
					+ courtLocation.getStreetNum() + "," + courtLocation.getStreetName() + "," + courtLocation.getParish() + "," + totalUnpaidTic + "," + totalFineAmt + "," + warrant ;
		}
		
		//DisplayTicket Method
		//This method is called in Class Main to display 
		//specific attributes of Ticket. This is found in the TIOCS part of system
		public void DisplayTicket()
		{
			System.out.println("The ticket number is : " + ticketNum);
			System.out.println("The ticket was issued on : " + ticketIssueDate);
			System.out.println("The ticket due date is : " + ticketDueDate);
			System.out.println("The ticket offense code is : " + offenseCode);
			System.out.println("The ticket offense description is : " + offenseDesc);
			System.out.println("The fine amount is :" + fineAmt);
			System.out.println("Was the ticket paid? : " + ticketPayStatus);
		}
		

}
