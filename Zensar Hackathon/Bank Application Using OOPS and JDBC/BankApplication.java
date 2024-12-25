import java.sql.*;
import java.util.Scanner;

abstract class AbstractBank {

    protected String accountNumber;
    protected String accountHolderName;
    protected int age;
    protected String aadharNo;
    protected double balance;

    public AbstractBank() {
        this.balance = 0.0;
    }

    public abstract String openAccount(String accountHolderName, int age, String aadharNo) throws SQLException;

    public abstract void deposit(String accountNumber, double amount) throws SQLException, IllegalArgumentException;

    public abstract void withdrawal(String accountNumber, double amount) throws SQLException, IllegalArgumentException;

    public abstract double getBalance(String accountNumber) throws SQLException;
}


/* 
-- For HdfcBank
CREATE TABLE Hdfc_accounts (
    account_number VARCHAR2(20) PRIMARY KEY,
    account_holder_name VARCHAR2(100),
    age NUMBER(3),
    aadhar_no VARCHAR2(12) UNIQUE,
    balance NUMBER(10, 2)
);
 */

class HdfcBank extends AbstractBank {

    private Connection connection;

    public HdfcBank(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String openAccount(String accountHolderName, int age, String aadharNo) throws SQLException {
        String checkAadharQuery = "SELECT * FROM Hdfc_accounts WHERE aadhar_no = ?";
        try (PreparedStatement stmt = connection.prepareStatement(checkAadharQuery)) {
            stmt.setString(1, aadharNo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                throw new SQLException("An account already exists with the same Aadhar number.");
            }
        }

        String query = "INSERT INTO Hdfc_accounts (account_holder_name, age, aadhar_no, balance) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, accountHolderName);
            stmt.setInt(2, age);
            stmt.setString(3, aadharNo);
            stmt.setDouble(4, this.balance);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                String lastquery = "SELECT account_number FROM Hdfc_accounts WHERE aadhar_no = ?";
                try (PreparedStatement psstmt = connection.prepareStatement(lastquery)) {
                    psstmt.setString(1, aadharNo);
                    ResultSet rs = psstmt.executeQuery();
                    if (rs.next()) {
                        // this.accountNumber = rs.getString("account_number");
                        // this.accountHolderName = accountHolderName;
                        // this.age = age;
                        // this.aadharNo = aadharNo;
                        return rs.getString("account_number");
                    } else {
                        throw new SQLException("Failed to retrieve account number.");
                    }
                }
            } else {
                throw new SQLException("Failed to open account.");
            }
        }
    }

    @Override
    public void deposit(String accountNumber, double amount) throws SQLException, IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }

        String query = "UPDATE Hdfc_accounts SET balance = balance + ? WHERE account_number = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, amount);
            stmt.setString(2, accountNumber);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Account not found or update failed.");
            }
        }
    }

    @Override
    public void withdrawal(String accountNumber, double amount) throws SQLException, IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }

        double currentBalance = getBalance(accountNumber);
        if (amount > currentBalance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }

        String query = "UPDATE Hdfc_accounts SET balance = balance - ? WHERE account_number = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, amount);
            stmt.setString(2, accountNumber);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Account not found or update failed.");
            } 
        }
    }

    @Override
    public double getBalance(String accountNumber) throws SQLException {
        String query = "SELECT balance FROM Hdfc_accounts WHERE account_number = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, accountNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            } else {
                throw new SQLException("Account not found.");
            }
        }
    }

}



/* 
- For KotakBank
CREATE TABLE Kotak_accounts (
    account_number VARCHAR2(20) PRIMARY KEY,
    account_holder_name VARCHAR2(100),
    age NUMBER(3),
    aadhar_no VARCHAR2(12) UNIQUE,
    balance NUMBER(10, 2)
); 
 */

class KotakBank extends AbstractBank {

    private Connection connection;

    public KotakBank(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String openAccount(String accountHolderName, int age, String aadharNo) throws SQLException {
        String checkAadharQuery = "SELECT * FROM Kotak_accounts WHERE aadhar_no = ?";
        try (PreparedStatement stmt = connection.prepareStatement(checkAadharQuery)) {
            stmt.setString(1, aadharNo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                throw new SQLException("An account already exists with the same Aadhar number.");
            }
        }

        String query = "INSERT INTO Kotak_accounts (account_holder_name, age, aadhar_no, balance) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, accountHolderName);
            stmt.setInt(2, age);
            stmt.setString(3, aadharNo);
            stmt.setDouble(4, this.balance);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                String lastquery = "SELECT account_number FROM Kotak_accounts WHERE aadhar_no = ?";
                try (PreparedStatement psstmt = connection.prepareStatement(lastquery)) {
                    psstmt.setString(1, aadharNo);
                    ResultSet rs = psstmt.executeQuery();
                    if (rs.next()) {
                        // this.accountNumber = rs.getString("account_number");
                        // this.accountHolderName = accountHolderName;
                        // this.age = age;
                        // this.aadharNo = aadharNo;
                        return rs.getString("account_number");
                    } else {
                        throw new SQLException("Failed to retrieve account number.");
                    }
                }
            } else {
                throw new SQLException("Failed to open account.");
            }
        }
    }


    @Override
    public void deposit(String accountNumber, double amount) throws SQLException, IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero.");
        }

        String query = "UPDATE Kotak_accounts SET balance = balance + ? WHERE account_number = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, amount);
            stmt.setString(2, accountNumber);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Account not found or update failed.");
            }
        }
    }

    @Override
    public void withdrawal(String accountNumber, double amount) throws SQLException, IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
        }

        double currentBalance = getBalance(accountNumber);
        if (amount > currentBalance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }

        String query = "UPDATE Kotak_accounts SET balance = balance - ? WHERE account_number = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, amount);
            stmt.setString(2, accountNumber);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated == 0) {
                throw new SQLException("Account not found or update failed.");
            } 
        }
    }

    @Override
    public double getBalance(String accountNumber) throws SQLException {
        String query = "SELECT balance FROM Kotak_accounts WHERE account_number = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, accountNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            } else {
                throw new SQLException("Account not found.");
            }
        }
    }

}




public class BankApplication {

    public static void main(String[] args) {
        // Database connection setup
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String username = "system";
        String password = "admin";
        
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Connected to the database!");

            // Menu-driven operations for Bank selection and Submenu
            boolean exitApp = false;
            while (!exitApp) {
                // Prompt the user for which bank to proceed with
                System.out.println("\n****************  Select a bank  ***************\n");
                System.out.println("1. Hdfc Bank");
                System.out.println("2. Kotak Bank");
                System.out.println("3. Exit");

                System.out.println("\nEnter your bank choice : ");
                int bankChoice = scanner.nextInt();

                scanner.nextLine();  // Consume the newline character

                AbstractBank selectedBank = null;
                if (bankChoice == 1) {
                    selectedBank = new HdfcBank(connection);
                } else if (bankChoice == 2) {
                    selectedBank = new KotakBank(connection);
                } else if (bankChoice == 3) {
                    exitApp = true;  // Exit the application
                    System.out.println("\nExiting the program...");
                    break;
                } else {
                    System.out.println("\nInvalid choice. Please select again.");
                    continue; // Go back to the bank selection menu
                }

                // Menu-driven operations for selected bank
                boolean exitBankMenu = false;
                while (!exitBankMenu) {
                    System.out.println("\n*************  Select an operation: **************");
                    System.out.println("1. Create new account");
                    System.out.println("2. Deposit money");
                    System.out.println("3. Withdraw money");
                    System.out.println("4. Get account balance");
                    System.out.println("5. Back to bank selection");
                    System.out.println("6. Exit");

                    System.out.println("\nEnter your operation choice : ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    switch (choice) {
                        case 1: // Create new account
                            try {
                                System.out.println("\nEnter account holder name:");
                                String name = scanner.nextLine();

                                System.out.println("\nEnter age:");
                                int age = scanner.nextInt();

                                scanner.nextLine();  // Consume newline

                                System.out.println("\nEnter Aadhar number:");
                                String aadhar = scanner.nextLine();

                                String accountNumber = selectedBank.openAccount(name, age, aadhar);

                                System.out.println("\nAccount created successfully!\nYour account number is: " + accountNumber);
                            } catch (SQLException e) {
                                System.err.println("\nDatabase error while creating account: " + e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.err.println("\nInvalid input while creating account: " + e.getMessage());
                            } catch (Exception e) {
                                System.err.println("\nUnexpected error while creating account: " + e.getMessage());
                            }
                            break;

                        case 2: // Deposit money
                            try {
                                System.out.println("\nEnter account number:");
                                String depositAccount = scanner.nextLine();

                                System.out.println("\nEnter deposit amount:");
                                double depositAmount = scanner.nextDouble();

                                scanner.nextLine(); // Consume newline

                                selectedBank.deposit(depositAccount, depositAmount);

                                System.out.println("\nDeposit successful!");
                            } catch (SQLException e) {
                                System.err.println("\nDatabase error during deposit: " + e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.err.println("\nInvalid input during deposit: " + e.getMessage());
                            } catch (Exception e) {
                                System.err.println("\nUnexpected error during deposit: " + e.getMessage());
                            }
                            break;

                        case 3: // Withdraw money
                            try {
                                System.out.println("\nEnter account number:");
                                String withdrawAccount = scanner.nextLine();

                                System.out.println("\nEnter withdrawal amount:");
                                double withdrawalAmount = scanner.nextDouble();

                                scanner.nextLine();  // Consume newline

                                selectedBank.withdrawal(withdrawAccount, withdrawalAmount);

                                System.out.println("\nWithdrawal successful!");
                            } catch (SQLException e) {
                                System.err.println("\nDatabase error during withdrawal: " + e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.err.println("\nInvalid input during withdrawal: " + e.getMessage());
                            } catch (Exception e) {
                                System.err.println("\nUnexpected error during withdrawal: " + e.getMessage());
                            }
                            break;

                        case 4: // Get balance
                            try {
                                System.out.println("\nEnter account number:");
                                String balanceAccount = scanner.nextLine();

                                double balance = selectedBank.getBalance(balanceAccount);

                                System.out.println("\nAccount balance: " + balance);
                            } catch (SQLException e) {
                                System.err.println("\nDatabase error while getting balance: " + e.getMessage());
                            } catch (IllegalArgumentException e) {
                                System.err.println("\nInvalid input while getting balance: " + e.getMessage());
                            } catch (Exception e) {
                                System.err.println("\nUnexpected error while getting balance: " + e.getMessage());
                            }
                            break;

                        case 5: // Back to bank selection menu
                            exitBankMenu = true;  // Exit the current bank submenu
                            break;

                        case 6: // Exit application
                            exitApp = true;  // Exit the application entirely
                            exitBankMenu = true;  // Exit current submenu
                            System.out.println("\nExiting the program...");
                            break;

                        default:
                            System.out.println("\nInvalid option. Please try again.");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("\nDatabase error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("\nInvalid input: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\nUnexpected error: " + e.getMessage());
        }
    }
    
}

