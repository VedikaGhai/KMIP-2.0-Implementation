package Enum;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

/**
 * EnumObjectType class encompasses mapping the various types of objects to their subsequent tags
 * as specified by KMIP for TTLV encoding.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPEnum
 */ 
public class EnumObjectType extends KMIPEnum {
	public static final int SecretData= 0x07;
	public static HashMap<String, Integer> tagvalues;
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
	public EnumObjectType(int value)
	{
		this.value=getEntry(value, tagvalues);
	}

	@Override
	public String toString() {
		return "EnumObjectType []";
	}
	
	
}
