package ClientInterfaces;
import Messages.CreateRequestMessage;
import java.io.*;
import Operations.DecodeResponseMessage;
import Messages.CreateRequestMessage;


public class KMIPOperations
{
    //call the desired operation class and its methods
    public KMIPOperations() 
    {
        
    }

    KeyUniqueIDMap create(KeyUniqueIDMap k, Connection connection) throws Exception
    {
        CreateRequestMessage createRequestMessage= new CreateRequestMessage();
        CreateKey createKey=new CreateKey(k.algorithm, k.type, k.length);
        File f= createRequestMessage.createKeyRequestMessage(createKey);
        //byte[] requestMessageByteArray = new byte[(int)f.length()];
        //BufferedReader bis= new BufferedReader(new InputStreamReader(new FileInputStream(f)));
        DataOutputStream bout= new DataOutputStream(connection.socket.getOutputStream());
        //DataInputStream bin=new DataInputStream(new FileInputStream(f));
        InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "UTF-8");
        BufferedReader bin = new BufferedReader(isr);

        String line=null;
        System.out.println("Hello");
        
        while((line=bin.readLine())!=null)
        {
            bout.writeUTF(line);
        }
        //bout.writeUTF(bin.readUTF());
        //System.out.println(bin.available());

        /*while(bin.available()>0)
        {
            String sin=bin.readUTF();
            System.out.println(sin);
            bout.writeUTF(sin);
        }*/

        //Thread.sleep(1000);
        DataInputStream dis=new DataInputStream(connection.socket.getInputStream());
        //String s= dis.readUTF();
        File response =new File("/home/soha/Documents/Response3.xml");
        DataOutputStream dout= new DataOutputStream(new FileOutputStream(response));
        dout.writeUTF(dis.readUTF());
        DecodeResponseMessage decodeResponseMessage= new DecodeResponseMessage();
        String uniqueIdentifier = decodeResponseMessage.DOMParser(response);
        KeyUniqueIDMap responseUID=new KeyUniqueIDMap(k, uniqueIdentifier);
            
        bin.close();
        dout.close();

        return responseUID;
    }
    
}

