package main.java.ua.sfwe;
import java.util.ArrayList;
import java.util.Scanner;
public class scholarshipDatabase {
    private ArrayList<scholarship> database; //This is our arraylist mock database
    
    public scholarshipDatabase(){ //This is the default constructor
        this.database = new ArrayList<>();
    }
    ///// Start Overloaded constructors for the scholarshipDatabase class /////
    public scholarshipDatabase(ArrayList <scholarship> database){
        this.database = database;
    }
    ///// End Overloaded constructors for the scholarshipDatabase class /////
    
    public void addToDatabase(scholarship newScholarship){ 
        database.add(newScholarship); //This adds a new scholarship to the database
    }


    public void removeFromDatabase(String inputScholarshipName){ 
        boolean deleted = false; //This is a boolean to check if the scholarship was deleted
        for(int i = 0; i < database.size(); i++) { //This loops through the database
            if (database.get(i).getScholarshipName().equals(inputScholarshipName)) { //This checks if the scholarship is in the database
                database.remove(i); //This removes the scholarship from the database
                System.out.println("Scholarship '" + inputScholarshipName + "' removed from database");
                deleted = true; //This sets the boolean to true
            }
        }
        if(deleted == false){ //This checks if the scholarship was deleted
            System.out.println("Scholarship '" + inputScholarshipName + "' not found in database. No scholarships removed.");
        }
        else{
            System.out.println("Scholarship '" + inputScholarshipName + "' removed from database");
        }

    }


    public void editScholarshipInDatabase(String inputScholarshipName, Scanner input){ 
        boolean found = false; //This is a boolean to check if the scholarship was found
        for(int i = 0; i < database.size(); i++) { //This loops through the database
            if(database.get(i).getScholarshipName().equals(inputScholarshipName)){ //NAMES are immutable so we can always use this to find the scholarship
                found = true; //This sets the boolean to true
                int choice = 1;
                while(choice != 0){
                    updateScholarshipMenu();
                    choice = input.nextInt();
                    input.nextLine(); //This is to clear the buffer
                    if(choice == 1){ //Payout
                        System.out.print("Enter new payout: ");
                        int newPayout = input.nextInt();
                        input.nextLine(); //This is to clear the buffer
                        database.get(i).setPayout(newPayout);
                    }
                    else if(choice == 2){ //Deadline
                        System.out.print("Enter new deadline: ");
                        String newDeadline = input.nextLine();
                        database.get(i).setDeadline(newDeadline);
                    }
                    else if(choice == 3){ //Custom Required Information
                        System.out.print("Enter new custom required information: (CSV)");
                        String newCustomRequiredInfo = input.nextLine();
                        database.get(i).setCustomRequiredInfo(newCustomRequiredInfo);
                    }
                    else if(choice == 4){ //Preferred Majors
                        System.out.print("Enter new preferred majors: ");
                        String newPreferredMajors = input.nextLine();
                        database.get(i).setPreferedMajors(newPreferredMajors);
                    }
                    else{
                        System.out.println("Invalid option. Please try again.");
                    }
                }
            }
        }
        if(found == false){ //This checks if the scholarship was found
            System.out.println("Scholarship '" + inputScholarshipName + "' not found in database. No scholarships edited.");
        }
        else{
            System.out.println("Scholarship '" + inputScholarshipName + "' edited in database");
        }
    }

    public void printDatabase(){
        System.out.println("\nStart of scholarship database records");
        for(int i = 0; i < database.size(); i++) { //This loops through the database
            database.get(i).printScholarshipInfo(); //This prints the scholarship info
        }
        System.out.println("End of scholarship database records\n");
    }
    
    public scholarship searchByName(String inputScholarship){ 
        for(int i = 0; i < database.size(); i++) { //This loops through the database
            if (database.get(i).getScholarshipName().equals(inputScholarship)) { //This checks if the scholarship is in the database
                return database.get(i); //This returns the scholarship
            }
        }
        return null; //This returns null if the scholarship is not found
    }


    private void updateScholarshipMenu(){
        System.out.println("What would you like to update?");
        System.out.println("0) Exit");
        System.out.println("1) Payout");
        System.out.println("2) Deadline");
        System.out.println("3) Custom Required Information");
        System.out.println("4) Preferred Majors");
    }
}
