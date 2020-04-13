package Operations;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
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
import Messages.*;
//DON'T IMPORT THIS (Document Builder doesn't accept it) -> import jdk.internal.org.xml.sax.InputSource;
import org.xml.sax.InputSource;

public class DecodeResponseMessage 
{
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document document;
    Element root;

    InputSource is;

    List<ResponseBatchItem> responseBatchItem;

    public DecodeResponseMessage()
    {
        
    }

    public void DOMParser(File f) throws SAXException, IOException, ParserConfigurationException
    {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();

        document = builder.parse(f);

        document.getDocumentElement().normalize();

        root = document.getDocumentElement();
        //System.out.println(root.getNodeName());
    }

    public void DOMParser(String s) throws SAXException, IOException, ParserConfigurationException, IllegalArgumentException
    {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();

        is = new InputSource();
        is.setCharacterStream(new StringReader(s));
        
        document = builder.parse(is);

        document.getDocumentElement().normalize();

        root = document.getDocumentElement();

        //inputStream.reset();
    }

    /*ORIGINAL public String getElementsByTagName(String tagName) throws SAXException, IOException, ParserConfigurationException
    {
        NodeList nList = document.getElementsByTagName(tagName);
        //System.out.println(nList.getLength());
        String s=null;
        for(int temp=0; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            Element e= (Element)node;
            //ResponseBatchItem responseBatchItem=new ResponseBatchItem(new XMLTag("Operation", new EnumTag(EnumTag.BatchItem), new EnumType(EnumType.Enummeration), new KMIPEnumeration("Register")), new XMLTag("ResultStatus", new EnumTag(EnumTag.ResultStatus), new EnumType(EnumType.Enummeration), new KMI)
            //System.out.println(e.getElementsByTagName("value").item(0).getTextContent());
            //System.out.println(e.getAttribute("value"));
            s = e.getAttribute("value");
            //System.out.println(s);
        }

        return s;
    }*/

    //TRIAL - Working! 
    public List<String> getElementsByTagName(String tagName) throws SAXException, IOException, ParserConfigurationException
    {
        NodeList nList = document.getElementsByTagName(tagName);
        //System.out.println(nList.getLength());
        List<String> s= new ArrayList<String>();

        if(nList!=null)
        {
            for(int temp=0; temp < nList.getLength(); temp++)
            {
                Node node = nList.item(temp);
                Element e= (Element)node;
                //ResponseBatchItem responseBatchItem=new ResponseBatchItem(new XMLTag("Operation", new EnumTag(EnumTag.BatchItem), new EnumType(EnumType.Enummeration), new KMIPEnumeration("Register")), new XMLTag("ResultStatus", new EnumTag(EnumTag.ResultStatus), new EnumType(EnumType.Enummeration), new KMI)
                //System.out.println(e.getElementsByTagName("value").item(0).getTextContent());
                //System.out.println(e.getAttribute("value"));
                s.add(e.getAttribute("value"));
                //System.out.println(s);
            }

        }
        
        return s;
    }

    /*ORIGINAL public List<String> DOMParser(File f, List<String> tagNames) throws SAXException, IOException, ParserConfigurationException
    {
        List<String> requiredValues = new ArrayList<>();

        DOMParser(f); //initialization for a particular response message file

        System.out.println("============================");

        if(getElementsByTagName("ResultStatus").equalsIgnoreCase("Success"))
        {
            for(String tagName : tagNames)
            {
                String requiredValue = getElementsByTagName(tagName);
                System.out.println(requiredValue);
                requiredValues.add(requiredValue);
            }
            
        }

        return requiredValues;
    }*/

    public List<String> DOMParser(File f, List<String> tagNames) throws SAXException, IOException, ParserConfigurationException
    {
        List<String> requiredValues = new ArrayList<>();

        DOMParser(f); //initialization for a particular response message file

        System.out.println("============================");

        if(getElementsByTagName("ResultStatus").get(0).equalsIgnoreCase("Success"))
        {
            for(String tagName : tagNames)
            {
                List<String> requiredValue = new ArrayList<String>();
                requiredValue = getElementsByTagName(tagName);
                System.out.println(requiredValue);
                
                for(String s : requiredValue)
                {
                    requiredValues.add(s);
                }
            }
            
        }
        else //if ResultStatus is not "Success"
        {
            List<String> requiredValue = new ArrayList<String>();
            requiredValue = getElementsByTagName("ResultMessage");

            System.out.println(requiredValue);
                
            for(String s : requiredValue)
            {
                requiredValues.add(s);
            }
            
        }

        return requiredValues;
    }

    public List<String> DOMParser(String stringXML, List<String> tagNames) throws SAXException, IOException, ParserConfigurationException
    {
        List<String> requiredValues = new ArrayList<>();

        DOMParser(stringXML); //initialization for a particular response message file

        System.out.println("============================");

        if(getElementsByTagName("ResultStatus").get(0).equalsIgnoreCase("Success"))
        {
            for(String tagName : tagNames)
            {
                List<String> requiredValue = new ArrayList<String>();
                requiredValue = getElementsByTagName(tagName);
                System.out.println(requiredValue);
                
                for(String s : requiredValue)
                {
                    requiredValues.add(s);
                }
            }
            
        }
        else //if ResultStatus is not "Success"
        {
            List<String> requiredValue = new ArrayList<String>();
            requiredValue = getElementsByTagName("ResultMessage");

            System.out.println(requiredValue);
                
            for(String s : requiredValue)
            {
                requiredValues.add(s);
            }
            
        }

        return requiredValues;
    }

    /*public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException 
    {
        DecodeResponseMessage d = new DecodeResponseMessage();
        //d.responseBatchItem=new ArrayList<ResponseBatchItem>();
        d.DOMParser();
    }*/

}