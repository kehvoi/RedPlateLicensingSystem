package System;

public class Address {
	//Attributes
			private int streetNum;
			private String streetName;
			private String parish;
			
			//Default Constructor
			public Address()
			{
				streetNum = 0;
				streetName = "";
				parish = "";
			}
			
			//Primary Constructor
			public Address(int streetNum, String streetName, String parish)
			{
				this.streetNum = streetNum;
				this.streetName = streetName;
				this.parish = parish;
			}
			
			//Copy Constructor
			public Address(Address addr)
			{
				this.streetNum = addr.streetNum;
				this.streetName = addr.streetName;
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


			public String getParish() {
				return parish;
			}

			public void setParish(String parish) {
				this.parish = parish;
			}
			
			//toString Method
			public String toString()
			{
				String output;
				
				output = "The Address is 	:"+ streetNum + "," + streetName + "," + parish;
				System.out.println(output);
				
				return output;
			}

}
