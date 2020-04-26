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

import Enum.EnumTag;
import Enum.EnumType;
import KMIPTypes.KMIPType;
import Messages.*;
//DON'T IMPORT THIS (Document Builder doesn't accept it) -> import jdk.internal.org.xml.sax.InputSource;
import org.xml.sax.InputSource;

/**
 * This class has methods for extracting important information from the 
 * server's response message (without having to go through the entire response message).
 * We are using DOM Parsing for this purpose.
 * Input response message can be either written into a file, or as a string. This can be changed according to requirement in {@link CreateRequestMessage}.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see ResponseBatchItem
 */ 
public class DecodeResponseMessage 
{
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    Document document;
    Element root;

    InputSource is;

    List<ResponseBatchItem> responseBatchItem;

    /**
     * Default constructor.
     */
    public DecodeResponseMessage()
    {
        
    }

    /**
     * This method converts the response message file into a document and normalizes it.
     * @param f file which contains the response message.
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public void DOMParser(File f) throws SAXException, IOException, ParserConfigurationException
    {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();

        document = builder.parse(f);

        document.getDocumentElement().normalize();

        root = document.getDocumentElement();
        //System.out.println(root.getNodeName());
    }

    /**
     * This method converts the response message that is saved to a String variable, into a document and normalizes it.
     * @param s the string variable which has the response message.
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     * @throws IllegalArgumentException
     */
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

    /**
     * This method extracts values of the attributes in the response message, according to their tag name. 
     * It also works for multiple same name tags.
     * For eg. If there are 2 "UniqueIdentifier" tags (for asymmetric), then it extracts both the unique identifiers.
     * @param tagName the XML tag which we need the extract the value of.
     * @return {@code List<String>} a list of all the extracted values.
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
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

    /**
     * This method takes in the response message file, converts it into a document, normalizes it,
     * goes ahead with extraction of values if the ResultStatus is Success,
     * otherwise extracts and returns back the ResultReason.  
     * @param f the response message file.
     * @param tagNames the list of attribute tags whose value needs to be extracted.
     * @return {@code List<String>} a list of all the extracted values.
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
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

    /**
     * This method takes in the response message string, converts it into a document, normalizes it,
     * goes ahead with extraction of values if the ResultStatus is Success,
     * otherwise extracts and returns back the ResultReason.  
     * @param stringXML the response message saved in a string variable.
     * @param tagNames the list of attribute tags whose value needs to be extracted.
     * @return {@code List<String>} a list of all the extracted values.
     * @throws SAXException
     * @throws IOException
     * @throws ParserConfigurationException
     */
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