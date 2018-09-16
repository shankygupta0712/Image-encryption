import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
public class user extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JButton b1,b2;
	JTextField tf1,tf2;
	Image img;
	Toolkit tool;
	Container c;
	public user()
	{
		
tool=Toolkit.getDefaultToolkit();
	img=tool.createImage("java.gif");
		c=getContentPane();
		c.setLayout(null);
		addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e)	{System.exit(0);}});
		l1=new JLabel("Userid:");
		l2=new JLabel("Password:");
		tf1=new JTextField();
		tf2=new JPasswordField();
		b1=new JButton("SUBMIT");
		b1.setForeground(Color.yellow);
		b1.setBackground(Color.black);
		b2=new JButton("CANCEL");
		b2.setForeground(Color.yellow);
		b2.setBackground(Color.black);
		
	
		tf1.setBounds(350,140,150,30);
		tf2.setBounds(350,180,150,30);
		l1.setBounds(250,140,150,30);
		l2.setBounds(250,180,150,30);
		b1.setBounds(270,250,100,30);
		b1.setToolTipText("Login");
		b2.setToolTipText("Cancel");
		b2.setBounds(380,250,100,30);
		c.add(tf1);
		c.add(tf2);
		c.add(l1);
		c.add(l2);
		c.add(b1);
		c.add(b2);
		
	b1.addActionListener(this);
	b2.addActionListener(this);
		setVisible(true);
		setSize(1024,768);
	 setTitle("USER LOGIN");
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
Connection con=DriverManager.getConnection("jdbc:odbc:dsn","scott","tiger");
PreparedStatement st=con.prepareStatement("select  * from  regist where  USERID=? and password=?"); 
st.setString(1,x);
st.setString(2,y);
ResultSet rs=st.executeQuery();
if(rs.next())
		{
try
			{
InputStream is=null;
System.out.println("out put is "+x);
PreparedStatement ps=con.prepareStatement("select * from userrole where fname=?");
ps.setString(1,x);

ResultSet rs1=ps.executeQuery();
if(rs1.next())
			{
	
	String role=rs1.getString(2);
	String path=System.getProperty("user.dir");
	String file=path+"/"+x+".doc";
	System.out.println(file);
	
    File file1=new File(file);
    is=rs1.getBinaryStream(3);
    int k=is.read();
	System.out.println(k);
	FileOutputStream fos=new FileOutputStream(file1);
		while(k!=-1)
		{

		fos.write(k);
		k=is.read();
		
		}	 
is.close();
fos.close();
if(role.equalsIgnoreCase("clerk"))
				{
	file1.setReadOnly();
				}
JOptionPane.showMessageDialog(null,"File retrive successfully");
	}
	
	  }
	  catch(Exception e)
		{
		  e.printStackTrace();
		}


dispose();
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
		}

	}

}
