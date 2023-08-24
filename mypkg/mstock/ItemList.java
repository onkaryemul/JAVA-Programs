
package mypkg.mstock;

import mypkg.Util;
import mypkg.mstock.Item;
import mypkg.mstock.Transaction;
import mypkg.mstock.Menu;
import mypkg.mstock.ObjectAMD;

import java.util.*;
import java.util.LinkedList;

public class ItemList implements Transaction, Menu, ObjectAMD {
    
    public LinkedList<Item> ls;
    public Item ref;

    public ItemList()
    {
        ref = null;
        ls = new LinkedList<Item>();
    }

    public boolean search(int no)
    {
        int i=0,n=ls.size();

        while(i<n)
        {
            ref = ls.get(i);

            if(ref.no == no)
            {
                break;
            }

            i++;
        }
        
        return (i==n) ? false:true;
    }

    public void add()
    {
        int no = Util.iInput("Item id : ");

        if(search(no) == true)
        {
            Util.display("Record Exists!!");
        }
        else
        {
            ref = new Item();
            ref.setData(no);
            ls.add(ref);
        }
    }

    public void mod()
    {
        int no = Util.iInput("Item id : ");

        if(search(no) == false)
        {
            Util.display("Record Not Exists!!");
        }
        else
        {
            if(ref.getState() == false)
            {
                Util.display("Record Not Exist");
            }
            else
            {
                ref.setData(no);
            }
        }
    }
    
    public void del()
    {
        int no = Util.iInput("Item id : ");

        if(search(no) == false)
        {
            Util.display("Record Not Exists!!");
        }
        else
        {
            if(ref.getState() == false)
            {
                Util.display("Record Not Exist");
            }
            else
            {
                ref.delRecord();;
            }
        }
    }

    public void displayAll()
    {
        int i=0,n=ls.size();

        while(i<n)
        {
           ref = ls.get(i);
           ref.display();
           i++;
        }
    }

    public int getBalance()
    {
        return ref.qty;
    }

    public void getStock()
    {
        int no = Util.iInput("Item No. : ");
        
        if(search(no) == false)
        {
            return;
        }

        ref.display();
    }
     
    public void addQty()
    {
        int no = Util.iInput("Item No. : ");

        if(search(no) == false || ref.getState() == false)
        {
            Util.display("Invalid");
            return;
        }

        ref.display();

        int q = Util.iInput("Purchase Qty : ");

        if(q<=0)
        {
            return;
        }

        ref.qty = ref.qty + q;
    }

    public void subQty()
    {
        int no = Util.iInput("Item No. : ");

        if(search(no) == false || ref.getState() == false)
        {
            Util.display("Invalid");
            return;
        }

        ref.display();

        int q = Util.iInput("Sell Qty : ");

        if(q<=0)
        {
            return;
        }

        ref.qty = ref.qty - q;
    }

    public void menu()
    {
        String[] choice = new String[]{"Add","Mod","Del","DisplayAll","Purchase","Sell","Balance Qty","Exit"};

        while(true)
        {
            int opt = Util.oInput("Choose Option","Stock",choice);

            if(opt==7)
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

                case 3:
                     displayAll();
                     break;

                case 4:
                     addQty();
                     break;

                case 5:
                     subQty();
                     break;

                case 6:
                     getStock();
                     break;
                     
            }

        }

    }

}
