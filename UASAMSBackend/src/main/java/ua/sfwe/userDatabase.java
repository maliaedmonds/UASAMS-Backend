package ua.sfwe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserDatabase {
 
    private List <User> database; //This is our arraylist mock database

    public UserDatabase(){ //This is the default constructor
        this.database = new ArrayList<>();
    }
    ///// Start Overloaded constructors for the userDatabase class /////
    public UserDatabase(List <User> database){
        this.database = database;
    }
    ///// End Overloaded constructors for the userDatabase class /////
    
    public void addToDatabase(User newUser){ 
        database.add(newUser); //This adds a new scholarship to the database
    }

    
    public void removeFromDatabase(String iD){
        boolean deleted = false; //This is a boolean to check if the user was deleted
        for (int i = 0; i < database.size(); i++) { //This loops through the database
            String userType = database.get(i).getUserPermission(); //This gets the user type
            User foundUser = database.get(i);  //This gets the user in the database
            if("admin".equals(userType)){
                Admin adminUser = (Admin) foundUser; //Typecast to admin child class
                if(adminUser.getAdminID().equals(iD)){
                    database.remove(i);
                    deleted = true;
                }
            }
            else if("reviewer".equals(userType)){
                reviewer reviewerUser = (reviewer) foundUser; //Typecast to reviewer child class
                if(reviewerUser.getReviewerID().equals(iD)){
                    database.remove(i);
                    deleted = true;
                }
            }
            else if("student".equals(userType)){
                Student studentUser = (Student) foundUser; //Typecast to student child class
                if(studentUser.getStudentID().equals(iD)){
                    database.remove(i);
                    deleted = true;
                }
            }
            else if("donor".equals(userType)){
                donor donorUser = (donor) foundUser; //Typecast to donor child class
                if(donorUser.getDonorID().equals(iD)){
                    database.remove(i);
                    deleted = true;
                }
            }
            else{
                //This should never execute just leaving in for sanity check
                System.out.println("Error: User type not found");
            }
        }
        if(deleted == false){ //This checks if the user was deleted
            System.out.println("User '" + iD + "' not found in database. No users removed.");
        }
        else{
            System.out.println("User '" + iD + "' removed from database");}
    }


    public void editUserInDatabase(String iD, Scanner input){ 
        boolean found = false; //This is a boolean to check if the user was found
        for(int i = 0; i < database.size(); i++){
            String userType = database.get(i).getUserPermission(); //This gets the user type
            User foundUser = database.get(i);  //This gets the user in the database
            if("admin".equals(userType)){
                Admin adminUser = (Admin) foundUser; //Typecast to admin child class
                if(adminUser.getAdminID().equals(iD)){
                    int userChoice = 1;
                    updateUserMenu();
                    updateAdminMenu();
                    userChoice = input.nextInt();
                    input.nextLine(); //This is to clear the buffer
                    updateAdmin(adminUser, userChoice, input);
                    found = true;
                }
            }
            else if("reviewer".equals(userType)){
                reviewer reviewerUser = (reviewer) foundUser; //Typecast to reviewer child class
                if(reviewerUser.getReviewerID().equals(iD)){
                    int userChoice = 1;
                    updateUserMenu();
                    updateReviewerMenu();
                    userChoice = input.nextInt();
                    input.nextLine(); //This is to clear the buffer
                    updateReviewer(reviewerUser, userChoice, input);
                    found = true;
                }
            }
            else if("student".equals(userType)){
                Student studentUser = (Student) foundUser; //Typecast to student child class
                if(studentUser.getStudentID().equals(iD)){
                    int userChoice = 1;
                    updateUserMenu();
                    updateStudentMenu();
                    userChoice = input.nextInt();
                    input.nextLine(); //This is to clear the buffer
                    updateStudent(studentUser, userChoice, input);
                    found = true;
                }
            }
            else if("donor".equals(userType)){
                donor donorUser = (donor) foundUser; //Typecast to donor child class
                if(donorUser.getDonorID().equals(iD)){
                    int userChoice = 1;
                    updateUserMenu();
                    updateDonorMenu();
                    userChoice = input.nextInt();
                    input.nextLine(); //This is to clear the buffer
                    updateDonor(donorUser, userChoice, input);
                    found = true;
                }
            }
            else{
                //This should never execute just leaving in for sanity check
                System.out.println("Error: User type not found");
            }
        }
        if(found == false){ //This checks if the user was found
            System.out.println("User '" + iD + "' not found in database. No users edited.");
        }
        else{
            System.out.println("User '" + iD + "' edited in database");
        }
    }


    public User searchByName(String inputUser){
        for(int i = 0; i < database.size(); i++) { //This loops through the database
            if (database.get(i).getName().equals(inputUser)){ //This checks if the user is in the database
                return database.get(i); //This returns the user
            }
        }
        return null; //This returns null if the user is not found
    }

    public void printDatabase(){
        System.out.println("\nStart of user database records");
        for(int i = 0; i < database.size(); i++) { //This loops through the database
            
                Admin foundAdmin = (Admin) database.get(i);
                foundAdmin.printInfo();if(database.get(i).getUserPermission().equals("admin")){
            }
            else if(database.get(i).getUserPermission().equals("donor")){
                donor foundDonor = (donor) database.get(i);
                foundDonor.printInfo();
            }
            else if(database.get(i).getUserPermission().equals("reviewer")){
                reviewer foundReviewer = (reviewer) database.get(i);
                foundReviewer.printInfo();
            }
            else if(database.get(i).getUserPermission().equals("student")){
                Student foundStudent = (Student) database.get(i);
                foundStudent.printInfo();
            }
            else{
                System.out.println("**** Error occured ****");
            }
        }
        System.out.println("End of user database records\n");
    }

    public User searchByID(String inputID){
        for(int i = 0; i < database.size(); i++) { //This loops through the database
            if(database.get(i).getUserPermission().equals("admin")){
                Admin adminUser = (Admin) database.get(i); //Typecast to admin child class
                if(adminUser.getAdminID().equals(inputID)){
                    return (User) adminUser;
                }
            }
            else if(database.get(i).getUserPermission().equals("reviewer")){
                reviewer reviewerUser = (reviewer) database.get(i); //Typecast to reviewer child class
                if(reviewerUser.getReviewerID().equals(inputID)){
                    return (User) reviewerUser;
                }
            }
            else if(database.get(i).getUserPermission().equals("student")){
                Student studentUser = (Student) database.get(i); //Typecast to student child class
                if(studentUser.getStudentID().equals(inputID)){
                    return (User) studentUser;
                }
            }
            else if(database.get(i).getUserPermission().equals("donor")){
                donor donorUser = (donor) database.get(i); //Typecast to donor child class
                if(donorUser.getDonorID().equals(inputID)){
                    return (User) donorUser;
                }
            }
            else{
                //This should never execute just leaving in for sanity check
                System.out.println("Error: User type not found");
            }
        }
        return null; //This returns null if the user is not found
    }
    

    private void updateUserMenu(){
        System.out.println("0) Exit");
        System.out.println("1) Update Name");
        System.out.println("2) Update Email");
        System.out.println("3) Update Security Question");
        System.out.println("4) Update Security Question Answers");
    }
    private void updateStudentMenu(){
        System.out.println("5) Update Major");
        System.out.println("6) Update GPA");
        System.out.println("7) Update Student ID");
        System.out.println("8) Update Citizenship");
        System.out.println("9) Update Units Enrolled");
        System.out.println("10) Update Expected Graduation");
        System.out.println("11) Update Essay Responses");
        System.out.println("12) Update Bursar Account Reference");
    }
    private void updateReviewerMenu(){
        System.out.println("5) Update Reviewer ID");
    }
    private void updateDonorMenu(){
        System.out.println("5) Update Bursar Account Reference");
        System.out.println("6) Update Donor ID");
    }
    private void updateAdminMenu(){
        System.out.println("5) Update Admin ID");
    }
     

    private void updateAdmin(Admin adminUser, int userChoice, Scanner input){
        if(userChoice == 1){ //Name
            System.out.print("Enter new name: ");
            String newName = input.nextLine();
            adminUser.setName(newName);
        }
        else if(userChoice == 2){ //Email
            System.out.print("Enter new email: ");
            String newEmail = input.nextLine();
            adminUser.setEmailAddress(newEmail);
        }
        else if(userChoice == 3){ //Security Question
            System.out.print("Enter new security question: ");
            String newSecurityQuestion = input.nextLine();
            adminUser.setSecurityQuestion(newSecurityQuestion);
        }
        else if(userChoice == 4){ //Security Question Answers
            System.out.print("Enter new security question answers: ");
            String newSecurityQuestionAnswers = input.nextLine();
            adminUser.setSecurityQuestionAnswers(newSecurityQuestionAnswers);
        }
        else if(userChoice == 5){ //Admin ID
            System.out.print("Enter new admin ID: ");
            String newAdminID = input.nextLine();
            adminUser.setAdminID(newAdminID);
        }
        else{
            System.out.println("Invalid option. Please try again.");
        }
    }

    private void updateReviewer(reviewer reviewerUser, int userChoice, Scanner input){
        if(userChoice == 1){ //Name
            System.out.print("Enter new name: ");
            String newName = input.nextLine();
            reviewerUser.setName(newName);
        }
        else if(userChoice == 2){ //Email
            System.out.print("Enter new email: ");
            String newEmail = input.nextLine();
            reviewerUser.setEmailAddress(newEmail);
        }
        else if(userChoice == 3){ //Security Question
            System.out.print("Enter new security question: ");
            String newSecurityQuestion = input.nextLine();
            reviewerUser.setSecurityQuestion(newSecurityQuestion);
        }
        else if(userChoice == 4){ //Security Question Answers
            System.out.print("Enter new security question answers: ");
            String newSecurityQuestionAnswers = input.nextLine();
            reviewerUser.setSecurityQuestionAnswers(newSecurityQuestionAnswers);
        }
        else if(userChoice == 5){ //Reviewer ID
            System.out.print("Enter new reviewer ID: ");
            String newReviewerID = input.nextLine();
            reviewerUser.setReviewerID(newReviewerID);
        }
        else{
            System.out.println("Invalid option. Please try again.");
        }
    }

    private void updateStudent(Student studentUser, int userChoice, Scanner input){
        if(userChoice == 1){ //Name
            System.out.print("Enter new name: ");
            String newName = input.nextLine();
            studentUser.setName(newName);
        }
        else if(userChoice == 2){ //Email
            System.out.print("Enter new email: ");
            String newEmail = input.nextLine();
            studentUser.setEmailAddress(newEmail);
        }
        else if(userChoice == 3){ //Security Question
            System.out.print("Enter new security question: ");
            String newSecurityQuestion = input.nextLine();
            studentUser.setSecurityQuestion(newSecurityQuestion);
        }
        else if(userChoice == 4){ //Security Question Answers
            System.out.print("Enter new security question answers: ");
            String newSecurityQuestionAnswers = input.nextLine();
            studentUser.setSecurityQuestionAnswers(newSecurityQuestionAnswers);
        }
        else if(userChoice == 5){ //Major
            System.out.print("Enter new major: ");
            String newMajor = input.nextLine();
            studentUser.setMajor(newMajor);
        }
        else if(userChoice == 6){ //GPA
            System.out.print("Enter new GPA: ");
            double newGPA = input.nextDouble();
            studentUser.setGpa(newGPA);
        }
        else if(userChoice == 7){ //Student ID
            System.out.print("Enter new student ID: ");
            String newStudentID = input.nextLine();
            studentUser.setStudentID(newStudentID);
        }
        else if(userChoice == 8){ //Citizenship
            System.out.print("Enter new citizenship: ");
            String newCitizenship = input.nextLine();
            studentUser.setCitizenship(newCitizenship);
        }
        else if(userChoice == 9){ //Units Enrolled
            System.out.print("Enter new units enrolled: ");
            int newUnitsEnrolled = input.nextInt();
            input.nextLine(); //This is to clear the buffer
            studentUser.setUnitsEnrolled(newUnitsEnrolled);
        }
        else if(userChoice == 10){ //Expected Graduation
            System.out.print("Enter new expected graduation: ");
            String newExpectedGraduation = input.nextLine();
            studentUser.setExpectedGraduation(newExpectedGraduation);
        }
        else if(userChoice == 11){ //Essay Responses
            System.out.print("Enter new essay responses: ");
            String newEssayResponses = input.nextLine();
            studentUser.setEssayResponses(newEssayResponses);
        }
    }

    private void updateDonor(donor donorUser, int userChoice, Scanner input){
        if(userChoice == 1){ //Name
            System.out.print("Enter new name: ");
            String newName = input.nextLine();
            donorUser.setName(newName);
        }
        else if(userChoice == 2){ //Email
            System.out.print("Enter new email: ");
            String newEmail = input.nextLine();
            donorUser.setEmailAddress(newEmail);
        }
        else if(userChoice == 3){ //Security Question
            System.out.print("Enter new security question: ");
            String newSecurityQuestion = input.nextLine();
            donorUser.setSecurityQuestion(newSecurityQuestion);
        }
        else if(userChoice == 4){ //Security Question Answers
            System.out.print("Enter new security question answers: ");
            String newSecurityQuestionAnswers = input.nextLine();
            donorUser.setSecurityQuestionAnswers(newSecurityQuestionAnswers);
        }
        else if(userChoice == 5){ //Bursar Account Reference
            System.out.print("Enter new bursar account reference: ");
            String newBursarAccountReference = input.nextLine();
            donorUser.setBursarAccountReference(newBursarAccountReference);
        }
        else if(userChoice == 6){ //Donor ID
            System.out.print("Enter new donor ID: ");
            String newDonorID = input.nextLine();
            donorUser.setDonorID(newDonorID);
        }
        else{
            System.out.println("Invalid option. Please try again.");
        }
    }
}
