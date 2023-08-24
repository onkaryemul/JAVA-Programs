
import java.sql.*;
import mypkg.Util;

public class DisplayTrade {

    public static void main(String[] args) throws Exception{

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
         
        PreparedStatement p1 = conn.prepareStatement("SELECT * FROM trade");
        
        ResultSet rs = null;

        int no = 0;
        String nm = "";
        String res = "Y";

        rs = p1.executeQuery();
 
        while(rs.next()) {
            no = rs.getInt(1);
            nm = rs.getString(2);
            res = rs.getString(3);

            Util.display("Trade Id: " + no + "\nName: " + nm + "\nState: " + res);
        }

        conn.close();
    }

}


