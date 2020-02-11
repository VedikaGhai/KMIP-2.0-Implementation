package Enum;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;


public class EnumResultStatus extends KMIPEnum {
	public static final int Success= 0x00;
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
	public EnumResultStatus(int value)
	{
		this.value=getEntry(value, tagvalues);
	}

	@Override
	public String toString() {
		return "EnumResultStatus []";
	}

}
