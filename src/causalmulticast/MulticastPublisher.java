package causalmulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Mattheus
 */
public class MulticastPublisher {
    private DatagramSocket socket;
  //  private InetAddress group;
    private byte[] buf;
    
    public void mcsend(String multicastMessage, InetAddress group) throws IOException {
        socket = new DatagramSocket();
    //    group = InetAddress.getByName("225.0.0.0");
        buf = multicastMessage.getBytes();
        
        DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
        socket.send(packet);
        socket.close();
    }
    
    public static void main(String[] args) throws IOException{
        MulticastPublisher publicador = new MulticastPublisher();
        publicador.mcsend("Hello", InetAddress.getByName("225.0.0.0"));
    }
}
