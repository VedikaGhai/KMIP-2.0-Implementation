package Enum;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * EnumOperation class encompasses mapping the various types of operations to their subsequent tags
 * as specified by KMIP for TTLV encoding.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPEnum
 */
public class EnumOperation extends KMIPEnum {
	public static final int Create= 0x01;
	public static final int Register=0x02;
	public static HashMap<String, Integer> tagvalues;

	String operationName;

	static {
		tagvalues=new HashMap<String, Integer>();
		Field tagfieldvalues[]=EnumType.class.getDeclaredFields();
		for(Field f: tagfieldvalues)
		{
			if(Modifier.isStatic(f.getModifiers())&&Modifier.isFinal(f.getModifiers()))
			{
				try {
					tagvalues.put(f.getName(), f.getInt(EnumType.class));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Parameterized constructor.
	 * @param value
	 */
	public EnumOperation(int value)
	{
		this.value=getEntry(value, tagvalues);
	}

	/**
	 * Getter.
	 * @return String the tag value (value) is used to find the operation name (key) and the operation name is thus returned.
	 */
	public String getValue()
	{
		this.operationName = this.value.getKey();
		return this.operationName;
	}
	
	@Override
	public String toString() {
		return "EnumOperation []";
	}
	
}
