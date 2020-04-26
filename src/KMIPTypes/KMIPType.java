package KMIPTypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * KMIPType POJO class.
 * It describes methods for the various data types as interpreted by KMIP for reading values.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPType
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class KMIPType {

	int defaultLength;
	String value;

	/**
	 * Default constructor.
	 */
	public KMIPType(){
		
	}
	
	/**
	 * Parameterized constructor.
	 * @param defaultLength default length of the value, for any particular data type.
	 */
	KMIPType(int defaultLength)
	{
		this.defaultLength = defaultLength;
	}
	
	/**
	 * Parameterized constructor.
	 * @param value String value
	 */
	KMIPType(String value)
	{
		this.value = value;
	}

	/**
	 * Getter.
	 * @return int default length of the value, according to data type
	 */
	public int getDefaultLength()
	{
		return this.defaultLength;
	}

	/**
	 * Getter.
	 * @return String value
	 */
	public String getValue()
	{
		return this.value;
	}

	@Override
	public String toString() {
		return "KMIPType [defaultLength=" + defaultLength + "]";
	}
	
}
