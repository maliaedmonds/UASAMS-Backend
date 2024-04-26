package ua.sfwe;
//This inherits from the user class
public class reviewer extends user{
    private String reviewerID;
    
    public reviewer(){ //Default constructor
        this.reviewerID = "None";
    }

    ///// Start Overloaded constructors for the reviewer class /////
    public reviewer(String reviewerID){
        this.reviewerID = reviewerID;
    }
    ///// End Overloaded constructors for the reviewer class /////

    ///// Start Getters and Setters for the reviewer class /////
    public String getReviewerID(){
        return reviewerID;
    }
    public void setReviewerID(String reviewerID){
        this.reviewerID = reviewerID;
    }
    ///// End Getters and Setters for the reviewer class /////
    
    ///// Start Methods for the reviewer class /////
    public void printInfo(){
        super.printInfo();
        System.out.println("Reviewer ID: " + this.reviewerID);
        System.out.println();
    }
}
