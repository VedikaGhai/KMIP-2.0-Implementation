package ClientInterfaces;
import java.net,*;

public class Connection{

    Socket socket;
    String ip;
    int port;

    Connection(Socket socket, String ip, int port)
    {
        this.socket=socket;
        this.ip=ip;
        this.port=port;
    }

    //call SSL connection methods
    
    

}
