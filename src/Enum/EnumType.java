package Enum;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;


//TTLV types
public class EnumType extends KMIPEnum {
	public static final int Integer= 0x02;
	public static final int LongInteger= 0x03;
	public static final int BigInteger= 0x04;
	public static final int Enummeration= 0x05;
	public static final int Boolean= 0x06;
	public static final int TextString= 0x07;
	public static final int ByteString= 0x08;
	public static final int DateTime= 0x09;
	public static final int Interval= 0x0A;
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
	public EnumType(int value)
	{
		this.value=getEntry(value, tagvalues);
		System.out.println("EnumType : "+value);
	}

	
	
	
}
