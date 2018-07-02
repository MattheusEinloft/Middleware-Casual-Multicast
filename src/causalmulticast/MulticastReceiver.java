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
    
    public void run(){
        try {
            socket = new MulticastSocket(4446);
            InetAddress group = InetAddress.getByName("225.0.0.0");  // In IPv4, any address between 224.0.0.0 to 239.255.255.255 can be used as a multicast address.
            socket.joinGroup(group);
            while(true){
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Mensagem recebida = " + received);
                if("end".equals(received)){
                    break;
                }
            }
            socket.leaveGroup(group);
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An IOException was caught :" + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        MulticastReceiver receptor = new MulticastReceiver();
        receptor.start();
    }
}
