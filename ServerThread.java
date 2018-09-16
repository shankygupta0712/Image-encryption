package algo;


/*
 * ServerThread.java
 *
 * Created on October 10, 2007, 12:57 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class ServerThread extends Thread{
    ReceiverServer rs;
    /** Creates a new instance of ServerThread */
   public void run() {
        System.out.println("in run");
        ReceiverServer.serverstatus=true;
        rs=new ReceiverServer();
    }
    
}
