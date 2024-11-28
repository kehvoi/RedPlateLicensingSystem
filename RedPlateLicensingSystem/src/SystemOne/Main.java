package SystemOne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {

	
	
	
	
    // Global variable to hold the ticket number
    public static int ticketNum = 1;
    //PPV100000
    //PPV100001
    public static int ppvNum = 100000;
    public static String ppvLicense;
    public static int option;
    public static int license;
    
    public static int trnInput;
    public static String result;
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

    public static void main(String[] args) 
    {
    	//Declaration of ArrayLists 
    	ArrayList<Driver> Drivers = new ArrayList<>();
    	ArrayList<Ticket> Tickets = new ArrayList<>();
    	
		//Default User 1
		Name d1 = new Name("John", "Brown");
		Address a1 = new Address(19,"Maldave Avenue","Kingston");
		Driver driver1 = new Driver(123456789,d1, LocalDate.parse("2000-05-05"),a1, "john.brown@gmail.com", "8768403526", "Male");

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
		
    	String filePath2 = "driver_records.csv";
        String filePath = "ticketCount.txt";

        // Load ticket number from the file
        ticketNum = LoadTicketNum(filePath);
        
        
        Scanner scan = new Scanner(System.in);
        String adminPass = "ABC123";
        String passcode;
        
        boolean state = true;
        
        //Loads in the default users before the while loop starts
        DefaultDrivers("driver_records.csv", Drivers);// Suppose to be in system 1
        
        try 
        {
        	while (state)
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
            	case 1:
            		System.out.println("Please enter the admin password:");
            		passcode = scan.next();
            		if (passcode.equals(adminPass))
            		{
            			System.out.println("1- Add new ticket to offender (driver)"
            					+ "\n2 - Delete offender (driver) ticket"
            					+ "\n3 - View current ticketing information"
            					+ "\n4 - Check status of a driver in the system"
            					+ "\n5 - View all outstanding tickets (sorted by parish)"
            					+ "\nEnter an option:");
            			
            			option = scan.nextInt();
            			if (option == 1)
            			{
            				System.out.println("Please enter offender trn: ");
            				trnInput = scan.nextInt();
            				if (String.valueOf(trnInput).length() == 9)
            				{
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
                		            
                		            
                		            Tickets.add(tic);
                		            
                		            AddTicket("ticket_records.csv", Tickets);
                		            
                		            ticketNum++;
                		          //Saves the current ticket number to file
                		            SaveTicketNum(filePath, ticketNum);
                		            
                		            
                		            
                		  
                		            
                		            
                		        } else {
                		            System.out.println("Driver not found with TRN");
                		        }  
            				}
            				else
            				{
            				  System.out.println("Invalid TRN. TRN must contain 9 digits");
            				}
            				
            				
            				
            				
            				System.out.println("");
            				
            				
            				
            			}
            		}
            		else
            		{
            			System.out.println("Wrong Password please try again");
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
            	
            	
            	
            }//end while loop
        	}//end try
        	catch(InputMismatchException e)
            {
            	System.out.println("You inputted the wrong data type!");
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
    
    private static void AddTicket(String filePath3, ArrayList<Ticket> parameterList) {
        File file = new File(filePath3);

        // If the file doesn't exist, create it and add tickets
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
                System.out.println("Ticket is Successfully Loaded");
                
               // Write the drivers to the file
            try (FileWriter writer = new FileWriter(file, true)) {
                for (Ticket ticket : parameterList) {
                    writer.write(ticket.toCSV());  // Get the CSV string and write it to the file
                    writer.append("\n");  // Append a newline after each driver's record
                }
              } //end second try
              catch (IOException e) {
                System.out.println("An error occurred while saving the driver info.");
                e.printStackTrace();
              }//end catch  
                
                
                
            }//endif
            else
            {
            	try (FileWriter writer = new FileWriter(file, true)) {
                    for (Ticket ticket : parameterList) {
                        writer.write(ticket.toCSV());  // Get the CSV string and write it to the file
                        writer.append("\n");  // Append a newline after each driver's record
                    }
                  } //end second try
                  catch (IOException e) {
                    System.out.println("An error occurred while saving the driver info.");
                    e.printStackTrace();
                  }//end catch  
            }

           
        }//end first try 
        catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }// end DefaultDrivers method
    
    //Generate Offense Description based on offense code
    private static String GenerateOffenseDesc(int offenseCode, String offenseDesc)
	{
		switch (offenseCode)
		{
		case 1:
			return offenseDesc = "Aid And Abet No Driver’s Licence or Permit";
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
    
    //Add Ticket Method 
    
}//end of Class Main
