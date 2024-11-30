import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
public class AppDriver {
	private static final String DefaultPwd="officer876";//default password
	
	public static void main(String[] args) throws IOException {
		//default users 
		String fileName = "Storedinfo.txt";//declaration of the file name 
		
	        // Default users
			int trn1 = 123456;
			Name driverName1 = new Name();
			driverName1.setFirstName("Jimmy");
			driverName1.setMiddleName("P.");
			driverName1.setLastName("Dawkins");
			LocalDate dob1 = LocalDate.parse("1990-01-15");
			Address address1 = new Address();
			address1.setStreetNum(123);
			address1.setStreetName("Main St");
			address1.setCommunity("Downtown");
			address1.setParish("Kingston");
			String email1 = "jimmyD@example.com";
			String contactNum1 = "8761234567";
			String gender1 = "Male";
			String policerecord1 = "no";
			String accident1 = "no";
			String outstandingTicket1 = "no";

			// Second default user
			int trn2 = 987654321;
			Name driverName2 = new Name();
			driverName2.setFirstName("Mary");
			driverName2.setMiddleName("B.");
			driverName2.setLastName("Smith");
			LocalDate dob2 = LocalDate.parse("1985-05-20");
			Address address2 = new Address();
			address2.setStreetNum(456);
			address2.setStreetName("Second St");
			address2.setCommunity("Midtown");
			address2.setParish("St. Andrew");
			String email2 = "mary.smith@example.com";
			String contactNum2 = "8767654321";
			String gender2 = "Female";
			String policerecord2 = "yes";
			String accident2 = "no";
			String outstandingTicket2 = "yes";
			
			 boolean usersExist = checkIfUsersExist(fileName, trn1, trn2);
			 
			// Write the first default user to the file
			 if (!usersExist) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
			writer.write("Trn:" + trn1 + "\n");
			writer.write("First name:" + driverName1.getFirstName() + "\n");
			writer.write("Middle name:" + driverName1.getMiddleName() + "\n");
			writer.write("Last name:" + driverName1.getLastName() + "\n");
			writer.write("Police record?:" + policerecord1 + "\n");
			writer.write("Date of Birth:" + dob1 + "\n");
			writer.write("Street Number:" + address1.getStreetNum() + "\n");
			writer.write("Street Name:" + address1.getStreetName() + "\n");
			writer.write("Community:" + address1.getCommunity() + "\n");
			writer.write("Parish:" + address1.getParish() + "\n");
			writer.write("Email:" + email1 + "\n");
			writer.write("Contact Number:" + contactNum1 + "\n");
			writer.write("Gender:" + gender1 + "\n");
			writer.write("Accident(s)?:" + accident1 + "\n");
			writer.write("Outstanding tickets?:" + outstandingTicket1 + "\n");
			writer.write("*** ** ** **\n");

			// Write the second default user to the file
			writer.write("Trn:" + trn2 + "\n");
			writer.write("First name:" + driverName2.getFirstName() + "\n");
			writer.write("Middle name:" + driverName2.getMiddleName() + "\n");
			writer.write("Last name:" + driverName2.getLastName() + "\n");
			writer.write("Police record?:" + policerecord2 + "\n");
			writer.write("Date of Birth:" + dob2 + "\n");
			writer.write("Street Number:" + address2.getStreetNum() + "\n");
			writer.write("Street Name:" + address2.getStreetName() + "\n");
			writer.write("Community:" + address2.getCommunity() + "\n");
			writer.write("Parish:" + address2.getParish() + "\n");
			writer.write("Email:" + email2 + "\n");
			writer.write("Contact Number:" + contactNum2 + "\n");
			writer .write("Gender:" + gender2 + "\n");
			writer.write("Accident(s)?:" + accident2 + "\n");
			writer.write("Outstanding tickets?:" + outstandingTicket2 + "\n");
			writer.write("*** ** ** **\n");
			writer.flush();
			} catch (IOException e) {
	            System.out.println("Error initializing file: " + e.getMessage());
	        }
	    
			 }

Scanner Scanner= new Scanner(System.in);

System.out.println("Enter admin password");
String pwd=Scanner.nextLine();
if(!pwd.equals(DefaultPwd)) {//checks if the password entered is the same as the default else the access is denied
System.out.println("Access Denied!!!");
return;
}



File file=new File(fileName);

try(BufferedWriter writer1=new BufferedWriter(new FileWriter(fileName, true))){

while (true) {
System.out.println("***Red Plate Licensing System***");
System.out.println("\n");
System.out.println("1: Create");
System.out.println("2: Update");
System.out.println("3: Delete");
System.out.println("4: Reject");
System.out.println("5:Check for Outstanding Ticket");
System.out.println("6:Search");
System.out.println("7: Exit");

System.out.println("Choose an option:");
int choice =Scanner.nextInt();
Scanner.nextLine();
switch(choice) {
	case 1:
			createApplication(Scanner, writer1, file);
			break;
			 
	case 2:
			updateApplication(Scanner, file);
			break;
			
	case 3:
			deleteApplication(Scanner, file);
			break;
	case 4:
			rejectApplication(Scanner, file);
			break;
	case 5:
			checkOutstandingTicket( Scanner,file);
			break;
	case 6:
			searchApplication(Scanner, file);
			break;
	case 7:
			exitApplication();
			break;

	default:
			System.out.println("Invalid!!. Please choose a valid number from the menu.");
      
			}
}
}catch(IOException e) {
System.out.println("Error!!");
}
	    }
	private static boolean checkIfUsersExist(String fileName, int trn1, int trn2) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean foundTrn1 = false;
            boolean foundTrn2 = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Trn: " + trn1)) {
                    foundTrn1 = true;
                }
                if (line.contains("Trn: " + trn2)) {
                    foundTrn2 = true;
                }
                if (foundTrn1 && foundTrn2) {
                    break; // Exit early if both TRNs are found
                }
            }
            return foundTrn1 && foundTrn2;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return false;
        }
    }


	private static void exitApplication() {
		System.out.println("You have chosen to exit the program.");
		
	}
	private static void checkOutstandingTicket(Scanner scanner, File file) throws IOException {
        List<String> users = retrieveUsers(file); // Retrieve current users
        System.out.println(" Users Trn Availabl:");
        users.forEach(System.out::println);
        System.out.print("Enter the TRN to check for outstanding tickets: ");
        int searchTRN = scanner.nextInt();
        scanner.nextLine();
        boolean applicantFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean readingApplication = false;
            try (BufferedReader reader1 = new BufferedReader(new FileReader(file))) {
                String line1;
                boolean readingApplication1 = false;
                boolean isOutstandingTicketsFound = false;
                String name = "";
                String dob = "";
                String address = "";
                String email = "";
                String contactNumber = "";
                String policeRecord = "";
                String ticketAmount = "";
                int totalAmountOwing = 0;

                while ((line1 = reader1.readLine()) != null) {
                    if (line1.startsWith("Trn: " + searchTRN)) {
                        applicantFound = true;
                        readingApplication1 = true; // Start reading the current application
                        System.out.println("Application found for TRN: " + searchTRN);
                        continue; // Skip the current line, as it's just the TRN
                    }

                    if (readingApplication1) {
                        if (line1.startsWith("First name:")) {
                            name += line1.split(":")[1].trim() + " ";
                        } else if (line1.startsWith("Middle name:")) {
                            name += line1.split(":")[1].trim() + " ";
                        } else if (line1.startsWith("Last name:")) {
                            name += line1.split(":")[1].trim();
                        } else if (line1.startsWith("Date of Birth:")) {
                            dob = line1.split(":")[1].trim();
                        } else if (line1.startsWith("Street Number:") || line1.startsWith("Street Name:") ||
                                   line1.startsWith("Community:") || line1.startsWith("Parish:")) {
                            address += line1.split(":")[1].trim() + " ";
                        } else if (line1.startsWith("Email:")) {
                            email = line1.split(":")[1].trim();
                        } else if (line1.startsWith("Contact Number:")) {
                            contactNumber = line1.split(":")[1].trim();
                        } else if (line1.startsWith("Police record?:")) {
                            policeRecord = line1.split(":")[1].trim();
                        } else if (line1.startsWith("Outstanding tickets?:")) {
                            // Handle Outstanding Tickets
                            String ticketStatus = line1.split(":")[1].trim();
                            System.out.println("Outstanding Ticket Status: " + ticketStatus);
                            isOutstandingTicketsFound = true; // Track if tickets were found
                        } else if (line1.startsWith("Outstanding tickets?")) {
                            // Handle specific ticket details
                            if (isOutstandingTicketsFound) {
                                // Assuming the amount owing is mentioned after each ticket entry, you can track that here
                                // This part of the logic needs to be customized based on how the tickets are listed in your file
                                String ticketDetails = line1.split(":")[1].trim();
                                int ticketCost = Integer.parseInt(ticketDetails.split(" ")[1]); // Assume the cost is the second value
                                totalAmountOwing += ticketCost;
                                System.out.println("Ticket Amount: " + ticketCost);
                            }
                        }
                        // Other checks for fields as needed

                        // Check if the application is denied
                        if (line1.startsWith("Accident(s)?")) {
                            String accidentStatus = line1.split(":")[1].trim();
                            if ("yes".equals(accidentStatus)) {
                                System.out.println("Application Denied based on the disqualification of the proposed driver, you have 5 to 10 business days to provide another driver.");
                            }
                        }
                        if (line1.startsWith("Police record?")) {
                            if ("no".equals(policeRecord)) {
                                System.out.println("Police Record Check: Denied.");
                            } else {
                                System.out.println("Police Record Check: Approved.");
                            }
                        }

                        // End of current application data
                        if (line1.isEmpty()) {
                            readingApplication1 = false;
                        }
                    }
                }

                // If no matching TRN is found
                if (!applicantFound) {
                    System.out.println("No applicant found with TRN: " + searchTRN);
                } else {
                    // Display the collected information if the TRN was found
                    if (applicantFound) {
                        System.out.println("Full Name: " + name);
                        System.out.println("Date of Birth: " + dob);
                        System.out.println("TRN: " + searchTRN);
                        System.out.println("Address: " + address);
                        System.out.println("Email: " + email);
                        System.out.println("Contact Number: " + contactNumber);
                        System.out.println("Total Amount Owing: " + totalAmountOwing);
                        if (!policeRecord.isEmpty()) {
                            System.out.println("Police Record Check: " + policeRecord);
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        }
	}
	private static void searchApplication(Scanner scanner, File file) throws FileNotFoundException, IOException {
	    System.out.print("Enter the TRN to retrieve information: ");
	    int searchTRN = scanner.nextInt();
	    scanner.nextLine(); // Consume the newline character

	    boolean applicantFound = false;
	    StringBuilder applicantInfo = new StringBuilder();

	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        String line;
	        boolean isReadingUser = false;

	        while ((line = reader.readLine()) != null) {
	            if (line.startsWith("Trn:" + searchTRN)) {
	                applicantFound = true;
	                isReadingUser = true;
	            }

	            if (isReadingUser) {
	                applicantInfo.append(line).append("\n");
	                if (line.startsWith("Trn")) { // End of user details block
	                    break;
	                }
	            }
	        }
	    }

	    if (applicantFound) {
	        System.out.println("User Details:");
	        System.out.println(applicantInfo);
	    } else {
	        System.out.println("No user found with TRN: " + searchTRN);
	    }
	}


private static void rejectApplication(Scanner scanner, File file) throws IOException {
	List<String> users = retrieveUsers(file); // Retrieve current users
    System.out.println("Current Users:");
    users.forEach(System.out::println);
	System.out.print("Enter the TRN  you want to reject: ");
	int rejectTRN = scanner.nextInt();
	scanner.nextLine(); 
	List<String> lines = new ArrayList<>();
	boolean trnFound = false;
	
	try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
		String line;
		while ((line = reader.readLine()) != null) {
		if (line.startsWith("Trn:" + rejectTRN)) {
		trnFound = true;
		lines.add(line);// Add the line for the TRN
		while ((line = reader.readLine()) != null && !line.startsWith("Trn:")) {
			lines.add(line); 
			   }
		lines.add("Status: Rejected");
		if (line != null) {
			 lines.add(line); 
			 }
			} else {
			lines.add(line); 
			 }
		}
		} catch (IOException e) {
		System.out.println("Error : " + e.getMessage());
		return;
		  }
	try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
		for (String updatedLine : lines) {
			writer.write(updatedLine + "\n");
		       }
		 } catch (IOException e) {
			 System.out.println("An error occurred while writing to the file: " + e.getMessage());
		 }
		 if (trnFound) {
		    System.out.println("Application with TRN " + rejectTRN + " has been rejected.");
		 } else {
			 System.out.println("Application with TRN " + rejectTRN + " not found.");
		   }
	}


private static void deleteApplication(Scanner scanner, File file) throws FileNotFoundException, IOException {
	List<String> users = retrieveUsers(file); // Retrieve current users
	System.out.println("Enter TRN:");
    int deleteTRN = scanner.nextInt();
    scanner.nextLine();
    List<String> lines = new ArrayList<>();
    boolean trnFound = false;
    boolean isDeleting = false;
    
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
    	String line;
    	while ((line = reader.readLine()) != null) {
            if (line.startsWith("Trn:" + deleteTRN)) {
            	trnFound=true;
            	isDeleting = true;
            }
            if (isDeleting) {
            // Check if we've reached the next TRN to stop deleting
            if (line.startsWith("Trn:")&& !line.startsWith("Trn:" + deleteTRN)) {
            	isDeleting = false; // Stop deleting when we reach a new TRN
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
    Name driverName = new Name();
    
    System.out.println("First Name:");
    driverName.setFirstName(scanner.nextLine());
    
    System.out.println("Middle Name:");
    driverName.setMiddleName(scanner.nextLine());
    
    System.out.print("Last Name: ");
    driverName.setLastName(scanner.nextLine());
    
    System.out.print("Date of Birth (YYYY-MM-DD): ");
    LocalDate dob = LocalDate.parse(scanner.nextLine());
    
    Address address = new Address();
   
    System.out.print("Street Number: ");
    address.setStreetNum(scanner.nextInt());
   
    System.out.print("Street Name: ");
    address.setStreetName(scanner.nextLine());
 
    System.out.print("Community: ");
    address.setCommunity(scanner.nextLine());
    
    System.out.print("Parish: ");
     address.setParish(scanner.nextLine());
   
     System.out.print("Email: ");
     String email = scanner.nextLine();
     
     System.out.print("Contact Number: ");
     String contactNum = scanner.nextLine();
     
     System.out.print("Gender (Male/Female): ");
     String gender = scanner.nextLine();
    
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
        if (driverChange.equalsIgnoreCase("yes")) {
            changeDriver(scanner, writer, file, appDate);
        }else if (driverChange.equalsIgnoreCase("no")) {
        	System.out.println("You chose not to change the proposed driver, you are still able to change your driver as long as 5-10 business days.");
        } else {
        	System.out.println("Permit Approved");
    }
    
    writer.write("Trn:" + trn + "\n");
    writer.write("First name:" + driverName.getFirstName() + "\n");
    writer.write("Last name:" + driverName.getMiddleName() + "\n");
    writer.write("Police record?:" + driverName.getLastName() + "\n");
    writer.write("Date of Birth:" + dob + "\n");
    writer.write("Street Number:" + address.getStreetNum() + "\n");
    writer.write("Street Name:" + address.getStreetName() + "\n");
    writer.write("Community:" + address.getCommunity() + "\n");
    writer.write("Parish:" + address.getParish() + "\n");
    writer.write("Email:" + email + "\n");
    writer.write("Contact Number:" + contactNum + "\n");
    writer.write("Gender:" + gender + "\n");
    writer.write("Accident(s)? " + accident + "\n");
    writer.write("Outstanding tickets?:" + outstandingTicket + "\n");
    writer.flush();
    }
}
private static void updateApplication(Scanner scanner, File file) throws IOException {
	List<String> users = retrieveUsers(file); // Retrieve current users
    
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
                if (!newFirstName.isEmpty()) {
                	line = line.replaceFirst("First name:.*", "First name:" + newFirstName);
                	 }
                
                System.out.print("New Middle Name: ");
                String newMiddleName = scanner.nextLine();
                if (!newMiddleName.isEmpty()) {
                	line = line.replaceFirst("Middle name:.*", "Middle name:" + newMiddleName);
                	}
                
                System.out.println("New Last Name:");
                String newLastName = scanner.nextLine();
                if (!newLastName.isEmpty()) {
                	line = line.replaceFirst("Last name:.*", "Last name:" + newLastName);
                	 }
                
                System.out.print("New Date of Birth: ");
                String dobInput = scanner.nextLine();
                if (!dobInput.isEmpty()) {
                	line = line.replaceFirst("Date of Birth:.*", "Date of Birth:" + LocalDate.parse(dobInput));
                	}
                
                System.out.print("New Street Number: ");
                String newStreetNum = scanner.nextLine();
                if (!newStreetNum.isEmpty()) {
                	line = line.replaceFirst("Street Number:.*", "Street Number:" + newStreetNum);
                }
                System.out.print("New Street Name (leave blank to keep current): ");
                String newStreetName = scanner.nextLine();
                if (!newStreetName.isEmpty()) {
                	line = line.replaceFirst("Street Name:.*", "Street Name:" + newStreetName);
                 }
                
                System.out.print("New Community (leave blank to keep current): ");
                String newCommunity = scanner.nextLine();
                if (!newCommunity.isEmpty()) {
                	line = line.replaceFirst("Community:.*", "Community:" + newCommunity);
                	}
                
                System.out.print("New Parish (leave blank to keep current): ");
                String newParish = scanner.nextLine();
                if (!newParish.isEmpty()) {
                line = line.replaceFirst("Parish:.*", "Parish:" + newParish);
                	}
                
                System.out.print("New Email: ");
                String newEmail = scanner.nextLine();
                if (!newEmail.isEmpty()) {
                	line = line.replaceFirst("Email:.*", "Email:" + newEmail);
                	}
                
                System.out.print("New Contact Number: ");
                String newContactNum = scanner.nextLine();
                if (!newContactNum.isEmpty()) {
                	line = line.replaceFirst("Contact Number:.*", "Contact Number:" + newContactNum);
                	}
                
                System.out.print("New Gender (Male/Female): ");
                String newGender = scanner.nextLine();
                if (!newGender.isEmpty()) {
                	line = line.replaceFirst("Gender:.*", "Gender:" + newGender);
                	}
                
                lines.add(line);
                 } else {
                lines.add(line);
                 }
        }
    }
           
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine + "\n");
            }
        }
        if (trnFound) {
        System.out.println("Driver information updated successfully.");
    } else {
        System.out.println("Driver with TRN " + updateTRN + " not found.");
    }
}


	 private static void changeDriver(Scanner scanner, BufferedWriter writer, File file, LocalDate appDate) throws IOException {
		 List<String> users = retrieveUsers(file); // Retrieve current users
		 LocalDate currentDate = LocalDate.now();
		 	long businessDays= calculateBusinessDays(currentDate,appDate);
		 		
		 	System.out.println("Business days between " + appDate + " and " + currentDate + ": " + businessDays);

		 		
		 	if(businessDays <=5 && businessDays<=10) {
		 		System.out.println("You are within the allowed period to change the driver.");
		 		System.out.print("Enter the current driver's TRN to update: ");
		 		int currentTrn = scanner.nextInt();
		 		scanner.nextLine();
		 			
		 		List<String> lines = new ArrayList<>();
		 		boolean trnFound = false;
		 			
		 		String updateTRN = null;
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
		 	                if (!newFirstName.isEmpty()) {
		 	                	line = line.replaceFirst("First name:.*", "First name:" + newFirstName);
		 	                	 }
		 	                
		 	                System.out.print("New Middle Name: ");
		 	                String newMiddleName = scanner.nextLine();
		 	                if (!newMiddleName.isEmpty()) {
		 	                	line = line.replaceFirst("Middle name:.*", "Middle name:" + newMiddleName);
		 	                	}
		 	                
		 	                System.out.println("New Last Name:");
		 	                String newLastName = scanner.nextLine();
		 	                if (!newLastName.isEmpty()) {
		 	                	line = line.replaceFirst("Last name:.*", "Last name:" + newLastName);
		 	                	 }
		 	                
		 	                System.out.print("New Date of Birth: ");
		 	                String dobInput = scanner.nextLine();
		 	                if (!dobInput.isEmpty()) {
		 	                	line = line.replaceFirst("Date of Birth:.*", "Date of Birth:" + LocalDate.parse(dobInput));
		 	                	}
		 	                
		 	                System.out.print("New Street Number: ");
		 	                String newStreetNum = scanner.nextLine();
		 	                if (!newStreetNum.isEmpty()) {
		 	                	line = line.replaceFirst("Street Number:.*", "Street Number:" + newStreetNum);
		 	                }
		 	                System.out.print("New Street Name (leave blank to keep current): ");
		 	                String newStreetName = scanner.nextLine();
		 	                if (!newStreetName.isEmpty()) {
		 	                	line = line.replaceFirst("Street Name:.*", "Street Name:" + newStreetName);
		 	                 }
		 	                
		 	                System.out.print("New Community (leave blank to keep current): ");
		 	                String newCommunity = scanner.nextLine();
		 	                if (!newCommunity.isEmpty()) {
		 	                	line = line.replaceFirst("Community:.*", "Community:" + newCommunity);
		 	                	}
		 	                
		 	                System.out.print("New Parish (leave blank to keep current): ");
		 	                String newParish = scanner.nextLine();
		 	                if (!newParish.isEmpty()) {
		 	                line = line.replaceFirst("Parish:.*", "Parish:" + newParish);
		 	                	}
		 	                
		 	                System.out.print("New Email: ");
		 	                String newEmail = scanner.nextLine();
		 	                if (!newEmail.isEmpty()) {
		 	                	line = line.replaceFirst("Email:.*", "Email:" + newEmail);
		 	                	}
		 	                
		 	                System.out.print("New Contact Number: ");
		 	                String newContactNum = scanner.nextLine();
		 	                if (!newContactNum.isEmpty()) {
		 	                	line = line.replaceFirst("Contact Number:.*", "Contact Number:" + newContactNum);
		 	                	}
		 	                
		 	                System.out.print("New Gender (Male/Female): ");
		 	                String newGender = scanner.nextLine();
		 	                if (!newGender.isEmpty()) {
		 	                	line = line.replaceFirst("Gender:.*", "Gender:" + newGender);
		 	                	}
		 	                
		 	                lines.add(line);
		 	                 } else {
		 	                lines.add(line);
		 	                 }
		 	        }
		 	    }
		 	           
		 	    
		 	        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter(file))) {
		 	            for (String updatedLine : lines) {
		 	                writer1.write(updatedLine + "\n");
		 	            }
		 	        }
		 	        if (trnFound) {
		 	        System.out.println("Driver information updated successfully.");
		 	    } else {
		 	        System.out.println("Driver with TRN " + updateTRN + " not found.");
		 	    }
		 	}
	 }
	
	private static long calculateBusinessDays(LocalDate startDate, LocalDate appDate){
		long businessDays=0;
		LocalDate start = appDate.isBefore(startDate) ? appDate : startDate;
		LocalDate end = appDate.isAfter(startDate) ? appDate : startDate;



		for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
		    if (isWeekdays(date)) {
		        businessDays++;
		    }
		}
		return businessDays;
	}//checks the number of business days 
	
	private static boolean isWeekdays(LocalDate date) {//checks if the days are between monday and friday
		
		return date.getDayOfWeek() !=  DayOfWeek.SATURDAY && date.getDayOfWeek() != DayOfWeek.SUNDAY;
	}
	private static List<String> retrieveUsers(File file) throws IOException {
	    List<String> users = new ArrayList<>();
	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            if (line.startsWith("Trn:")) {
	            	users.add(line.split(":")[1].trim());
	            }
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("File not found: " + e.getMessage());
	    } catch (IOException e) {
	        System.out.println("Error reading file: " + e.getMessage());
	    }
	    return users;
	}
}


 

