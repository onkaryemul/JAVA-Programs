
/*
   User login form using Java Swing APIs 
*/

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class UserLogin extends JFrame
{
    public static final long serialVersionUID = 1L;
    public JTextField textField;
    public JPasswordField passwordField;
    public JButton btnNewButton;
    public JLabel label;
    public JPanel contentPane;

    public Connection connection;
    public PreparedStatement st;
    public ResultSet rs;

    // creating the frame
    public UserLogin()
    {
        super("User Login");
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(null);

        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman",Font.PLAIN,46));
        lblNewLabel.setBounds(423,13,273,93);
        
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma",Font.PLAIN,32));
        textField.setBounds(481,170,281,68);
        textField.setColumns(10);

        contentPane.add(textField);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma",Font.PLAIN,32));
        passwordField.setBounds(481,286,281,68);

        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma",Font.PLAIN,31));
        lblUsername.setBounds(250,166,193,52);

        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma",Font.PLAIN,31));
        lblPassword.setBounds(250,286,193,52);

        contentPane.add(lblPassword);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma",Font.PLAIN,26));
        btnNewButton.setBounds(545,392,162,73);

        btnNewButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                String username = textField.getText();
                String password = new String(passwordField.getPassword());

                try
                {
                    connection = DriverManager.getConnection(
                             "jdbc:oracle:thin:@localhost:1521:xe",
                            "system","admin");

                    st = connection.prepareStatement(
                        "SELECT name, password FROM student_login_details WHERE name=? AND password=?");
                    st.setString(1,username);
                    st.setString(2,password);

                    rs = st.executeQuery();

                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog(btnNewButton,"You have successful logged in");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(btnNewButton,"Wrong Username & Password");
                    }
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    try
                    {
                      st.close();
                      rs.close();
                      connection.close();
                    }catch(Exception e){System.out.println(e);}
                }
            }
        });

        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0,0,1008,562);

        contentPane.add(label);
    }

    // Launching the appication
    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run()
            {
                try
                {
                    UserLogin frame = new UserLogin();
                    frame.setBounds(450,190,1014,597);
                    frame.setResizable(false);
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

    }
}




