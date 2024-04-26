package ua.sfwe;
public class application {
    private String ScholarshipName;
    private String studentID;
    private String scholarshipResponses;
    private String academicYear;

    public application(){
        this.ScholarshipName = "None";
        this.studentID = "None";
        this.scholarshipResponses = "None";
        this.academicYear = "None";
    }

    public application(String ScholarshipName){
        this.ScholarshipName = ScholarshipName;
        this.studentID = "None";
        this.scholarshipResponses = "None";
        this.academicYear = "None";
    }

    public application(String ScholarshipName, String studentID){
        this.ScholarshipName = ScholarshipName;
        this.studentID = studentID;
        this.scholarshipResponses = "None";
        this.academicYear = "None";
    }

    public application(String ScholarshipName, String studentID, String scholarshipResponses){
        this.ScholarshipName = ScholarshipName;
        this.studentID = studentID;
        this.scholarshipResponses = scholarshipResponses;
        this.academicYear = "None";
    }

    public application(String ScholarshipName, String studentID, String scholarshipResponses, String academicYear){
        this.ScholarshipName = ScholarshipName;
        this.studentID = studentID;
        this.scholarshipResponses = scholarshipResponses;
        this.academicYear = academicYear;
    }

    public String getScholarshipName(){
        return ScholarshipName;
    }

    public void setScholarshipName(String ScholarshipName){
        this.ScholarshipName = ScholarshipName;
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
        System.out.println("Scholarship Name: " + this.ScholarshipName);
        System.out.println("Student ID: " + this.studentID);
        System.out.println("Scholarship Responses: " + this.scholarshipResponses);
    }

}
