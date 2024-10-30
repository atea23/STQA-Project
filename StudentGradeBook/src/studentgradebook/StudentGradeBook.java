
package studentgradebook;

import java.sql.SQLException;
import javax.swing.JFrame;


public class StudentGradeBook {

    
    public static void main(String[] args) throws SQLException {
        
        Database db=new Database();
        db.openConnection();
        
        
        Login loginFrame = new Login();
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setVisible(true);
    }
    
}
