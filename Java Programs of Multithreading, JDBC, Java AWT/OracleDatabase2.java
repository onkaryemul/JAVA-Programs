

import java.sql.*;

public class OracleDatabase2
{
    public static void main(String[] args) throws Exception {
        
       Class.forName("oracle.jdbc.driver.OracleDriver");

       Connection con = DriverManager.getConnection(
                  "jdbc:oracle:thin:@10.10.16.15:1521/pdborcl","21510017","21510017");

       DatabaseMetaData metaData = con.getMetaData();

       ResultSet res = metaData.getTables(null,"SYSTEM","%",null);

       while(res.next())
       {
           System.out.println(res.getString(3));
       }

        res.close();
        con.close();
    }
 
}

