package dataLayer;

import java.sql.SQLException;
import java.sql.*;
import static java.lang.Class.forName;

public class DB_user {


    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/webapptutorial";

    static final String USER ="webappuser";
    static final String PASS="test123";

    public boolean isValidUserLogin(String userName, String userPassword){
        boolean isValidUser = false;

        Connection conn = null;
        Statement stmt = null;
        String sql="";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Creating Statement");
            stmt = conn.createStatement();

            sql = "SELECT * FROM users WHERE user_name = \""
                    + userName + "\"And user_password = \"" + userPassword + "\"";

            System.out.println(sql);

            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                isValidUser = true;
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se){
            se.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Closing DB connection - GoodBye!");


        return isValidUser;
    }
}
