package SystemOne;

public class Ticket 
{
	private int ticketNum;
	private Date ticketDate;
	private String offenseCode;
	private String offenseDesc;
	private String ticketStatDesc;
	private float fineAmt;
	
	private Date courtDate;
	private Address courtLocation;
	private float totalUnpaidTic;
	private float totalFineAmt;
	private boolean warrant;
	
	
	//Default Constructor
	
	public Ticket()
	{
		ticketNum = 0;
		ticketDate = new Date();
		offenseCode = "";
		offenseDesc = "";
		ticketStatDesc = "";
		fineAmt = 0.0f;
		
		courtDate = new Date();
		courtLocation = new Address();
		totalUnpaidTic = 0.0f;
		totalFineAmt = 0.0f;
		warrant = false;
		
	}
	
	//Primary Constructor
	
	public Ticket(int ticketNum, Date ticketDate, String offenseCode, 
			String offenseDesc, String ticketStatDesc, float fineAmt,
			Date courtDate, Address courtLocation, float totalUnpaidTic, float totalFineAmt, boolean warrant)
	{
		this.ticketNum = ticketNum;
		this.ticketDate = ticketDate;
		this.offenseCode = offenseCode;
		this.offenseDesc = offenseDesc;
		this.ticketStatDesc = ticketStatDesc;
		this.fineAmt = fineAmt;
		
		this.courtDate = courtDate;
		this.courtLocation = courtLocation;
		this.totalUnpaidTic = totalUnpaidTic;
		this.totalFineAmt = totalFineAmt;
		this.warrant = warrant;
		
	}
	
	//Generating Getters and Setters
	
	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public Date getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
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

	public String getTicketStatDesc() {
		return ticketStatDesc;
	}

	public void setTicketStatDesc(String ticketStatDesc) {
		this.ticketStatDesc = ticketStatDesc;
	}

	public float getFineAmt() {
		return fineAmt;
	}

	public void setFineAmt(float fineAmt) {
		this.fineAmt = fineAmt;
	}

	public Date getCourtDate() {
		return courtDate;
	}

	public void setCourtDate(Date courtDate) {
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

	//To String Method
	public String toString()
	{
		String output;
		output = "The ticket number is : " + ticketNum;
		output += "\nThe ticket was issued on : " + ticketDate.getMonth() + "/" + ticketDate.getDay() + "/" + ticketDate.getYear();
		output += "\nThe ticket offense code is : " + offenseCode;
		output += "\nThe ticket offense description is : " + offenseDesc;
		output += "\nThe ticket status description is : " + ticketStatDesc;
		
		output += "\nThe fine amount is :" + fineAmt;
		output += "\nThe court date is : " + courtDate.getMonth() + "/" + courtDate.getDay() + "/" + courtDate.getYear();
		output += "\nThe court location is :" + courtLocation.getStreetNum() + "," + courtLocation.getStreetName() + "," + courtLocation.getCommunity() + "," + courtLocation.getParish();
		output += "\nThe total unpaid ticket is :" + totalUnpaidTic;
		output += "\nThe total fine amount is :" + totalFineAmt;
		output += "\nWas a warrant issued? : " + warrant;
		
		System.out.println(output);
		return output;
	}
	
	public void ticketPayment()
	{
		
	}
	
	public void View()
	{
		
	}
	
	

}
