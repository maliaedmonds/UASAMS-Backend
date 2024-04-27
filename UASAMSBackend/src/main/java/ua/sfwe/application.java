package ua.sfwe;
public class Application {
    private String scholarshipName;
    private String studentID;
    private String scholarshipResponses;
    private String academicYear;

    public Application(){
        this.scholarshipName = "None";
        this.studentID = "None";
        this.scholarshipResponses = "None";
        this.academicYear = "None";
    }

    public Application(String scholarshipName){
        this.scholarshipName = scholarshipName;
        this.studentID = "None";
        this.scholarshipResponses = "None";
        this.academicYear = "None";
    }

    public Application(String scholarshipName, String studentID){
        this.scholarshipName = scholarshipName;
        this.studentID = studentID;
        this.scholarshipResponses = "None";
        this.academicYear = "None";
    }

    public Application(String scholarshipName, String studentID, String scholarshipResponses){
        this.scholarshipName = scholarshipName;
        this.studentID = studentID;
        this.scholarshipResponses = scholarshipResponses;
        this.academicYear = "None";
    }

    public Application(String scholarshipName, String studentID, String scholarshipResponses, String academicYear){
        this.scholarshipName = scholarshipName;
        this.studentID = studentID;
        this.scholarshipResponses = scholarshipResponses;
        this.academicYear = academicYear;
    }

    public String getScholarshipName(){
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName){
        this.scholarshipName = scholarshipName;
    }

    public String getStudentID(){
        return studentID;
    }

    public void setStudentID(String studentID){
        this.studentID = studentID;
    }

    public String getScholarshipResponses(){
        return scholarshipResponses;
    }

    public void setScholarshipResponses(String scholarshipResponses){
        this.scholarshipResponses = scholarshipResponses;
    }

    public String getAcademicYear(){
        return academicYear;
    }

    public void setAcademicYear(String academicYear){
        this.academicYear = academicYear;
    }

    public void printInfo(){
        System.out.println("Scholarship Name: " + this.scholarshipName);
        System.out.println("Student ID: " + this.studentID);
        System.out.println("Scholarship Responses: " + this.scholarshipResponses);
    }

}
