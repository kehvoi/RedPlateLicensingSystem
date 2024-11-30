package SystemOne;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
    // Global variable to hold the ticket number
    private static int ticketNum = 7;
    //PPL1003
    private static int ppvNum = 1003;
    private static String ppvLicense;
    private static int option;
    private static String choice;
    private static String policerecord;
    private static String accident;
    private static String outstandingTicket;
    private static String applicantResult;
    private static String newInfo;
    
    private static int trnInput;
    private static String parishInput;
    private static String dobString;
    
    private static String result;
    private static Scanner scan = new Scanner(System.in);
    private static String adminPass = "ABC123";
    private static String passcode;
    //Global variables for ticket
    
    private static LocalDate today = LocalDate.now();
    private static LocalDate weeks = today.plusWeeks(3);
    private static LocalDate courtDateInput = weeks.plusWeeks(1);
    private static int offenseCodeInput;
    private static String offenseDescInput;
    private static int fineAmtInput;
    private static int totalUnpaidTicInput;
    private static int totalFineAmtInput;
    private static boolean warrantInput = false;
    private static String ticketPayStatusInput = "Unpaid";
    private static boolean state = true;
    private static int ticketNumInput;
    
    //private static String filePath5 = "ppv_records.csv";
    //private static String filePath4 = "ppvCount.txt";
    private static String filePath3 = "ticket_records.csv";
	private static String filePath2 = "driver_records.csv";
    private static String filePath = "ticketCount.txt";
    

    public static void main(String[] args) 
    {
    	//Declaration of ArrayLists 
    	ArrayList<Driver> Drivers = new ArrayList<>();
    	ArrayList<Ticket> Tickets = new ArrayList<>();
    	ArrayList<PPVLicense> PPVHolders = new ArrayList<>();
    	
		//Default User 1
		Name d1 = new Name("John", "Brown");
		Address a1 = new Address(19,"Maldave Avenue","Kingston");
		Driver driver1 = new Driver(123456789,d1, LocalDate.parse("2000-05-05"),a1, "john.brown@gmail.com", "8768403526", "Male");
		
		//Default Tickets for User 1
		Address t1 = new Address(144,"Maxfield Ave","Kingston");
		Address t2 = new Address(69,"Public West Building","Kingston");
		Address t3 = new Address(24,"Sutton Street","Kingston");
		Address t4 = new Address(36,"Camp Road","Kingston");
		Address t5 = new Address(79,"Duke Street","Kingston");
		Address t6 = new Address (69, "Wilford Street","Kingston");
		
		Ticket defaultTic1 = new Ticket(123456789, 1, LocalDate.parse("2019-01-01"), LocalDate.parse("2019-01-22"), 1, "Aid And Abet No Driver’s Licence or Permit", 
                "Outstanding", 15000, LocalDate.parse("2019-01-29") , t1, 0, 
                0, true);
		//Paid Tickets would display $0 for fineAmt
		Ticket defaultTic2 = new Ticket(123456789, 2, LocalDate.parse("2019-06-29"), LocalDate.parse("2019-06-29"), 2, "Aid And Abet Operating Motor Vehicle...", 
                "Paid", 0, LocalDate.parse("2019-06-29") , t2, 0, 
                0, false);
		//Paid Tickets would display $0 for fineAmt
		Ticket defaultTic3 = new Ticket(123456789, 3, LocalDate.parse("2004-01-01"), LocalDate.parse("2004-01-22"), 3, "Body Protruding", 
                "Paid", 0, LocalDate.parse("2004-01-29") , t3, 0, 
                0, false);
		
		Ticket defaultTic4 = new Ticket(123456789, 4, LocalDate.parse("2024-11-28"), LocalDate.parse("2024-12-19"), 7, "Carrying dangerous goods without the transport....", 
                "Unpaid", 175000, LocalDate.parse("2024-12-26") , t4, 0, 
                0, false);
		
		Ticket defaultTic5 = new Ticket(123456789, 5, LocalDate.parse("2020-05-05"), LocalDate.parse("2020-05-26"), 4, "Breach of special permit", 
                "Outstanding", 30000, LocalDate.parse("2004-01-29") , t5, 0, 
                0, true);
		
		Ticket defaultTic6 = new Ticket(123456789, 6, LocalDate.parse("2024-11-07"), LocalDate.parse("2024-11-28"), 5, "Careless Driving Causing Collision", 
                "Unpaid", 25000, LocalDate.parse("2024-12-05") , t6, 0, 
                0, true);
		
		
		Tickets.add(defaultTic1);
		Tickets.add(defaultTic2);
		Tickets.add(defaultTic3);
		Tickets.add(defaultTic4);
		Tickets.add(defaultTic5);
		Tickets.add(defaultTic6);
		
		PPVLicense defaultPPV1 = new PPVLicense();
		PPVHolders.add(defaultPPV1);
		
		//Default User 2
		Name d2 = new Name("Mary", "Anderson");
		Address a2 = new Address(12, "Redwood Lane", "St.Andrew");
		Driver driver2 = new Driver(987654321, d2, LocalDate.parse("1995-08-15"),a2, "mary.anderson@gmail.com", "8761234567", "Female");
		
		PPVLicense defaultPPV2 = new PPVLicense(987654321,"PL1002",today,today.plusYears(4),"St Andrew");
		PPVHolders.add(defaultPPV2);
		
		//Default User 3
		Name d3 = new Name("Sashana","Blackwood");
		Address a3 = new Address(88,"Stockforth Road","St.Thomas");
		Driver driver3 = new Driver(100000000,d3, LocalDate.parse("2001-08-05"),a3, "sashana.blackwood@gmail.com", "8767252731", "Female");

		//Default User 4 created from default constructor
		Driver driver4 = new Driver();
		
		Drivers.add(driver1);
		Drivers.add(driver2);
		Drivers.add(driver3);
		Drivers.add(driver4);
		
		
        

        // Load ticket number and ppvNum from respective files
        ticketNum = LoadTicketNum("ticketCount.txt");
        ppvNum = LoadPPV("ppvCount.txt");
        
        //Formats PPV License to represent real life licenses
        ppvLicense = String.format("PL%04d", ppvNum);
        
        
        
        
        
        
        //Loads in the default users,tickets, ppvLicense before the while loop starts
        DefaultDrivers("driver_records.csv", Drivers);
        DefaultTickets("ticket_records.csv", Tickets);
        DefaultPPVLicense("ppv_records.csv", PPVHolders);
        
        
        try 
        {
        	while (state)
            {
        		System.out.println("Welcome to the Jamaica Constabulary Force and Public Passenger Vehicle Association. How may I assist?"
        				+ "\n1 - Red Plate Licensing System (RPLTS)"
        				+ "\n2 - Ticketing Issuing and Offender Checking System (TIOCS)"
        				+ "\n3 - Exit"
        				+ "\nEnter an option:");
        		option = scan.nextInt();
        		switch (option)
        		{
        		case 1:
        			RPLTS();
        			break;
        		case 2:
        			TIOCS(); 
        			break;
        		case 3:
        			state = false;
        			break;
        		default:
        			System.out.println("Invalid option. Please try again");
        			break;
        		}
        		
        		
            	
            }//end while loop
        	}//end try
        	catch(InputMismatchException e)
            {
            	System.out.println("You inputted the wrong data type. Please try again");
            }
            catch(ArithmeticException e)
            {
            	System.out.println("You can't divide!");
            }
            scan.close();
            
            
            
            System.out.println("Thank you for your business. Have a nice day");
            
            
        }// end of private static void main
        
        
  //Methods for PPV License
    
    private static void DefaultPPVLicense(String filePath, ArrayList<PPVLicense> parameterList)
    {
    	File file = new File(filePath);

        // If the file doesn't exist, create it and add default drivers
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                
               // Write the drivers to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                for (PPVLicense ppv : parameterList) {
                    writer.write(ppv.toCSV());  // Get the CSV string and write it to the file
                    writer.append("\n");  
                }
              } //end second try
              catch (IOException e) {
                System.out.println("An error occurred while saving the PPV License info.");
                e.printStackTrace();
              }//end catch  
                
                
                
            }//endif

           
        }//end first try 
        catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    	
    }



    
    
    
    //Methods for Drivers
    
  //Method to Load Default Driver Records
    private static void DefaultDrivers(String filePath, ArrayList<Driver> parameterList) {
        File file = new File(filePath);

        // If the file doesn't exist, create it and add default drivers
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                System.out.println("Default Users Successfully Loaded");
                
               // Write the drivers to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                for (Driver driver : parameterList) {
                    writer.write(driver.toCSV());  // Get the CSV string and write it to the file
                    writer.append("\n");  // Append a newline after each driver's record
                }
              } //end second try
              catch (IOException e) {
                System.out.println("An error occurred while saving the driver info.");
                e.printStackTrace();
              }//end catch  
                
                
                
            }//endif

           
        }//end first try 
        catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }// end DefaultDrivers method
    
    
    //Search TRN Method
    
    private static String searchDriverByTrn(String filePath, int searchTrn) {
        Map<Integer, String> index = new HashMap<>();
        
        // Read the file and build the index
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                try {
                    int trn = Integer.parseInt(parts[0].trim());
                    index.put(trn, line); // Map TRN to the full line
                } catch (NumberFormatException e) {
                    // Skip malformed lines where TRN is not a valid integer
                    System.out.println("Skipping invalid line");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null; // Return null if there's an issue with file reading
        }

        // Search for the TRN in the index
        return index.get(searchTrn); // Return the matching line, or null if not found
    }
    
    private static void EditInformation(String filePath, int trnToUpdate, int columnIndex, String newValue) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = new ArrayList<>();
            String line;

            // Read all lines into a list
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // If the file is empty, there's nothing to update
            if (lines.isEmpty()) {
                System.out.println("File is empty.");
                return;
            }

            // Iterate through the lines and find the record with the specified TRN
            boolean updated = false;
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                try {
                    int trn = Integer.parseInt(parts[0].trim()); // Assume TRN is in the first column (index 0)
                    if (trn == trnToUpdate) {
                        // Update the specified column
                        if (columnIndex >= 0 && columnIndex < parts.length) {
                            parts[columnIndex] = newValue;  // Update the column with new value
                            lines.set(i, String.join(",", parts));  // Join the parts back into a single line
                            updated = true;
                        } else {
                            System.out.println("Invalid column index.");
                            return;
                        }
                        break;
                    }
                } catch (NumberFormatException e) {
                    // Skip lines where the TRN is not a valid number
                }
            }

            if (!updated) {
                System.out.println("Record with TRN " + trnToUpdate + " not found.");
                return;
            }

            // Write the updated list of lines to the original file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String l : lines) {
                    writer.write(l);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error updating record: " + e.getMessage());
        }
    }

    
    //Delete Last Record for Ticket
    private static void deleteLastRecord(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = new ArrayList<>();
            String line;

            // Read all lines into a list
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // If the file is empty, there's nothing to delete
            if (lines.isEmpty()) {
                System.out.println("File is empty.");
                return;
            }

            // Remove the last line from the list
            lines.remove(lines.size() - 1);

            // Write the updated list to the original file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String l : lines) {
                    writer.write(l);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error deleting last record: " + e.getMessage());
        }
    }
    
    
    private static String readLastRecord(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String lastLine = null;
            String line;

            // Read all lines and keep track of the last one
            while ((line = reader.readLine()) != null) {
                lastLine = line;
            }

            // If the file is empty, return null
            if (lastLine == null) {
                System.out.println("File is empty.");
                return null;
            }

            return lastLine;
        } catch (IOException e) {
            System.out.println("Error reading last record: " + e.getMessage());
            return null;
        }
    }

    private static String ValidateParish(String y, int x) {
        switch(x) {
            case 1:
                return y = "Kingston";
            case 2:
                return y = "St Andrew";
            case 3:
                return y = "St Thomas";
            case 4:
                return y = "Portland";
            case 5:
                return y = "St Mary";
            case 6:
                return y = "St Ann";
            case 7:
                return y = "Trelawny";
            case 8:
                return y = "St James";
            case 9:
                return y = "Hanover";
            case 10:
                return y = "Westmoreland";
            case 11:
                return y = "St Elizabeth";
            case 12:
                return y = "Manchester";
            case 13:
                return y = "Clarendon";
            case 14:
                return y = "St Catherine";
            default:
                return y;  // Default case if x is out of range (1-14)
        }
    }

    
    
    //Methods for Ticket Class
    
    
    // Method to load the ticket number from the file
private static int LoadTicketNum(String filepath) {
        // Create a File object
        File file = new File(filepath);

        // Check if the file exists
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                // Read the file content (ticket number is expected to be on a single line)
                String line = reader.readLine();
                if (line != null) {
                    return Integer.parseInt(line); // Return the ticket number from the file
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading the file.");
                e.printStackTrace();
            }
        } else {
            // If file doesn't exist, create it and initialize the ticket number to 0
            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                    SaveCount(filepath, 7);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
            }
        }

        return 7; // Return default value if the file was not found or read fails
    }

private static int LoadPPV(String filepath) {
    // Create a File object
    File file = new File(filepath);

    // Check if the file exists
    if (file.exists()) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            // Read the file content (ticket number is expected to be on a single line)
            String line = reader.readLine();
            if (line != null) {
                return Integer.parseInt(line); // Return the ticket number from the file
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    } else {
        // If file doesn't exist, create it and initialize the ppv number to 1003
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                
                SaveCount("ppvCount.txt", 1003);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    return 1003; // Return default value if the file was not found or read fails
}

    // Method to save the ticket number back to the file
    private static void SaveCount(String filepath, int ticketNum) {
        try (FileWriter writer = new FileWriter(filepath)) {
            // Write the ticket number to the file
            writer.write(String.valueOf(ticketNum));
        } catch (IOException e) {
            System.out.println("An error occurred while saving the counter");
            e.printStackTrace();
        }
    }
    
    
    
    private static void DefaultTickets(String placeholder, ArrayList<Ticket> parameterList) {
        File file = new File(placeholder);

        // If the file doesn't exist, create it and add default drivers
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                System.out.println("Default Tickets Successfully Created");
                
               // Write the drivers to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                for (Ticket tickets : parameterList) {
                    writer.write(tickets.toCSV());  // Get the CSV string and write it to the file
                    writer.append("\n");  // Append a newline after each driver's record
                }
              } //end second try
              catch (IOException e) {
                System.out.println("An error occurred while saving the driver info.");
                e.printStackTrace();
              }//end catch  
                
                
                
            }//endif

           
        }//end first try 
        catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }// end DefaultTickets method
    
    
    
    private static void EditFineAmt(String filePath, int searchTrn, int ticketNum, int newFineAmt, String newPaymentStatus) {
        List<String> lines = new ArrayList<>();
        boolean updated = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the file line by line and store the lines in a list
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                try {
                    // Ensure there are enough columns
                    if (parts.length > 7) {
                        int trn = Integer.parseInt(parts[0].trim()); // TRN from column 1
                        int ticket = Integer.parseInt(parts[1].trim()); // TicketNum from column 2

                        // If both TRN and ticketNum match, update fineAmt and payment status
                        if (trn == searchTrn && ticket == ticketNum) {
                            parts[7] = String.valueOf(newFineAmt); // Update fineAmt
                            parts[6] = newPaymentStatus.trim();   // Update payment status
                            updated = true; // Mark as updated
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid line: " + line);
                }
                // Add the (possibly modified) line back to the list
                lines.add(String.join(",", parts));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Write the updated lines back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String updatedLine : lines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            return;
        }

        if (!updated) {
            System.out.println("No matching record found for TRN: " + searchTrn + " and TicketNum: " + ticketNum);
        }
    }
    //Searches Driver Ticket Due Date
    private static Integer OnlinePayment(String filePath, int searchTrn, int ticketNum)
    {
    	try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                try {
                    // Ensure there are enough columns
                    if (parts.length > 7) {
                        int trn = Integer.parseInt(parts[0].trim()); // TRN from column 1
                        int ticket = Integer.parseInt(parts[1].trim()); // TicketNum from column 2

                        // Match both TRN and ticketNum
                        if (trn == searchTrn && ticket == ticketNum) {
                            return Integer.parseInt(parts[7].trim()); // fineAmt from column 8
                        }
                    }
                } catch (NumberFormatException e) {
                    // Skip malformed TRN, ticketNum, or fineAmt
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return null;
    }
    
    private static void PayTicketOnline() {
	    System.out.println("Please enter the ticket number: ");
		ticketNumInput = scan.nextInt();
		if (OnlinePayment("ticket_records.csv", trnInput, ticketNumInput) == null)
		{
			System.out.println("Ticket number was not found");
		}
		else
		{
			if(OnlinePayment("ticket_records.csv", trnInput, ticketNumInput) == 0)
			{
				System.out.println("Ticket number " + ticketNumInput + " has been paid already!");
			}
			else
			{
				System.out.println("The fine amount for ticket is: $" + OnlinePayment("ticket_records.csv", trnInput, ticketNumInput));
	        	System.out.print("Please enter the fine amount: $");
	        	fineAmtInput = scan.nextInt();
	        	
	        	while (fineAmtInput < OnlinePayment("ticket_records.csv", trnInput, ticketNumInput))
	        	{
	        		System.out.println("Invalid input");
	        		System.out.println("The fine amount for ticket is: $" + OnlinePayment("ticket_records.csv", trnInput, ticketNumInput));
	        		System.out.println("The fine amount must be greater than or equal to: $" + OnlinePayment("ticket_records.csv", trnInput, ticketNumInput));
	            	System.out.print("Please enter the fine amount: $");
	            	fineAmtInput = scan.nextInt();
	        	}
	        	EditFineAmt("ticket_records.csv", trnInput, ticketNumInput,0, "Paid");
	        	
	        	System.out.println("Ticket number " + ticketNumInput + " has been paid");
	        	System.out.println("Ticket payment status has changed to Paid");
			}
			
		}
	
		
			}
    
    private static void ShowPastDueDates(String filePath3, int trn1) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath3))) {
            String line;

           

            // Read each line in the file
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length > 6) { // Ensure there are enough columns (TRN, ticketDueDate, ticketPayStatus, etc.)
                    int trn = Integer.parseInt(parts[0].trim()); // Get TRN from the 1st column (index 0)
                    String ticketDueDateString = parts[3].trim(); // Get the due date from the 4th column (index 3)
                    String ticketPayStatus = parts[6].trim(); // Get the ticketPayStatus from the 7th column (index 6)

                    // Filter by TRN
                    if (trn == trn1) {
                        LocalDate ticketDueDate = LocalDate.parse(ticketDueDateString);

                        // Check if the ticket is past due and unpaid
                        if (ticketDueDate.isBefore(LocalDate.now()) && ticketPayStatus.equalsIgnoreCase("Unpaid")) {
                            System.out.println(line); // Output the matching line
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid data in TRN or numeric fields: " + e.getMessage());
        }
    }
    
    private static void ShowNotPastDueDates(String filePath3, int trn1) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath3))) {
            String line;

           

            // Read each line in the file
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length > 6) { // Ensure there are enough columns (TRN, ticketDueDate, ticketPayStatus, etc.)
                    int trn = Integer.parseInt(parts[0].trim()); // Get TRN from the 1st column (index 0)
                    String ticketDueDateString = parts[3].trim(); // Get the due date from the 4th column (index 3)
                    String ticketPayStatus = parts[6].trim(); // Get the ticketPayStatus from the 7th column (index 6)

                    // Filter by TRN
                    if (trn == trn1) {
                        LocalDate ticketDueDate = LocalDate.parse(ticketDueDateString);

                        // Check if the ticket is past due and unpaid
                        if (!ticketDueDate.isBefore(LocalDate.now()) && ticketPayStatus.equalsIgnoreCase("Unpaid")) {
                            System.out.println(line); // Output the matching line
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid data in TRN or numeric fields: " + e.getMessage());
        }
    }

    
private static void ShowAllOutstandingTicket(String filePath3) {
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath3))) {
            String line;
            
            
            // Read each line in the file
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                
                if (parts.length > 5) { // Ensure there are at least 6 columns (ticketDueDate and ticketPayStatus)
                    String ticketDueDateString = parts[3].trim(); // Get the due date from the 4th column (index 3)
                    String ticketPayStatus = parts[6].trim(); // Get the ticketPayStatus from the 6th column (index 5)
                    
                    
                        // Parse the ticketDueDate to LocalDate
                        LocalDate ticketDueDate = LocalDate.parse(ticketDueDateString);
                        
                        // Calculate the number of days between the due date and today
                        if (ticketDueDate.isBefore(LocalDate.now()) && ticketPayStatus.equalsIgnoreCase("Outstanding")) {
            	            System.out.println(line);
                    } 
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    
    private static void DeleteTrn(String filePath, int trnToDelete) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            List<String> lines = new ArrayList<>();
            String line;

            // Read all lines into a list
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            // If the file is empty, there's nothing to delete
            if (lines.isEmpty()) {
                System.out.println("File is empty.");
                return;
            }

            boolean recordFound = false;
            // Iterate through the lines to find the record with the specified TRN
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(",");
                try {
                    int trn = Integer.parseInt(parts[0].trim()); // Assume TRN is in the first column (index 0)
                    if (trn == trnToDelete) {
                        // Remove the record with the matching TRN
                        lines.remove(i);
                        recordFound = true;
                        break; // Stop once the record is found and removed
                    }
                } catch (NumberFormatException e) {
                    // Skip lines where TRN is not a valid number
                }
            }

            if (!recordFound) {
                System.out.println("Record with TRN " + trnToDelete + " not found.");
                return;
            }

            // Write the updated list of lines back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                for (String l : lines) {
                    writer.write(l);
                    writer.newLine();
                }
            }

            System.out.println("Record with TRN " + trnToDelete + " has been deleted.");

        } catch (IOException e) {
            System.out.println("Error deleting record: " + e.getMessage());
        }
    }


    
    
    //Generate Offense Description based on offense code
    private static String GenerateOffenseDesc(int offenseCode, String offenseDesc)
	{
		switch (offenseCode)
		{
		case 1:
			return offenseDesc = "Aid And Abet No Driver's Licence or Permit";
		case 2:
			return offenseDesc = "Aid And Abet Operating Motor Vehicle...";
		case 3:
			return offenseDesc = "Body Protruding";
		case 4:
			return offenseDesc = "Breach of special permit";
		case 5:
			return offenseDesc = "Careless Driving Causing Collision";
		case 6:
			return offenseDesc = "Careless Driving Where No Collision Occurs";
		case 7:
			return offenseDesc = "Carrying dangerous goods without the transport....";
		}
		return offenseDesc = "";
	}
    
    
    //Generate Fine based on offenseCode
    private static int GenerateFine (int offenseCode, int fineAmt)
	{
		switch (offenseCode)
		{
		case 1:
			return fineAmt = 15000;
		case 2:
			return fineAmt = 30000;
		case 3:
			return fineAmt = 5000;
		case 4:
			return fineAmt = 30000;
		case 5:
			return fineAmt = 25000;
		case 6:
			return fineAmt = 11000;
		case 7:
			return fineAmt = 175000;
		}
		return fineAmt = 0;
	}
    
    private static void ShowAllPendingTickets(){
    System.out.println("Enter driver trn number: ");
	trnInput = scan.nextInt();
	while (String.valueOf(trnInput).length() != 9)
	  {
	    System.out.println("TRN must be of length 9 digits. Please try again.");
	    System.out.println("Enter trn:");
	    trnInput = scan.nextInt();
	  }
		result = searchDriverByTrn("ticket_records.csv", trnInput);
		if (result != null) 
		{
            System.out.println("Found driver record");
            
            
            System.out.println("Searching driver's due tickets...");
            System.out.println("Driver has unpaid tickets below");
            ShowPastDueDates(filePath3,trnInput);
		}
		else {
            System.out.println("Driver not found with TRN");
        }  
	
}
    
    private static void TIOCSCheckDriverStatus()
    {
    	System.out.println("1 - Verify if the Driver has any unpaid tickets past 21 days"
				+ "\n2 -View all offenders who have outstanding tickets pending"
				+ "\nEnter an option:");
				option = scan.nextInt();
				while (option <=0  || option > 2 )
				{
					System.out.println("Invalid Input. Please enter a valid option"
							+ "Enter an option: ");
					option = scan.nextInt();
				}
				switch (option)
				{
				case 1:
					ShowAllPendingTickets();
					break;
				case 2:
					ShowAllOutstandingTicket(filePath3);
					
					break;
				default:
					System.out.println("Invalid input");
					break;
				}
    }
    
    
    private static void CreateApplication()
    {
    	System.out.println("-----Create an Application-----\n");

		Driver applicant = new Driver();
		Name applicantName = new Name();
		Address applicantAddress = new Address();
		
		System.out.println("Please enter trn: ");
		applicant.setTrn(scan.nextInt());
		
		scan.nextLine();
		while (String.valueOf(applicant.getTrn()).length() != 9)
		{
			System.out.println("Invalid TRN. TRN must contain 9 digits");
			applicant.setTrn(scan.nextInt());
			scan.nextLine();
		}
		
		
		System.out.println("\nEnter first name: ");
        applicantName.setFirstName(scan.next());
        
        System.out.println("Enter last name: ");
        applicantName.setLastName(scan.next());
        
        // Set the driver's name using the Name object
        applicant.setName(applicantName);
        
        LocalDate dob = null;
        
        // Ensure we read a full line for the date of birth
        
        // Loop until valid date is entered
        while (dob == null) {
            try {
                dob = LocalDate.parse(dobString, DateTimeFormatter.ISO_LOCAL_DATE);  // Parse the date string
            } catch (Exception e) {
                System.out.println("Enter date of birth (YYYY-MM-DD format):");
                dobString = scan.nextLine();  // Capture new input if invalid date
            }
        }
        
        applicant.setDob(dob); 
        
        
        System.out.println("Enter the applicant's street number: ");
        applicantAddress.setStreetNum(scan.nextInt());
        scan.nextLine();  // This clears the buffer after reading the integer

        System.out.println("Enter the applicant's street name: ");
        applicantAddress.setStreetName(scan.nextLine());
        
        System.out.println("\n");
        System.out.println("1 - Kingston, 2 - St Andrew, 3 - St Thomas,  4 - Portland, 5 - St Mary,");
        System.out.println("\n6 - St Ann, 7 - Trelawny, 8 - St James, 9 - Hanover, 10 - Westermoreland,");
        System.out.println("\n11 - St Elizabeth, 12 - Manchester, 13 - Clarendon, 14 - St Catherine");
        System.out.println("\nEnter the applicant's parish (1-14): ");
        option = scan.nextInt();
        while (option <= 0 || option >14)
		{
        	System.out.println("\n");
			System.out.println("Invalid Parish. Please enter valid parish from options");
			System.out.println("\n1 - Kingston, 2 - St Andrew, 3 - St Thomas,  4 - Portland, 5 - St Mary,");
			System.out.println("\n6 - St Ann, 7 - Trelawny, 8 - St James, 9 - Hanover, 10 - Westermoreland,");
			System.out.println("\n11 - St Elizabeth, 12 - Manchester, 13 - Clarendon, 14 - St Catherine");
			System.out.println("\nEnter the applicant's parish (1-14): ");
			option = scan.nextInt();
			scan.nextLine();
		}
        applicantAddress.setParish(ValidateParish(parishInput,option));
        applicant.setAddr(applicantAddress);
		
        System.out.println("Enter your email address: ");
        applicant.setEmail(scan.next());
        
        System.out.println("Enter your phone number: ");
        applicant.setContactNum(scan.next());
        
        System.out.println("Please enter gender from: ");
        System.out.println("Options: Male, Female, or Other");
        System.out.println("Enter a option: ");
        applicant.setGender(scan.next().toUpperCase());
        while (!applicant.getGender().equals("MALE") && !applicant.getGender().equals("FEMALE") && !applicant.getGender().equals("OTHER"))
        {
        	System.out.println("Invalid choice. Please enter correct gender from:"
        			+ "\nMale, Female, or Other"
        			+ "\nEnter a option: ");
        	applicant.setGender(scan.next().toUpperCase());
        }
        
        
        System.out.println("Does the driver have a negative police record?(yes or no)");
        policerecord = scan.next().toUpperCase();
        while (!policerecord.equals("YES") && !policerecord.equals("NO"))
        {
        	System.out.println("Invalid choice. Does the driver have a negative police record?(yes or no)");
        	policerecord = scan.next().toUpperCase();
        }
        
        System.out.println("Did the driver cause any accident(s) within the last two years?(yes or no)");
        accident = scan.next().toUpperCase();
        while (!accident.equals("YES") && !accident.equals("NO"))
        {
        	System.out.println("Invalid choice.\nDid the driver cause any accident(s) within the last two years?(yes or no)");
        	accident = scan.next().toUpperCase();
        }
        
        System.out.println("Does the driver have any outstanding ticket?(yes or no)");
        outstandingTicket = scan.next().toUpperCase();
        while (!outstandingTicket.equals("YES") && !outstandingTicket.equals("NO"))
        {
        	System.out.println("Invalid choice.\nDoes the driver have any outstanding ticket?(yes or no)");
        	outstandingTicket = scan.next().toUpperCase();
        }
        
        boolean status;
        if (policerecord.equals("YES") || accident.equals("YES") || outstandingTicket.equals("YES")) {
            System.out.println("Application Denied!! You need to change the proposed driver with 5-10 business days\n");
            System.out.println("Would you like to change the proposed driver? (yes or no)\n");
            String driverChange = scan.nextLine();
            if (driverChange.equals("yes")) {
            	System.out.println("The applicant will have to change the proposed driver within 5 to 10 business days,"
            			+ "\n otherwise, the application will be denied.");
            	status = false;
            }
            else
            {
            	System.out.println("Application denied");
            	status = false;
            }
        } else {
            System.out.println("Red Plate Permit Approved");
            status = true;
            //Generates new PPV License to current applicant
            PPVLicense ppv = new PPVLicense(applicant.getTrn(), ppvLicense, today, today.plusYears(4), applicantAddress.getParish());
            System.out.println("\nCongratulations");
            System.out.println("PPV License has been assigned to applicant!");
            System.out.println("-----PPV License Details-----\n");
            ppv.toString();
            
            
            try (FileWriter writer = new FileWriter("ppv_records.csv", true)) {
                writer.append(ppv.toCSV());
                writer.append("\n");
            } catch (IOException e) {
                System.out.println("An error occurred while saving the ppv license.");
                e.printStackTrace();
            }
            
            ppvNum++;
            SaveCount("ppvCount.txt", ppvNum);
            
            try (FileWriter writer = new FileWriter("driver_records.csv", true)) {
                writer.append(applicant.toCSV());
                writer.append("\n");
            } catch (IOException e) {
                System.out.println("An error occurred while saving the driver records.");
                e.printStackTrace();
            }
        }
        
        
        if (status == true)
        {
        	applicantResult = "Passed";
        }
        else
        {
        	applicantResult = "Failed";
        }
        
        System.out.println("-----General Application Details-----");
        System.out.println("Date of Application " + today);
        System.out.println("Applicant Status: " + applicantResult);
        System.out.println("\n");
        System.out.println("-----Application Personal Information-----");
        applicant.Info();
        System.out.println("\n");
        System.out.println("-----Interview Details-----");
        System.out.println("Police record?:" + policerecord );
        System.out.println("Accident(s)? " + accident);
        System.out.println("Outstanding tickets?:" + outstandingTicket);
        System.out.println("\n");
    }
    
    
    private static void UpdateApplication()
    {
    	System.out.println("-----Edit Applicant Information-----\n");
    	System.out.println("Please enter applicant trn: ");
		trnInput = scan.nextInt();
		while (String.valueOf(trnInput).length() != 9)
		{
			System.out.println("Invalid TRN. TRN must contain 9 digits");
			trnInput = scan.nextInt(); 
		}
		result = searchDriverByTrn(filePath2, trnInput);
		if (result != null) {
            System.out.println("Found applicant record");
            System.out.println("Available information to edit below");
            System.out.println("1 - First Name, 2 - Last Name");
            System.out.println("Please enter an option:");
            option = scan.nextInt();
            while (option <=0 || option > 2)
            {
            	System.out.println("Invalid input.");
            	System.out.println("Available information to edit below");
                System.out.println("1 - First Name, 2 - Last Name");
                System.out.println("Please enter an option: ");
                option = scan.nextInt();
            }
           
            System.out.println("Enter new information: ");
            newInfo = scan.next();
            
            EditInformation("driver_records.csv",trnInput,option,newInfo);
            System.out.println("Applicant information has successfully changed");
            
		}
		else
		{
			System.out.println("Applicant not found");
		}
    }
    
    
    private static void DeleteApplication()
    {
    	System.out.println("-----Delete Applicant Information-----\n");
    	System.out.println("Please enter applicant trn: ");
		trnInput = scan.nextInt();
		while (String.valueOf(trnInput).length() != 9)
		{
			System.out.println("Invalid TRN. TRN must contain 9 digits");
			trnInput = scan.nextInt(); 
		}
		result = searchDriverByTrn(filePath2, trnInput);
		if (result != null) {
			System.out.println("Application record found");
			DeleteTrn("driver_records.csv", trnInput);
		}
		else
		{
			System.out.println("Applicant record not found");
		}
    	
    }
       
    private static void ViewAllDrivingRecords(String X) {
    	try (BufferedReader reader = new BufferedReader(new FileReader(X))) {
            String line;

            System.out.println("----- View All PPV Records -----");

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Split the line into fields based on a delimiter (e.g., comma)
                String[] fields = line.split(",");

                // Ensure the expected number of fields are present
                if (fields.length >= 5) { // Adjusted to suit PPV record structure
                    System.out.println("TRN: " + fields[0]);
                    System.out.println("Badge Number: " + fields[1]);
                    System.out.println("Badge Issue Date: " + fields[2]);
                    System.out.println("Badge Due Date: " + fields[3]);
                    System.out.println("Badge Parish: " + fields[4]);
                    System.out.println("-------------------------");
                } else {
                    // Handle malformed lines
                    System.out.println("Invalid record: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the PPV records: " + e.getMessage());
            e.printStackTrace();
        }
    }
        
    private static void ViewDrivingRecord(String filePath, int targetTRN) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            System.out.println("----- Search PPV Record by TRN -----");

            boolean recordFound = false; // Flag to indicate if a matching record is found

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Split the line into fields based on a delimiter (e.g., comma)
                String[] fields = line.split(",");

                // Ensure the expected number of fields are present
                if (fields.length >= 5) { // Adjusted to suit PPV record structure
                    int trn = Integer.parseInt(fields[0].trim()); // Assuming TRN is in the first column

                    // Check if the TRN matches the target TRN
                    if (trn == targetTRN) {
                        System.out.println("TRN: " + fields[0]);
                        System.out.println("Badge Number: " + fields[1]);
                        System.out.println("Badge Issue Date: " + fields[2]);
                        System.out.println("Badge Due Date: " + fields[3]);
                        System.out.println("Badge Parish: " + fields[4]);
                        System.out.println("-------------------------");

                        recordFound = true; // Update flag
                        break; // Stop searching after finding the first match
                    }
                } else {
                    // Handle malformed lines
                    System.out.println("Invalid record: " + line);
                }
            }

            if (!recordFound) {
                System.out.println("No PPV record found for TRN: " + targetTRN);
            }
        } catch (IOException e) {
            System.out.println("Error reading the PPV records: " + e.getMessage());
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid TRN format in the file.");
            e.printStackTrace();
        }
    }

    
        
    
    private static void TIOCSAddTicket()
    {
    	System.out.println("-----Add Ticket to Offender-----\n");
    	System.out.println("Please enter offender trn: ");
		trnInput = scan.nextInt();
		while (String.valueOf(trnInput).length() != 9)
		{
			System.out.println("Invalid TRN. TRN must contain 9 digits");
			trnInput = scan.nextInt(); 
		}
		result = searchDriverByTrn("driver_records.csv", trnInput);
		if (result != null) {
            System.out.println("Found driver record");
            System.out.println("Please enter offense Code (1-7) to apply to offender:"
            		+ "\n1 - Aid And Abet No Driver’s Licence or Permit"
            		+ "\n2 - Aid And Abet Operating Motor Vehicle..."
            		+ "\n3 - Body Protruding "
            		+ "\n4 - Breach of special permit"
            		+ "\n5 - Careless Driving Causing Collision"
            		+ "\n6 - Careless Driving Where No Collision Occurs"
            		+ "\n7 - Carrying dangerous goods without the transport....");
            offenseCodeInput = scan.nextInt();
            while(offenseCodeInput <=0  || offenseCodeInput > 7)
            {
            		System.out.println("That offenseCode is not available. Please enter offense Code (1-7).");
            		offenseCodeInput = scan.nextInt();
            }
            offenseDescInput = GenerateOffenseDesc(offenseCodeInput,offenseDescInput);
            fineAmtInput = GenerateFine(offenseCodeInput, fineAmtInput);
            Address c1 = new Address(144,"Maxfield Ave","Kingston");
            
            Ticket tic = new Ticket(trnInput, ticketNum, today, weeks, offenseCodeInput, offenseDescInput, 
                    ticketPayStatusInput, fineAmtInput, courtDateInput, c1, totalUnpaidTicInput, 
                    totalFineAmtInput, warrantInput);
            JCFOfficer jcf = new JCFOfficer();
            tic.DisplayTicket();
            jcf.DisplayTicketOfficer();
            System.out.println("Driver details : " + result);
            
            try (FileWriter writer = new FileWriter("ticket_records.csv", true)) {
                writer.append(tic.toCSV());
                writer.append("\n");
            } catch (IOException e) {
                System.out.println("An error occurred while saving the ticket.");
                e.printStackTrace();
            }
            ticketNum++;
            SaveCount(filePath, ticketNum);
            }
               
          //Saves the current ticket number to file
    
    
    }
    
    
    
    
    private static void TIOCSViewCurrentTicket()
    {
    String lastRecord = readLastRecord("ticket_records.csv");
	if (lastRecord != null) {
	    System.out.println("Last record: " + lastRecord);
	}
	
	//A JCF Officer should be able to view the current ticketing information 
    //that was added and verified with the driver before the final submission.
    System.out.println("\n");
    System.out.println("Was the ticket verified with the driver before final submission? "
    		+ "\nOptions: Yes or No?");
    choice = scan.next().toUpperCase();
    while (!choice.equals("YES") && !choice.equals("NO"))
    {
    	System.out.println("Invalid choice. Was the ticket verified with driver before final submission?"
    			+ "\nOptions: Yes or No?");
    	choice = scan.next().toUpperCase();
    }
    if (choice.equals("YES"))
    {
    	System.out.println("Final Submission of Ticket has been made after verifying with driver.");
    	
    }
    else
    {
    	System.out.println("Last Ticket has been deleted from system because driver has not reviewed it to make Final Submission.");
    	deleteLastRecord(filePath3);
    }
}
    
    private static void TIOCS()
    {
    	System.out.print("Welcome to the Ticketing Issuing and Offender Checking System (TIOCS)"
    			+ "\nHow may I assist?"
    			+ "\n1 - JCF Officer"
    			+ "\n2 - Driver"
    			+ "\n3 - Exit"
    			+ "\nEnter an option:");
    	

    	option = scan.nextInt();
    	
    	switch (option)
    	{
    	//JCF Officer Option
    	case 1:
    		System.out.println("Please enter the admin password:");
    		passcode = scan.next();
    		if (passcode.equals(adminPass))
    		{
    			System.out.println("1- Add new ticket to offender (driver)"
    					+ "\n2 - View current ticketing information"
    					+ "\n3 - Check status of a driver in the system"
    					+ "\n4 - View all outstanding tickets (sorted by parish)"
    					+ "\nEnter an option:");
    			
    			option = scan.nextInt();
    			switch (option)
    			{
    			case 1:
    				TIOCSAddTicket();
    				
    				break;//break statement within inner loop
    			case 2:
    				
    				
    				TIOCSViewCurrentTicket();
    				break;//break statement within inner loop
    				
    				
    			case 3:    				
    				TIOCSCheckDriverStatus();//break statement within inner loop
    				break;
    			case 4:
					System.out.println("Unfortunately the feature you selected is not available at this time");
					break;
    				
    				default:
    				System.out.println("Invalid Input");
    					break;
    				
    				
    				
    			}}//end of if statement
    		else {
    			System.out.println("Invalid password");
    		}
    			
    	break;//end of main case
    	case 2:
    		System.out.println("Enter driver trn number: ");
			trnInput = scan.nextInt();
			while (String.valueOf(trnInput).length() != 9)
			 {
			    System.out.println("TRN must be of length 9 digits. Please try again.");
			    System.out.println("Enter trn:");
			    trnInput = scan.nextInt();
			 }
			result = searchDriverByTrn("driver_records.csv", trnInput);
			if (result != null) 
			{
				System.out.println("Driver record found");
				System.out.println("1 – Check for all past tickets for driver (ascending alphabetical order) "
	    				+ "\n2 – Make online payment for tickets (that are issued but not past due)"
	    				+ "\n3 – Check for past-due tickets. Tickets which have passed the 21 days for payment will reflect a court details. "
	    				+ "\n4 - View ticket(s) that have not passed due based on their TRN"
	    				+ "\n5 – Check where there is a warrant issued and display which police station they should turn themselves in."
	    				+ "Enter an option:");
	            option = scan.nextInt();
	            //while loop validate the option selected
	            while (option <=0 || option > 5)
	            {
	            	System.out.println("Invalid input.");
	            	System.out.println("1 – Check for all past tickets for driver (ascending alphabetical order) "
		    				+ "\n2 – Make online payment for tickets (that are issued but not past due)"
		    				+ "\n3 – Check for past-due tickets. Tickets which have passed the 21 days for payment will reflect a court details. "
		    				+ "\n4 - View ticket(s) that have not passed due based on their TRN"
		    				+ "\n5 – Check where there is a warrant issued and display which police station they should turn themselves in."
		    				+ "Enter an option:");
	                option = scan.nextInt();
	            }
	            switch (option)
	            {
	            case 1:
	            	//ShowDriverPastTickets(String filePath3, int trn1)
	            	break;
	            case 2:
	            	PayTicketOnline();
	            	break;
				case 3:
					ShowPastDueDates("ticket_records.csv",trnInput);
					break;
				case 4: 
					ShowNotPastDueDates("ticket_records.csv",trnInput);
					break;
				case 5:
					//ShowWarrant("ticket_records",trnInput);
					break;
				
				}
				}
				else
				{
				System.out.println("Driver record not found");
				}
    	break;
    	case 3:
    		state = false;
    	break;	
    	default:
    		System.out.println("Invalid Option");
    	break;
    	}
    	
    	System.out.println("\n");
    	
    }//end of TIOCS
    
    private static void RPLTS()
    {
    	System.out.println("***Red Plate Licensing System***");
		System.out.println("\n");
		System.out.println("1 - Processing Officer"
				+ "\n2 - Driver"
				+ "\n3 - Exit"
				+ "\nEnter an option:");
		option = scan.nextInt();
		while (option <=0  || option > 3 )
		{
			System.out.println("Invalid Input. Please enter a valid option"
					+ "Enter an option: ");
			option = scan.nextInt();
		}
		switch (option)
		{
		case 1:
			System.out.println("Enter admin pass");
			passcode = scan.next();
			if (passcode.equals(adminPass))
    		{
				System.out.println("1: Create an Application");
				System.out.println("2: Update an Application");
				System.out.println("3: Delete an Application");
				System.out.println("4: View a Driver's Driving Records");
				System.out.println("5: View All Drivers with PPV License");
				System.out.println("6 - View Applicant outstanding tickets");
				System.out.println("7: Exit");
				option = scan.nextInt();
				while (option <=0  || option > 7 )
				{
					System.out.println("Invalid Input. Please enter a valid option"
							+ "Enter an option: ");
					option = scan.nextInt();
				}
				switch (option)
				{
					case 1:
						CreateApplication();
					break;
					case 2:
						UpdateApplication();
					break;
					case 3:
						DeleteApplication();
					break;
					case 4:
						System.out.println("Enter driver trn number: ");
						trnInput = scan.nextInt();
						while (String.valueOf(trnInput).length() != 9)
						  {
						    System.out.println("TRN must be of length 9 digits. Please try again.");
						    System.out.println("Enter trn:");
						    trnInput = scan.nextInt();
						  }
						result = searchDriverByTrn("driver_records.csv", trnInput);
						if (result != null) 
						{
							ViewDrivingRecord("ppv_records.csv",trnInput);
						}
						else
						{
							System.out.println("Applicant not found");
						}
						
					break;
					case 5:
						ViewAllDrivingRecords("ppv_records.csv");
					break;
					case 6:
						System.out.println("Enter driver trn number: ");
						trnInput = scan.nextInt();
						while (String.valueOf(trnInput).length() != 9)
						  {
						    System.out.println("TRN must be of length 9 digits. Please try again.");
						    System.out.println("Enter trn:");
						    trnInput = scan.nextInt();
						  }
						result = searchDriverByTrn(filePath2, trnInput);
						if (result != null) 
						{
							ShowPastDueDates(filePath3,trnInput);
						}
						else
						{
							System.out.println("Applicant not found");
						}
					break;
					case 7:
						state = false;
						break;
					
				}
				
		    	
    		}
			else
			{
				System.out.println("Invalid password");
			}
			break;
		case 2:
			
			break;
		case 3:
			state = false;
		
		}//end of switch statement
		
		
    }
    
}//end of Class Main
