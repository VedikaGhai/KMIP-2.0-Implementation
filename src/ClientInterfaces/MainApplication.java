package ClientInterfaces;

public class MainApplication
{
    public static void main(String args[])
    {
        KMIPConnection kconn = new KMIPConnection();
        EstablishConnection connection = kconn.connect(" ", 0); //String IP Address, integer port number
        KMIPOperations kops = new KMIPOperations();

    }
}