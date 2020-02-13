package Enum;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
//@XmlAccessorType(XmlAccessType.NONE)
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
	public EnumOperation(int value)
	{
		this.value=getEntry(value, tagvalues);
	}

	//@XmlAttribute(name = "value")
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
