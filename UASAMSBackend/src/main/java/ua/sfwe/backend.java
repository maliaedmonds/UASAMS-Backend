package ua.sfwe;
import java.util.InputMismatchException;
import java.util.Scanner; //this will be used to read in test data 


public class Backend {
    
    ////Testing classes////
    public void printTestMenu(){
        System.out.println("Menu:");
        System.out.println("0) quit testing mode");
        System.out.println("1) Test user database");
        System.out.println("2) Test scholarship database");
        System.out.println("3) Scholarship applications"); 
        System.out.println("4) Search scholarship by name");
        System.out.println("5) Search user by name");
        System.out.println("6) Switch user");
        System.out.println("7) Test scholarship archival");
        System.out.println();
    }

    public void databaseTestMenu(){
        System.out.println("Database Menu:");
        System.out.println("1) Create and add object to database");
        System.out.println("2) Remove object from database");
        System.out.println("3) Edit object in database");
        System.out.println("4) Print database");
        System.out.println();
    }

    public void applicationTestMenu(){
        System.out.println("Application Menu:");
        System.out.println("1) New application to a scholarship");
        System.out.println("2) Edit a previously submitted application");
        System.out.println();
    }

    ////Testing classes////
    public static void main(String[] args) {
        
        Backend app = new Backend(); //This creates an instance of the backend class
        UserDatabase userData = new UserDatabase();
        scholarshipDatabase scholarshipData = new scholarshipDatabase();
        //This creates an object of each of our databases
        boolean exit = false; //This is used to exit the program loop once the application is ended

        User currentUser = new User();
        String baseAdminName = "Adimn1";
        String baseAdminPermissions = "admin"; 
        String baseAdminID = "admin1";
        Admin admin = new Admin();
        admin.setName(baseAdminName);
        admin.setAdminID(baseAdminID);
        admin.setUserPermission(baseAdminPermissions);
        //This creates our base admin account which will be the only account in the database at the start
        userData.addToDatabase(admin); //This adds the admin to the database since they are the first user
        currentUser = admin; //This sets the current user to the admin 
        Scanner input =new Scanner(System.in);
        System.out.println("\n********** Welcome to the UArizona Scholarship Application Management System. **********\n");
        System.out.print("To start using the system type 'Login':");
        String userStartInput = input.nextLine(); 
        while(exit == false){
            if("Login".equals(userStartInput)){
                break;
            } 
            else{
                System.out.print("\nTo start using the system type 'Login':");
                userStartInput = input.nextLine(); 
            }
        }
        System.out.println();
        
        while(exit == false){ //This is our main loop
            try{
                app.printTestMenu();
                System.out.print("Enter a number to select an option: ");
                int appAction = input.nextInt(); //This reads in the user's option
                input.nextLine(); //This is used to clear the scanner buffer
                int databaseAction; //This will be used to read in the user's option for the database test menu
                if(appAction == 0){
                    exit = true; //This will exit the loop on the next iteration
                }
                else if(appAction == 1){ //This will be used for testing the user database
                    if("admin".equals(currentUser.getUserPermission())){ //This is guarded by the admin permission since only admins are allowed to work with user accounts
                        app.databaseTestMenu();
                        System.out.print("Enter a number to select an option: ");
                        databaseAction = input.nextInt(); //This reads in the user's option
                        input.nextLine(); //This is used to clear the scanner buffer
                        if(databaseAction == 1){ //add to user database
                            User newUser = new User();
                            newUser = admin.createAccount(input);
                            userData.addToDatabase(newUser);
                        }
                        else if(databaseAction == 2){ //remove from user database
                            System.out.print("Enter the ID of the user you would like to remove: ");
                            String userName = input.nextLine(); //This reads in the user's option
                            userData.removeFromDatabase(userName);
                        }
                        else if(databaseAction == 3){ //edit user in database
                            System.out.print("Enter the ID of the user you would like to edit: ");
                            String userName = input.nextLine(); //This reads in the user's option
                            userData.editUserInDatabase(userName, input);
                        }
                        else if(databaseAction == 4){ //print user database
                            userData.printDatabase();
                        }
                        else{
                            System.out.println("Invalid option. Please try again.");
                        }
                    }
                    else{
                        System.out.println("You do not have permission to perform this action.");
                    }
                }
                else if(appAction == 2){ //This will be used for testing the scholarship database
                    if("donor".equals(currentUser.getUserPermission())){ //Only donors can create scholarships
                        app.databaseTestMenu();
                        System.out.print("Enter a number to select an option: ");
                        databaseAction = input.nextInt(); //This reads in the user's option
                        input.nextLine(); //This is used to clear the scanner buffer
                        if(databaseAction == 1){ //add to scholarship database
                            scholarship newScholarship = new scholarship();
                            donor currentDonor = (donor) currentUser; //Need to typcast the current user to a donor
                            newScholarship = currentDonor.createNewScholarship(input);
                            scholarshipData.addToDatabase(newScholarship); //Adds the scholarship to the scholarship database
                        }
                        else if(databaseAction == 2){ //remove from scholarship database
                            System.out.print("Enter the name of the scholarship you would like to remove: ");
                            String scholarshipName = input.nextLine(); //This reads in the user's option
                            scholarshipData.removeFromDatabase(scholarshipName);
                        }
                        else if(databaseAction == 3){   //edit scholarship in database
                            System.out.print("Enter the name of the scholarship you would like to edit: ");
                            String scholarshipName = input.nextLine(); //This reads in the user's option
                            scholarshipData.editScholarshipInDatabase(scholarshipName, input);
                        }
                        else if(databaseAction == 4){ //print scholarship database
                            scholarshipData.printDatabase();
                        }
                        else{
                            System.out.println("Invalid option. Please try again.");
                        }
                    }
                    else{
                        System.out.println("You do not have permission to perform this action.");
                    }
                }
                else if(appAction == 3){ //Student applies to scholarship
                   if("student".equals(currentUser.getUserPermission())){
                        app.applicationTestMenu();
                        System.out.print("Enter a number to select an option: ");
                        int action = input.nextInt(); //This reads in the user's option
                        input.nextLine(); //This is used to clear the scanner buffer
                        if(action == 1){ //New application to a scholarship
                            student currentStudent = (student) currentUser; //Need to typcast the current user to a student
                            System.out.print("Enter the name of the scholarship you would like to apply to: ");
                            String scholarshipName = input.nextLine(); //This reads in the user's option
                            scholarship returned = scholarshipData.searchByName(scholarshipName);
                            currentStudent.applyForScholarship(returned, input);
                            System.out.println();
                        }
                        else if(action == 2){ //Edit a previously submitted application
                            student currentStudent = (student) currentUser; //Need to typcast the current user to a student
                            System.out.print("Enter the name of the scholarship you would like to edit: ");
                            String scholarshipName = input.nextLine(); //This reads in the user's option
                            currentStudent.updateSavedApplications(scholarshipName, input);
                            System.out.println();
                        }
                        else{
                            System.out.println("Invalid option. Please try again.");
                        }
                   }
                   else{
                       System.out.println("You do not have permission to perform this action.");
                   }
                }
                else if(appAction == 4){
                    if("student".equals(currentUser.getUserPermission()) || "reviewer".equals(currentUser.getUserPermission()) ||"admin".equals(currentUser.getUserPermission())){
                        //This check the user permission we allow admins to do everything
                        scholarship foundScholarship;
                        System.out.print("Enter the name of the scholarship you would like to search for: ");
                        String scholarshipName = input.nextLine(); //This reads in the user's option
                        foundScholarship = scholarshipData.searchByName(scholarshipName);
                        if(foundScholarship != null){
                            foundScholarship.printScholarshipInfo(); //This prints the scholarship info
                        }
                        else{
                            System.out.println("Scholarship not found.");
                        }
                        System.out.println();
                    }
                    else{
                        System.out.println("You do not have permission to perform this action.");
                    }
                }
                else if(appAction == 5){ //Search user by name
                    if("currentUser.getUserPermission()".equals("admin")){
                        User foundUser;
                        System.out.println("Enter the name of the user you would like to search for: ");
                        String userName = input.nextLine(); //This reads in the user's option
                        foundUser = userData.searchByName(userName);
                        if(foundUser != null){
                            if("admin".equals(foundUser.getUserPermission())){
                                Admin foundAdmin = (Admin) foundUser;
                                foundAdmin.printInfo();
                            }
                            else if("donor".equals(foundUser.getUserPermission())){
                                donor foundDonor = (donor) foundUser;
                                foundDonor.printInfo();
                            }
                            else if("reviewer".equals(foundUser.getUserPermission())){
                                reviewer foundReviewer = (reviewer) foundUser;
                                foundReviewer.printInfo();
                            }
                            else if("student".equals(foundUser.getUserPermission())){
                                student foundStudent = (student) foundUser;
                                foundStudent.printInfo();
                            }
                            else{
                                System.out.println("**** Error occured ****");
                            }
                        }
                        else{
                            System.out.println("User not found.");
                        }
                    } 
                    else{
                        System.out.println("You do not have permission to perform this action.");
                    }  
                }
                else if(appAction == 6){
                    System.out.print("Enter the ID numeber of the user you would like to switch to: ");
                    String userID = input.nextLine(); //This reads in the user's option
                    currentUser = userData.searchByID(userID);
                    if(currentUser != null){
                        System.out.println("User switched to " + currentUser.getName() + " (" + currentUser.getUserPermission() + ") successfully.");
                        //Print out the name of the user that was switched to
                    }
                    else{
                        System.out.println("User not found.\n");
                    }
                }
                else if(appAction == 7){
                    if("student".equals(currentUser.getUserPermission())){
                        System.out.print("Enter the name of the scholarship you would like to archive (For testing purposes): ");
                        String scholarshipName = input.nextLine(); //This reads in the user's option
                        scholarship foundScholarship = scholarshipData.searchByName(scholarshipName);
                        student currentStudent = (student) currentUser; //Need to typcast the current user to a student
                        if(foundScholarship != null){
                            currentStudent.archiveAwardedScholarship(foundScholarship); //This tests the archival function for a scholarship
                        }
                        else{
                            System.out.println("Scholarship not found.");
                        }
                    }
                    else{
                        System.out.println("You do not have permission to perform this action.");
                    }
                }   
                else{
                    System.out.println("\nInvalid option. Please try again.\n");
                }
            }
            catch(InputMismatchException e){
                System.out.println("\n********** Invalid input. Returning to main menu. Nothing was saved. Please try again. **********\n");
                System.out.println("Hit enter to acknowledge this message: \n");
                input.nextLine(); //This is used to clear the scanner buffer
                continue;
            } //This is the error handling for the scanner object if there is a type mismatch
            catch(Exception e){
                System.out.println("\n********** Unexpected error occured. Returning to main menu. Please try again. **********\n");
                System.out.println("Hit enter to acknowledge this message: \n");
                input.nextLine(); //This is used to clear the scanner buffer
                continue;
            } //This will catch all errors if they occur and return to the main menu
        }
        System.out.println("\n********** Thank you for using the UArizona Scholarship Application Management System. **********\n");
        input.close(); //This closes the scanner object

    }
}