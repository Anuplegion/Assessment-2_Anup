public class Student{
    private String lastName;
    private String firstName;
    private String studentID;
    private double mark1;
    private double mark2;
    private double mark3;
    private double totalMark;
    
    //Creating constructors for Student and also calculating total marks
    public Student(String lastName, String firstName, String studentID, double mark1, double mark2, double mark3){
        this.lastName = lastName;
        this.firstName = firstName;
        this.studentID = studentID;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.totalMark = mark1 + mark2 + mark3;
    }
    
    //getter for totalMark
    public double getTotalMark(){
        return totalMark;
    }
}