package SystemOne;
import java.time.LocalDate;
public class JCFOfficer extends User
{
	private int policeBadgeNum;
	private String policeStation;
	
	//Default Constructor
	public JCFOfficer()
	{
		trn = 700000000;
		name = new Name("Damion","Manderson");
		dob = LocalDate.parse("1985-01-07");
		addr = new Address(78, "Hope Road","Maven","St.Andrew");
		email = "damian.manderson@jcf.gov.jm";
		contactNum = "876-832-9082";
		gender = "Male";
		policeBadgeNum = 23256;
		policeStation = "Half Way Tree Police Station";
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

	public void Info()
	{
		System.out.println("The trn of driver is :" + trn);
		System.out.println("The name of the jcf officer is :" + name.getFirstName() + " " + name.getLastName());
		System.out.println("The date of birth of the jcf officer :" + dob);
		System.out.println("The address of jcf officer is :"+ addr.getStreetNum() + "," + addr.getStreetName() + "," + addr.getCommunity() + "," + addr.getParish());
		System.out.println("The email of jcf officer is  :" + email);
		System.out.println("The contact number of jcf officer is :"+ contactNum);
		System.out.println("The gender of jcf officer is :" + gender);
		System.out.println("The jcf officer badge number is :" + policeBadgeNum);
		System.out.println("The jcf officer police station is at :" + policeStation);
	}
	
	public String toCSV() 
	 {
	        return name.getFirstName() + "," + name.getLastName() + "," + policeBadgeNum + "," + policeStation;
	 }
	
	
	public void DisplayTicketOfficer()
	{
		System.out.println("The name of the jcf officer is :" + name.getFirstName() + " " + name.getLastName());
		System.out.println("The jcf officer badge number is  :" + policeBadgeNum);
		System.out.println("The jcf officer police station is at  :" + policeStation);
	}
	
	
	
	public static void main (String[] args)
	{
		JCFOfficer pol = new JCFOfficer();
		pol.DisplayTicketOfficer();
	}
}
