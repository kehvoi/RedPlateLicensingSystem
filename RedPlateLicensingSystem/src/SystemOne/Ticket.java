package SystemOne;

import java.time.LocalDate;

public class Ticket {
	
	//Ticket Attributes
		private int ticketNum;
		private int trn;
		private LocalDate ticketIssueDate;
		private LocalDate ticketDueDate;
		private String offenseCode;
		private String offenseDesc;
		private boolean ticketPayStatus;
		private float fineAmt;
		
		private LocalDate courtDate;
		private Address courtLocation;
		private float totalUnpaidTic;
		private float totalFineAmt;
		private boolean warrant;
			
		//Default Constructor
		public Ticket()
		{
			ticketNum = 0;
			trn = 0;
			ticketIssueDate = LocalDate.now();
	    	ticketDueDate =  ticketIssueDate.plusWeeks(3);
			offenseCode = "";
			offenseDesc = "";
			ticketPayStatus = false;
			fineAmt = 0;
			
			courtDate = ticketDueDate.plusWeeks(1);
			courtLocation = new Address();
			totalUnpaidTic = 0;
			totalFineAmt = 0;
			warrant = false;
		}
		
		//Primary Constructor
		public Ticket(int ticketNum, int trn, LocalDate ticketIssueDate, LocalDate ticketDueDate, String offenseCode, 
				String offenseDesc, Boolean ticketPayStatus, Boolean warrantStatus,float fineAmt, LocalDate courtDate,
				Address courtLocation, float totalUnpaidTic, float totalFineAmt, boolean warrant)
		{
			this.ticketNum = ticketNum;
			this.trn = trn;
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
			this.ticketNum = tic.ticketNum;
			this.trn = tic.trn;
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
		public int getTicketNum() {
			return ticketNum;
		}

		public void setTicketNum(int ticketNum) {
			this.ticketNum = ticketNum;
		}
		
		public int getTrn()
		{
			return trn;
		}
		
		public void setTrn(int trn)
		{
			this.trn = trn;
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

		public String getOffenseCode() {
			return offenseCode;
		}

		public void setOffenseCode(String offenseCode) {
			this.offenseCode = offenseCode;
		}

		public String getOffenseDesc() {
			return offenseDesc;
		}

		public void setOffenseDesc(String offenseDesc) {
			this.offenseDesc = offenseDesc;
		}

		public boolean isTicketPayStatus() {
			return ticketPayStatus;
		}

		public void setTicketPayStatus(boolean ticketPayStatus) {
			this.ticketPayStatus = ticketPayStatus;
		}

		public float getFineAmt() {
			return fineAmt;
		}

		public void setFineAmt(float fineAmt) {
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

		public float getTotalUnpaidTic() {
			return totalUnpaidTic;
		}

		public void setTotalUnpaidTic(float totalUnpaidTic) {
			this.totalUnpaidTic = totalUnpaidTic;
		}

		public float getTotalFineAmt() {
			return totalFineAmt;
		}

		public void setTotalFineAmt(float totalFineAmt) {
			this.totalFineAmt = totalFineAmt;
		}

		public boolean isWarrant() {
			return warrant;
		}

		public void setWarrant(boolean warrant) {
			this.warrant = warrant;
		}
		
		
		public void CheckTicketDate(LocalDate ticketIssueDate, LocalDate ticketDueDate)
		{
			if (ticketDueDate.isBefore(LocalDate.now())) {
	            System.out.println("\nThe ticket has expired.");
	        } else {
	            System.out.println("\nThe ticket is still valid.");
	        }
		}
		
		
		
		//toString display method
		

		public String toString()
		{
			String output;
			output = "The ticket number is : " + ticketNum;
			output += "\nThe trn is :" +trn;
			output += "\nThe ticket was issued on : " + ticketIssueDate;
			output += "\nThe ticket due date is : " + ticketDueDate;
			output += "\nThe ticket offense code is : " + offenseCode;
			output += "\nThe ticket offense description is : " + offenseDesc;
			output += "\nWas the ticket paid? : " + ticketPayStatus;
			output += "\nThe fine amount is :" + fineAmt;
			
			output += "\nThe court date is : " + courtDate;
			output += "\nThe court location is :" + courtLocation.getStreetNum() + "," + courtLocation.getStreetName() + "," + courtLocation.getCommunity() + "," + courtLocation.getParish();
			output += "\nThe total unpaid ticket is :" + totalUnpaidTic;
			output += "\nThe total fine amount is :" + totalFineAmt;
			output += "\nWas a warrant issued? : " + warrant;
			
			System.out.println(output);
			return output;
		}
		
		
		
		
		public static void main(String[] args)
		{
			Ticket newtic = new Ticket();
			newtic.toString();
			System.out.println("\n");
			newtic.CheckTicketDate(newtic.getTicketIssueDate(), newtic.ticketDueDate);
			System.out.println(newtic.getTicketIssueDate() + "and" +  newtic.ticketDueDate);
		}

}
