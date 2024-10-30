
package studentgradebook;


public class Teacher extends Person{
    
    private int teacherID;
    private int licenceNumber;
    private String email;

    public Teacher(int teacherID, int licenceNumber, String email, String name, String surname) {
        super(name, surname);
        this.teacherID = teacherID;
        this.licenceNumber = licenceNumber;
        this.email = email;
    }

    public int getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(int licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

}
