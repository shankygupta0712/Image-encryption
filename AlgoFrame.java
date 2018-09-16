package algo;
//import Server.ReceiverClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import javax.swing.border.Border;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Graphics;

public class AlgoFrame extends JFrame
{
	Container content;
    String initDir = null;
    private JPanel jPanel1 = new JPanel();
    JTextField jtfInputFile = new JTextField();
    JTextField jtfOutputFile = new JTextField();
    private JLabel jlInFile = new JLabel();
    private JLabel jlOutFile = new JLabel();
    private JButton jbInFile = new JButton();
    private JButton jbOutFile = new JButton();
    private JButton jbProperties = new JButton();
    private JButton jbOk = new JButton();
    private JButton jbExit = new JButton();
    private JButton jbCancel = new JButton();
//	private JButton jbReadonly = new JButton();
//	private JButton jbReadWrite = new JButton();
    private Border border1;
    private Border border2;
    private Border border3;
    private Border border4;
    private Border border5;
    private Border border6;
    private Border border7;
    private Border border8;
 
	File f=null;
	private CheckboxGroup cbgOperation = new CheckboxGroup();
    Checkbox cbEncrypt = new Checkbox();
    Checkbox cbDecrypt = new Checkbox();
    int BLOCK_SIZE=128;
    int KEY_SIZE=128;
    JProgressBar pbPosition = new JProgressBar();
    Toolkit tk=Toolkit.getDefaultToolkit();
	public static java.awt.Image img=null;
    /**
     *Constructor initializes the progress bar and constructs
     *the frame.
     */
    
    public AlgoFrame()
    {
		content=getContentPane();
	//	content.setBackground(Color.green);
		img=tk.createImage("pic1.jpg");
        pbPosition.setVisible(false);
        try
        {
            jbInit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

     
    public static void main(String[] args)
    {
        AlgoFrame algoFrame1 = new AlgoFrame();
		algoFrame1.setResizable(true);
        /*algoFrame1.setSize(410,310);
        algoFrame1.setResizable(false);
        algoFrame1.setTitle("Blow Fish..." );
        int x=0,y=0;
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        x = d.width /2 - 550/2;
        y = d.height /2 - 400/2;
        algoFrame1.setLocation( x,y);
        algoFrame1.show();*/
    }

    /**
     *Called by the constructor and construts 
     *the complete user interface.
     */
    
    private void jbInit() throws Exception
    {
		this.setSize(1024,768);
		this.setResizable(false);
		this.setTitle("Chaotic image encryption techniques" );
	//	int x=0,y=0;
	//	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	//	x = d.width /2 - 550/2;
	//	y = d.height /2 - 400/2;
	//	this.setLocation( x,y);
	//	this.setBackground(new Color(123,213,23));
		//ImageFile file=new ImageFile();
		//file.setBounds(0,0,410,310);
        border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(142, 142, 142),new Color(99, 99, 99));
        border2 = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(142, 142, 142));
        border3 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(148, 145, 140),new Color(103, 101, 98));
        border4 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(142, 142, 142),new Color(99, 99, 99));
        border5 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(142, 142, 142),new Color(99, 99, 99));
        border6 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(142, 142, 142),new Color(99, 99, 99));
        border7 = BorderFactory.createBevelBorder(BevelBorder.RAISED,Color.white,Color.white,new Color(142, 142, 142),new Color(99, 99, 99));
        border8 = BorderFactory.createLineBorder(SystemColor.windowBorder,2);
        jPanel1.setBackground(SystemColor.control);
        jPanel1.setForeground(Color.red);
        jPanel1.setBorder(border8);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);
        jtfInputFile.setFont(new java.awt.Font("SansSerif", 1, 12));
        jtfInputFile.setCaretColor(Color.red);
        jtfInputFile.setText("Select Input File");
        jtfInputFile.setBounds(new Rectangle(140, 57, 200, 30));
        jtfOutputFile.setFont(new java.awt.Font("SansSerif", 1, 12));
        jtfOutputFile.setCaretColor(Color.red);
        jtfOutputFile.setText("Select Output File");
        jtfOutputFile.setBounds(new Rectangle(140, 117, 203, 30));
        jbInFile.setBorder(border1);
        jbInFile.setToolTipText("Select In File");
        jbInFile.setText("Browse...");
        jbInFile.setBounds(new Rectangle(350, 56, 79, 27));
        jbInFile.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                inFileActionPerformed(e);
            }
        });
        jbOutFile.setBounds(new Rectangle(350, 117, 79, 27));
        jbOutFile.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                outFileActionPerformed(e);
            }
        });
        jbOutFile.setBorder(border7);
        jbOutFile.setToolTipText("Select  Out File");
        jbOutFile.setText("Browse...");
        jbProperties.setFont(new java.awt.Font("SansSerif", 1, 10));
        jbProperties.setBorder(border2);
        jbProperties.setText("File Transfer");
        jbProperties.setBounds(new Rectangle(320, 166, 113, 30));
        jbProperties.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //propertiesActionPerformed(e);
				new ReceiverClient(); 
            }
        });
        jlInFile.setForeground(Color.blue);
        jlInFile.setText("Select Input  File ");
		
        jlInFile.setBounds(new Rectangle(8, 60, 96, 28));
        jlOutFile.setForeground(Color.blue);
        jlOutFile.setText("Select Output File ");

        jlOutFile.setBounds(new Rectangle(11, 126, 105, 22));
        jbOk.setBorder(border4);
        jbOk.setText("OK");
        jbOk.setBounds(new Rectangle(75, 235, 86, 28));
        jbOk.addActionListener(new java.awt.event.ActionListener()
        {
    public void actionPerformed(ActionEvent e) {
    okActionPerformed(e);
    }
    });
    jbExit.setBounds(new Rectangle(168, 235, 86, 28));
    jbExit.addActionListener(new java.awt.event.ActionListener() {

    public void actionPerformed(ActionEvent e) {
    exitActionPerformed(e);
    }
    });
    jbExit.setBorder(border6);
    jbExit.setText("Close");
    jbCancel.setBounds(new Rectangle(78, 235, 86, 28));
//	jbReadonly.setBorder(border6);
 //   jbReadonly.setText("Readonly");
 //   jbReadonly.setBounds(new Rectangle(258, 235, 86, 28));

/*    jbReadonly.addActionListener(new java.awt.event.ActionListener() {

    public void actionPerformed(ActionEvent e) {
   readOnlyActionPerformed(e);
    }
    });*/
//    jbReadWrite.setBorder(border6);
 //   jbReadWrite.setText("Read/Write");
  //  jbReadWrite.setBounds(new Rectangle(350, 235, 86, 28));
	
	
	jbCancel.setBorder(border5);
    jbCancel.setText("Cancel");
    cbEncrypt.setBackground(Color.white);
    cbEncrypt.setBounds(new Rectangle(105, 170, 80, 23));
    cbEncrypt.setFont(new java.awt.Font("Serif", 1, 12));
    cbEncrypt.setForeground(Color.blue);
    cbEncrypt.setCheckboxGroup(cbgOperation);
    cbEncrypt.setLabel("Encode");
    cbEncrypt.setState(true);
    cbDecrypt.setBackground(Color.white);
    cbDecrypt.setBounds(new Rectangle(190, 170, 80, 23));
    cbDecrypt.setFont(new java.awt.Font("Serif", 1, 12));
    cbDecrypt.setForeground(Color.blue);
    cbDecrypt.setCheckboxGroup(cbgOperation);
    cbDecrypt.setLabel("Decode");
    this.setResizable(false);
    pbPosition.setBackground(Color.white);
    pbPosition.setForeground(Color.red);
    pbPosition.setStringPainted(true);
    pbPosition.setBounds(new Rectangle(250, 10, 148, 22));
    java.awt.Container con=this.getContentPane();
	//con.add(file);
	con.add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jbInFile, null);
    jPanel1.add(jtfInputFile, null);
    jPanel1.add(jtfOutputFile, null);
    jPanel1.add(jbOutFile, null);
    jPanel1.add(jlInFile, null);
    jPanel1.add(jlOutFile, null);
    jPanel1.add(jbProperties, null);
   // jPanel1.add(jbCancel, null);
    jPanel1.add(jbExit, null);
    jPanel1.add(jbOk, null);
//    jPanel1.add(jbReadonly, null);
//    jPanel1.add(jbReadWrite, null);
    jPanel1.add(cbEncrypt, null);
    jPanel1.add(cbDecrypt, null);
    jPanel1.add(pbPosition, null);
    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    SwingUtilities.updateComponentTreeUI(this);


	
    this.show();

    }

    /**
     *Raises when ok button was clicked.
     *Asks for the password and starts the execution.
     *@param ae The button click event
     */

    private void okActionPerformed(ActionEvent ae)
    {
            //	OK
            pbPosition.setValue(0);
            algo.PasswordDialog d = new algo.PasswordDialog(this) ;
            d.show();
            String pass="0";
            if(!d.cancel)
                    pass = d.tfPassword.getText() ;
            else
                    return;
            for(int i=pass.length() ; i < KEY_SIZE/8;i++ )
                    pass += "0";
            pbPosition.setVisible(true);
            algo.Connector spi = new algo.Connector(pbPosition);
            try
            {
                    spi.setKey(pass.getBytes());
                     f = new File(jtfInputFile.getText());
                    byte[] in = null;
                    byte pad=0;
                    if(cbEncrypt.getState())
                    {
                            //	Encrypt
                            if(f.length() % BLOCK_SIZE != 0)
                            {
                                    pad = (byte) (BLOCK_SIZE - (f.length() % BLOCK_SIZE));
                                    in = new byte[(int) f.length() + pad +1];
                                    FileInputStream fin = new FileInputStream(f);
                                    fin.read(in , 1 , (int)f.length());
                                    fin.close();
                            }
                            else
                            {
                                    in = new byte[(int) f.length() + 1];
                                    FileInputStream fin = new FileInputStream( f);
                                    fin.read( in,1,(int)f.length());
                                    fin.close();
                            }
                            byte[] out = spi.encrypt(in, 1, in.length-1);
                            byte[] out1 = new byte[out.length + 1];
                            System.arraycopy(out,0,out1,1,out.length);
                            out1[0] = pad;
                            f = new File(jtfOutputFile.getText());
                            FileOutputStream fout = new FileOutputStream(f);
                            fout.write(out1);
                            fout.close();
                    }
                    else
                    {
                            //	Decrypt
                            in = new byte[(int)f.length()];
                            FileInputStream fin = new FileInputStream( f);
                            fin.read( in);
                            pad = in[0];
            byte[] in1 = new byte[ in.length - 1];
            System.arraycopy(in,1,in1,0,in1.length );
            byte[] out = spi.decrypt(in1);
            byte[] out1 = new byte[ out.length-pad];
            System.arraycopy(  out , 0,out1,0,out1.length );
            f = new File( jtfOutputFile.getText());
            FileOutputStream fout = new FileOutputStream(f);
            fout.write( out1);
            fout.close();
          }
          algo.MsgBox.show("Operation Completed");
         }catch(Exception e1){
             algo.MsgBox.show("ERROR :" + e1.getMessage());
             e1.printStackTrace();
         }
          pbPosition.setVisible(false);
      }

    /**
     *Raises when cancel button was clicked.
     *No operation will be performed.
     *@param ae The button click event
     */
    
    private void cancelActionPerformed(ActionEvent ae)
    {
        //  Nothing to do here.
    }

    /**
     *Raises when exit button was clicked.
     *Terminates the application
     *@param ae The button click event
     */
    
    private void exitActionPerformed(ActionEvent ae)
    {
        System.exit(0);
    }

private void readOnlyActionPerformed(ActionEvent ae)
    {
       f.setReadOnly();
    }



    /**
     *Raises when properties button was clicked.
     *Adjusts the properties required for performing the operation.
     *@param ae The button click event
     */
    
    private void propertiesActionPerformed(ActionEvent ae)
    {
        algo.PropertiesDialog d = new algo.PropertiesDialog(this);
        d.setVisible(true);
        BLOCK_SIZE = d.BLOCK_SIZE ;
        KEY_SIZE = d.KEY_SIZE ;
    }

    /**
     *Raises when input file button was clicked.
     *Takes the input file name from the user.
     *@param ae The button click event
     */
    
    private void inFileActionPerformed(ActionEvent ae)
    {   
        if(initDir == null)
            initDir = System.getProperty("user.dir","C:\\");
        javax.swing.JFileChooser f = new javax.swing.JFileChooser();
        f.setCurrentDirectory(new File(initDir));
        f.showOpenDialog( this);
        initDir = f.getCurrentDirectory().getAbsolutePath();
        jtfInputFile.setText( f.getSelectedFile().getAbsolutePath());
    }

    /**
     *Raises when output file button was clicked.
     *Takes the output file name from the user.
     *@param ae The button click event
     */
    
    private void outFileActionPerformed(ActionEvent ae)
    {
        if(initDir == null)
            initDir = System.getProperty("user.dir","C:\\");
        javax.swing.JFileChooser f = new javax.swing.JFileChooser();
        f.setCurrentDirectory(new File(initDir));
        f.showSaveDialog(this);
        initDir = f.getCurrentDirectory().getAbsolutePath();
        jtfOutputFile.setText( f.getSelectedFile().getAbsolutePath() );
    }
		/*public void paint(Graphics g)
	{
		System.out.println("in paint");
		g.drawImage(img,0,0,1024,768,this);
	}
*/
}
//class ImageFile extends JPanel
//
//};