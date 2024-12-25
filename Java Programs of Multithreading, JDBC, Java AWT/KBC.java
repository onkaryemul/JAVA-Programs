
import java.sql.*;
import java.util.*;

public class KBC {
    int ap = 0, ph = 0, ff = 0, fq = 0;

    public static void main(String args[]) throws Exception {
        
        String url = "jdbc:oracle:thin:@localhost:1521:xe";  
        String user = "system";
        String password = "admin";

        String sname;
        int age;
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        Connection connect = DriverManager.getConnection(url,user,password);
        Statement statement = connect.createStatement();

        while(true)
        {
            try {
                KBC x = new KBC();
                Scanner m = new Scanner(System.in);
    
                System.out.print("                        _______________________________________________________  \n");
                System.out.print("                      /|                                                       | \n");
                System.out.print("                     | |  * *     * *    * ** ** ** ** *   * ** ** ** ** **    | \n");
                System.out.print("                     | |  * *    * *     * ** ** ** ** *   * ** ** ** ** **    | \n");
                System.out.print("                     | |  * *   * *      * *         * *   * *                 | \n");
                System.out.print("                     | |  * *  * *       * *         * *   * *                 | \n");
                System.out.print("                     | |  * * * *        * *         * *   * *                 | \n");
                System.out.print("                     | |  * *  *         * ** ** ** ** *   * *                 | \n");
                System.out.print("                     | |  * * * *        * ** ** ** ** *   * *                 | \n");
                System.out.print("                     | |  * *  * *       * *         * *   * *                 | \n");
                System.out.print("                     | |  * *   * *      * *         * *   * *                 | \n");
                System.out.print("                     | |  * *    * *     * ** ** ** ** *   * ** ** ** ** **    | \n");
                System.out.print("                     | |  * *     * *.   * ** ** ** ** * . * ** ** ** ** **    | \n");
                System.out.print("                     | |_______________________________________________________| \n");
                System.out.print("                     |/_______________________________________________________/\n");
    
                System.out.print("\nCreated by:-");
                Thread.sleep(500);
                System.out.print("O");
                Thread.sleep(500);
                System.out.print("n");
                Thread.sleep(500);
                System.out.print("k");
                Thread.sleep(500);
                System.out.print("a");
                Thread.sleep(500);
                System.out.print("r ");
                Thread.sleep(500);
                System.out.print("Y");
                Thread.sleep(500);
                System.out.print("e");
                Thread.sleep(500);
                System.out.print("m");
                Thread.sleep(500);
                System.out.print("u");
                Thread.sleep(500);
                System.out.print("l");
                Thread.sleep(500);
                
                for (int clr = 1; clr <= 5; clr++) {
                    System.out.println("");
                }
                System.out.println("++++++++++++++++++++++++++");
                System.out.println("+   Enter Your choice    +");
                System.out.println("++++++++++++++++++++++++++");
                System.out.println("+ 1.Play                 +");
                System.out.println("+ 2.Your last Score      +");
                System.out.println("+ 3.Help                 +");
                System.out.println("+ 4.Exit                 +");
                System.out.println("++++++++++++++++++++++++++");
                for (int clr = 1; clr <= 3; clr++) {
                    System.out.println("");
                }
                System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
                int enter = m.nextInt();
    
                if (enter == 1) {
                    System.out.println("\nTo Register for the game full fill the requirement");
                    System.out.println("\nEnter your name:-");
    
                    sname = m.next();
    
                    System.out.println("Enter your Age:-");
                    age = m.nextInt();
                    int rs = statement.executeUpdate("INSERT INTO score(name,age) VALUES('" + sname + "'," + age + ")");
                    int sc = statement
                            .executeUpdate("UPDATE score SET score=0 WHERE name='" + sname + "' AND age=" + age);
    
                    System.out.println("Hello " + sname + " welcome to K.B.C");
                    {
    
                        for (int a = 1; a <= 5; a++) {
                            System.out.println();
                        }
    
                        System.out.println("•  •  • ");
                        
                        System.out.println("Loading...");
                        Thread.sleep(1000);
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println("\n");
                        for (int a = 1; a <= 5; a++) {
                            System.out.println();
                        }
                        System.out.println("Done.....");
                        Thread.sleep(1000);
                    }
                    if (age < 100) {
                        System.out.println("\n\n\n\n\t\t\tFastest Finger Question");
                        Random rand1 = new Random();
                        int fq = 0;
                        fq = rand1.nextInt();
                        if (fq % 3 == 1) {
                            System.out.println("Arrange these words in the correct order to form a Hindi Proverb–");
                            System.out.println("A Dum                            B Karna \n");
                            System.out.println("C Naak                           D Mein    ");
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            String ffq = m.next();
                            switch (ffq) {
                                case "CDAB":
                                case "cdab":
                                    break;
                                default:
                                    Thread.sleep(3000);
                                    System.out.println("Sorry your answer is wrong");
                                    System.out.println("Best Luck Next Time !!!!!");
                                    Thread.sleep(3000);
                                    return;
                            }
                        } else if (fq % 3 == 2) {
                            System.out.println(
                                    "Arrange these words in the correct order to form the slogan of the Pulse Polio campaign in India ?");
                            System.out.println("(A) Zindagi                       (B) Do  \n");
                            System.out.println("(C) Boond                         (D) Ki    ");
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            String ffq = m.next();
                            switch (ffq) {
                                case "bcad":
                                case "BCAD":
                                    break;
                                default:
                                    Thread.sleep(3000);
                                    System.out.println("Sorry your answer is wrong");
                                    System.out.println("Best Luck Next Time !!!!!");
                                    Thread.sleep(3000);
                                    return;
                            }
    
                        }
                         else {
                            System.out.println(
                                    "Starting with the earliest, arrange the following events in Narendra Modi's life in chronological order.");
                            System.out.println("(A) CM of Gujarat                 (B) Took oath as PM \n");
                            System.out.println("(C) Joined BJP                    (D) Became RSS Pracharak    ");
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            String ffq = m.next();
                            switch (ffq) {
                                case "DCAB":
                                case "dcab":
                                    break;
                                default:
                                    Thread.sleep(3000);
                                    System.out.println("Sorry your answer is wrong");
                                    System.out.println("Best Luck Next Time !!!!!");
                                    Thread.sleep(3000);
                                    return;
                            }
    
                        }
                        
                        move: {
                            long change = System.currentTimeMillis();
                            if (change % 2 == 0) {
    
                                System.out.println("\t\t\t\t\t\t _____________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 5000 is |");
                                System.out.println(
                                        "Which of the following name means “Person of long age “?                               \t\t|-----------Lifeline------------|");
                                System.out.println("(A) Abhitabh                  (B) Arunodaya                                           \t\t| Type lifeline                 |");
                                System.out.println(
                                        "                                                                                      \t\t|-------------------------------|");
                                System.out.println("(C) Abhishek                  (D) Ayushmaan");
                            } else {
                                System.out.println("\t\t\t\t\t\t _____________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 5000 is |");
                                System.out.println(
                                        "In the game of ludo the discs or tokens are of how many colours? “?                    \t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A) Three                           (B) Two                                            \t\t| Type lifeline                 |");
                                System.out.println(
                                        "                                                                                       \t\t|-------------------------------|");
                                System.out.println("(c) One                             (D) Four");
    
                            }
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            long first = System.currentTimeMillis();
                            String sss = m.next();
                            long second = System.currentTimeMillis();
                            long timer = second - first;
                            if (timer > 31000) {
                                System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                Thread.sleep(1500);
    
                                return;
                            }
                            switch (sss) {
                                case "d":
                                case "D":
    
                                    System.out.println("yes you are right you won Rs.5,000");
                                    Thread.sleep(1600);
                                    System.out.println("\nYour next question for Rs.10,000");
                                    Thread.sleep(2000);
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    break move;
                                case "LIFELINE":
                                case "Lifeline":
                                case "lifeline":
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    x.lifeline(4);
                                    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                                    first = System.currentTimeMillis();
                                    sss = m.next();
                                    second = System.currentTimeMillis();
                                    timer = second - first + timer;
                                    if (timer > 31000) {
                                        System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                        return;
                                    }
                                    switch (sss) {
                                        case "d":
                                        case "D":
    
                                            System.out.println("yes you are right you won Rs.5,000");
                                            Thread.sleep(1600);
                                            System.out.println("\nYour next question for Rs.10,000");
                                            Thread.sleep(2000);
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            break move;
                                        case "LIFELINE":
                                        case "Lifeline":
                                        case "lifeline":
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            x.lifeline(4);
                                            System.out.print(
                                                    ">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                                            first = System.currentTimeMillis();
                                            sss = m.next();
                                            second = System.currentTimeMillis();
                                            timer = second - first + timer;
                                            if (timer > 31000) {
                                                System.out.println(
                                                        "Sorry you are too late. You have 30 Seconds to give answer");
                                                return;
                                            }
                                            switch (sss) {
                                                case "d":
                                                case "D":
    
                                                    System.out.println("yes you are right you won Rs.5,000");
                                                    Thread.sleep(1600);
                                                    System.out.println("\nYour next question for Rs.10,000");
                                                    Thread.sleep(2000);
                                                    for (int asd = 1; asd <= 5; asd++) {
                                                        System.out.println("\b");
                                                    }
                                                    break move;
                                                default:
                                                    System.out.println("Sorry You are wrong today you won Nothing");
                                                    return;
                                            }
                                        default:
                                            System.out.println("Sorry You are wrong today you won Nothing");
                                            return;
                                    }
                                default:
                                    System.out.println("Sorry You are wrong today you won Nothing");
                                    return;
                            }
    
                        }
                        // ********************************************************************************************************************************************
                        // ********************************************************************************************************************************************
    
                        move1: {
                            long change = System.currentTimeMillis();
                            if (change % 2 == 1) {
                                System.out.println("\t\t\t\t\t\t _____________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 10,000 is |");
                                System.out.println("How is the call of a chicken usually expressed?                                       \t\t|-----------Lifeline------------|");
                                System.out.println("(A) Denchu Dencu             (B) Kukro Koo                                            \t\t|Type lifeline\t\t\t|");
                                System.out.println("                                                                                      \t\t|-------------------------------|");
                                System.out.println("(C) Peehu Peehu              (D) Guta Goo");
                            } else {
                                System.out.println("\t\t\t\t\t\t _____________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 10,000 is |");
                                System.out.println(
                                        "How many rings are there in an Olympic Flag?                                          \t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A) 2              (B) 5                                                              \t\t|Type lifeline\t\t\t|");
                                System.out.println(
                                        "                                                                                      \t\t|-------------------------------|");
                                System.out.println("(C) 3              (D) 4");
                            }
    
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            long first = System.currentTimeMillis();
                            String sss = m.next();
                            long second = System.currentTimeMillis();
                            long timer = second - first;
                            if (timer > 31000) {
                                System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                Thread.sleep(1500);
    
                                return;
                            }
                            switch (sss) {
                                case "b":
                                case "B":
    
                                    System.out.println("yes you are right you won Rs.10,000");
                                    Thread.sleep(1600);
                                    System.out.println("\nYour next question for Rs.20,000");
                                    Thread.sleep(2000);
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    break move1;
                                case "LIFELINE":
                                case "Lifeline":
                                case "lifeline":
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                                    x.lifeline(2);
                                    first = System.currentTimeMillis();
                                    sss = m.next();
                                    second = System.currentTimeMillis();
                                    timer = second - first + timer;
                                    if (timer > 31000) {
                                        System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                        return;
                                    }
                                    switch (sss) {
                                        case "b":
                                        case "B":
    
                                            System.out.println("yes you are right you won Rs.10,000");
                                            Thread.sleep(1600);
                                            System.out.println("\nYour next question for Rs.20,000");
                                            Thread.sleep(2000);
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            break move1;
                                        case "LIFELINE":
                                        case "Lifeline":
                                        case "lifeline":
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("");
                                            }
                                            x.lifeline(2);
                                            System.out.print(
                                                    ">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                                            first = System.currentTimeMillis();
                                            sss = m.next();
                                            second = System.currentTimeMillis();
                                            timer = second - first + timer;
                                            if (timer > 31000) {
                                                System.out.println(
                                                        "Sorry you are too late. You have 30 Seconds to give answer");
                                                return;
                                            }
                                            switch (sss) {
                                                case "b":
                                                case "B":
    
                                                    System.out.println("yes you are right you won Rs.10,000");
                                                    Thread.sleep(1600);
                                                    System.out.println("\nYour next question for Rs.20,000");
                                                    Thread.sleep(2000);
                                                    for (int asd = 1; asd <= 5; asd++) {
                                                        System.out.println("\b");
                                                    }
                                                    break move1;
                                                default:
                                                    System.out.println("Sorry You are wrong today you won nothing");
                                                    return;
                                            }
                                        default:
                                            System.out.println("Sorry You are wrong today you won nothing");
                                            return;
                                    }
                                default:
                                    System.out.println("Sorry You are wrong today you won nothing");
                                    return;
                            }
                        }
    
                        // ********************************************************************************************************************************************
                        // ********************************************************************************************************************************************
    
                        move2: {
                            long change = System.currentTimeMillis();
                            if (change % 2 == 1) {
                                System.out.println("\t\t\t\t\t\t _____________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 20,000 is |");
                                System.out.println(
                                        "Seeds of which of these flowers are used to produce a edible oil ?                    \t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A) Genda                            (B) Guldaudi                                     \t\t|Type lifeline\t\t\t|");
                                System.out.println(
                                        "                                                                                      \t\t|-------------------------------|");
                                System.out.println("(C) Arhul                            (D) Surajmukhi");
                            } else {
                                System.out.println("\t\t\t\t\t\t _____________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 20,000 is |");
                                System.out.println(
                                        "In which commonwealth games did flying Sikh Milkha Singh win the first gold medal for India?   \t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A) 1934. London                     (B) 1938. Sidney                                          \t\t|Type lifeline\t\t\t|");
                                System.out.println(
                                        "                                                                                               \t\t|-------------------------------|");
                                System.out.println("(C) 1950. Auckland                   (D) 1958. Cardiff ");
    
                            }
    
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            long first = System.currentTimeMillis();
                            String sss = m.next();
                            long second = System.currentTimeMillis();
                            long timer = second - first;
                            if (timer > 31000) {
                                System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                Thread.sleep(1500);
    
                                return;
                            }
                            switch (sss) {
                                case "d":
                                case "D":
    
                                    System.out.println("yes you are right you won Rs.20,000");
                                    Thread.sleep(1600);
                                    System.out.println("\nYour next question for Rs.40,000");
                                    Thread.sleep(2000);
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    break move2;
                                case "LIFELINE":
                                case "Lifeline":
                                case "lifeline":
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    x.lifeline(4);
                                    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                                    first = System.currentTimeMillis();
                                    sss = m.next();
                                    second = System.currentTimeMillis();
                                    timer = second - first + timer;
                                    if (timer > 31000) {
                                        System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                        return;
                                    }
                                    switch (sss) {
                                        case "d":
                                        case "D":
    
                                            System.out.println("yes you are right you won Rs.20,000");
                                            Thread.sleep(1600);
                                            System.out.println("\nYour next question for Rs.40,000");
                                            Thread.sleep(2000);
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            break move2;
                                        case "LIFELINE":
                                        case "Lifeline":
                                        case "lifeline":
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            x.lifeline(4);
                                            System.out.print(
                                                    ">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                                            first = System.currentTimeMillis();
                                            sss = m.next();
                                            second = System.currentTimeMillis();
                                            timer = second - first + timer;
                                            if (timer > 31000) {
                                                System.out.println(
                                                        "Sorry you are too late. You have 30 Seconds to give answer");
                                                return;
                                            }
                                            switch (sss) {
                                                case "d":
                                                case "D":
    
                                                    System.out.println("yes you are right you won Rs.20,000");
                                                    Thread.sleep(1600);
                                                    System.out.println("\nYour next question for Rs.40,000");
                                                    Thread.sleep(2000);
                                                    for (int asd = 1; asd <= 5; asd++) {
                                                        System.out.println("\b");
                                                    }
                                                    break move2;
                                                default:
                                                    System.out.println("Sorry You are wrong today you won nothing");
                                                    return;
                                            }
                                        default:
                                            System.out.println("Sorry You are wrong today you won nothing");
                                            return;
                                    }
                                default:
                                    System.out.println("Sorry You are wrong today you won nothing");
                                    return;
                            }
                        }
                        // ********************************************************************************************************************************************
                        // ********************************************************************************************************************************************
    
                        move3: {
                            long change = System.currentTimeMillis();
                            if (change % 2 == 1) {
                                System.out.println("\t\t\t\t\t\t _______________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 40,000 is |");
                                System.out.println(
                                        "According to a TV ad, Which duo goes to the tailor and says ,“Masterji, pitaji ki patloon ek bilang chhoti kar do” ?\t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A) Hari – Harish                             (B) Ramesh – Suresh                                                   \t\t|Type lifeline\t\t\t|");
                                System.out.println(
                                        "                                                                                                                    \t\t|-------------------------------|");
                                System.out.println("(C) Santa – Banta                             (D) Ajay – Vijay");
                            } else {
                                System.out.println("\t\t\t\t\t\t _______________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 40,000 is |");
                                System.out.println(
                                        "When and where will Nineteenth Commonwealth games be held ?                     \t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A)2010 Melbourne                    (B) 2010 New Delhi                         \t\t|Type lifeline\t\t\t|");
                                System.out.println(
                                        "                                                                                \t\t|-------------------------------|");
                                System.out.println("(C) 2010 Canada                      (D) 2010 Pakistan ");
                            }
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            long first = System.currentTimeMillis();
                            String sss = m.next();
                            long second = System.currentTimeMillis();
                            long timer = second - first;
                            if (timer > 31000) {
                                System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                Thread.sleep(1500);
    
                                return;
                            }
                            switch (sss) {
                                case "b":
                                case "B":
                                    int sc1 = statement.executeUpdate("UPDATE score SET score=80000 WHERE name='"
                                            + sname + "' AND age=" + age);
                                    System.out.println("yes you are right you won Rs.40,000");
                                    Thread.sleep(1600);
                                    System.out.println("\nYour next question for Rs.80,000");
                                    Thread.sleep(2000);
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    break move3;
                                case "LIFELINE":
                                case "Lifeline":
                                case "lifeline":
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    x.lifeline(2);
                                    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                                    first = System.currentTimeMillis();
                                    sss = m.next();
                                    second = System.currentTimeMillis();
                                    timer = second - first + timer;
                                    if (timer > 31000) {
                                        System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                        return;
                                    }
                                    switch (sss) {
                                        case "b":
                                        case "B":
    
                                            sc1 = statement.executeUpdate("UPDATE score SET score=40000 WHERE name='"
                                                    + sname + "' AND age=" + age);
                                            System.out.println("yes you are right you won Rs.40,000");
                                            Thread.sleep(1600);
                                            System.out.println("\nYour next question for Rs.80,000");
                                            Thread.sleep(2000);
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            break move3;
                                        case "LIFELINE":
                                        case "Lifeline":
                                        case "lifeline":
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            x.lifeline(2);
                                            System.out.print(
                                                    ">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                                            first = System.currentTimeMillis();
                                            sss = m.next();
                                            second = System.currentTimeMillis();
                                            timer = second - first + timer;
                                            if (timer > 31000) {
                                                System.out.println(
                                                        "Sorry you are too late. You have 30 Seconds to give answer");
                                                return;
                                            }
                                            switch (sss) {
                                                case "b":
                                                case "B":
                                                    sc1 = statement
                                                            .executeUpdate("UPDATE score SET score=40000 WHERE name='"
                                                                    + sname + "' AND age=" + age);
                                                    System.out.println("yes you are right you won Rs.40,000");
                                                    Thread.sleep(1600);
                                                    System.out.println("\nYour next question for Rs.80,000");
                                                    Thread.sleep(2000);
                                                    for (int asd = 1; asd <= 5; asd++) {
                                                        System.out.println("\b");
                                                    }
                                                    break move3;
                                                default:
                                                    System.out.println("Sorry You are wrong today you won nothing");
                                                    return;
                                            }
                                        default:
                                            System.out.println("Sorry You are wrong today you won nothing");
                                            return;
                                    }
                                default:
                                    System.out.println("Sorry You are wrong today you won nothing");
                                    return;
                            }
                        }
                        // ********************************************************************************************************************************************
                        // ********************************************************************************************************************************************
    
                        move4: {
                            long change = System.currentTimeMillis();
    
                            if (change % 2 == 1) {
                                System.out.println("\t\t\t\t\t\t _____________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 80,000 is |");
                                System.out.println(
                                        "In which sport has Jwala Gutta been a 13-time National Champion?                      \t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A) Badminton                       (B) Chess                                         \t\t|Type lifeline\t\t\t|");
                                System.out.println(
                                        "                                                                                      \t\t|-------------------------------|");
                                System.out.println("(C) Squash                          (D) Table Tennis");
                            } else {
                                System.out.println("\t\t\t\t\t\t _____________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 80,000 is |");
                                System.out.println(
                                        "On which date is Nobel Prize awarded?                                                 \t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A) December 10                     (B) January 10                                    \t\t|Type lifeline\t\t\t|");
                                System.out.println(
                                        "                                                                                      \t\t|-------------------------------|");
                                System.out.println("(C) April 10                        (D) July 10");
                            }
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            long first = System.currentTimeMillis();
                            String sss = m.next();
                            long second = System.currentTimeMillis();
                            long timer = second - first;
                            if (timer > 31000) {
                                System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                Thread.sleep(1500);
    
                                return;
                            }
                            switch (sss) {
                                case "a":
                                case "A":
                                    System.out.println("yes you are right you won Rs.80,000");
                                    Thread.sleep(1600);
                                    System.out.println("\nYour next question for Rs.1,60,000");
                                    Thread.sleep(2000);
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    break move4;
                                case "LIFELINE":
                                case "Lifeline":
                                case "lifeline":
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    x.lifeline(1);
                                    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
    
                                    first = System.currentTimeMillis();
                                    sss = m.next();
                                    second = System.currentTimeMillis();
                                    timer = second - first + timer;
                                    if (timer > 31000) {
                                        System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                        return;
                                    }
                                    switch (sss) {
                                        case "a":
                                        case "A":
                                            System.out.println("yes you are right you won Rs.80,000");
                                            Thread.sleep(1600);
                                            System.out.println("\nYour next question for Rs.1,60,000");
                                            Thread.sleep(2000);
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            break move4;
                                        case "LIFELINE":
                                        case "Lifeline":
                                        case "lifeline":
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            x.lifeline(1);
                                            System.out.print(
                                                    ">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                                            first = System.currentTimeMillis();
                                            sss = m.next();
                                            second = System.currentTimeMillis();
                                            timer = second - first + timer;
                                            if (timer > 31000) {
                                                System.out.println(
                                                        "Sorry you are too late. You have 30 Seconds to give answer");
                                                return;
                                            }
                                            switch (sss) {
                                                case "a":
                                                case "A":
                                                    System.out.println("yes you are right you won Rs.80,000");
                                                    Thread.sleep(1600);
                                                    System.out.println("\nYour next question for Rs.1,60,000");
                                                    Thread.sleep(2000);
                                                    for (int asd = 1; asd <= 5; asd++) {
                                                        System.out.println("\b");
                                                    }
                                                    break move4;
                                                default:
                                                    System.out.println("You are wrong today you won Only 40,000");
                                                    return;
                                            }
                                        default:
                                            System.out.println("You are wrong today you won Only 40,000");
                                            return;
                                    }
                                default:
                                    System.out.println("You are wrong today you won Only 40,000");
                                    return;
                            }
                        }
                        // ********************************************************************************************************************************************
                        // ********************************************************************************************************************************************
    
                        move5: {
                            long change = System.currentTimeMillis();
                            if (change % 2 == 1) {
                                System.out.println("\t\t\t\t\t\t _________________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 1,60,000 is |");
                                System.out.println(
                                        "Which of these organs helps in maintaining the sense of balance or equilibrium of our body\t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A) Nose                                 (B) Ears                                         \t\t|Type lifeline\t\t\t|");
                                System.out.println(
                                        "                                                                                          \t\t|-------------------------------|");
                                System.out.println("(C) Tongue                               (D) Lungs");
                            } else {
                                System.out.println("\t\t\t\t\t\t _________________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 1,60,000 is |");
                                System.out.println(
                                        "Who was the Chairman of the Drafting committee of the Constituent of India?               \t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A) Rajaendra Prasad                   (B) B. R. Ambedkar                                 \t\t|Type lifeline\t\t\t|");
                                System.out.println(
                                        "                                                                                          \t\t|-------------------------------|");
                                System.out.println("(C) Vallabhbhai Prasad                 (D) G. V. Mavalankar");
    
                            }
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            long first = System.currentTimeMillis();
                            String sss = m.next();
                            long second = System.currentTimeMillis();
                            long timer = second - first;
                            if (timer > 31000) {
                                System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                Thread.sleep(1500);
    
                                return;
                            }
                            switch (sss) {
                                case "b":
                                case "B":
                                    System.out.println("yes you are right you won Rs.1,60,000");
                                    Thread.sleep(1600);
                                    System.out.println("\nYour next question for Rs.3,20,000");
                                    Thread.sleep(2000);
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    break move5;
                                case "LIFELINE":
                                case "Lifeline":
                                case "lifeline":
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    x.lifeline(2);
                                    System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
    
                                    first = System.currentTimeMillis();
                                    sss = m.next();
                                    second = System.currentTimeMillis();
                                    timer = second - first + timer;
                                    if (timer > 31000) {
                                        System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                        return;
                                    }
                                    switch (sss) {
                                        case "b":
                                        case "B":
                                            System.out.println("yes you are right you won Rs.1,60,000");
                                            Thread.sleep(1600);
                                            System.out.println("\nYour next question for Rs.3,20,000");
                                            Thread.sleep(2000);
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            break move5;
                                        case "LIFELINE":
                                        case "Lifeline":
                                        case "lifeline":
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            x.lifeline(2);
                                            first = System.currentTimeMillis();
                                            sss = m.next();
                                            second = System.currentTimeMillis();
                                            timer = second - first + timer;
                                            if (timer > 31000) {
                                                System.out.println(
                                                        "Sorry you are too late. You have 30 Seconds to give answer");
                                                return;
                                            }
                                            switch (sss) {
                                                case "b":
                                                case "B":
                                                    System.out.println("yes you are right you won Rs.1,60,000");
                                                    Thread.sleep(1600);
                                                    System.out.println("\nYour next question for Rs.3,20,000");
                                                    Thread.sleep(2000);
                                                    for (int asd = 1; asd <= 5; asd++) {
                                                        System.out.println("\b");
                                                    }
                                                    break move5;
                                                default:
                                                    System.out.println("You are wrong today you won Only 40,000");
                                                    return;
                                            }
                                        default:
                                            System.out.println("You are wrong today you won Only 40,000");
                                            return;
                                    }
                                default:
                                    System.out.println("You are wrong today you won Only 40,000");
                                    return;
                            }
                        }
    
                        // ********************************************************************************************************************************************
                        // ********************************************************************************************************************************************
    
                        move4: {
                            long change = System.currentTimeMillis();
                            if (change % 2 == 1) {
                                System.out.println("\t\t\t\t\t\t _________________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 3,20,000 is |");
                                System.out.println(
                                        "People from which of these professions are most likely to use ‘aari’, ‘basula’ and ‘burma’ at their work?\t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A) Tailor                                      (B) Washerman                                         \t\t|Type lifeline\t\t\t|");
                                System.out.println(
                                        "                                                                                                      \t\t|-------------------------------|");
                                System.out.println("(C) Carpenter                                   (D) Painter");
                            } else {
                                System.out.println("\t\t\t\t\t\t _________________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 3,20,000 is |");
                                System.out.println(
                                        "Which Bank is known as Banker of Bank(Provide support to the bank) ?                              \t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A)State bank of india                  (B) Punjab National Bank                                   \t\t|Type lifeline\t\t\t|");
                                System.out.println(
                                        "                                                                                                  \t\t|-------------------------------|");
                                System.out.println("(C)Reserve Bank of India                (D) ICIC Bank");
    
                            }
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            long first = System.currentTimeMillis();
                            String sss = m.next();
                            long second = System.currentTimeMillis();
                            long timer = second - first;
                            if (timer > 31000) {
                                System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                Thread.sleep(1500);
    
                                return;
                            }
                            switch (sss) {
                                case "c":
                                case "C":
                                    System.out.println("yes you are right you won Rs.3,20,000");
                                    Thread.sleep(1600);
                                    System.out.println("\nYour next question for Rs.6,40,000");
                                    Thread.sleep(2000);
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    break move4;
                                case "LIFELINE":
                                case "Lifeline":
                                case "lifeline":
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    x.lifeline(3);
                                    first = System.currentTimeMillis();
                                    sss = m.next();
                                    second = System.currentTimeMillis();
                                    timer = second - first + timer;
                                    if (timer > 31000) {
                                        System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                        return;
                                    }
                                    switch (sss) {
                                        case "c":
                                        case "C":
                                            System.out.println("yes you are right you won Rs.3,20,000");
                                            Thread.sleep(1600);
                                            System.out.println("\nYour next question for Rs.6,40,000");
                                            Thread.sleep(2000);
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            break move4;
                                        case "LIFELINE":
                                        case "Lifeline":
                                        case "lifeline":
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            x.lifeline(3);
                                            first = System.currentTimeMillis();
                                            sss = m.next();
                                            second = System.currentTimeMillis();
                                            timer = second - first + timer;
                                            if (timer > 31000) {
                                                System.out.println(
                                                        "Sorry you are too late. You have 30 Seconds to give answer");
                                                return;
                                            }
                                            switch (sss) {
                                                case "c":
                                                case "C":
                                                    System.out.println("yes you are right you won Rs.3,20,000");
                                                    Thread.sleep(1600);
                                                    System.out.println("\nYour next question for Rs.6,40,000");
                                                    Thread.sleep(2000);
                                                    for (int asd = 1; asd <= 5; asd++) {
                                                        System.out.println("\b");
                                                    }
                                                    break move4;
                                                default:
                                                    System.out.println("You are wrong today you won Only 40,000");
                                                    return;
                                            }
                                        default:
                                            System.out.println("You are wrong today you won Only 40,000");
                                            return;
                                    }
                                default:
                                    System.out.println("You are wrong today you won Only 40,000");
                                    return;
                            }
                        }
                        // ********************************************************************************************************************************************
                        // ********************************************************************************************************************************************
    
                        move4: {
                            long change = System.currentTimeMillis();
                            if (change % 2 == 1) {
                                System.out.println("\t\t\t\t\t\t _________________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 6,40,000 is |");
                                System.out.println(
                                        "Which of the following animals do not have external ears?                             \t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A) Cat                               (B) Bat                                         \t\t|Type lifeline\t\t\t|");
                                System.out.println(
                                        "                                                                                      \t\t|-------------------------------|");
                                System.out.println("(C) Rat                               (D) Snake");
                            } else {
                                System.out.println("\t\t\t\t\t\t _________________________________");
                                System.out.println("\t\t\t\t\t\t|your Question for Rs 6,40,000 is |");
                                System.out.println(
                                        "According to the song from ‘Sholay’, “Koi Haseena Jab Rooth Jaati Hai, Toh Aur Bhi_____________ ” ? \t\t|-----------Lifeline------------|");
                                System.out.println(
                                        "(A) Rangeen Ho Jaati Hai                    (B) Shareef Ho Jaati Hai                              \t\t|Type lifeline\t\t\t|");
                                System.out.println(
                                        "                                                                                                  \t\t|-------------------------------|");
                                System.out.println("(C) Namkeen Ho Jaati Hai                    (D) Haseen Ho Jaati Hai");
    
                            }
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            long first = System.currentTimeMillis();
                            String sss = m.next();
                            long second = System.currentTimeMillis();
                            long timer = second - first;
                            if (timer > 31000) {
                                System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                Thread.sleep(1500);
    
                                return;
                            }
                            switch (sss) {
                                case "d":
                                case "D":
                                    int sc2 = statement.executeUpdate("UPDATE score SET score=640000 WHERE name='"
                                            + sname + "' AND age=" + age );
                                    System.out.println("yes you are right you won Rs.6,40,000");
                                    Thread.sleep(1600);
                                    System.out.println("\nYour next question for Rs.12,50,000");
                                    Thread.sleep(2000);
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    break move4;
                                case "LIFELINE":
                                case "Lifeline":
                                case "lifeline":
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    x.lifeline(4);
                                    first = System.currentTimeMillis();
                                    sss = m.next();
                                    second = System.currentTimeMillis();
                                    timer = second - first + timer;
                                    if (timer > 31000) {
                                        System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                        return;
                                    }
                                    switch (sss) {
                                        case "d":
                                        case "D":
                                            sc2 = statement.executeUpdate("UPDATE score SET score=640000 WHERE name='"
                                                    + sname + "' AND age=" + age);
                                            System.out.println("yes you are right you won Rs.6,40,000");
                                            Thread.sleep(1600);
                                            System.out.println("\nYour next question for Rs.12,50,000");
                                            Thread.sleep(2000);
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            break move4;
                                        case "LIFELINE":
                                        case "Lifeline":
                                        case "lifeline":
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            x.lifeline(4);
                                            first = System.currentTimeMillis();
                                            sss = m.next();
                                            second = System.currentTimeMillis();
                                            timer = second - first + timer;
                                            if (timer > 31000) {
                                                System.out.println(
                                                        "Sorry you are too late. You have 30 Seconds to give answer");
                                                return;
                                            }
                                            switch (sss) {
                                                case "d":
                                                case "D":
                                                    sc2 = statement
                                                            .executeUpdate("UPDATE score SET score=640000 WHERE name='"
                                                                    + sname + "' AND age=" + age);
                                                    System.out.println("yes you are right you won Rs.6,40,000");
                                                    Thread.sleep(1600);
                                                    System.out.println("\nYour next question for Rs.12,50,000");
                                                    Thread.sleep(2000);
                                                    for (int asd = 1; asd <= 5; asd++) {
                                                        System.out.println("\b");
                                                    }
                                                    break move4;
                                                default:
                                                    System.out.println("You are wrong today you won Only 40,000");
                                                    return;
                                            }
                                        default:
                                            System.out.println("You are wrong today you won Only 40,000");
                                            return;
                                    }
                                default:
                                    System.out.println("You are wrong today you won Only 40,000");
                                    return;
                            }
                        }
                        // ********************************************************************************************************************************************
                        // ********************************************************************************************************************************************
    
                        move4: {
                            System.out.println("\t\t\t\t\t\t __________________________________");
                            System.out.println("\t\t\t\t\t\t|your Question for Rs 12,50,000 is |");
                            System.out.println(
                                    "Which of these national parks, reserved for tigers, is named after a river?           \t\t|-----------Lifeline------------|");
                            System.out.println(
                                    "(A) Indrawati                         (B) Sunderbans                                  \t\t|Type lifeline\t\t\t|");
                            System.out.println(
                                    "                                                                                      \t\t|-------------------------------|");
                            System.out.println("(C) Dudhwa                            (D) Kanha");
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            long first = System.currentTimeMillis();
                            String sss = m.next();
                            long second = System.currentTimeMillis();
                            long timer = second - first;
                            if (timer > 31000) {
                                System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                Thread.sleep(1500);
    
                                return;
                            }
                            switch (sss) {
                                case "a":
                                case "A":
    
                                    System.out.println("yes you are right you won Rs.12,50,000");
                                    Thread.sleep(1600);
                                    System.out.println("\nYour next question for Rs.25,00,000");
                                    Thread.sleep(2000);
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    break move4;
                                case "LIFELINE":
                                case "Lifeline":
                                case "lifeline":
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    x.lifeline(1);
                                    first = System.currentTimeMillis();
                                    sss = m.next();
                                    second = System.currentTimeMillis();
                                    timer = second - first + timer;
                                    if (timer > 31000) {
                                        System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                        return;
                                    }
                                    switch (sss) {
                                        case "a":
                                        case "A":
    
                                            System.out.println("yes you are right you won Rs.12,50,000");
                                            Thread.sleep(1600);
                                            System.out.println("\nYour next question for Rs.25,00,000");
                                            Thread.sleep(2000);
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            break move4;
                                        case "LIFELINE":
                                        case "Lifeline":
                                        case "lifeline":
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            x.lifeline(1);
                                            first = System.currentTimeMillis();
                                            sss = m.next();
                                            second = System.currentTimeMillis();
                                            timer = second - first + timer;
                                            if (timer > 31000) {
                                                System.out.println(
                                                        "Sorry you are too late. You have 30 Seconds to give answer");
                                                return;
                                            }
                                            switch (sss) {
                                                case "a":
                                                case "A":
    
                                                    System.out.println("yes you are right you won Rs.12,50,000");
                                                    Thread.sleep(1600);
                                                    System.out.println("\nYour next question for Rs.25,00,000");
                                                    Thread.sleep(2000);
                                                    for (int asd = 1; asd <= 5; asd++) {
                                                        System.out.println("\b");
                                                    }
                                                    break move4;
                                                default:
                                                    System.out.println("You are wrong today you won Only Rs.6,40,000/-");
                                                    return;
                                            }
                                        default:
                                            System.out.println("You are wrong today you won Only 6,40,000/-");
                                            return;
                                    }
                                default:
                                    System.out.println("You are wrong today you won Only 6,40,000/-");
                                    return;
                            }
                        }
                        // ********************************************************************************************************************************************
                        // ********************************************************************************************************************************************
    
                        move4: {
                            System.out.println("\t\t\t\t\t\t __________________________________");
                            System.out.println("\t\t\t\t\t\t|your Question for Rs 25,00,000 is |");
                            System.out.println(
                                    "Who was the Chairman of the Drafting committee of the Constituent of India?           \t\t|-----------Lifeline------------|");
                            System.out.println(
                                    "(A) Rajaendra Prasad                  (B) B. R. Ambedkar                              \t\t|Type lifeline\t\t\t|");
                            System.out.println(
                                    "                                                                                      \t\t|-------------------------------|");
                            System.out.println("(C) Vallabhbhai Prasad                (D) G. V. Mavalankar");
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            long first = System.currentTimeMillis();
                            String sss = m.next();
                            long second = System.currentTimeMillis();
                            long timer = second - first;
                            if (timer > 31000) {
                                System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                Thread.sleep(1500);
    
                                return;
                            }
                            switch (sss) {
                                case "b":
                                case "B":
                                    System.out.println("yes you are right you won Rs.12,50,000");
                                    Thread.sleep(1600);
                                    System.out.println("\nYour next question for Rs.25,00,000");
                                    Thread.sleep(2000);
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    break move4;
                                case "LIFELINE":
                                case "Lifeline":
                                case "lifeline":
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    x.lifeline(2);
                                    first = System.currentTimeMillis();
                                    sss = m.next();
                                    second = System.currentTimeMillis();
                                    timer = second - first + timer;
                                    if (timer > 31000) {
                                        System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                        return;
                                    }
                                    switch (sss) {
                                        case "b":
                                        case "B":
                                            System.out.println("yes you are right you won Rs.12,50,000");
                                            Thread.sleep(1600);
                                            System.out.println("\nYour next question for Rs.25,00,000");
                                            Thread.sleep(2000);
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            break move4;
                                        case "LIFELINE":
                                        case "Lifeline":
                                        case "lifeline":
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            x.lifeline(2);
                                            first = System.currentTimeMillis();
                                            sss = m.next();
                                            second = System.currentTimeMillis();
                                            timer = second - first + timer;
                                            if (timer > 31000) {
                                                System.out.println(
                                                        "Sorry you are too late. You have 30 Seconds to give answer");
                                                return;
                                            }
                                            switch (sss) {
                                                case "b":
                                                case "B":
                                                    System.out.println("yes you are right you won Rs.12,50,000");
                                                    Thread.sleep(1600);
                                                    System.out.println("\nYour next question for Rs.25,00,000");
                                                    Thread.sleep(2000);
                                                    for (int asd = 1; asd <= 5; asd++) {
                                                        System.out.println("\b");
                                                    }
                                                    break move4;
                                                default:
                                                    System.out.println("You are wrong today you won Only Rs.6,40,000/-");
                                                    return;
                                            }
                                        default:
                                            System.out.println("You are wrong today you won Only 6,40,000/-");
                                            return;
                                    }
                                default:
                                    System.out.println("You are wrong today you won Only 6,40,000/-");
                                    return;
                            }
                        }


                        // ********************************************************************************************************************************************
                        // ********************************************************************************************************************************************
    
                        move4: {
                            System.out.println("\t\t\t\t\t\t _____________________________");
                            System.out.println("\t\t\t\t\t\t|your Question for Rs 50,00,000 is |");
                            System.out.println(
                                    "The wife of which of these famous sportspersons was once captain of Indian volleyball team?   \t\t|-----------Lifeline------------|");
                            System.out.println(
                                    "(A) K.D.Jadav                             (B) Milkha Singh                                     \t\t|Type lifeline\t\t\t|");
                            System.out.println(
                                    "                                                                                              \t\t|-------------------------------|");
                            System.out.println("(C)Dhyan Chand                            (D) Prakash Padukone");
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            long first = System.currentTimeMillis();
                            String sss = m.next();
                            long second = System.currentTimeMillis();
                            long timer = second - first;
                            if (timer > 31000) {
                                System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                Thread.sleep(1500);
    
                                return;
                            }
                            switch (sss) {
                                case "b":
                                case "B":
                                    System.out.println("yes you are right you won Rs.50,00,000");
                                    Thread.sleep(1600);
                                    System.out.println("\nYour next question for Rs.1 Crore");
                                    Thread.sleep(2000);
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    break move4;
                                case "LIFELINE":
                                case "Lifeline":
                                case "lifeline":
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    x.lifeline(2);
                                    first = System.currentTimeMillis();
                                    sss = m.next();
                                    second = System.currentTimeMillis();
                                    timer = second - first + timer;
                                    if (timer > 31000) {
                                        System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                        return;
                                    }
                                    switch (sss) {
                                        case "b":
                                        case "B":
                                            System.out.println("yes you are right you won Rs.50,00,000");
                                            Thread.sleep(1600);
                                            System.out.println("\nYour next question for Rs.1 Crore");
                                            Thread.sleep(2000);
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            break move4;
                                        case "LIFELINE":
                                        case "Lifeline":
                                        case "lifeline":
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            x.lifeline(2);
                                            first = System.currentTimeMillis();
                                            sss = m.next();
                                            second = System.currentTimeMillis();
                                            timer = second - first + timer;
                                            if (timer > 31000) {
                                                System.out.println(
                                                        "Sorry you are too late. You have 30 Seconds to give answer");
                                                return;
                                            }
                                            switch (sss) {
                                                case "b":
                                                case "B":
                                                    System.out.println("yes you are right you won Rs.50,00,000");
                                                    Thread.sleep(1600);
                                                    System.out.println("\nYour next question for Rs.1 Crore");
                                                    Thread.sleep(2000);
                                                    for (int asd = 1; asd <= 5; asd++) {
                                                        System.out.println("\b");
                                                    }
                                                    break move4;
                                                default:
                                                    System.out.println("You are wrong today you won Only Rs.6,40,000/-");
                                                    return;
                                            }
                                        default:
                                            System.out.println("You are wrong today you won Only 6,40,000/-");
                                            return;
                                    }
                                default:
                                    System.out.println("You are wrong today you won Only 6,40,000/-");
                                    return;
                            }
                        }

                        // ********************************************************************************************************************************************
                        // ********************************************************************************************************************************************

                        move4: {
                            System.out.println("\t\t\t\t\t\t ________________________________");
                            System.out.println("\t\t\t\t\t\t|your Question for Rs 1 Crore is |");
                            System.out.println(
                                    "Who was the first Indian woman to take part in Olympic Games?                         \t\t|-----------Lifeline------------|");
                            System.out.println(
                                    "(A) Merry La RO                 (B) P.T.Usha                                          \t\t|Type lifeline\t\t\t|");
                            System.out.println(
                                    "                                                                                      \t\t|-------------------------------|");
                            System.out.println("(B) Anju B.G.                   (D) K.Malleshwree ");
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }
    
                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");
                            long first = System.currentTimeMillis();
                            String sss = m.next();
                            long second = System.currentTimeMillis();
                            long timer = second - first;
                            if (timer > 31000) {
                                System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                Thread.sleep(1500);
    
                                return;
                            }
                            switch (sss) {
                                case "a":
                                case "A":
                                    int sc4 = statement.executeUpdate("UPDATE score SET score=10000000 WHERE name='"
                                            + sname + "' AND age=" + age);
                                    System.out.println("yes you are right you won Rs.1 Crore\n");
                                    Thread.sleep(500);
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("");
                                    }
                                    for (int win = 1; win <= 4; win++) {
    
                                        System.out.println(
                                                "\t\t\t\t************************************You Won*************************************");
                                        System.out.println(
                                                "\t\t\t\t*                                                                              *");
                                        System.out.println(
                                                "\t\t\t\t*   W       W   IIIIIIIIIIII   N       N   N       N   EEEEEEEE   RRRRRRRR     *  ");
                                        System.out.println(
                                                "\t\t\t\t*   W       W        II        N N     N   N N     N   EE         R       R    *  ");
                                        System.out.println(
                                                "\t\t\t\t*   W       W        II        N  N    N   N  N    N   EE         R       R    *  ");
                                        System.out.println(
                                                "\t\t\t\t*   W   W   W        II        N   N   N   N   N   N   EEEEEEEE   RRRRRRRR     *  ");
                                        System.out.println(
                                                "\t\t\t\t*   W  W W  W        II        N    N  N   N    N  N   EE         R R          *  ");
                                        System.out.println(
                                                "\t\t\t\t*   W W   W W        II        N     N N   N     N N   EE         R   R        * ");
                                        System.out.println(
                                                "\t\t\t\t*   WW     WW   IIIIIIIIIIII   N       N   N       N   EEEEEEEE   R     R      *  ");
                                        System.out.println(
                                                "\t\t\t\t*                                                                              *");
                                        System.out.println(
                                                "\t\t\t\t************************************You Won*************************************");
                                        for (int asd = 1; asd <= 5; asd++) {
                                            System.out.println("");
                                        }
                                        Thread.sleep(500);
                                        
                                    }
                                    Thread.sleep(3000);
                                    break move4;
                                    case "LIFELINE":
                                    case "Lifeline":
                                    case "lifeline":
                                    for (int asd = 1; asd <= 5; asd++) {
                                        System.out.println("\b");
                                    }
                                    x.lifeline(1);
                                    first = System.currentTimeMillis();
                                    sss = m.next();
                                    second = System.currentTimeMillis();
                                    timer = second - first + timer;
                                    if (timer > 31000) {
                                        System.out.println("Sorry you are too late. You have 30 Seconds to give answer");
                                        return;
                                    }
                                    switch (sss) {
                                        case "a":
                                        case "A":
                                            sc4 = statement
                                                    .executeUpdate("UPDATE score SET score=10000000 WHERE name='"
                                                            + sname + "' AND age=" + age);
                                            System.out.println("yes you are right you won Rs.1 Crore\n");
                                            Thread.sleep(5000);
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("");
                                            }
                                            for (int win = 1; win <= 4; win++) {
    
                                                System.out.println(
                                                        "\t\t\t\t************************************You Won*************************************");
                                                System.out.println(
                                                        "\t\t\t\t*                                                                              *");
                                                System.out.println(
                                                        "\t\t\t\t*   W       W   IIIIIIIIIIII   N       N   N       N   EEEEEEEE   RRRRRRRR     *  ");
                                                System.out.println(
                                                        "\t\t\t\t*   W       W        II        N N     N   N N     N   EE         R       R    *  ");
                                                System.out.println(
                                                        "\t\t\t\t*   W       W        II        N  N    N   N  N    N   EE         R       R    *  ");
                                                System.out.println(
                                                        "\t\t\t\t*   W   W   W        II        N   N   N   N   N   N   EEEEEEEE   RRRRRRRR     *  ");
                                                System.out.println(
                                                        "\t\t\t\t*   W  W W  W        II        N    N  N   N    N  N   EE         R R          *  ");
                                                System.out.println(
                                                        "\t\t\t\t*   W W   W W        II        N     N N   N     N N   EE         R   R        * ");
                                                System.out.println(
                                                        "\t\t\t\t*   WW     WW   IIIIIIIIIIII   N       N   N       N   EEEEEEEE   R     R      *  ");
                                                System.out.println(
                                                        "\t\t\t\t*                                                                              *");
                                                System.out.println(
                                                        "\t\t\t\t************************************You Won*************************************");
                                                for (int asd = 1; asd <= 5; asd++) {
                                                    System.out.println("");
                                                }
                                                Thread.sleep(800);
                                                
                                            }
                                            Thread.sleep(5000);
                                            break move4;
                                            case "LIFELINE":
                                            case "Lifeline":
                                            case "lifeline":
                                            for (int asd = 1; asd <= 5; asd++) {
                                                System.out.println("\b");
                                            }
                                            x.lifeline(1);
                                            first = System.currentTimeMillis();
                                            sss = m.next();
                                            second = System.currentTimeMillis();
                                            timer = second - first + timer;
                                            if (timer > 31000) {
                                                System.out.println(
                                                        "Sorry you are too late. You have 30 Seconds to give answer");
                                                return;
                                            }
                                            sss = m.next();
                                            switch (sss) {
                                                case "a":
                                                case "A":
                                                    sc4 = statement.executeUpdate(
                                                            "UPDATE score SET score=10000000 WHERE name='" + sname
                                                                    + "' AND age=" + age);
                                                    System.out.println("yes you are right you won Rs.1 Crore\n");
                                                    Thread.sleep(2000);
                                                    for (int asd = 1; asd <= 5; asd++) {
                                                        System.out.println("");
                                                    }
                                                    for (int win = 1; win <= 4; win++) {
    
                                                        System.out.println(
                                                                "\t\t\t\t************************************You Won*************************************");
                                                        System.out.println(
                                                                "\t\t\t\t*                                                                              *");
                                                        System.out.println(
                                                                "\t\t\t\t*   W       W   IIIIIIIIIIII   N       N   N       N   EEEEEEEE   RRRRRRRR     *  ");
                                                        System.out.println(
                                                                "\t\t\t\t*   W       W        II        N N     N   N N     N   EE         R       R    *  ");
                                                        System.out.println(
                                                                "\t\t\t\t*   W       W        II        N  N    N   N  N    N   EE         R       R    *  ");
                                                        System.out.println(
                                                                "\t\t\t\t*   W   W   W        II        N   N   N   N   N   N   EEEEEEEE   RRRRRRRR     *  ");
                                                        System.out.println(
                                                                "\t\t\t\t*   W  W W  W        II        N    N  N   N    N  N   EE         R R          *  ");
                                                        System.out.println(
                                                                "\t\t\t\t*   W W   W W        II        N     N N   N     N N   EE         R   R        * ");
                                                        System.out.println(
                                                                "\t\t\t\t*   WW     WW   IIIIIIIIIIII   N       N   N       N   EEEEEEEE   R     R      *  ");
                                                        System.out.println(
                                                                "\t\t\t\t*                                                                              *");
                                                        System.out.println(
                                                                "\t\t\t\t************************************You Won*************************************");
                                                        for (int asd = 1; asd <= 5; asd++) {
                                                            System.out.println("");
                                                        }
                                                        Thread.sleep(800);
                                                        for (int asd = 1; asd <= 5; asd++) {
                                                            System.out.println("");
                                                        }
                                                        for (int asd = 1; asd <= 5; asd++) {
                                                            System.out.println("");
                                                        }
                                                        Thread.sleep(800);
                                                    }
                                                    Thread.sleep(5000);
                                                    for (int asd = 1; asd <= 5; asd++) {
                                                        System.out.println("\b");
                                                    }
                                                    break move4;
                                                default:
                                                    System.out.println("You are wrong today you won Only Rs.6,40,000/-");
                                                    return;
                                            }
                                        default:
                                            System.out.println("You are wrong today you won Only Rs.6,40,000/-");
                                            return;
                                    }
                                default:
                                    System.out.println("You are wrong today you won Only Rs.6,40,000/-");
                                    return;
                            }
                        }
                        // ********************************************************************************************************************************************
                        // ********************************************************************************************************************************************
    
                    } else {
                        System.out.println("Process under Development");
                    }
                } 
                
                //your last score
                else if (enter == 2) {
                    for (int clr = 1; clr <= 5; clr++) {
                        System.out.println("");
                    }
                    System.out.println(
                            "\t\t\t-----------------------------------------Your Last Score----------------------------------------");
    
                    String yourname;
    
                    int yourage, a = 0;
                    System.out.println("Enter your name ");
                    for (int clr = 1; clr <= 5; clr++) {
                        System.out.println();
                    }
                    System.out.println("------------------------------------------------------------------------------------------\nAns:-");
                    yourname = m.next();
                    String yourname2 = "'" + yourname + "'";
                    System.out.println("Enter you age");
                    yourage = m.nextInt();
                    for (int clr = 1; clr <= 5; clr++) {
                        System.out.println();
                    }

                    ResultSet Res = statement.executeQuery("SELECT * FROM score WHERE name=" + yourname2 + " AND age= " + yourage);
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    while (Res.next()) {
    
                        System.out.println(" Name           =>  " + Res.getString(1));
                        System.out.println(" Age            =>  " + Res.getInt(2));
                        System.out.println(" Total Earn     =>  "+ Res.getInt(3));
    
                        a++;
                    }
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    for (int clr = 1; clr <= 5 - a; clr++) {
                        System.out.println();
                    }
    
                }
    
                // HELP OPTION 
                else if (enter == 3) {
                    for (int clr = 1; clr <= 5; clr++) {
                        System.out.println("");
                    }
                    System.out.println("\t\t\t\t\tHELP");
                    System.out.println(" If you are Playing this game you have to know :-");
                    System.out.println(
                            " --------------------------------------------------------------------------------------");
                    System.out.println(
                            "|1. First you have to solve Fastest finger question                                    |");
                    System.out.println(
                            "|2. After solving the fastest finger question you will move to Hot Seat zone           |");
                    System.out.println(
                            "|3. In Hot seat zone you will receive different questions one by one and               |");
                    System.out.println(
                            "|you have to give right answer to recive next Question                                 |");
                    System.out.println(
                            "|4. To Become Winner you have to give the right answer of 12 Question                  |");
                    System.out.println(
                            "|5. You have 30 Second to give you answer but If you are using lifeline then           |");
                    System.out.println(
                            "|timer will stop till the lifeline will complete after that time is automatically On   |");
                    System.out.println(
                            "|6. You have 4 Lifeline but each Lifeline can works only one Time.                     |");
                    System.out.println(
                            " --------------------------------------------------------------------------------------\n");

                    Thread.sleep(5000);

                    System.out.println(" If you want to check your score");
                    System.out.println(
                            " --------------------------------------------------------------------------------------");
                    System.out.println(
                            "|1. In Menu option select Third option                                                  |");
                    System.out.println(
                            "|2. Then Enter your name and age                                                        |");
                    System.out.println(
                            "|3. If you have Played our game or your record is save in our database then             |");
                    System.out.println(
                            "|you are can easily view your high score                                                |");
                    System.out.println(
                            " --------------------------------------------------------------------------------------\n");
                    
                    Thread.sleep(5000);
                    
                    System.out.println("If you want to Quit/Exit");
                    System.out.println(
                            " --------------------------------------------------------------------------------------");
                    System.out.println(
                            "|1. In Menu option select Fifth option                                                  |");
                    System.out.println(
                            "|2. Then the program will Exit                                                          |");
                    System.out.println(
                            " --------------------------------------------------------------------------------------");
                    
                    Thread.sleep(6000);

                    
                } 
                
                //exit
                else if (enter == 4) {
                    System.out.println("You are exited");
                    return;
                }

                //wrong choise
                else
                {
                    System.out.println("Wrong choice");
                }
    
            } catch (InterruptedException exc) {
                System.out.println("sleep\\wait is not working");
            }
        }

    }

    //LIFELINE

    public void lifeline(int quesno) {
        Scanner m = new Scanner(System.in);
        if (quesno == 1) {
            try {
                System.out.print("------------------------------------------------------");
                System.out.print("\n|\t\t    Lifeline\t\t\t     |\n");
                System.out.println("------------------------------------------------------");
                System.out.println("1.Audience poll \t\t2.Phone a friend");
                System.out.println("3.Fifty fifty   \t\t4.Flip The question");
                for (int space = 1; space <= 5; space++) {
                    System.out.println("");
                }
                int lifeline = m.nextInt();
                System.out.println();
                System.out.println();
                if (lifeline == 1) {
                    try {
                        ap = ap + 1;
                        if (ap == 1) {
                            System.out.print("Audience are voting");
                            Thread.sleep(1000);
                            System.out.print(".");
                            Thread.sleep(1000);
                            System.out.print(".");
                            Thread.sleep(1000);
                            System.out.print(".");
                            Thread.sleep(1000);
                            System.out.print(".");
                            Thread.sleep(1000);
                            System.out.print(".");
                            Thread.sleep(1000);
                            System.out.print(".\n\n\n\n\n");
                            System.out.println("          Audience Rating");
                            System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|");
                            System.out.println(" |-|     A     B    C   D     |-|");
                            System.out.println(" |-|                          |-|");
                            System.out.println(" |-|                          |-|");
                            System.out.println(" |-|                          |-|");
                            System.out.println(" |-|     __                   |-|");
                            System.out.println(" |-|    |  |                  |-|");
                            System.out.println(" |-|    |  |                  |-|");
                            System.out.println(" |-|    |  |                  |-|");
                            System.out.println(" |-|    |  |  __              |-|");
                            System.out.println(" |-|    |60| |20|  __   __    |-|");
                            System.out.println(" |-|    |  |_|  |_|10|_|10|   |-|");
                            System.out.println(" |-|    |__|_|__|_|__|_|__|   |-|");
                            System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|");
                            for (int move = 1; move <= 5; move++) {
                                System.out.println();
                            }
                        }
                        else {
                            System.out.println("you have used this lifeline");
                            lifeline(1);
                        }
                    } catch (InterruptedException exc) {
                        System.out.println("sleep\\wait is not working");
                    }

                }

                else if (lifeline == 2) {
                    for (int space = 1; space <= 5; space++) {
                        System.out.println("");
                    }
                    ph = ph + 1;
                    if (ph == 1) {
                        System.out.println("Choose any friend to call for help");
                        System.out.println(" _________        _________         _________       _________ ");
                        System.out.println("|         |      |         |       |         |     |         |");
                        System.out.println("| RAM     |      |  RAHIM  |       |  RAJAN  |     |  ROHIT  |");
                        System.out.println("|_________|      |_________|       |_________|     |_________|");
                        
                        System.out.println("Enter any one name for calling");

                        for (int space = 1; space <= 5; space++) {
                            System.out.println("");
                        }
                        String call = m.next();
                        switch (call) {

                            case "Ram":
                            case "RAM":
                            case "ram":
                            case "Rahim":
                            case "rahim":
                            case "RAHIM":
                            case "Rajan":
                            case "rajan":
                            case "RAJAN":
                            case "Rohit":
                            case "rohit":
                            case "ROHIT":

                                System.out.print("Call is Diverting to " + call);

                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.println(".");
                                System.out.println("Hello");
                                String as = m.next();

                                System.out.println("Hi !! give me your question");
                                String a = m.next();
                                System.out.println("give me option");
                                String asa = m.next();
                                System.out.println("I think A is True");
                                break;

                        }

                    } else {
                        System.out.println("You have already used this lifeline");
                        lifeline(1);
                    }
                } else if (lifeline == 3) {
                    for (int move = 1; move <= 5; move++) {
                        System.out.println("");
                    }
                    ff = ff + 1;
                    if (ff == 1) {
                        System.out.println("Fifty fifty");
                        System.out.println("You Answer may be :-");
                        System.out.println("A.     ");
                        System.out.println("\t\tC.");
                        for (int move = 1; move <= 5; move++) {
                            System.out.println("");
                        }
                    } else {
                        System.out.println("You have already used this lifeline");
                        lifeline(1);
                    }
                } else if (lifeline == 4) {
                    fq = fq + 1;
                    if (fq == 1) {
                        System.out.println("Flip the Question");
                        System.out.println("According to the Mahabharata, who made Gandiva, the famous bow of Arjuna?");
                        System.out.println("(A) Brahma                            (B) Indra ");
                        System.out.println("(C) Chandra                           (D) Prajapati");
                        for (int clr = 1; clr <= 5; clr++) {
                            System.out.println("");
                        }

                        System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");

                    } else {
                        System.out.println("you have already used this lifeline");
                        lifeline(1);
                    }
                } 
                

            } catch (InterruptedException exc) {
                System.out.println("!!!!!!!!!!!!!!!!!!!!RESTART!!!!!!!!!!!!!!!!!!!");
            }

        }
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        else if (quesno == 2) {
            {
                try {
                    System.out.print("------------------------------------------------------");
                    System.out.print("\n|\t\t    Lifeline\t\t\t     |\n");
                    System.out.println("------------------------------------------------------");
                    System.out.println("1.Audience poll \t\t2.Phone a friend");
                    System.out.println("3.Fifty fifty   \t\t4.Flip The question");
                    for (int space = 1; space <= 5; space++) {
                        System.out.println("");
                    }
                    int lifeline = m.nextInt();
                    System.out.println();
                    System.out.println();
                    if (lifeline == 1) {
                        try {
                            ap = ap + 1;
                            if (ap == 1) {
                                System.out.print("Audience are voting");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".\n\n\n\n\n");
                                System.out.println("          Audience Rating");
                                System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|");
                                System.out.println(" |-|     A     B    C   D     |-|");
                                System.out.println(" |-|                          |-|");
                                System.out.println(" |-|                          |-|");
                                System.out.println(" |-|          __              |-|");
                                System.out.println(" |-|         |  |             |-|");
                                System.out.println(" |-|         |  |             |-|");
                                System.out.println(" |-|         |  |             |-|");
                                System.out.println(" |-|         |  |             |-|");
                                System.out.println(" |-|         |  |             |-|");
                                System.out.println(" |-|     __  |70|  __   __    |-|");
                                System.out.println(" |-|    |10|_|  |_|10|_|10|   |-|");
                                System.out.println(" |-|    |__|_|__|_|__|_|__|   |-|");
                                System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|");
                                for (int move = 1; move <= 5; move++) {
                                    System.out.println();
                                }
                            } else {
                                System.out.println("you have used this lifeline");
                                lifeline(1);
                            }

                        } catch (InterruptedException exc) {

                        }

                    }

                    else if (lifeline == 2) {
                        for (int space = 1; space <= 5; space++) {
                            System.out.println("");
                        }
                        ph = ph + 1;
                        if (ph == 1) {
                            System.out.println("Choose any friend to call for help");
                            System.out.println(" _________        _________         _________       _________ ");
                            System.out.println("|         |      |         |       |         |     |         |");
                            System.out.println("| RAM     |      |  RAHIM  |       |  RAJAN  |     |  ROHIT  |");
                            System.out.println("|_________|      |_________|       |_________|     |_________|");

                            System.out.println("Enter any one name for calling");

                            for (int space = 1; space <= 5; space++) {
                                System.out.println("");
                            }
                            String call = m.next();
                            switch (call) {

                                case "Ram":
                                case "RAM":
                                case "ram":
                                case "Rahim":
                                case "rahim":
                                case "RAHIM":
                                case "Rajan":
                                case "rajan":
                                case "RAJAN":
                                case "Rohit":
                                case "rohit":
                                case "ROHIT":

                                    System.out.print("Call is Diverting to " + call);

                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.println(".");
                                    System.out.println("Hello");
                                    String as = m.next();

                                    System.out.println("Hi !! Tell me your question");
                                    String a = m.next();
                                    System.out.println("give me option");
                                    String asa = m.next();
                                    System.out.println("I think B is True");
                                    break;

                            }

                        } else {
                            System.out.println("You have already used this lifeline");
                            lifeline(2);
                        }
                    } else if (lifeline == 3) {
                        for (int move = 1; move <= 5; move++) {
                            System.out.println("");
                        }
                        ff = ff + 1;
                        if (ff == 1) {
                            System.out.println("Fifty fifty");
                            System.out.println("You Answer may be :-");
                            System.out.println("\t\tB.");
                            System.out.println("C.");
                            for (int move = 1; move <= 5; move++) {
                                System.out.println("");
                            }
                        } else {
                            System.out.println("You have already used this lifeline");
                            lifeline(2);
                        }
                    } else if (lifeline == 4) {
                        fq = fq + 1;
                        if (fq == 1) {
                            System.out.println("Flip the Question");
                            System.out.println("In Cricket, “round the wicket” and “over the wicket” represent what ?");
                            System.out.println("(A) Wicket-keeping                    (B) Bowling ");
                            System.out.println("(C) Batting                           (D) Commentary");
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }

                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");

                        } else {
                            System.out.println("you have already used this lifeline");
                            lifeline(2);
                        }
                    } 

                    else {
                        System.out.println("you have enter wrong choice");
                        lifeline(2);
                    }

                } catch (InterruptedException exc) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!RESTART!!!!!!!!!!!!!!!!!!!");
                }

            }
        }

        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        else if (quesno == 3) {
            {
                try {
                    System.out.print("------------------------------------------------------");
                    System.out.print("\n|\t\t    Lifeline\t\t\t     |\n");
                    System.out.println("------------------------------------------------------");
                    System.out.println("1.Audience poll \t\t2.Phone a friend");
                    System.out.println("3.Fifty fifty   \t\t4.Flip The question");
                    for (int space = 1; space <= 5; space++) {
                        System.out.println("");
                    }
                    int lifeline = m.nextInt();
                    System.out.println();
                    System.out.println();
                    if (lifeline == 1) {
                        try {
                            ap = ap + 1;
                            if (ap == 1) {
                                System.out.print("Audience are voting");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".\n\n\n\n\n");
                                System.out.println("          Audience Rating");
                                System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|");
                                System.out.println(" |-|     A     B    C   D     |-|");
                                System.out.println(" |-|                          |-|");
                                System.out.println(" |-|                          |-|");
                                System.out.println(" |-|                          |-|");
                                System.out.println(" |-|                          |-|");
                                System.out.println(" |-|                          |-|");
                                System.out.println(" |-|               __         |-|");
                                System.out.println(" |-|     __       |  |        |-|");
                                System.out.println(" |-|    |  |  __  |  |        |-|");
                                System.out.println(" |-|    |30| |20| |  |  __    |-|");
                                System.out.println(" |-|    |  |_|  |_|40|_|10|   |-|");
                                System.out.println(" |-|    |__|_|__|_|__|_|__|   |-|");
                                System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|");
                                for (int move = 1; move <= 5; move++) {
                                    System.out.println();
                                }
                            } else {
                                System.out.println("you have used this lifeline");
                                lifeline(3);
                            }

                        } catch (InterruptedException exc) {

                        }

                    }

                    else if (lifeline == 2) {
                        for (int space = 1; space <= 5; space++) {
                            System.out.println("");
                        }
                        ph = ph + 1;
                        if (ph == 1) {
                            System.out.println("Choose any friend to call for help");
                            System.out.println(" _________        _________         _________       _________ ");
                            System.out.println("|         |      |         |       |         |     |         |");
                            System.out.println("| RAM     |      |  RAHIM  |       |  RAJAN  |     |  ROHIT  |");
                            System.out.println("|_________|      |_________|       |_________|     |_________|");

                            System.out.println("Enter any one name for calling");

                            for (int space = 1; space <= 5; space++) {
                                System.out.println("");
                            }
                            String call = m.next();
                            switch (call) {

                                case "Ram":
                                case "RAM":
                                case "ram":
                                case "Rahim":
                                case "rahim":
                                case "RAHIM":
                                case "Rajan":
                                case "rajan":
                                case "RAJAN":
                                case "Rohit":
                                case "rohit":
                                case "ROHIT":

                                    System.out.print("Call is Diverting to " + call);

                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.println(".");
                                    System.out.println("Hello");
                                    String as = m.next();

                                    System.out.println("Hi !! Tell me your question");
                                    String a = m.next();
                                    m.close();
                                    System.out.println("give me option");
                                    String asa = m.next();
                                    System.out.println("I think C is True");
                                    break;

                            }

                        } else {
                            System.out.println("You have already used this lifeline");
                            lifeline(3);
                        }
                    } else if (lifeline == 3) {
                        for (int move = 1; move <= 5; move++) {
                            System.out.println("");
                        }
                        ff = ff + 1;
                        if (ff == 1) {
                            System.out.println("Fifty fifty");
                            System.out.println("You Answer may be :-");
                            System.out.println("\t\tB.     ");
                            System.out.println("C.");
                            for (int move = 1; move <= 5; move++) {
                                System.out.println();
                            }
                        } else {
                            System.out.println("You have already used this lifeline");
                            lifeline(3);
                        }
                    } else if (lifeline == 4) {
                        fq = fq + 1;
                        if (fq == 1) {
                            System.out.println("Flip the Question");
                            System.out.println("Which of these Indian cricketers made his Test Debut in 2012?");
                            System.out.println("(A) Abhinav Mukund                    (B) Ajankia Rahane ");
                            System.out.println("(C) Ravindra Jadeja                   (D) Rohit Sharma");
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }

                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");

                        } else {
                            System.out.println("you have already used this lifeline");
                            lifeline(3);
                        }
                    } 
                    else {
                        System.out.println("you have enter wrong choice");
                        lifeline(3);
                    }

                } catch (InterruptedException exc) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!RESTART!!!!!!!!!!!!!!!!!!!");
                }

            }
        } else {
            {
                try {
                    System.out.print("------------------------------------------------------");
                    System.out.print("\n|\t\t    Lifeline\t\t\t     |\n");
                    System.out.println("------------------------------------------------------");
                    System.out.println("1.Audience poll \t\t2.Phone a friend");
                    System.out.println("3.Fifty fifty   \t\t4.Flip The question");
                    for (int space = 1; space <= 5; space++) {
                        System.out.println("");
                    }
                    int lifeline = m.nextInt();
                    System.out.println();
                    System.out.println();
                    if (lifeline == 1) {
                        try {
                            ap = ap + 1;
                            if (ap == 1) {
                                System.out.print("Audience are voting");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".");
                                Thread.sleep(1000);
                                System.out.print(".\n\n\n\n\n");
                                System.out.println("          Audience Rating");
                                System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|");
                                System.out.println(" |-|     A     B    C   D     |-|");
                                System.out.println(" |-|                          |-|");
                                System.out.println(" |-|                          |-|");
                                System.out.println(" |-|                          |-|");
                                System.out.println(" |-|                    __    |-|");
                                System.out.println(" |-|                   |  |   |-|");
                                System.out.println(" |-|                   |  |   |-|");
                                System.out.println(" |-|                   |  |   |-|");
                                System.out.println(" |-|          __       |  |   |-|");
                                System.out.println(" |-|     __  |20|  __  |  |   |-|");
                                System.out.println(" |-|    |10|_|  |_|10|_|60|   |-|");
                                System.out.println(" |-|    |__|_|__|_|__|_|__|   |-|");
                                System.out.println(" |-|-|-|-|-|-|-|-|-||-|-|-|-|-|-|");
                                for (int move = 1; move <= 5; move++) {
                                    System.out.println();
                                }
                            } else {
                                System.out.println("you have used this lifeline");
                                lifeline(4);
                            }

                        } catch (InterruptedException exc) {

                        }

                    }

                    else if (lifeline == 2) {
                        for (int space = 1; space <= 5; space++) {
                            System.out.println("");
                        }
                        ph = ph + 1;
                        if (ph == 1) {
                            System.out.println("Choose any friend to call for help");
                            System.out.println(" _________        _________         _________       _________ ");
                            System.out.println("|         |      |         |       |         |     |         |");
                            System.out.println("| RAM     |      |  RAHIM  |       |  RAJAN  |     |  ROHIT  |");
                            System.out.println("|_________|      |_________|       |_________|     |_________|");
                            System.out.println("Enter any one name for calling");

                            for (int space = 1; space <= 5; space++) {
                                System.out.println("");
                            }
                            String call = m.next();
                            switch (call) {

                                case "Ram":
                                case "RAM":
                                case "ram":
                                case "Rahim":
                                case "rahim":
                                case "RAHIM":
                                case "Rajan":
                                case "rajan":
                                case "RAJAN":
                                case "Rohit":
                                case "rohit":
                                case "ROHIT":

                                    System.out.print("Call is Diverting to " + call);

                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.print(".");
                                    Thread.sleep(1000);
                                    System.out.println(".");
                                    System.out.println("Hello");
                                    String as = m.next();

                                    System.out.println("Enter your question");
                                    String a = m.next();
                                    System.out.println("give me option");
                                    String asa = m.next();
                                    System.out.println("I think D is True");
                                    break;

                            }

                        } else {
                            System.out.println("You have already used this lifeline");
                            lifeline(4);
                        }
                    } else if (lifeline == 3) {
                        for (int move = 1; move <= 5; move++) {
                            System.out.println("");
                        }
                        ff = ff + 1;
                        if (ff == 1) {
                            System.out.println("Fifty fifty");
                            System.out.println("You Answer may be :-");
                            System.out.println("A.     ");
                            System.out.println("\t\tC.");
                            for (int move = 1; move <= 5; move++) {
                                System.out.println("");
                            }
                        } else {
                            System.out.println("You have already used this lifeline");
                            lifeline(4);
                        }
                    } else if (lifeline == 4) {
                        fq = fq + 1;
                        if (fq == 1) {
                            System.out.println("Flip the Question");
                            System.out.println(
                                    "Which of the only planet of our Solar System that rotates in a clockwise direction around its own axis?");
                            System.out.println("(A) Earth                             (B) Jupiter ");
                            System.out.println("(C) Mars                              (D) Venus");
                            for (int clr = 1; clr <= 5; clr++) {
                                System.out.println("");
                            }

                            System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<\nAns:-");

                        } else {
                            System.out.println("you have already used this lifeline");
                            lifeline(4);
                        }
                    } 
                    else {
                        System.out.println("you have enter wrong choice");
                        lifeline(4);
                    }

                } catch (InterruptedException exc) {
                    System.out.println("!!!!!!!!!!!!!!!!!!!!RESTART!!!!!!!!!!!!!!!!!!!");
                }

            }

        }

    }
}



