
import java.awt.*;
import java.awt.event.*;

import java.net.*;
import java.io.*;

public class Server3 extends Frame implements Runnable , ActionListener {

	Label l1,l2;
	TextArea t1,t2;
	Button b1,b2;
	
	DataOutputStream dos;
	DataInputStream dis;

	Thread th;

	ServerSocket ss;
	Socket s;
	
	public Server3()
	{
		super("Server");
		
		l1 = new Label("From Client");
		l2 = new Label("To Client");
		
		t1 = new TextArea("",10,16,TextArea.SCROLLBARS_BOTH);
		t2 = new TextArea("",10,16,TextArea.SCROLLBARS_BOTH);
		
		t1.setEditable(false);
		
		b1 = new Button("Send");
		b2 = new Button("Exit");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setLayout(null);
		
		l1.setBounds(50,50,100,20);
		t1.setBounds(50,80,100,100);

		l2.setBounds(50,190,100,20);
		t2.setBounds(50,220,100,100);

		b1.setBounds(50,330,45,20);
		b2.setBounds(105,330,45,20);
		
		add(l1);
		add(t1);

		add(l2);
		add(t2);

		add(b1);
		add(b2);
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		setSize(200,400);
		setVisible(true);
		
		try
		{
			ss = new ServerSocket(5051);
			s = ss.accept();

			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			
			th = new Thread(this);
			th.start();
		}
		catch(Exception e1){}	

	}
	
    @Override
	public void run()
	{
		try
		{
			while(true)
			{
				String str = dis.readUTF();  //reads from client
				String s = t1.getText() + "\n" + str;
		
				t1.setText(s);
			}
		}
		catch(Exception e){}

	}
	
    @Override
	public void actionPerformed(ActionEvent e)
	{
		Button b = (Button)e.getSource();
		
		if(b == b2)
			System.exit(0);
		else
		{
			try
			{
				String str = t2.getText();
				dos.writeUTF(str);  //sends message to client
			}
			catch(Exception e2){}
		}

	}
	
	public static void main(String []args) {
		Server3 a = new Server3();
	}
	
}




