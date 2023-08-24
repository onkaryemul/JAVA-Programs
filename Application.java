
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import mypkg.Util;

class StuAdd extends JDialog implements FocusListener, ActionListener {
    int no;
    String name;
    String city;
    String trade;
    int tno;

    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JComboBox<String> tr;
    JButton b1,b2;

    Connection conn;
    PreparedStatement pi,ps,pt;
    ResultSet rs;

    public StuAdd(JFrame prnt, String title, boolean state, Connection conn) {
        super(prnt,title,state);
        this.conn = conn;

        try {
            pi = conn.prepareStatement("INSERT INTO Student1 VALUES (?, ?, ?, ?)");
            ps = conn.prepareStatement("SELECT * FROM Student1 WHERE rno=?");
            pt = conn.prepareStatement("SELECT * FROM trade");
        } catch (Exception e) {}

        l1 = new JLabel("Roll No.");
        l2 = new JLabel("Name");
        l3 = new JLabel("City");
        l4 = new JLabel("Trade");

        t1 = new JTextField(30);
        t2 = new JTextField(30);
        t3 = new JTextField(30);

        tr = new JComboBox<String>();

        try {
            rs = pt.executeQuery();
            while(rs.next()) {
                tr.addItem(rs.getString(2));
            }
        } catch (Exception e) {}

        b1 = new JButton("Add");
        b2 = new JButton("Back");

        t1.addFocusListener(this);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(5,2,5,5));

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(l3);
        add(t3);

        add(l4);
        add(tr);

        add(b1);
        add(b2);

        setSize(300,400);
        setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e) {}

    @Override
    public void focusLost(FocusEvent e) {
        JTextField t = (JTextField)e.getSource();

        try {
            no = Integer.parseInt(t.getText());

            ps.setInt(1, no);
            rs = ps.executeQuery();

            if(rs.next() == true) {
                Util.display("Record Exists");
                t1.requestFocus();
                return;
            }
        } catch (Exception e1) {
            t1.requestFocus();
            return;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();

        if(b == b1) {
            name = t2.getText();
            city = t3.getText();

            int pos = tr.getSelectedIndex();
            if(pos < 0) {
                tr.requestFocus();
                return;
            }

            trade = tr.getSelectedItem().toString();

            try {
                pi.setInt(1,no);
                pi.setString(2,name);
                pi.setString(3,city);
                pi.setString(4,trade);

                pi.executeUpdate();
            } catch (Exception e1) {}

            setVisible(false);
        }
    }

}


class StuMod extends JDialog implements FocusListener, ActionListener {
    int no;
    String name;
    String city;
    String trade;
    int tno;

    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JComboBox<String> tr;
    JButton b1,b2;

    Connection conn;
    PreparedStatement pi,ps,pt;
    ResultSet rs;

    public StuMod(JFrame prnt, String title, boolean state, Connection conn) {
        super(prnt,title,state);
        this.conn = conn;

        try {
            pi = conn.prepareStatement("UPDATE Student1 set name=?, city=?, tnm=? WHERE rno=?");
            ps = conn.prepareStatement("SELECT * FROM Student1 WHERE rno=?");
            pt = conn.prepareStatement("SELECT * FROM trade");
        } catch (Exception e) {}

        l1 = new JLabel("Roll No.");
        l2 = new JLabel("Name");
        l3 = new JLabel("City");
        l4 = new JLabel("Trade");

        t1 = new JTextField(30);
        t2 = new JTextField(30);
        t3 = new JTextField(30);

        tr = new JComboBox<String>();

        try {
            rs = pt.executeQuery();
            while(rs.next()) {
                tr.addItem(rs.getString(2));
            }
        } catch (Exception e) {}

        b1 = new JButton("Mod");
        b2 = new JButton("Back");

        t1.addFocusListener(this);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(5,2,5,5));

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(l3);
        add(t3);

        add(l4);
        add(tr);

        add(b1);
        add(b2);

        setSize(300,400);
        setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e) {}

    @Override
    public void focusLost(FocusEvent e) {
        JTextField t = (JTextField)e.getSource();

        try {
            no = Integer.parseInt(t.getText());

            ps.setInt(1, no);
            rs = ps.executeQuery();

            if(rs.next() == false) {
                Util.display("Record does not exist!");
                t1.requestFocus();
                return;
            }

            name = rs.getString(2);
            city = rs.getString(3);
            trade = rs.getString(4);

            t2.setText(name);
            t3.setText(city);
            t4.setText(trade);
        } catch (Exception e1) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();

        if(b == b1) {
            name = t2.getText();
            city = t3.getText();

            int pos = tr.getSelectedIndex();
            if(pos < 0) {
                tr.requestFocus();
                return;
            }

            trade = tr.getSelectedItem().toString();

            try {
                pi.setString(1,name);
                pi.setString(2,city);
                pi.setString(3,trade);
                pi.setInt(4, no);

                pi.executeUpdate();
            } catch (Exception e1) {}

            setVisible(false);
        }
    }

}



class StuDel extends JDialog implements FocusListener, ActionListener {
    int no;
    String name;
    String city;
    String trade;
    int tno;

    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JComboBox<String> tr;
    JButton b1,b2;

    Connection conn;
    PreparedStatement pi,ps,pt;
    ResultSet rs;

    public StuDel(JFrame prnt, String title, boolean state, Connection conn) {
        super(prnt,title,state);
        this.conn = conn;

        try {
            pi = conn.prepareStatement("DELETE FROM Student1 WHERE rno=?");
            ps = conn.prepareStatement("SELECT * FROM Student1 WHERE rno=?");
            pt = conn.prepareStatement("SELECT * FROM trade");
        } catch (Exception e) {}

        l1 = new JLabel("Roll No.");
        l2 = new JLabel("Name");
        l3 = new JLabel("City");
        l4 = new JLabel("Trade");

        t1 = new JTextField(30);
        t2 = new JTextField(30);
        t3 = new JTextField(30);

        tr = new JComboBox<String>();

        try {
            rs = pt.executeQuery();
            while(rs.next()) {
                tr.addItem(rs.getString(2));
            }
        } catch (Exception e) {}

        b1 = new JButton("Del");
        b2 = new JButton("Back");

        t1.addFocusListener(this);

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(5,2,5,5));

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(l3);
        add(t3);

        add(l4);
        add(tr);

        add(b1);
        add(b2);

        setSize(300,400);

        t2.setEditable(false);
        t3.setEditable(false);
        tr.setEditable(false);

        setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e) {}

    @Override
    public void focusLost(FocusEvent e) {
        JTextField t = (JTextField)e.getSource();

        try {
            no = Integer.parseInt(t.getText());

            ps.setInt(1, no);
            rs = ps.executeQuery();

            if(rs.next() == false) {
                Util.display("Record does not exist!");
                t1.requestFocus();
                return;
            }

            name = rs.getString(2);
            city = rs.getString(3);
            trade = rs.getString(4);

            t2.setText(name);
            t3.setText(city);
            t4.setText(trade);
        } catch (Exception e1) {
            t1.requestFocus();
            return;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();

        if(b == b1) {
            name = t2.getText();
            city = t3.getText();

            int pos = tr.getSelectedIndex();
            if(pos < 0) {
                tr.requestFocus();
                return;
            }

            trade = tr.getSelectedItem().toString();

            try {
                pi.setInt(1, no);
                pi.executeUpdate();
            } catch (Exception e1) {}

            setVisible(false);
        }
    }

}


class StuTable extends JDialog implements ActionListener {
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
 
    DefaultTableModel dtm;
    JTable jt;

    JButton b1,b2;
    JPanel pan;

    public StuTable(JFrame frm, String title, boolean state, Connection conn) {
        super(frm, title, state);
        this.conn = conn;

        try {
            dtm = new DefaultTableModel(new Object[][]{}, new String[]{"Roll No", "Name", "City", "Trade"});
            jt = new JTable(dtm);

            pst = conn.prepareStatement("SELECT * FROM Student1");
            rs = pst.executeQuery();

            int i = 0;
            while(rs.next()) {
                dtm.insertRow(i, new Object[]{rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)});
                i++;
            }

        } catch(Exception e){}

        b1 = new JButton("Print");
        b2 = new JButton("Back");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);

        jt.setBounds(50,50,200,200);

        b1.setBounds(50,280,75,30);
        b2.setBounds(175,280,75,30);

        setSize(250,360);

        add(jt);
        add(b1);
        add(b2);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();

        if(b == b1) {
            try {
                jt.print();
            } catch (Exception e1) {}
        }

        setVisible(false);
    }

}


public class Application extends JFrame implements ActionListener {
    
    JButton ba;
    JButton bm;
    JButton bd;
    JButton bdisp;

    Connection conn;

    public Application() {
        super("Application");

        ba = new JButton("Add Student");
        ba.addActionListener(this);

        bm = new JButton("Modify Student");
        bm.addActionListener(this);

        bd = new JButton("Delete Student");
        bd.addActionListener(this);
      
        bdisp = new JButton("Display Student");
        bdisp.addActionListener(this);

        setLayout(null);

        ba.setBounds(50,50,150,30);
        bm.setBounds(250,50,150,30);
        bd.setBounds(50,100,150,30);
        bdisp.setBounds(250,100,150,30);

        add(ba);
        add(bm);
        add(bd);
        add(bdisp);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");    
        } catch (Exception e) {
            System.out.println(e);
        }
        
        setSize(450, 210);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();

        if(b == ba) {
            StuAdd obj = new StuAdd(null, "Add Student", true, conn);
        }

        if(b == bm) {
            StuMod a = new StuMod(null, "Modification", true, conn);
        }

        if(b == bd) {
            StuDel d = new StuDel(null, "Deletion", true, conn);
        }

        if(b == bdisp) {
            StuTable t = new StuTable(null, "Display", true, conn);
        }
    }

    public static void main(String[] args) {
        Application a = new Application();
    }

}
