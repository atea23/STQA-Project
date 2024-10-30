
package studentgradebook;


public class Student extends Person{
    
    private int studentID;
    private String course;
    private String grade;

    
    //Constructor
    public Student(int studentID, String course, String name, String surname) {
        super(name, surname);
        this.studentID = studentID;
        this.course = course;
        this.grade=grade;
    }

    public Student(String name, String surname, int studentID, String course, String grade) {
        super(name, surname);
        this.studentID = studentID;
        this.course = course;
        this.grade = grade;
    }
    

    //Getters and Setters
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    
}
