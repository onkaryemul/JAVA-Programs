
package mypkg.mstock;

import mypkg.DataIO;

public interface NewDataIO extends DataIO
{
    void setData(int no);
    int getNo();
    int getOpnQty();
    String getName();
    double getRate();
    boolean getState();
}

// set CLASSPATH=d:\java23\;
// javac NewDataIO.java