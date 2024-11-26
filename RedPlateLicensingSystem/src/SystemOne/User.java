package SystemOne;

import java.time.LocalDate;

public abstract class User 
{

		protected Name name;
		protected LocalDate dob;
		protected int trn;
		protected Address addr;
		protected String email;
		protected String contactNum;
		protected String gender;
		
		
		//Primary Constructor
		public User(Name name, LocalDate dob, int trn, Address addr, String email, String contactNum,
				String gender) 
		{
			this.name = name;
			this.dob = dob;
			this.trn = trn;
			this.addr = addr;
			this.email = email;
			this.contactNum = contactNum;
			this.gender = gender;


		}
		
		//Copy Constructor
		public User(User use) 
		{
			this.name = use.name;
			this.dob = use.dob;
			this.trn = use.trn;
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
