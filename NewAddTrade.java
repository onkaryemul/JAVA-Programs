
import java.sql.*;
import mypkg.Util;

public class NewAddTrade {

    public static void main(String[] args) throws Exception{

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
         
        PreparedStatement p1 = conn.prepareStatement("INSERT INTO Trade VALUES(?, ?, ?)");
        PreparedStatement p2 = conn.prepareStatement("SELECT * FROM trade WHERE tno=?");
        
        ResultSet rs = null;

        int no = 0;
        String nm = "";
        String res = "Y";

        while(true) {
            no = Util.iInput("Enter Trade ID");

            if(no == 0) {
                break;
            }

            p2.setInt(1, no);
            rs = p2.executeQuery();

            if(rs.next() == true) {
                Util.display("Trade Record Exists!");
                continue;
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


