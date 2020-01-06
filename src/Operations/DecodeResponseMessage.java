package Operations;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.util.*;
import java.io.*;
import Messages.ResponseBatchItem;

public class DecodeResponseMessage {

    List<ResponseBatchItem> responseBatchItem;

    public void DOMParser() throws SAXException, IOException, ParserConfigurationException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(new File("/home/soha/Documents/Response1.xml"));

        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();
        //System.out.println(root.getNodeName());

        NodeList nList = document.getElementsByTagName("KeyMaterial");
        System.out.println("============================");
        System.out.println(nList.getLength());
        for(int temp=0; temp< nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            Element e= (Element)node;
            System.out.println(e.getAttribute("value"));

            
        }

    }

    public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException
    {
        DecodeResponseMessage d = new DecodeResponseMessage();
        d.responseBatchItem=new ArrayList<ResponseBatchItem>();
        d.DOMParser();
    }

}