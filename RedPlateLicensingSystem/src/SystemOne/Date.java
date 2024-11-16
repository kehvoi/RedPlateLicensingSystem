package SystemOne;

public class Date 
{
		//Attributes
		private int day;

		private int month;

		private int year;

		

		//Default constructor

		

		public Date()

		{

			day = 11;

			month = 9;

			year = 2024;

		}

		

		//Primary constructor

		

		public Date(int day, int month, int year)

		{

			this.day = day;

			this.month = month;

			this.year = year;

		}

		

		//Copy constructor

		

		public Date(Date obj)

		{

			this.day = obj.day;

			this.month = obj.month;

			this.year = obj.year;

		}



		//Getters and Setters

		public int getDay() {

			return day;

		}



		public void setDay(int day) {

			this.day = day;

		}



		public int getMonth() {

			return month;

		}



		public void setMonth(int month) {

			this.month = month;

		}



		public int getYear() {

			return year;

		}



		public void setYear(int year) {

			this.year = year;

		}



		public void Display ()

		{

			System.out.println(day+"/"+month+"/"+year);

		}

	
}

