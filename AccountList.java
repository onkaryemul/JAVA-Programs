
import java.util.*;
import javax.swing.*;

class Account{
    public int acno;
    public String acnm;
    public int acopnbal;
    public Vector<Integer> tls;
    public boolean acstate;

    public Account(){
        acno = 0;
        acnm = new String();
        acopnbal=0;
        acstate = true;
        tls = new Vector<Integer>();
    }

    public int balEnq()
    {
        int bal = acopnbal;
        int amt = 0;

        int i=0, n=tls.size();

        while(i<n)
        {
            Integer obj = tls.get(i);
            amt = obj.intValue();

            bal += amt;

            i++;
        }
         
        return bal;
    }

    public void set(int no){
        acno = no;

        acnm = JOptionPane.showInputDialog(null,"A/c Holder Name : ");
        
        try
        {
            acopnbal = Integer.parseInt(JOptionPane.showInputDialog(null,"Opening Balance : "));
        }
        catch(Exception e)
        {
            acopnbal = 500;
        }

        acstate = true;
    }

    public String toString(){

        String a = "\nA/c No : " + acno +"\nName : " + acnm + 
                   "\nOpening Amt : " + acopnbal + "\nTransactions : \n"
                   + tls + "\nClosing Balance : " + balEnq() + "\nState : "
                   + acstate;

        return a;
    }

    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());
    }

    public void delRecord()
    {
        acstate = false;
    }

    public void deposit()
    {
        int amt=0;

        try
        {
            amt = Integer.parseInt(JOptionPane.showInputDialog(null,"Deposit Amount : "));
        }
        catch(Exception e)
        {
            amt = -1;
        }

        if(amt <= 0)
        {
            JOptionPane.showMessageDialog(null,"Invalid");
            return;
        }

        tls.add(amt);
    }

    public void withDraw()
    {
        int amt=0;

        try
        {
            amt = Integer.parseInt(JOptionPane.showInputDialog(null,"Withdraw Amount : "));
        }
        catch(Exception e)
        {
            amt = -1;
        }

        if(amt <= 0)
        {
            JOptionPane.showMessageDialog(null,"Invalid");
            return;
        }

        int bal = balEnq() - amt;

        if(bal<=500)
        {
            JOptionPane.showMessageDialog(null,"Below 500");
            return;
        }

        tls.add(-amt);
    }

    public void closeAccount()
    {
        int bal = balEnq();

        tls.add(-bal);

        delRecord();
    }

}


public class AccountList{

    public LinkedList<Account> ls;

    public Account ref;

    public AccountList()
    {
        ref = null;
        ls = new LinkedList<Account>();
    }

    public int search(int no)
    {
        int i=0,n=ls.size();

        while(i<n)
        {
            ref = ls.get(i);

            if(ref.acno == no)
            {
                break;
            }

            i++;
        }

        if(i==n)
        {
            ref = null;
            return -1;
        }
        else
        {
            return i;
        }
    }

    public void add()
    {
        int no=0;

        try
        {
            no = Integer.parseInt(JOptionPane.showInputDialog(null,"A/c No. : "));
        }
        catch(Exception e){}

        int pos = search(no);

        if(pos>=0)
        {
            JOptionPane.showMessageDialog(null,"Record Exists");
        }
        else
        {
            ref = new Account();

            ref.set(no);

            ls.add(ref);
        }
        
    }

    public void mod()
    {
        int no=0;

        try
        {
            no = Integer.parseInt(JOptionPane.showInputDialog(null,"A/c No. : "));
        }
        catch(Exception e){}

        int pos = search(no);

        if(pos == -1 || ref.acstate == false)
        {
            JOptionPane.showMessageDialog(null,"Record Not Exists");
        }
        else
        {
            ref.set(no);
        }

    }

    public void del()
    {
        int no=0;

        try
        {
            no = Integer.parseInt(JOptionPane.showInputDialog(null,"A/c No. : "));
        }
        catch(Exception e){}

        int pos = search(no);

        if(pos == -1 || ref.acstate == false)
        {
            JOptionPane.showMessageDialog(null,"Record Not Exists");
        }
        else
        {
            ref.closeAccount();
        }

    }

    public void transact()
    {
        int no = 0;

        try
        {
            no = Integer.parseInt(JOptionPane.showInputDialog(null,"A/c No. : "));
        }
        catch(Exception e){}

        int pos = search(no);

        if(pos==-1 || ref.acstate==false)
        {
            JOptionPane.showMessageDialog(null,"Record Not Exists");
            return;
        }

        int opt = JOptionPane.showOptionDialog(null,"Choose Option","Transaction",JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new String[]{"Depo","With","Balance","Back"},0);

        switch(opt)
        {
            case 0:
                ref.deposit();
                break;

            case 1:
                ref.withDraw();
                break;

            case 2:
                JOptionPane.showMessageDialog(null,"Balance : " + ref.balEnq());
        }
    }
    
    public void menu()
    {
        int opt,sv,res;

        String[] option = new String[]{"Add","Mod","Del","Search","Transaction","Display All","Exit"};

        while(true)
        {
            opt = JOptionPane.showOptionDialog(null,"Choose One","Saving A/c",
                  JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,option,0);

            if( opt==6 )
            {
                break;
            }

            switch(opt)
            {
                case 0:
                    add();
                    break;

                case 1:
                    mod();
                    break;

                case 2:
                    del();
                    break;

                case 4:
                    transact();
                    break;

                case 3:
                    try
                    {
                        sv = Integer.parseInt(JOptionPane.showInputDialog(null,"A/c No. : "));
                    }
                    catch(Exception e)
                    {
                        continue;
                    }

                    res = search(sv);
                    if( res == -1 )
                    {
                        JOptionPane.showMessageDialog(null,"Invalid A/c");
                    }
                    else
                    {
                        ref.display();
                    }
                    break;

                case 5:
                    int i=0,n=ls.size();
                    while(i<n)
                    {
                        ref = ls.get(i);
                        ref.display();
                        i++;
                    }
                    break;
            }
        }
    }
    
    public static void main(String[] args){
        
        AccountList a = new AccountList();
        a.menu();
    }

}


