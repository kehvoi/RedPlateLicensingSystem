package SystemOne;

import java.time.LocalDate;

public abstract class User 
{
		protected int trn;
		protected Name name;
		protected LocalDate dob;
		
		protected Address addr;
		protected String email;
		protected String contactNum;
		protected String gender;
		
		//Default Constructor
		public User()
		{
			trn = 0;
			name = new Name();
			dob = LocalDate.now();
			addr = new Address();
			email = "";
			contactNum = "";
			gender = "Other";
		}
		
		//Primary Constructor
		public User(int trn,Name name, LocalDate dob, Address addr, String email, String contactNum,
				String gender) 
		{
			this.trn = trn;
			this.name = name;
			this.dob = dob;
			
			this.addr = addr;
			this.email = email;
			this.contactNum = contactNum;
			this.gender = gender;


		}
		
		//Copy Constructor
		public User(User use) 
		{
			this.trn = use.trn;
			this.name = use.name;
			this.dob = use.dob;
			
			this.addr = use.addr;
			this.email = use.email;
			this.contactNum = use.contactNum;
			this.gender = use.gender;
		}
		


		public Name getFullName() {
			return name;
		}



		public void setFullName(Name name) {
			this.name = name;
		}



		public LocalDate getDob() {
			return dob;
		}



		public void setDob(LocalDate dob) {
			this.dob = dob;
		}



		public int getTrn() {
			return trn;
		}



		public void setTrn(int trn) {
			this.trn = trn;
		}



		public Address getAddr() {
			return addr;
		}



		public void setAddr(Address addr) {
			this.addr = addr;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getContactNum() {
			return contactNum;
		}



		public void setContactNum(String contactNum) {
			this.contactNum = contactNum;
		}



		public String getGender() {
			return gender;
		}



		public void setGender(String gender) {
			this.gender = gender;
		}



		public abstract void Info();
		

	


}
