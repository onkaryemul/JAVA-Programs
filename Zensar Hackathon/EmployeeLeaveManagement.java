import java.sql.*;
import java.util.*;


public class EmployeeLeaveManagement {
    
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";

    private static final String username = "system";
    
    private static final String password = "admin";


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Connection conn = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection(url, username, password);

            System.out.println("Connection to database is successful");

            while(true) {
                System.out.println("\n********************* Menu **************************\n");
                System.out.println("1. Admin");
                System.out.println("2. Employee");
                System.out.println("3. Exit");
                
                System.out.println("\nEnter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        displayAdminPanel(conn, sc);
                        break;
                    
                    case 2:
                       displayEmployeePanel(conn, sc);
                        break; 

                    case 3: 
                       System.out.println("Exiting from Employee Management System");
                       return;

                    default:
                        System.out.println("Invalid Choice!. Please enter correct option number from menu!");
                        break;
                }
            }
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        catch(Exception e) {
            System.out.println(e);
        }
        
        try {
            if(conn != null) {
                conn.close();
            }

            sc.close();
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    
    // Admin
    private static void displayAdminPanel(Connection conn, Scanner sc) {
        while(true) {
            System.out.println("******************** Admin ****************************");
            System.out.println("1. View all leave requests");
            System.out.println("2. Approve/reject a particular leave request");
            System.out.println("3. Exit admin");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewAllLeaveRequests(conn, sc);
                    break;

                case 2:
                    approveOrRejectLeaveRequest(conn, sc);
                    break;

                case 3: 
                    System.out.println("Exiting from Admin..");
                    return;

                 default:
                    System.out.println("Invalid Choice!. Please enter correct option number from admin menu!");
                    break;
            }
        }
    }
    
    
    private static void viewAllLeaveRequests(Connection conn, Scanner sc) {
        try {
            String query = "SELECT leave_id, employeeId, employeeName, leaveBalance, leaveType, leaveDate, reason, status FROM Leaves";
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(query);
        
            System.out.println("\n******************* Leave Requests ******************* \n");
            
            System.out.println("leave_id | employeeId  |   employeeName   | leaveBalance |   leaveType   |  leaveDate  |    reason   |   status");

            while(rs.next()) {
                int leaveId = rs.getInt("leave_id");
                int employeeId = rs.getInt("employeeId");
                String employeeName = rs.getString("employeeName");
                int leaveBalance = rs.getInt("leaveBalance");
                String leaveType = rs.getString("leaveType");
                String leaveDate = rs.getString("leaveDate");
                String reason = rs.getString("reason");
                String status = rs.getString("status");

                System.out.println(leaveId + "  |  " + employeeId + "  |  " + employeeName + "   |  " + leaveBalance + "   |  " + leaveType + "  |  " + leaveDate + "  |  " + reason + "  |  " + status);
            }
            
            System.out.println("\n");
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
    private static void approveOrRejectLeaveRequest(Connection conn, Scanner sc) {
        try {
            System.out.println("Enter leave ID : ");
            int leaveId = sc.nextInt();

            String query = "SELECT leave_id, employeeId, employeeName, leaveBalance, leaveType, leaveDate, reason, status FROM Leaves WHERE leave_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, leaveId);
            
            ResultSet rs = stmt.executeQuery();
        
            System.out.println("\n********* Details for inputted leaveId Leave Requests ************\n");
            
            System.out.println("leave_id | employeeId  |   employeeName   | leaveBalance |   leaveType   |  leaveDate  |    reason   |   status");

            while(rs.next()) {
                int leave_Id = rs.getInt("leave_id");
                int employeeId = rs.getInt("employeeId");
                String employeeName = rs.getString("employeeName");
                int leaveBalance = rs.getInt("leaveBalance");
                String leaveType = rs.getString("leaveType");
                String leaveDate = rs.getString("leaveDate");
                String reason = rs.getString("reason");
                String status = rs.getString("status");

                System.out.println(leave_Id + "  |  " + employeeId + "  |  " + employeeName + "   |  " + leaveBalance + "   |  " + leaveType + "  |  " + leaveDate + "  |  " + reason + "  |  " + status);
            }
            
            System.out.println("\n");

            System.out.println("Enter your verdict(ie. approve/reject): ");
            String status = sc.next();

            String updateQuery = "UPDATE Leaves SET status = ? WHERE leave_id = ?";
            
            PreparedStatement ps = conn.prepareStatement(updateQuery);
            ps.setString(1, status);
            ps.setInt(2, leaveId);

            int count = ps.executeUpdate();
            
            if(count > 0) {
                System.out.println("Verdict saved!");
            }
            else {
                System.out.println("Failed to update the status of leave request");
            }
         
            System.out.println("\n");
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    // Employee
    private static void displayEmployeePanel(Connection conn, Scanner sc) {
        while(true) {
            System.out.println("******************** Employee ****************************");
            System.out.println("1. Submit a leave request");
            System.out.println("2. Read leave status");
            System.out.println("3. Modify leave request");
            System.out.println("4. Delete leave request");
            System.out.println("5. Exit employee");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    submitLeaveRequest(conn, sc);
                    break;

                case 2:
                    readLeaveStatus(conn, sc);
                    break;

                case 3:
                    modifyLeaveRequest(conn, sc);
                    break;

                case 4:
                    deleteLeaveRequest(conn, sc);
                    break;

                case 5: 
                    System.out.println("Exiting from Employee..");
                    return;

                 default:
                    System.out.println("Invalid Choice!. Please enter correct option number from employee menu!");
                    break;
            }
        }
    }


    private static void submitLeaveRequest(Connection conn, Scanner sc) {
        //INSERT INTO Leaves(leave_id, employeeId, employeeName, leaveBalance, leaveType, leaveDate, reason, status) VALUES(1, 101, "Onkar Yemul", 5, "Health Issues", "19-12-2024", "Malaria bed rest", "Approved");
        try {
            System.out.println("Enter leave ID : ");
            int leaveId = sc.nextInt();

            System.out.println("Enter employee ID : ");
            int employeeId = sc.nextInt();

            sc.nextLine();
            System.out.println("Enter employee Name : ");
            String employeeName = sc.nextLine();
            
            System.out.println("Enter leave balance : ");
            int leaveBalance = sc.nextInt();
            
            sc.nextLine();
            System.out.println("Enter your leave type : ");
            String leaveType = sc.nextLine();

            System.out.println("Enter your leave date : ");
            String leaveDate = sc.nextLine();

            System.out.println("Enter your reason for leave : ");
            String reason = sc.nextLine();

            String status = "pending";

            String query = "INSERT INTO Leaves VALUES(" + leaveId + ", " + employeeId + ", '" + employeeName +  "', " + leaveBalance + ", '" + leaveType + "', '" + leaveDate + "', '" + reason + "', '" + status + "')";
            
            Statement stmt = conn.createStatement();
            
            int count = stmt.executeUpdate(query);
            
            if(count > 0) {
                System.out.println("\nLeave request successfully saved!");
            }
            else {
                System.out.println("Failed to save leave request!");
            }
         
            System.out.println("\n");
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    private static void readLeaveStatus(Connection conn, Scanner sc) {
        try {
            System.out.println("Enter leave ID : ");
            int leaveId = sc.nextInt();

            String query = "SELECT status FROM Leaves WHERE leave_id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, leaveId);

            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                System.out.println("Leave Status : " + rs.getString(1));
            }
            else {
                System.out.println("Failed to fetch leave status!");
            }
         
            System.out.println("\n");
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }


    private static void modifyLeaveRequest(Connection conn, Scanner sc) {
        try {
            System.out.println("Enter leave ID : ");
            int leaveId = sc.nextInt();

            System.out.println("Enter your modified leave type : ");
            String leaveType = sc.next();

            sc.nextLine();

            System.out.println("Enter your modified leave date : ");
            String leaveDate = sc.nextLine();

            String query = "UPDATE Leaves SET leaveType = ?, leaveDate = ? WHERE leave_id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, leaveType);
            ps.setString(2, leaveDate);
            ps.setInt(3, leaveId);

            int count = ps.executeUpdate();
            
            if(count > 0) {
                System.out.println("Leave request " + leaveId + " deleted successfully!");
            }
            else {
                System.out.println("Failed to delete requested leave!");
            }
         
            System.out.println("\n");
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    private static void deleteLeaveRequest(Connection conn, Scanner sc) {
        try {
            System.out.println("Enter leave ID : ");
            int leaveId = sc.nextInt();

            String query = "DELETE FROM Leaves WHERE leave_id = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, leaveId);

            int count = ps.executeUpdate();
            
            if(count > 0) {
                System.out.println("Leave request " + leaveId + " deleted successfully!");
            }
            else {
                System.out.println("Failed to delete requested leave!");
            }
         
            System.out.println("\n");
        }
        catch(SQLException e) {
            System.out.println(e);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

}


