package causalmulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

/**
 *
 * @author Mattheus
 */
public class MulticastReceiver extends Thread {
    protected MulticastSocket socket = null;
    protected byte[] buf = new byte[256];
    private String received;
    
    public MulticastReceiver(InetAddress group){
        try {
            socket = new MulticastSocket(4446);
            socket.joinGroup(group);
            
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Mensagem recebida = " + received);
                
            
            socket.leaveGroup(group);
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An IOException was caught :" + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public String getReceived(){
        return received;
    }
    
    public static void main(String[] args){
        //MulticastReceiver receptor = new MulticastReceiver();
        //receptor.start();
    }
}
