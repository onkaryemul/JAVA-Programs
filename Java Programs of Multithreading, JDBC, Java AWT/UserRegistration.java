
/*
   User Registration using Swing
*/

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class UserRegistration extends JFrame {

    public static final long serialVersionUID = 1L;
    public JPanel contentPane;
    public JTextField firstname;
    public JTextField lastname;
    public JTextField email;
    public JTextField username;
    public JTextField mob;
    public JPasswordField passwordField;
    public JButton btnNewButton;

    public Connection connection;
    public Statement st;

    // Creating the frame
    public UserRegistration() 
    {
        super("User Registration");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);

        setContentPane(contentPane);

        JLabel lblNewUserRegister = new JLabel("New User Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 325, 50);

        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);

        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(58, 243, 110, 29);

        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 50);
        firstname.setColumns(10);

        contentPane.add(firstname);
        
        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(214, 235, 228, 50);
        lastname.setColumns(10);

        contentPane.add(lastname);
      
        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 320, 228, 50);
        email.setColumns(10);

        contentPane.add(email);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(707, 151, 228, 50);
        username.setColumns(10);

        contentPane.add(username);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 99, 29);

        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);

        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(542, 329, 139, 26);

        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mob.setBounds(707, 320, 228, 50);
        mob.setColumns(10);

        contentPane.add(mob);
       
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(707, 235, 228, 50);

        contentPane.add(passwordField);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) 
            {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String userName = username.getText();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
                String password = new String(passwordField.getPassword());

                String msg = firstName + "\n";
    
                if (len != 10) 
                {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }

                try 
                { /* 
                    String url = "jdbc:oracle:thin:@10.10.16.15:1521/pdborcl";
                    String user = "21510017";
                    String password = "21510017";
                  */
                    connection = DriverManager.getConnection(
                                "jdbc:oracle:thin:@localhost:1521:xe",
                                "system","admin");

                    String query = "INSERT INTO account_registration_details values('" + firstName + "','" + lastName + "','" + userName + "','" +
                        password + "','" + emailId + "','" + mobileNumber + "')";

                    st = connection.createStatement();

                    int x = st.executeUpdate(query);

                    if (x == 0) 
                    {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
                } 
                catch (SQLException e)
                {
                    JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    e.printStackTrace();
                }
                finally
                {
                    try
                    {
                      st.close();
                      connection.close();
                    }catch(Exception e){System.out.println(e);}
                }

            }
        });

        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 447, 259, 74);

        contentPane.add(btnNewButton);
    }
    
    // Launching the application
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try 
                {
                    UserRegistration frame = new UserRegistration();
                    frame.setBounds(450, 190, 1014, 597);
                    frame.setResizable(false);
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                } 
                catch (Exception e) 
                {
                    e.printStackTrace();
                }
            }
        });

    }

}






