import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
public class admin extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JButton b1,b2;
	JTextField tf1,tf2;
	Image img;
	Toolkit tool;
	Container c;
	public admin()
	{
		
	tool=Toolkit.getDefaultToolkit();
	img=tool.createImage("java.gif");
	c=getContentPane();
	c.setLayout(null);
	addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e)	{System.exit(0);}});
	l1=new JLabel("Admin id:");
	l2=new JLabel("Admin Password:");

	tf1=new JTextField();
	tf2=new JPasswordField();

	b1=new JButton("SUBMIT",new ImageIcon("contents.png"));
	b1.setForeground(Color.yellow);
	b1.setBackground(Color.black);
	
	b2=new JButton("CANCEL",new ImageIcon("company reference.png"));
	b2.setForeground(Color.yellow);
	b2.setBackground(Color.black);
		
		tf1.setBounds(350,140,150,30);
		tf2.setBounds(350,180,150,30);

		l1.setBounds(250,140,150,30);
		l2.setBounds(250,180,150,30);
		
		b1.setToolTipText("Login");
		b2.setToolTipText("Cancel");
		

		b1.setBounds(270,300,140,30);
		b2.setBounds(420,300,140,30);
	
		
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
	setTitle("ADMINISTRATOR LOGIN");
	
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
	new userrole();
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