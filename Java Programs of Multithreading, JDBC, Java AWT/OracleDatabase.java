import java.sql.*;

public class OracleDatabase
{
    public static void main(String[] args) throws Exception {
        
       Class.forName("oracle.jdbc.driver.OracleDriver");

       Connection con=DriverManager.getConnection(
                  "jdbc:oracle:thin:@localhost:1521:xe","system","admin");

       Statement stm=con.createStatement();

       ResultSet res=stm.executeQuery("select * from customer");

       int customerID;
       String custName;
       String city;
       int grade;
       int salesmanID;

       while(res.next())
       {
           customerID = res.getInt("customer_id");
           custName = res.getString("cust_name");
           city = res.getString("city");
           grade = res.getInt("grade");
           salesmanID = res.getInt("salesman_id");

           System.out.println(customerID + " | " + custName + " | " + city + " | " + grade + " | " + salesmanID);  
       }

        stm.close();
        con.close();
    }
 
}

