package causalmulticast;

import java.io.IOException;
import java.net.InetAddress;

/**
 *
 * @author Mattheus
 */
public interface InterfaceMulticast {
    public void mcsend(String multicastMessage, InetAddress group) throws IOException;
}
