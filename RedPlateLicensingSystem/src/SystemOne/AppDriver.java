package RedPlateLicensingSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
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
				createApplication(scanner, writer, file);
                break;
				 
			case 2:
				updateApplication(scanner, file);
                break;
                
			case 3:
				deleteApplication(scanner, file);
				break;
			case 4:
				//rejectapplication
				break;
			case 5:
				//exit
				break;
			default:
                System.out.println("Invalid option. Please choose a valid number from the menu.");
       
				}
			}
		}catch(IOException e) {
			System.out.println("Error!!"  +e.getMessage());
		}
		
	}


private static void deleteApplication(Scanner scanner, File file) throws FileNotFoundException, IOException {
	System.out.println("Enter the TRN:");
    int deleteTRN = scanner.nextInt();
    scanner.nextLine();
    List<String> lines = new ArrayList<>();
    boolean trnFound = false;
    
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
    	String line;
    	while ((line = reader.readLine()) != null) {
            if (line.startsWith("Trn:" + deleteTRN)) {
            	trnFound=true;
            	for(int i=0; i<5;i++) {
            		reader.readLine();
            	}
           }else {
        	   lines.add(line);
           }
         }
      }
    if(trnFound) {
    	try(BufferedWriter writer= new BufferedWriter(new FileWriter(file))){
    		for (String updatedLine : lines) {
                writer.write(updatedLine );
            }
    	}
    	 System.out.println("Driver with TRN " + deleteTRN + " has been deleted.");
    } else {
        System.out.println("Driver with TRN " + deleteTRN + " not found.");
   
    }
        
	}


private static void createApplication(Scanner scanner, BufferedWriter writer, File file) throws IOException {
    System.out.println("Create Your Application.");
    System.out.println("TRN:");
    int trn = scanner.nextInt();
    scanner.nextLine();
    
    System.out.println("First Name:");
    String firstName = scanner.nextLine();
    
    System.out.println("Last Name:");
    String lastName = scanner.nextLine();
    
    System.out.println("Does the driver have a negative police record?(yes or no)");
    String policerecord = scanner.nextLine();
    
    System.out.println("Did the driver cause any accident(s) within the last two years?(yes or no)");
    String accident = scanner.nextLine();
    
    System.out.println("Does the driver have any outstanding ticket?(yes or no)");
    String outstandingTicket = scanner.nextLine();
    
    LocalDate appDate = LocalDate.now();
    if (policerecord.equals("yes") || accident.equals("yes") || outstandingTicket.equals("yes")) {
        System.out.println("Application Denied!! You need to change the proposed driver with 5-10 business days\n");
        System.out.println("Would you like to change the proposed driver? (yes or no)\n");
        String driverChange = scanner.nextLine();
        if (driverChange.equals("yes")) {
            changeDriver(scanner, writer, appDate);
        }
    } else {
        System.out.println("Permit Approved");
    }
    
    writer.write("Trn:" + trn + "\n");
    writer.write("First name:" + firstName + "\n");
    writer.write("Last name:" + lastName + "\n");
    writer.write("Police record?:" + policerecord + "\n");
    writer.write("Accident(s)? " + accident + "\n");
    writer.write("Outstanding tickets?:" + outstandingTicket + "\n");
    writer.flush();
}
private static void updateApplication(Scanner scanner, File file) throws IOException {
    System.out.println("Update your application:\n");
    System.out.println("Enter the TRN:");
    int updateTRN = scanner.nextInt();
    scanner.nextLine();
    
    List<String> lines = new ArrayList<>();
    boolean trnFound = false;
    
    
    try (BufferedReader read = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = read.readLine()) != null) {
            lines.add(line);
            if (line.startsWith("Trn:" + updateTRN)) {
                trnFound = true;
                System.out.println("Driver found! Enter new information:");
                
                // Prompt for new driver information
                System.out.println("New First Name:");
                String newFirstName = scanner.nextLine();
                System.out.println("New Last Name:");
                String newLastName = scanner.nextLine();
                for (int i = lines.size() - 1; i >= 0; i--) {
                    if (lines.get(i).startsWith("First Name:")) {
                        lines.set(i, "First Name:" + newFirstName);  // Update first name
                    } else if (lines.get(i).startsWith("Last Name:")) {
                        lines.set(i, "Last Name:" + newLastName);  // Update last name
                        break;  // We can stop once both names have been updated
                    }
                }
                
                }
        }
    }
    
    if (trnFound) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine + "\n");
            }
        }
        System.out.println("Driver information updated successfully.");
    } else {
        System.out.println("Driver with TRN " + updateTRN + " not found.");
    }
}


	 private static void changeDriver(Scanner scanner, BufferedWriter writer, LocalDate appDate) throws IOException {
		 		LocalDate currentDate = LocalDate.now();
		 		long businessDays= calculateBusinessDays(currentDate,appDate);
		 		
		 		System.out.println("Business days between " + appDate + " and " + currentDate + ": " + businessDays);

		 		
		 		if(businessDays >=5 && businessDays<=10) {
		 		System.out.println("Enter new driver's TRN:");
		 		int newTrn = scanner.nextInt();
		 		scanner.nextLine();
		 		System.out.println("Enter new driver's First Name:");
		       String newFirstName = scanner.nextLine();
		
		 		System.out.println("Enter new driver's Last Name:");
		 		String newLastName = scanner.nextLine();
		
		 		writer.write("New Driver Trn:" + newTrn + "\n");
		 		writer.write("New Driver First Name:" + newFirstName + "\n");
		 		writer.write("New Driver Last Name:" + newLastName + "\n");
		 		writer.flush();
		 		System.out.println("Proposed driver changed successfully.");
		 		}else {
		 			System.out.println("5-10 business days have passed, you cannot change driver");
		 		}
	 }
	
	private static long calculateBusinessDays(LocalDate startDate, LocalDate appDate){
		long businessDays=0;
		LocalDate start = appDate.isBefore(startDate) ? appDate : startDate;
		LocalDate end = appDate.isAfter(startDate) ? appDate : startDate;



		for(LocalDate date = start; date.isAfter(end);date=date.plusDays(1))  {
			if(isWeekdays(date)) {
				businessDays++;
			}
		}
		return businessDays;
	}//checks the number of business days 
	
	private static boolean isWeekdays(LocalDate date) {//checks if the days are between monday and friday
		
		return date.getDayOfWeek() !=  DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY;
	}
}

