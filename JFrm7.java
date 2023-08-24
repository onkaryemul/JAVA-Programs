
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class JFrm7 extends JFrame {

    JList list;
    JLabel l1;
    JScrollPane jsp;
    
    String[] city = {"Mumbai", "Pune", "Solapur", "Nagpur", "Kolhapur", "Amravati", "Amahadabad", "Chennai", "Bengaluru", "Hyderabad"};

    public JFrm7()
    {
        super();

        l1 = new JLabel("City");

        list = new JList(city);

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e)
            {
                int choice = list.getSelectedIndex();
                
                if(choice == -1)
                {
                    l1.setText("Choose city");
                }
                else
                {
                    l1.setText(city[choice]);
                }
            }
        });

        jsp = new JScrollPane(list);

        jsp.setPreferredSize(new Dimension(200,200));

        setLayout(new FlowLayout());

        add(jsp);
        add(l1);

        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrm7 a = new JFrm7();
    }
    
}
