
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresDatabase {
 
    public static void main(String[] args) {
        // create three connections to three different databases on localhost
        Connection conn1 = null;
        Connection conn2 = null;
        Connection conn3 = null;
 
        try {
            // Connect method #1
            String dbURL1 = "jdbc:postgresql:postgres?user=postgres&password=admin";
            conn1 = DriverManager.getConnection(dbURL1);
            if (conn1 != null) {
                System.out.println("Connected to database #1");
            }
 
            // Connect method #2
            String dbURL2 = "jdbc:postgresql://localhost/postgres";
            String user = "postgres";
            String pass = "admin";
 
            conn2 = DriverManager.getConnection(dbURL2, user, pass);
            if (conn2 != null) {
                System.out.println("Connected to database #2");
            }
 
            // Connect method #3
            String dbURL3 = "jdbc:postgresql://localhost:5432/postgres";
            Properties parameters = new Properties();
            parameters.put("user", "postgres");
            parameters.put("password", "admin");
 
            conn3 = DriverManager.getConnection(dbURL3, parameters);
            if (conn3 != null) {
                System.out.println("Connected to database #3");
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn1 != null && !conn1.isClosed()) {
                    conn1.close();
                }
                if (conn2 != null && !conn2.isClosed()) {
                    conn2.close();
                }
                if (conn3 != null && !conn3.isClosed()) {
                    conn3.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}