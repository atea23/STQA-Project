/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentgradebook;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ateac
 */
public class Database {
    
    private Connection conn;
    private Statement statement;
    
    public Connection openConnection() throws SQLException {
    if (conn == null || conn.isClosed()) {
        
    	String url = "jdbc:mysql://localhost:3306/"; // Specify port if it's not the default

        String dbName = "student";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "";

        try {
            Class.forName(driver);
            this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("CONNECTION SUCCESSFUL");
         } catch (ClassNotFoundException | SQLException sqle) {
            sqle.printStackTrace();  // This will print the error details to the console
        }

    }

    return conn;
}

    public void closeConnection() throws SQLException {
    if (conn != null && !conn.isClosed()) {
        conn.close();
        System.out.println("CONNECTION CLOSED");
    }
}

    
    public void insertStudent(Student student) throws SQLException {
        Connection conn = openConnection();
        String sql = "INSERT INTO studentinfo (`First Name`, `Last Name`, `Student ID`, `Course`, `Final Grade`) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getSurname());
            pstmt.setInt(3, student.getStudentID());
            pstmt.setString(4, student.getCourse());
            pstmt.setString(5, student.getGrade());
            pstmt.executeUpdate();//ekzekuto sql statement
        } finally {
            conn.close();
        }
    }
    
    public boolean removeStudent(int studentID) throws SQLException {
    Connection conn = openConnection();
    
    // Define the SQL query to delete a student by ID
    String sql = "DELETE FROM studentinfo WHERE `Student ID` = ?";
    
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, studentID);
        int rowCount = pstmt.executeUpdate();
        
        // Check if any rows were deleted (rowCount > 0 means a student was deleted)
        if (rowCount > 0) {
            return true; // Student removed successfully
        } else {
            return false; // No student with the given ID found
        }
    } finally {
        conn.close();
    }
}
    public Student searchStudent(int studentID) throws SQLException {
    Connection conn = openConnection();
    String sql = "SELECT * FROM studentinfo WHERE `Student ID` = ?";
    
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setInt(1, studentID);
        
        try (ResultSet resultSet = pstmt.executeQuery()) {
            if (resultSet.next()) {
                String firstName = resultSet.getString("First Name");
                String lastName = resultSet.getString("Last Name");
                String course = resultSet.getString("Course");
                String grade = resultSet.getString("Final Grade");
                
                // Create a Student object with retrieved data
                Student student = new Student(firstName, lastName, studentID, course, grade);
                
                return student;
            } else {
                // Student not found with the given ID
                return null;
            }
        }
    } finally {
        conn.close();
    }
}
    
    public boolean updateFinalGrade(int studentID, String newGrade) throws SQLException {
    Connection conn = openConnection();
    String sql = "UPDATE studentinfo SET `Final Grade` = ? WHERE `Student ID` = ?";
    
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, newGrade);
        pstmt.setInt(2, studentID);
        
        int rowCount = pstmt.executeUpdate();
        
        
        if (rowCount > 0) {
            return true; 
        } else {
            return false;
        }
    } finally {
        conn.close();
    }
}
    
    
    public void insertTeacher(Teacher teacher) throws SQLException {
    Connection conn = openConnection();
    String sql = "INSERT INTO teacherinfo (`Name`, `Surname`, `Teacher ID`, `Email`, `License Number`) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, teacher.getName());
        pstmt.setString(2, teacher.getSurname());
        pstmt.setInt(3, teacher.getTeacherID());
        pstmt.setString(4, teacher.getEmail());
        pstmt.setInt(5, teacher.getLicenceNumber());
        pstmt.executeUpdate();
    } finally {
        conn.close();
    }
}
    
    public List<Teacher> getAllTeachers() throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        Connection conn = openConnection();
        String sql = "SELECT * FROM teacherinfo";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("Name");
                    String surname = resultSet.getString("Surname");
                    int teacherID = resultSet.getInt("Teacher ID");
                    String email = resultSet.getString("Email");
                    int licenseNumber = resultSet.getInt("License Number");

                    Teacher teacher = new Teacher(teacherID, licenseNumber, email, name, surname);
                    teachers.add(teacher);
                }
            }
        } finally {
            conn.close();
        }
        return teachers;
    }



    }






