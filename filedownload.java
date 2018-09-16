import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
public class filedownload extends JFrame implements ActionListener
{
	JLabel l1;
	JButton b1;
	JTextField tf1;
	Image img;
	Toolkit tool;
	Container c;
	public filedownload()
	{
	tool=Toolkit.getDefaultToolkit();
	img=tool.createImage("java.gif");
	c=getContentPane();
	c.setLayout(null);
	addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e)	{System.exit(0);}});
	l1=new JLabel("FILE DOWN LOAD:");
	tf1=new JTextField();
	b1=new JButton("RETRIVE DATA",new ImageIcon("contents.png"));
	b1.setForeground(Color.yellow);
	b1.setBackground(Color.black);
		tf1.setBounds(350,140,200,30);
		l1.setBounds(250,140,150,30);
		b1.setToolTipText("CLICK TO RETRIVE DATA");
		b1.setBounds(300,300,180,30);
		c.add(tf1);
		c.add(l1);
		c.add(b1);
    	b1.addActionListener(this);

	setVisible(true);
	setSize(1024,768);
	setTitle("RETRIVE DATA FROM DATA BASE");
	
	}

	public void actionPerformed(ActionEvent ae)
	{

		}
	
	}

