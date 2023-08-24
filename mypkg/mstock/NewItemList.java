
package mypkg.mstock;

import mypkg.mstock.ItemList;
import java.io.*;
import java.util.*;

public class NewItemList extends ItemList {

    public NewItemList()
    {
        super();
    }

    public void load()
    {
        ObjectInputStream ois = null;

        try
        {
            ois = new ObjectInputStream(new FileInputStream("item.dat"));
            ls = (LinkedList)ois.readObject();
            ois.close();
        }
        catch(Exception e){}

    }

    public void save()
    {
        ObjectOutputStream oos = null;

        try
        {
            oos = new ObjectOutputStream(new FileOutputStream("item.dat"));
            oos.writeObject(ls);
            oos.close();
        }
        catch(Exception e){}

    }

    public void menu()
    {
        load();
        super.menu();
        save();
    }

  /*   
    public static void main(String[] args) {

    }
  */
  
}
