package causalmulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Mattheus
 */
public class MulticastPublisher {
    private static DatagramSocket socket;
  //  private InetAddress group;
    private byte[] buf;

    public MulticastPublisher(DatagramSocket socket) throws SocketException {
        this.socket = socket;
    }
    
    public void mcsend(String multicastMessage, InetAddress group) throws IOException {
    //    group = InetAddress.getByName("225.0.0.0");
        buf = multicastMessage.getBytes();
        
        DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
        socket.send(packet);
    }
    
    public static void main(String[] args) throws IOException{
        MulticastPublisher publicador = new MulticastPublisher(new DatagramSocket());
        publicador.mcsend("Hello", InetAddress.getByName("225.0.0.0"));
        socket.close();
    }
}
