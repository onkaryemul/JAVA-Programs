import java.sql.*;

public class Database
{
    public static void main(String[] args) throws Exception {

        Class.forName("org.sqlite.JDBC");

        Connection con=DriverManager.getConnection("jdbc:sqlite:C://sqlite//univ.db");

        Statement stm=con.createStatement();

        ResultSet res=stm.executeQuery("select * from dept");

        int deptno;
        String dname;

        while(res.next())
        {
            deptno = res.getInt("deptno");
            dname = res.getString("dname");

            System.out.println(deptno + " " + dname);
        }

        stm.close();
        con.close();
    }

}