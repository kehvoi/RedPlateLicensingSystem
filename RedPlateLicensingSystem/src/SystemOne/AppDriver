import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
public class AppDriver {
	private static final String DefaultPwd="officer876";//default password
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		
		System.out.println("Enter admin password");
		String pwd=scanner.nextLine();
		if(!pwd.equals(DefaultPwd)) {//checks if the password entered is the same as the default else the access is denied
			System.out.println("Access Denied!!!");
			return;
		}
		String fileName = "Storedinfo.txt";//declaration of the file name 
		
		File file=new File(fileName);
		if(file.length()==0) {
		//user enter the information directly to the file created.
		try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName, true))){
			
				writer.write("2344\nKim\nMendes\nYes\nNo\nNo\n");
				writer.write("*** ** ** **\n");
				writer.write("3355\nSimon\nPete\nNo\nNo\nNo\n");
				writer.write("*** ** ** **\n");
				writer.write("1122, Nate\nKnowles\nYes\nYes\nYes\n");
			}catch(IOException e) {
				System.out.println("Error!"+e.getMessage());
			}
				
			}
		try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName, true))){
			
			while (true) {
			System.out.println("***Red Plate Licensing System***");
			System.out.println("\n");
			System.out.println("1: Create");
			System.out.println("2: Update");
			System.out.println("3: Delete");
			System.out.println("4: Reject");
			System.out.println("Check for Outstanding Ticket");
			System.out.println("5: Exit");
			
			System.out.println("Choose an option:");
			int choice =scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Create Your Application.");
				System.out.println("TRN:");
				int trn=scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("First Name:");
				String firstName=scanner.nextLine();
				
				System.out.println("Last Name:");
				String lastName=scanner.nextLine();
				
				System.out.println("Does the driver have a negative police record?(yes or no)");
				String policerecord=scanner.nextLine();
	
			
				System.out.println("Did the driver cause any accident(s) within the last two years?(yes or no)");
				String accident=scanner.nextLine();
				
				
				System.out.println("Does the driver have any outstanding ticket?(yes or no)");
				String outstandingTicket=scanner.nextLine();
				
				Date appDate=new Date();
				
				if(policerecord.equals("yes")||accident.equals("yes")||outstandingTicket.equals("yes")) {
					System.out.println("Application Denied!!You need to change the proposed driver with 5-10 business days\n");
					
					System.out.println("Would you like to change the proposed driver(yes or no)\n");
					String driverChange=scanner.nextLine();
					if(driverChange.equals("yes")) {
						//correction to be made here
					}
				}else {
					System.out.println("Permit Approved");
				}
				
				
				writer.write("Trn:"+trn+"\n");
				writer.write("First name:" +firstName+"\n");
				writer.write("Last name:" +lastName+"\n");
				writer.write("Police record?:"+policerecord+"\n");
				writer.write("Accident(s)?"+accident+"\n");
				writer.write("Oustanding tickets?:"   +outstandingTicket+"\n");
				writer.flush();
				break;
				
				
			default:
                System.out.println("Invalid option. Please choose a valid number from the menu.");
       
				}
			}
		}catch(IOException e) {
			System.out.println("Error!!"  +e.getMessage());
		}
		
	}


}

