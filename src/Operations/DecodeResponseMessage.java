package Operations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import Enum.EnumTag;
import Enum.EnumType;
import KMIPTypes.KMIPEnumeration;
import Messages.ResponseBatchItem;
import Objects.XMLTag;

public class DecodeResponseMessage 
{
    List<ResponseBatchItem> responseBatchItem;

    public DecodeResponseMessage()
    {
        
    }

    public String DOMParser(File f) throws SAXException, IOException, ParserConfigurationException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.parse(f);

        document.getDocumentElement().normalize();

        Element root = document.getDocumentElement();
        //System.out.println(root.getNodeName());

        NodeList nList = document.getElementsByTagName("UniqueIdentifier");
        System.out.println("============================");
        System.out.println(nList.getLength());
        String s=null;
        for(int temp=0; temp< nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            Element e= (Element)node;
            //ResponseBatchItem responseBatchItem=new ResponseBatchItem(new XMLTag("Operation", new EnumTag(EnumTag.BatchItem), new EnumType(EnumType.Enummeration), new KMIPEnumeration("Register")), new XMLTag("ResultStatus", new EnumTag(EnumTag.ResultStatus), new EnumType(EnumType.Enummeration), new KMI)
            //System.out.println(e.getElementsByTagName("value").item(0).getTextContent());
            //System.out.println(e.getAttribute("value"));
            s= e.getAttribute("value");
            System.out.println(s);
        }
        return s;

    }

    /*public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException 
    {
        DecodeResponseMessage d = new DecodeResponseMessage();
        //d.responseBatchItem=new ArrayList<ResponseBatchItem>();
        d.DOMParser();
    }*/

}