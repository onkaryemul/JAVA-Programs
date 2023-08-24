
import java.sql.*;
import mypkg.Util;

public class AddTrade {

    public static void main(String[] args) throws Exception{

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
         
        PreparedStatement p1 = conn.prepareStatement("INSERT INTO Trade VALUES(?, ?, ?)");
        
        int no = 0;
        String nm = "";
        String res = "Y";

        while(true) {
            no = Util.iInput("Enter Trade ID");

            if(no == 0) {
                break;
            }

            nm = Util.sInput("Trade Name");

            p1.setInt(1, no);
            p1.setString(2, nm);
            p1.setString(3, res);

            p1.executeUpdate();
        }

        conn.close();
    }
    
}


