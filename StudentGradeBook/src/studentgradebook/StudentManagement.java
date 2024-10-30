
package studentgradebook;

import java.util.ArrayList;
import java.util.List;


public class StudentManagement {
     private List<Student> students;

    public StudentManagement() {
        students = new ArrayList<>();
    }
    
    public void addStudent(Student student) {
        students.add(student);
    }
    
     public void removeStudent(Student student) {
        students.remove(student);
    }
    
    public List<Student> getStudents() { 
        return students;
    }
    
    public List<String> getAllStudentInfo() {
        List<String> studentInfoList = new ArrayList<>();
        for (Student student : students) {
            String studentInfo = "Name: " + student.getName() + ", Surname: " + student.getSurname() +
                                ", Student ID: " + student.getStudentID() + ", Course: " + student.getCourse();
            studentInfoList.add(studentInfo);
        }
        return studentInfoList;
    }
    
     public void modifyStudentGrade(int studentId, String newGrade) {
        for (Student student : students) {
            if (student.getStudentID() == studentId) {
                student.setGrade(newGrade);
                return;
            }
        }
    }
     
     
    
}
