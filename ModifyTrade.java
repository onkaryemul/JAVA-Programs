
import java.sql.*;
import mypkg.Util;

public class ModifyTrade {

    public static void main(String[] args) throws Exception{

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
         
        PreparedStatement p1 = conn.prepareStatement("UPDATE trade SET tnm=?, tstat=? WHERE tno=?");
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

            if(rs.next() == false) {
                Util.display("Trade Record does not exist!");
                continue;
            }

            String st = rs.getString(3);

            if(st.equals("N")) {
                Util.display("Record Deleted ..... can't modify");
                continue;
            }

            nm = Util.sInput("Trade Name");

            p1.setString(1, nm);
            p1.setString(2, res);
            p1.setInt(3, no);

            p1.executeUpdate();
        }
        
        conn.close();
    }
    
}


