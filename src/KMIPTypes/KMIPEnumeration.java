package KMIPTypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.NONE)
public class KMIPEnumeration extends KMIPType
{
    int value;

	public KMIPEnumeration() {
		super(4);
		// TODO Auto-generated constructor stub
	}

	public KMIPEnumeration(String value)
	{
		super(value);
		toInteger(value);
	}

	public void toInteger(String value)
	{
		if(value.length()>1&& value.substring(0,2)=="0x")
		{
			this.value=Integer.parseInt(value.substring(2), 16 );
		}
		else
			this.value=Integer.parseInt(value);

	}

	//@XmlElement
	public String toString()
	{
		return Integer.toString(value);
	}
	
	public void setValue(int value)
	{
		this.value=value;
	}
}