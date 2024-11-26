package SystemOne;

public class Address 
{
	//Attributes
	private int streetNum;
	private String streetName;
	private String community;
	private String parish;
	
	//Default Constructor
	public Address()
	{
		streetNum = 0;
		streetName = "";
		community = "";
		parish = "";
	}
	
	//Primary Constructor
	public Address(int streetNum, String streetName, String community, String parish)
	{
		this.streetNum = streetNum;
		this.streetName = streetName;
		this.community = community;
		this.parish = parish;
	}
	
	//Copy Constructor
	public Address(Address addr)
	{
		this.streetNum = addr.streetNum;
		this.streetName = addr.streetName;
		this.community = addr.community;
		this.parish = addr.parish;
	}
	
	//Generating Getters and Setters

	public int getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(int streetNum) {
		this.streetNum = streetNum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getParish() {
		return parish;
	}

	public void setParish(String parish) {
		this.parish = parish;
	}
	
	public String toString()
			{
				String output;
				
				output = "The Address is 	:"+ streetNum + "," + streetName + "," + community + "," + parish;
				System.out.println(output);
				
				return output;
			}
	
	
	
	

}

