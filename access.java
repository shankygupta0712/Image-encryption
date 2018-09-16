import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import algo.AlgoFrame;
public class access extends JFrame implements ActionListener
{


	MenuBar mb;
	Menu m1,m2,m3;
    MenuItem mi1,mi2,mi3,mi4,mi5,mi6;
	access()
	{
ImageIcon ii=new ImageIcon("CE.jpg");
JLabel l=new JLabel(" ",ii,JLabel.CENTER);

   Container c=getContentPane();
c.add(l);
 
    	mb=new MenuBar();	
        m1=new Menu("FILE");
        m2=new Menu("ADMIN");
        m3=new Menu("USER");
		mi1=new MenuItem("ENCRYPTION AND DECRYPTION");
        mi2=new MenuItem("REGISTER");
        mi3=new MenuItem("ADMIN LOGIN");
	    mi4=new MenuItem("USER LOGIN");
    	mi5=new MenuItem("USER ROLE");
	//	mi6=new MenuItem("FILE DOWNLOAD");
		m1.add(mi1);
       m1.add(mi2);
        m2.add(mi3);
		m3.add(mi4);
	//	m3.add(mi6);
		m2.add(mi5);
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        setMenuBar(mb);
        
           setSize(900,500);
           setVisible(true);
           setTitle("Chaotic Image Encryption Techniques");

                        
	}
public void actionPerformed(ActionEvent ab)
{
if(ab.getActionCommand().equals("ENCRYPTION AND DECRYPTION"))
    {
       new AlgoFrame();
    }
    
    else if(ab.getActionCommand().equals("REGISTER"))
    {
       new reg();
    }
    else if(ab.getActionCommand().equals("ADMIN LOGIN"))
    {
        new admin();
		 }
else if(ab.getActionCommand().equals("USER ROLE"))
    {
        new userrole();
		 }

    else if(ab.getActionCommand().equals("USER LOGIN"))
    {
        new user();
		 }
 
    
}
       public static void main(String ar[])
       {
           access ac=new access();
       }
};