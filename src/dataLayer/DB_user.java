package dataLayer;

import java.sql.SQLException;
import java.sql.*;
import static java.lang.Class.forName;

public class DB_user {


    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/webapptutorial";

    static final String USER ="root";
    static final String PASS="root";

    public boolean isValidUserLogin(String userName, String userPassword){
        boolean isValidUser = false;

        Connection conn = null;
        Statement stmt = null;
        String sql="";

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");

            System.out.println("Creating Statement");
            stmt = conn.createStatement();

            sql = "SELECT * FROM new_table WHERE user_nam = \""
                    + userName + "\"And user_password = \"" + userPassword + "\"";

            System.out.println(sql+"hey");

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
