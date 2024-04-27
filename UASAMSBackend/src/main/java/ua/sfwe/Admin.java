package ua.sfwe;
import java.util.Locale;
//This class inherits from the user class
import java.util.Scanner;


public class Admin extends User{
    private String adminID;

    public Admin(){ //Default constructor
        this.adminID = "None";
    }

    ///// Start Overloaded constructors for the Admin class /////
    public Admin(String adminID){
        this.adminID = adminID;
    }
    ///// End Overloaded constructors for the Admin class /////

    ///// Start Getters and Setters for the Admin class /////
    public String getAdminID(){
        return adminID;
    }
    public void setAdminID(String adminID){
        this.adminID = adminID;
    }
    ///// End Getters and Setters for the Admin class /////

    public User createAccount(Scanner input){ 
        System.out.print("Enter type of user (student, admin, reviewer, donor): ");
        String userPermissions = input.nextLine();
        userPermissions = userPermissions.toLowerCase(Locale.ROOT); //Converts the string to lowercase (this is used to ensure that the user can enter the type of user in any case)
        userPermissions = userPermissions.trim(); //Removes leading and trailing whitespace
<<<<<<< HEAD
        if("student".equals(userPermissions)){
            student newStudent = new student();
=======
        if(userPermissions.equals("student")){
            Student newStudent = new Student();
>>>>>>> 0b13a12124d3fb035728aa5918c8d49df5c68fa3
            newStudent.setUserPermission(userPermissions); //Sets the user permission
            setBasicInfo(newStudent, input); 
            setStudentInfo(newStudent, input);
            System.out.println(); //Print a new line before the menu comes back up
            return (User) newStudent;
        }
        else if("admin".equals(userPermissions)){
            Admin newAdmin = new Admin();
            newAdmin.setUserPermission(userPermissions); //Sets the user permission
            setBasicInfo(newAdmin, input);
            setAdminInfo(newAdmin, input);
            System.out.println(); //Print a new line before the menu comes back up
            return (User) newAdmin;
        }
        else if("donor".equals(userPermissions)){
            donor newDonor = new donor();
            newDonor.setUserPermission(userPermissions); //Sets the user permission
            setBasicInfo(newDonor, input);
            setDonorInfo(newDonor, input);
            System.out.println(); //Print a new line before the menu comes back up
            return (User) newDonor;
        }
        else if("reviewer".equals(userPermissions)){
            reviewer newReviewer = new reviewer();
            newReviewer.setUserPermission(userPermissions);  //Sets the user permission
            setBasicInfo(newReviewer, input);
            setReviewerInfo(newReviewer, input);
            System.out.println(); //Print a new line before the menu comes back up
            return (User) newReviewer;
        }
        else{
            System.out.println("Invalid user type. Please try again.");
        }
        return null;
    }


    private User setBasicInfo(User inputUser, Scanner input){
        System.out.println("\nEnter name (ex. John Doe): ");
        String name = input.nextLine();
        inputUser.setName(name);
        System.out.println("\nEnter email address (ex. JohnDoe@email.com): ");
        String emailAddress = input.nextLine();
        inputUser.setEmailAddress(emailAddress);
        System.out.println("\nPlease enter 3 security questions seperated by a comma and a space");
        System.out.println("Enter security question (ex. What is my favorite food, What is my favorite color, ...): ");
        String securityQuestion = input.nextLine();
        inputUser.setSecurityQuestion(securityQuestion);
        System.out.println("\nPlease enter 3 security questions answers seperated by a comma and a space");
        System.out.println("Enter security question answers (ex. pizza, blue, ...): ");
        String securityQuestionAnswers = input.nextLine();
        inputUser.setSecurityQuestionAnswers(securityQuestionAnswers);
        return inputUser;
    }

    private student setStudentInfo(Student inputStudent, Scanner input) {
        System.out.println("\nEnter major (ex. Software Engineering): ");
        String major = input.nextLine();
        inputStudent.setMajor(major);
        System.out.println("\nEnter GPA (ex. 3.5): ");
        double gpa = input.nextDouble();
        input.nextLine(); //This is to get rid of the newline character
        inputStudent.setGpa(gpa);
        System.out.println("\nEnter student ID (ex. 1234567): ");
        String studentID = input.nextLine();
        inputStudent.setStudentID(studentID);
        System.out.println("\nEnter citizenship (ex. US Citizen): ");
        String citizenship = input.nextLine();
        inputStudent.setCitizenship(citizenship);
        System.out.println("\nEnter units enrolled (ex. 12): ");
        int unitsEnrolled = input.nextInt();
        input.nextLine(); //This is to get rid of the newline character
        inputStudent.setUnitsEnrolled(unitsEnrolled);
        System.out.println("\nEnter expected graduation (ex. May, 2022): ");
        String expectedGraduation = input.nextLine();
        inputStudent.setExpectedGraduation(expectedGraduation);
        System.out.println("\nEnter burser account reference (ex. 1234567): ");
        String bursarAccountReference = input.nextLine();
        inputStudent.setBursarAccountReference(bursarAccountReference);
        return inputStudent;
    }

    private Admin setAdminInfo(Admin inputAdmin, Scanner input) {
        System.out.println("\nEnter admin ID (ex. 1234567): ");
        String adminID = input.nextLine();
        inputAdmin.setAdminID(adminID);
        return inputAdmin;
    }
    private donor setDonorInfo(donor inputDonor, Scanner input) {
        System.out.println("\nEnter burser account reference (ex. 1234567): ");
        String bursarAccountReference = input.nextLine();
        inputDonor.setBursarAccountReference(bursarAccountReference);
        System.out.println("\nEnter donor ID (ex. 1234567): ");
        String donorID = input.nextLine();
        inputDonor.setDonorID(donorID);
        return inputDonor;
    }
    private reviewer setReviewerInfo(reviewer inputReviewer, Scanner input) {
        System.out.println("\nEnter reviewer ID (ex. 1234567): ");
        String reviewerID = input.nextLine();
        inputReviewer.setReviewerID(reviewerID);
        return inputReviewer;
    }


    public void printInfo(){
        super.printInfo();
        System.out.println("Admin ID: " + this.adminID);
        System.out.println();
    }

}
