import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
public class userrole extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,uid,fn,role;
	JButton b1,b2,b3,b4,b5,b6;
	JTextField tf1,tf2,tf3;
	Image img;
	Toolkit tool;
	Container c;
	ResultSet rs;
	Connection con;
	public userrole()
	{
		
	tool=Toolkit.getDefaultToolkit();
	img=tool.createImage("java.gif");
	c=getContentPane();
	c.setLayout(null);
	addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e)	{System.exit(0);}});
	l1=new JLabel("USER ID:");
	l2=new JLabel("Role:");
	l3=new JLabel("Select files /Grant Permission :");

	tf1=new JTextField();
	tf2=new JPasswordField();
	tf3=new JTextField();

	b1=new JButton("SUBMIT",new ImageIcon("contents.png"));
	b1.setForeground(Color.yellow);
	b1.setBackground(Color.black);
	
	b2=new JButton("CANCEL",new ImageIcon("company reference.png"));
	b2.setForeground(Color.yellow);
	b2.setBackground(Color.black);
	
	b3=new JButton("BROWSE",new ImageIcon("branch.png"));
	b3.setForeground(Color.yellow);
	b3.setBackground(Color.black);

	b4=new JButton("READ",new ImageIcon("Attendance.png"));
	b4.setForeground(Color.yellow);
	b4.setBackground(Color.black);
	
	b5=new JButton("WRITE",new ImageIcon("Business.png"));
	b5.setForeground(Color.yellow);
	b5.setBackground(Color.black);
	
	b6=new JButton("READ AND WRITE",new ImageIcon("products.png"));
	b6.setForeground(Color.yellow);
	b6.setBackground(Color.black);

		
		tf1.setBounds(350,140,150,30);
		tf2.setBounds(350,180,150,30);
		tf3.setBounds(350,220,150,30);

		l1.setBounds(250,140,150,30);
		l2.setBounds(250,180,150,30);
		l3.setBounds(150,220,180,30);

		b1.setToolTipText("Login");
		b2.setToolTipText("Cancel");
		b3.setToolTipText("Browse");
		b4.setToolTipText("Read");
		b5.setToolTipText("Write");
		b6.setToolTipText("Read and Write");
		

		b1.setBounds(270,300,140,30);
		b2.setBounds(420,300,140,30);
		b3.setBounds(580,300,180,30);
		
		b4.setBounds(270,350,140,30);
		b5.setBounds(420,350,140,30);
		b6.setBounds(580,350,180,30);
	
		
		c.add(tf1);
		c.add(tf2);
		c.add(tf3);
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(b1);
		c.add(b2);
		c.add(b3);
	//	c.add(b4);
	//	c.add(b5);
	//	c.add(b6);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
//	b4.addActionListener(this);
//	b5.addActionListener(this);
//	b6.addActionListener(this);

	setTitle("USER ROLE");
	
		uid=new JLabel("USER ID:");
		fn=new JLabel("FIRST NAME:");
		role=new JLabel("ROLE :");
        int x1=400;

		uid.setBounds(80,400,180,20);
		fn.setBounds(250,400,100,20);
		role.setBounds(390,400,80,20);
		
		c.add(uid);
		c.add(fn);
		c.add(role);
		
		try
		{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:dsn","scott","tiger");
PreparedStatement st=con.prepareStatement("select  usid,fname,role from  regist"); 
rs=st.executeQuery();
while(rs.next())
			{
	 x1=x1+40;
		uid=new JLabel(rs.getString(1));
		fn=new JLabel(rs.getString(2));
		role=new JLabel(rs.getString(3));
        uid.setBounds(80,x1,180,20);
		fn.setBounds(250,x1,100,20);
		role.setBounds(390,x1,80,20);
		c.add(uid);
		c.add(fn);
		c.add(role);
			}
		}
		catch(Exception rt)
		{}
		

	setSize(1024,768);
	setVisible(true);
	
	}

	public void actionPerformed(ActionEvent ae)
	{
	
		String x=tf1.getText();
		String y=tf2.getText();
		String action=ae.getActionCommand();
		if(action.equals("SUBMIT"))
		{
			try
			{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:dsn","scott","tiger");
PreparedStatement ps=con.prepareStatement("insert into userrole values(?,?,?)");
 File file1 =new File(tf3.getText());
	 System.out.println(file1);
	System.out.println("File is"+file1.getName());
System.out.println("File size is "+file1.length());
FileInputStream fis=new FileInputStream(file1);
   ps.setString(1,x);
ps.setString(2,y);
   ps.setBinaryStream(3,fis,(int)file1.length());
  int n= ps.executeUpdate();
   
   fis.close();
if(n>0)
	{
  	JOptionPane.showMessageDialog(null,"INSERTED SUCCESSFULLY");
	tf1.setText("");
tf2.setText("");
tf3.setText("");


	}
		else
		{
			JOptionPane.showMessageDialog(null,"Try Again?");
		}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		if(action.equals("CANCEL"))
		{
	tf1.setText("");
	tf2.setText("");
	tf3.setText("");
			}
		if(action.equals("BROWSE"))
		{
		JFileChooser f = new JFileChooser();
		f.setCurrentDirectory(new File("/"));
        f.showSaveDialog(this);
       String initDir = f.getSelectedFile().getAbsolutePath();
	   tf3.setText(initDir);
			}
if(action.equals("WRITE"))
		{

JOptionPane.showMessageDialog(null,"File is write only");
}
if(action.equals("READ AND WRITE"))
		{
JOptionPane.showMessageDialog(null,"File is read and write");

}




	}

}