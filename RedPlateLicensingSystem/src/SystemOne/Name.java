package SystemOne;

public class Name 
{
	//Attributes
	private String firstName;
	private String middleName;
	private String lastName;
	
	//Default Constructor
	
	public Name()
	{
		firstName = "";
		middleName = "";
		lastName = "";
	}
	
	//Primary Constructor
	
	public Name(String firstName, String middleName, String lastName)
	{
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	//Copy Constructor
	
	public Name(Name na)
	{
		this.firstName = na.firstName;
		this.middleName = na.middleName;
		this.lastName = na.lastName;
	}
	
	//Generating Getters and Setters
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	public void Display()
	{
		System.out.println("The person name is  :" + firstName + " " + middleName + " " + lastName);
	}

}
