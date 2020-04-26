package Enum;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * KMIPEnum class encompasses methods to get various types of operations, types, result statuses
 * from their subsequent tags (as specified by KMIP for TTLV encoding), and vice-versa.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPEnum
 */
public class KMIPEnum {
	Entry<String, Integer> value;
	public final int defaultLength=4;

	/**
	 * Default constructor.
	 */
	public KMIPEnum(){

	}

	/**
	 * This method allows to get the object type, operation name, result status name, etc
	 * if we know the tag (hex value)
	 * @param value the hex value (tag)
	 * @param tagvalues the Entry object which contains the object type/operation name/result status/etc. to tag (hex value) mapping. 
	 * @return {@code Entry<String, Integer>} the entry which has the value as the hex value is returned.
	 */
	public Entry<String, Integer> getEntry(int value, HashMap<String, Integer> tagvalues)
	{
		for(Map.Entry<String, Integer> e: tagvalues.entrySet() )
		{
			if(e.getValue()==value)
				return e;
		}
		return null;
	}
	
	/**
	 * This method allows to get the tag (hex value)
	 * if we know the object type, operation name, result status name, etc
	 * @param value the object type/result status/operation name/etc.
	 * @param tagvalues the Entry object which contains the object type/operation name/result status/etc. to tag (hex value) mapping. 
	 * @return {@code Entry<String, Integer>} the entry which has the value as the operation name/object type/ result status/etc. is returned.
	 */
	public Entry<String, Integer> getEntry(String value, HashMap<String, Integer> tagvalues)
	{
		for(Map.Entry<String, Integer> e: tagvalues.entrySet() )
		{
			if(e.getKey().equals(value))
				return e;
		}
		return null;
	}

	/*
	@Override
	public String toString() {
		return "KMIPEnum [defaultLength=" + defaultLength + ", value=" + value + "]";
	}
	*/
	
}
