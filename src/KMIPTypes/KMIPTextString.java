package KMIPTypes;

import javax.xml.bind.annotation.XmlAttribute;


public class KMIPTextString extends KMIPType{

    String value;
    
    public KMIPTextString(String value){
        super(0);
        this.value = value;
    }

    @Override
    public String toString() {
        return "KMIPTextString [value=" + value + "]";
    }

    //@XmlAttribute(name="value")
    public String getValue()
    {
        return this.value;
    }

    public void setValue(String value)
    {
        this.value=value;
    }
    
}