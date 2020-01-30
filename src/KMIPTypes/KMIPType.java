package KMIPTypes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class KMIPType {

	int defaultLength;

	public KMIPType(){
		
	}
	
	KMIPType(int defaultLength)
	{
		this.defaultLength=defaultLength;
	}
	
	KMIPType(String value)
	{
		
	}

	//@XmlElement
	public int getDefaultLength()
	{
		return this.defaultLength;
	}

	@Override
	public String toString() {
		return "KMIPType [defaultLength=" + defaultLength + "]";
	}

	
}
