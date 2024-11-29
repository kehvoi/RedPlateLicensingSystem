package SystemOne;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
    // Global variable to hold the ticket number
    public static int ticketNum = 7;
    //PPV100000
    //PPV100001
    public static int ppvNum = 100000;
    public static String ppvLicense;
    public static int option;
    public static int license;
    public static String choice;
    
    public static int trnInput;
    public static String result;
    public static Scanner scan = new Scanner(System.in);
    public static String adminPass = "ABC123";
    public static String passcode;
    //Global variables for ticket
    
    public static LocalDate today = LocalDate.now();
    public static LocalDate weeks = today.plusWeeks(3);
    public static LocalDate courtDateInput = weeks.plusWeeks(1);
    public static int offenseCodeInput;
    public static String offenseDescInput;
    public static int fineAmtInput;
    public static int totalUnpaidTicInput;
    public static int totalFineAmtInput;
    public static boolean warrantInput = false;
    public static String ticketPayStatusInput = "Unpaid";
    public static boolean state = true;
    
    public static String filePath3 = "ticket_records.csv";
	public static String filePath2 = "driver_records.csv";
    public static String filePath = "ticketCount.txt";
    

    public static void main(String[] args) 
    {
    	//Declaration of ArrayLists 
    	ArrayList<Driver> Drivers = new ArrayList<>();
    	ArrayList<Ticket> Tickets = new ArrayList<>();
    	
		//Default User 1
		Name d1 = new Name("John", "Brown");
		Address a1 = new Address(19,"Maldave Avenue","Kingston");
		Driver driver1 = new Driver(123456789,d1, LocalDate.parse("2000-05-05"),a1, "john.brown@gmail.com", "8768403526", "Male");
		
		//Tickets for User 1
		Address t1 = new Address(144,"Maxfield Ave","Kingston");
		Address t2 = new Address(69,"Public West Building","Kingston");
		Address t3 = new Address(24,"Sutton Street","Kingston");
		Address t4 = new Address(36,"Camp Road","Kingston");
		Address t5 = new Address(79,"Duke Street","Kingston");
		Address t6 = new Address (69, "Wilford Street","Kingston");
		
		Ticket defaultTic1 = new Ticket(123456789, 1, LocalDate.parse("2019-01-01"), LocalDate.parse("2019-01-22"), 1, "Aid And Abet No Driver’s Licence or Permit", 
                "Outstanding", 15000, LocalDate.parse("2019-01-29") , t1, 0, 
                0, true);
		
		Ticket defaultTic2 = new Ticket(123456789, 2, LocalDate.parse("2019-06-29"), LocalDate.parse("2019-06-29"), 2, "Aid And Abet Operating Motor Vehicle...", 
                "Paid", 30000, LocalDate.parse("2019-06-29") , t2, 0, 
                0, false);
		
		Ticket defaultTic3 = new Ticket(123456789, 3, LocalDate.parse("2004-01-01"), LocalDate.parse("2004-01-22"), 3, "Body Protruding", 
                "Paid", 5000, LocalDate.parse("2004-01-29") , t3, 0, 
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
		
        
		//Default User 2
		Name d2 = new Name("Mary", "Anderson");
		Address a2 = new Address(12, "Redwood Lane", "St.Andrew");
		Driver driver2 = new Driver(987654321, d2, LocalDate.parse("1995-08-15"),a2, "mary.anderson@gmail.com", "8761234567", "Female");

		//Default User 3
		Name d3 = new Name("Sashana","Blackwood");
		Address a3 = new Address(88,"Stockforth Road","St.Thomas");
		Driver driver3 = new Driver(100000000,d3, LocalDate.parse("2001-08-05"),a3, "sashana.blackwood@gmail.com", "8767252731", "Female");

		Drivers.add(driver1);
		Drivers.add(driver2);
		Drivers.add(driver3);
		
		
        

        // Load ticket number from the file
        ticketNum = LoadTicketNum(filePath);
        
        
        
        
        
        
        //Loads in the default users and tickets before the while loop starts
        DefaultDrivers("driver_records.csv", Drivers);//
        DefaultTickets("ticket_records.csv", Tickets);
        
        try 
        {
        	while (state)
            {
        		System.out.println("Welcome to the Jamaica Constabulary Force and Public Passenger Vehicle Association. How may I assist?"
        				+ "\n1 - Red Plate Licensing System (RPLS)"
        				+ "\n2 - Ticketing Issuing and Offender Checking System (TIOCS)"
        				+ "\n3 - Exit"
        				+ "\nEnter an option:");
        		option = scan.nextInt();
        		switch (option)
        		{
        		case 1:
        			RPLS();
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
            
            
        }// end of public static void main
        
        
  



    
    
    
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
                    // Write initial ticket number (1) to the file
                    SaveTicketNum(filepath, 1);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while creating the file.");
                e.printStackTrace();
            }
        }

        return 0; // Return default value if the file was not found or read fails
    }

    // Method to save the ticket number back to the file
    private static void SaveTicketNum(String filepath, int ticketNum) {
        try (FileWriter writer = new FileWriter(filepath)) {
            // Write the ticket number to the file
            writer.write(String.valueOf(ticketNum));
        } catch (IOException e) {
            System.out.println("An error occurred while saving the ticket number.");
            e.printStackTrace();
        }
    }
    
    
    
    private static void DefaultTickets(String filePath4, ArrayList<Ticket> parameterList) {
        File file = new File(filePath4);

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
    
    //Searches Driver Ticket Due Date
    
    public static void displayRowsWithPastDueDates(String filePath3) {
        
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
                        if (ticketDueDate.isBefore(LocalDate.now()) && ticketPayStatus.equalsIgnoreCase("Unpaid")) {
            	            System.out.println(line);
                    } 
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
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
    
    private static void TIOCSAddTicket()
    {
    	System.out.println("Please enter offender trn: ");
		trnInput = scan.nextInt();
		while (String.valueOf(trnInput).length() != 9)
		{
			System.out.println("Invalid TRN. TRN must contain 9 digits");
			trnInput = scan.nextInt(); 
		}
		result = searchDriverByTrn(filePath2, trnInput);
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
            SaveTicketNum(filePath, ticketNum);
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
    				//Focus on this lock in
    				
    				System.out.println("1 - Verify if the Driver has any unpaid tickets past 21 days"
    						+ "\n2 -View all offenders who have outstanding tickets pending"
    						+ "\n3 - View all the outstanding tickets in a specific parish"
    						+ "\nEnter an option:");
    						option = scan.nextInt();
    						switch (option)
    						{
    						case 1:
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
    						            System.out.println("Found driver record");
    						            
    						            
    						            System.out.println("Searching driver's due tickets...");
    						            displayRowsWithPastDueDates(filePath3);
    								}
    								else {
    						            System.out.println("Driver not found with TRN");
    						        }  
    							
    							
    							break;
    						case 2:
    							
    							break;
    						case 3:
    							break;
    						default:
    							System.out.println("Invalid input");
    							break;
    						}
    				break;
    				
    				default:
    				System.out.println("Invalid Input");
    					break;
    				
    				
    				
    			}}//end of if statement
    		else {
    			System.out.println("Invalid password");
    		}
    			
    	break;
    	case 2:
    		
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
    
    private static void RPLS()
    {
    	
    }
    
}//end of Class Main
