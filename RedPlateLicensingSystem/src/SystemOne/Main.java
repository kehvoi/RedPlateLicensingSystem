package SystemOne;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

    public static void main(String[] args) 
    {
    	//Declaration of ArrayList that contains Default Users
    	ArrayList<Driver> Drivers = new ArrayList<>();

		//Default User 1
		Name d1 = new Name("John", "Brown");
		Address a1 = new Address(19,"Maldave Avenue","Bellford","Kingston");
		Driver driver1 = new Driver(d1, LocalDate.parse("2000-05-05"), 100000001, a1, "john.brown@gmail.com", "8768403526", "Male");

		//Default User 2
		Name d2 = new Name("Mary", "Anderson");
		Address a2 = new Address(12, "Redwood Lane", "Sunnydale", "St. Andrew");
		Driver driver2 = new Driver(d2, LocalDate.parse("1995-08-15"), 100000002, a2, "mary.anderson@gmail.com", "8761234567", "Female");

		//Default User 3
		Name d3 = new Name("Sashana","Blackwood");
		Address a3 = new Address(88,"Stockforth Road","BellRoad","St.Thomas");
		Driver driver3 = new Driver(d3, LocalDate.parse("2001-08-05"), 100000003, a3, "sashana.blackwood@gmail.com", "8767252731", "Female");

		Drivers.add(driver1);
		Drivers.add(driver2);
		Drivers.add(driver3);
    	
		
		//ArrayList<Ticket> Tickets = new ArrayList<>();
		
    	
    	
    	
    	
        String filePath = "ticketCount.txt";

        // Load ticket number from the file
        ticketNum = LoadTicketNum(filePath);
        
        
        Scanner scan = new Scanner(System.in);
        String adminPass = "ABC123";
        String passcode;
        int trnInput;
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
            					+ "\nEnter an option");
            			
            			option = scan.nextInt();
            			if (option == 1)
            			{
            				System.out.println("Please enter offender trn: ");
            				trnInput = scan.nextInt();
            				//if (trnInput == searchTRN(trn))
            				//{
            					System.out.println("Please enter offenseCode");
            				
            				//}
            				
            				
            				
            				
            				System.out.println("");
            				
            				ticketNum++;
            				
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
            
            //Saves the current ticket number to file
            SaveTicketNum(filePath, ticketNum);
            System.out.println("Thank you for your business. Have a nice day");
            
            
        }// end of public static void main
        
        
  



    
    
    
    //Methods for Drivers
    
  //Method to Load Default Driver Records
    public static void DefaultDrivers(String filePath, ArrayList<Driver> parameterList) {
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
    
    
    //Methods for Ticket Class
    
    // Method to load the ticket number from the file
public static int LoadTicketNum(String filepath) {
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
    public static void SaveTicketNum(String filepath, int ticketNum) {
        try (FileWriter writer = new FileWriter(filepath)) {
            // Write the ticket number to the file
            writer.write(String.valueOf(ticketNum));
        } catch (IOException e) {
            System.out.println("An error occurred while saving the ticket number.");
            e.printStackTrace();
        }
    }
    
    
    
   
    
    
    
    
}//end of Class Main







