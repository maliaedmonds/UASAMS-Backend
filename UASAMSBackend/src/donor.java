//This class inherits from the user class

import java.util.Scanner;

public class donor extends user{
    private String bursarAccountReference;
    private String donorID;

    public donor(){ //Default constructor
        this.bursarAccountReference = "None";
        this.donorID = "None";
    }

    ///// Start Overloaded constructors for the donor class /////
    public donor(String bursarAccountReference){
        this.bursarAccountReference = bursarAccountReference;
    }
    public donor(String bursarAccountReference, String donorID){
        this.bursarAccountReference = bursarAccountReference;
        this.donorID = donorID;
    }
    ///// End Overloaded constructors for the donor class /////

    ///// Start Getters and Setters for the donor class /////
    public String getBursarAccountReference(){
        return bursarAccountReference;
    }
    public void setBursarAccountReference(String bursarAccountReference){
        this.bursarAccountReference = bursarAccountReference;
    }
    public String getDonorID(){
        return donorID;
    }
    public void setDonorID(String donorID){
        this.donorID = donorID;
    }
    ///// End Getters and Setters for the donor class /////

    ///// Start Methods for the donor class /////
    public void printInfo(){
        super.printInfo();
        System.out.println("Bursar Account Reference: " + this.bursarAccountReference);
        System.out.println("Donor ID: " + this.donorID);
        System.out.println();
    }

    public scholarship createNewScholarship(Scanner input){
        scholarship newScholarship = new scholarship();
            System.out.print("Enter the name of the scholarship: ");
            String scholarshipName = input.nextLine();
            newScholarship.setScholarshipName(scholarshipName);

            System.out.print("Enter the payout of the scholarship (integer value): ");
            int payout = input.nextInt();
            input.nextLine(); //This is to clear the buffer
            newScholarship.setPayout(payout);

            System.out.print("Enter the deadline of the scholarship: ");
            String deadline = input.nextLine();
            newScholarship.setDeadline(deadline);

            System.out.print("Enter the custom required information of the scholarship: ");
            String customRequiredInfo = input.nextLine();
            newScholarship.setCustomRequiredInfo(customRequiredInfo);

            System.out.print("Enter the preferred majors of the scholarship (if N/A enter None): ");
            String preferredMajors = input.nextLine();
            newScholarship.setPreferedMajors(preferredMajors);

            return newScholarship;
    }
}
