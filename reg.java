import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class reg extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JButton b1,b2;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	Choice li;
	Choice ch;
	Container c;
	Connection con;
	reg()
	{
		
		c=getContentPane();
		c.setLayout(null);
		l1=new JLabel("First Name");
		l2=new JLabel("Last Name");
		l3=new JLabel("User ID" );
		l4=new JLabel("Password");
		l5=new JLabel("Confirm Password");
		l6=new JLabel("Role");
		
		tf1=new JTextField(20);
		tf2=new JTextField(20);
		tf3=new JTextField(20);
		tf4=new JPasswordField(20);
		tf5=new JPasswordField(20);
		tf6=new JTextField(20);
		
		b1=new JButton("For Register");
		b1.setForeground(Color.yellow);
		b1.setBackground(Color.black);
		
		b2=new JButton("For Login");
		b2.setForeground(Color.yellow);
		b2.setBackground(Color.black);
		
		
		l1.setBounds(250,140,150,30);
		l2.setBounds(250,180,150,30);
		l3.setBounds(250,220,150,30);
		l4.setBounds(250,260,150,30);
		l5.setBounds(250,300,150,30);
		l6.setBounds(250,340,150,30);
	
		tf1.setBounds(380,140,150,30);
		tf2.setBounds(380,180,150,30);
		tf3.setBounds(380,220,150,30);
		tf4.setBounds(380,260,150,30);
		tf5.setBounds(380,300,150,30);
		tf6.setBounds(380,340,150,30);
		
		b1.setBounds(300,500,130,30);
		b2.setBounds(450,500,100,30);
		
		c.add(tf1);c.add(tf2);
		c.add(tf3);c.add(tf4);
		c.add(tf5);c.add(tf6);
		
		c.add(l1);	c.add(l2);
		c.add(l3);	c.add(l4);
		c.add(l5);	c.add(l6);

		c.add(b1);c.add(b2);		
b1.addActionListener(this);
b2.addActionListener(this);
setSize(1024,768);
setVisible(true);
 setTitle("REGISTRATION FORM");
	}
		
public void actionPerformed(ActionEvent ar)
	{
String x=ar.getActionCommand();
if(x.equals("For Register"))
		{
try
		{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
con=DriverManager.getConnection("jdbc:odbc:dsn","scott","tiger");
PreparedStatement st=con.prepareStatement("insert into regist values(?,?,?,?)"); 
String p=tf1.getText();
String q=tf2.getText();
String r=tf3.getText();
String s=tf4.getText();
String t=tf5.getText();
String u=tf6.getText();
st.setString(1,p);
st.setString(2,q);
st.setString(3,r);
st.setString(4,s);
//st.setString(5,t);
//st.setString(6,u);
int il=st.executeUpdate();
if(il>0)
			{
	JOptionPane.showMessageDialog(null,"UserRegisterSucessfully");
tf1.setText("");
tf2.setText("");
tf3.setText("");
tf4.setText("");
tf5.setText("");
tf6.setText("");
			}

		}
		catch(Exception ab)
		{
ab.printStackTrace();
		}
}
	else if(x.equals("For Login"))
	{
	user ob2=new user();
	dispose();
}
	}
	
	}
