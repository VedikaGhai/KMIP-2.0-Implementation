package ClientInterfaces;

import java.net.*;

/**
 * POJO Class for initializing any Connection object with the socket, IP and port number.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 */
public class Connection{

    Socket socket;
    String ip;
    int port;

    /**
     * Parameterized constructor
     * @param socket of type {@link Socket}
     * @param ip IP Address of the key management server
     * @param port port number at which key management server listens
     */
    Connection(Socket socket, String ip, int port)
    {
        this.socket=socket;
        this.ip=ip;
        this.port=port;
    }
}
