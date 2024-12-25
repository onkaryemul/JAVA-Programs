
/*  
   Menu-driven program for handling Oracle database :
*/

import java.sql.*;

public class OracleDatabaseMenu {

    public static Connection conn;
    public static Statement stmt;
    public static ResultSet rs;
    public static String tableName;

    // function to create new table
    public static void createTable() throws SQLException {
        System.out.println("\nEnter table name : ");
        tableName = System.console().readLine();

        System.out.println("Enter column names and data types (separated by commas) : ");
        String columns = System.console().readLine();

        String query = "CREATE TABLE " + tableName + "(" + columns + ")";
        stmt.execute(query);
        System.out.println("Table created successfully.\n");
    }

    // function to insert data into the table
    public static void insertData() throws SQLException {
        System.out.println("\nEnter table name : ");
        tableName = System.console().readLine();

        System.out.println("Enter values to insert (separated by commas) : ");
        String values = System.console().readLine();

        String query = "INSERT INTO " + tableName + " VALUES(" + values + ")";
        stmt.executeUpdate(query);
        System.out.println("Data inserted successfully.\n");
    }

    // function to display table
    public static void displayTable() throws SQLException {
        System.out.println("\nEnter table name: ");
        tableName = System.console().readLine();

        System.out.println("Select an option: ");
        System.out.println("1. Display entire table");
        System.out.println("2. Display selected columns");
        System.out.println("3. Display selected rows");
        System.out.println("4. Display selected columns with selected rows");

        System.out.print("\nEnter your option --->  ");
        int option = 0;
        try {
            option = Integer.parseInt(System.console().readLine());
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        String query = "";

        switch (option) {
            case 1:
                query = "SELECT * FROM " + tableName;
                break;

            case 2:
                System.out.println("\nEnter column names to display (separated by commas): ");
                String columns = System.console().readLine();
                query = "SELECT " + columns + " FROM " + tableName;
                break;

            case 3:
                System.out.println("\nEnter condition for selection: ");
                String condition = System.console().readLine();
                query = "SELECT * FROM " + tableName + " WHERE " + condition;
                break;

        
            case 4:
                System.out.println("\nEnter column names to display (separated by commas): ");
                String selectedColumns =  System.console().readLine();
                System.out.println("\nEnter condition for selection: ");
                String selectionCondition = System.console().readLine();
                query = "SELECT " + selectedColumns + " FROM " + tableName + " WHERE " + selectionCondition;
                break;
    
            default:
                System.out.println("\nInvalid option. Try again.");
                break;
        }

        // Following code do not display data in tabular format
        /* 
          if( ! query.isEmpty() )
          {
          rs = stmt.executeQuery(query);
          
          ResultSetMetaData metaData = rs.getMetaData();
          int columns = metaData.getColumnCount();
          
          while(rs.next())
          {
          for(int i=1;i<=columns;i++)
          {
          if(i<columns)
          {
          System.out.print(rs.getString(i) + " | ");
          }
          else
          {
          System.out.print(rs.getString(i));
          }
          }
          System.out.println();
          }
         
          System.out.println();
          }
         */

        if (!query.isEmpty()) {
            ResultSet rs = stmt.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Initialize column widths with column names lengths
            int[] columnWidths = new int[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                columnWidths[i - 1] = columnName.length();
            }

            // Update column widths based on values in each row
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = rs.getString(i);
                    if (columnValue != null) {
                        int valueLength = columnValue.length();
                        if (valueLength > columnWidths[i - 1]) {
                            columnWidths[i - 1] = valueLength;
                        }
                    }
                }
            }

            // Print column headers
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                System.out.printf("%-" + (columnWidths[i - 1] + 2) + "s", columnName);
            }
            System.out.println();

            // Print separator line
            for (int i = 1; i <= columnCount; i++) {
                for (int j = 0; j < columnWidths[i - 1] + 2; j++) {
                    System.out.print("-");
                }
            }
            System.out.println();

            // Fetch rows again and print table rows
            rs = stmt.executeQuery(query); // Re-execute the query
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnValue = rs.getString(i);
                    System.out.printf("%-" + (columnWidths[i - 1] + 2) + "s", columnValue);
                }
                System.out.println();
            }

            System.out.println();
        }

    }

    // function to delete record from the table
    public static void deleteRecord() throws SQLException {
        System.out.println("\nEnter table name : ");
        tableName = System.console().readLine();

        System.out.println("Enter condition for deletion : ");
        String condition = System.console().readLine();

        String query = "DELETE FROM " + tableName + " WHERE " + condition;
        stmt.executeUpdate(query);
        System.out.println("Record deleted successfully.\n");

    }

    // function to update the record in the table
    public static void updateTable() throws SQLException {
        System.out.println("\nEnter table name : ");
        tableName = System.console().readLine();

        System.out.println("Enter column name to update : ");
        String columnName = System.console().readLine();

        System.out.println("Enter new value : ");
        String newValue = System.console().readLine();

        System.out.println("Enter condition for updating : ");
        String condition = System.console().readLine();

        String query = "UPDATE " + tableName + " SET " + columnName + " = " + newValue + " WHERE " + condition;
        stmt.executeUpdate(query);
        System.out.println("Table updated successfully.\n");
    }

    // function to alter the table
    public static void alterTable() throws SQLException {
        String query = "";
        String constraintName = "";
        String constraintExpr = "";
        String columnName = "";

        System.out.println("\nEnter table name : ");
        tableName = System.console().readLine();

        System.out.println("\nSelect an option:");
        System.out.println("1. Add column");
        System.out.println("2. Drop column");
        System.out.println("3. Modify column data type");
        System.out.println("4. Rename column");
        System.out.println("5. Add constraint to table");
        System.out.println("6. Drop constraint from table");
        System.out.println("7. Add constraint to column");
        System.out.println("8. Drop constraint from column");

        System.out.print("\nEnter your option --->  ");
        int option = 0;
        try {
            option = Integer.parseInt(System.console().readLine());
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        switch (option) {
            case 1:
                System.out.println("\nEnter column name and data type to add: ");
                String columnToAdd = System.console().readLine();
                String addColumnQuery = "ALTER TABLE " + tableName + " ADD " + columnToAdd;
                stmt.executeUpdate(addColumnQuery);
                System.out.println("Column added successfully.\n");
                break;

            case 2:
                System.out.println("\nEnter column name to drop: ");
                String columnToDrop = System.console().readLine();
                String dropColumnQuery = "ALTER TABLE " + tableName + " DROP COLUMN " + columnToDrop;
                stmt.executeUpdate(dropColumnQuery);
                System.out.println("Column dropped successfully.\n");
                break;

            case 3:
                System.out.println("\nEnter column name and new data type: ");
                String columnToModify = System.console().readLine();
                String newDataType = System.console().readLine();
                String modifyColumnQuery = "ALTER TABLE " + tableName + " MODIFY " + columnToModify + " " + newDataType;
                stmt.executeUpdate(modifyColumnQuery);
                System.out.println("Column data type modified successfully.\n");
                break;

            case 4:
                System.out.println("\nEnter current column name and new column name: ");
                String currentColumnName = System.console().readLine();
                String newColumnName = System.console().readLine();
                String renameColumnQuery = "ALTER TABLE " + tableName + " RENAME COLUMN " + currentColumnName + " TO "
                        + newColumnName;
                stmt.executeUpdate(renameColumnQuery);
                System.out.println("Column renamed successfully.\n");
                break;

            case 5: // addConstraintToTable()
                System.out.println("\nEnter constraint name to add: ");
                constraintName = System.console().readLine();
                System.out.println("Enter constraint expression: ");
                constraintExpr = System.console().readLine();
                query = "ALTER TABLE " + tableName + " ADD CONSTRAINT " + constraintName + " " + constraintExpr;
                stmt.executeUpdate(query);
                System.out
                        .println("Constraint " + constraintName + " added to table " + tableName + " successfully.\n");
                break;

            case 6: // dropConstraintFromTable()
                System.out.println("\nEnter constraint name to drop: ");
                constraintName = System.console().readLine();
                query = "ALTER TABLE " + tableName + " DROP CONSTRAINT " + constraintName;
                stmt.executeUpdate(query);
                System.out.println(
                        "Constraint " + constraintName + " dropped from table " + tableName + " successfully.\n");
                break;

            case 7: // addConstraintToColumn()
                System.out.println("\nEnter column name on which constraint to be added: ");
                columnName = System.console().readLine();
                System.out.println("Enter constraint expression: ");
                constraintExpr = System.console().readLine();
                query = "ALTER TABLE " + tableName + " MODIFY " + columnName + " " + constraintExpr;
                stmt.executeUpdate(query);
                System.out.println(
                        "Constraint added to column " + columnName + " in table " + tableName + " successfully.\n");
                break;

            case 8: // dropConstraintFromColumn()
                System.out.println("\nEnter column name from which constraint to be dropped: ");
                columnName = System.console().readLine();
                System.out.println("Enter constraint expression (including MODIFY or DROP): ");
                constraintExpr = System.console().readLine();
                query = "ALTER TABLE " + tableName + " " + constraintExpr;
                stmt.executeUpdate(query);
                System.out.println(
                        "Constrain dropped from column " + columnName + " in table " + tableName + " successfully.\n");
                break;

            default:
                System.out.println("\nInvalid option! Try again!");
                break;
        }

    }

    // function to delete table
    public static void deleteTable() throws SQLException {
        System.out.println("\nEnter table name : ");
        tableName = System.console().readLine();

        String query = "DROP TABLE " + tableName;
        stmt.execute(query);
        System.out.println("Table deleted successfully.\n");
    }

    // function to describe table
    public static void describeTable() throws SQLException {
        System.out.println("\nEnter table name : ");
        tableName = System.console().readLine();

        String query = "SELECT * FROM " + tableName + " WHERE ROWNUM = 1";
        PreparedStatement pstmt = conn.prepareStatement(query);
        rs = pstmt.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();

        int columnCount = metaData.getColumnCount();

        // Following commented code do not give result in tabular format
       /*  
         System.out.println("Columns : ");
         for (int i = 1; i <= metaData.getColumnCount(); i++) {
         System.out.printf("%s | %s(%d) | %s\n",
         metaData.getColumnName(i),
         metaData.getColumnTypeName(i),
         metaData.getColumnDisplaySize(i),
         metaData.isNullable(i) == 1 ? "Nullable" : "Not Nullable");
          }
         
         System.out.println();
        */


        // Following code do give result in tabular format

        // Calculate maximum column widths
        int[] columnWidths = new int[columnCount];
        String[] columnNames = new String[columnCount];
        String[] dataTypes = new String[columnCount];
        int[] columnSizes = new int[columnCount];
        String[] nullableInfo = new String[columnCount];

        for (int i = 1; i <= columnCount; i++) {
            columnNames[i - 1] = metaData.getColumnName(i);
            columnWidths[i - 1] = columnNames[i - 1].length();

            dataTypes[i - 1] = metaData.getColumnTypeName(i);
            if (dataTypes[i - 1].length() > columnWidths[i - 1]) {
                columnWidths[i - 1] = dataTypes[i - 1].length();
            }

            columnSizes[i - 1] = metaData.getColumnDisplaySize(i);
            if (String.valueOf(columnSizes[i - 1]).length() > columnWidths[i - 1]) {
                columnWidths[i - 1] = String.valueOf(columnSizes[i - 1]).length();
            }

            nullableInfo[i - 1] = metaData.isNullable(i) == 1 ? "Nullable" : "Not Nullable";
            if (nullableInfo[i - 1].length() > columnWidths[i - 1]) {
                columnWidths[i - 1] = nullableInfo[i - 1].length();
            }
        }

        // Print table header
        System.out.println("Columns:");
        System.out.printf("%-" + (columnWidths[0] + 2) + "s", "Name");
        System.out.printf("%-" + (columnWidths[1] + 2) + "s", "Data Type");
        System.out.printf("%-" + (columnWidths[2] + 2) + "s", "Size");
        System.out.printf("%-" + (columnWidths[3] + 2) + "s", "Nullable");
        System.out.println();

        // Print separator line
        for (int i = 0; i < columnCount; i++) {
            for (int j = 0; j < columnWidths[i] + 2; j++) {
                System.out.print("-");
            }
        }
        
        System.out.println();

        // Print column information
        for (int i = 0; i < columnCount; i++) {
            System.out.printf("%-" + (columnWidths[0] + 2) + "s", columnNames[i]);
            System.out.printf("%-" + (columnWidths[1] + 2) + "s", dataTypes[i]);
            System.out.printf("%-" + (columnWidths[2] + 2) + "s", columnSizes[i]);
            System.out.printf("%-" + (columnWidths[3] + 2) + "s", nullableInfo[i]);
            System.out.println();
        }

        System.out.println();

    }


    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "system";
        String password = "admin";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection(url, user, password);

            stmt = conn.createStatement();

            System.out.println("\nConnection successful.");

            while (true) {
                System.out.println("\n*******  Menu  *******");
                System.out.println("1. Create table");
                System.out.println("2. Insert data");
                System.out.println("3. Display table");
                System.out.println("4. Delete record");
                System.out.println("5. Update table");
                System.out.println("6. Alter table");
                System.out.println("7. Delete table");
                System.out.println("8. Describe table");
                System.out.println("9. Exit");

                System.out.print("\nEnter your choice --->  ");
                int option = 0;
                try {
                    option = Integer.parseInt(System.console().readLine());
                } catch (Exception e) {
                    System.out.println(e);
                    continue;
                }

                switch (option) {
                    case 1:
                        try {
                            createTable();
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                        break;

                    case 2:
                        try {
                            insertData();
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                        break;

                    case 3:
                        try {
                            displayTable();
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                        break;

                    case 4:
                        try {
                            deleteRecord();
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                        break;

                    case 5:
                        try {
                            updateTable();
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                        break;

                    case 6:
                        try {
                            alterTable();
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                        break;

                    case 7:
                        try {
                            deleteTable();
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                        break;

                    case 8:
                        try {
                            describeTable();
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                        break;

                    case 9:
                        System.out.println("\nExiting program.\n");
                        System.exit(0);

                    default:
                        System.out.println("\nInvalid option. Try again.\n");
                        break;
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                stmt.close();
                rs.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }

}
