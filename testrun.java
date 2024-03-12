import java.sql.*;

public class testrun {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tealive", "root", "Tealivecafe2");
            
            if (con != null) {
                System.out.println("Connect successful");
                // Your code to interact with the database goes here
            } else {
                System.out.println("Error");
            }
            
            con.close(); // Remember to close the connection when you're done
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
