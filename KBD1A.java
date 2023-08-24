

public class KBD1A {

    public static void main(String[] args){
         
        int i=1,uc=0,lc=0,dc=0,oc=0,val=0;

        while(i<=10)
        {
            System.out.println("Type a character : ");

            try
            {
              // Skips over and discard n bytes of the data from input stream 
                System.in.skip(5); // clears buffer 
                val = System.in.read();
            }
            catch(Exception e){}
            
            if(val>=65 && val<=90)
            {
                uc++;
            }
            else
            {
                if(val>=97 && val<=122)
                {
                    lc++;
                }
                else
                {
                    if(val>=48 && val<=57)
                    {
                        dc++;
                    }
                    else
                    {
                        oc++;
                    }
                }
            }
            
            i++;
        }
        
        System.out.println("Upper : " + uc + "\nLower : " + lc + "\nDigit : " + dc + "\nOther : " + oc);
        
    }
    
}
