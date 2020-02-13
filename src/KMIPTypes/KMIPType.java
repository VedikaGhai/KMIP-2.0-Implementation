package KMIPTypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class KMIPType {

	int defaultLength;
	String value;

	public KMIPType(){
		
	}
	
	KMIPType(int defaultLength)
	{
		this.defaultLength=defaultLength;
	}
	
	KMIPType(String value)
	{
		this.value = value;
	}

	public int getDefaultLength()
	{
		return this.defaultLength;
	}

	@XmlAttribute(name = "value")
	public int getValue()
	{
		return this.value;
	}

	@Override
	public String toString() {
		return "KMIPType [defaultLength=" + defaultLength + "]";
	}
	
}
