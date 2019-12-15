package Enum;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;

public class EnumTag extends KMIPEnum {
	public static final int ProtocolVersion= 0x420069;
	public static final int ProtocolVersionMajor= 0x42006A;
	public static final int ProtocolVersionMinor= 0x42006B;
	public static final int BatchOrderOption= 0x420010;
	public static final int BatchCount= 0x42000D;
	public static final int RequestMessage= 0x420078;
	public static final int RequestHeader= 0x420077;
	public static final int BatchItem= 0x42000F;
	public static final int Operation= 0x42005C;
	public static final int UniqueBatchItemId= 0x420093;
	public static final int RequestPayload= 0x420079;
	public static final int ObjectType= 0x420057;
	public static final int Attribute= 0x420008;
	public static final int CryptographicLength= 0x42002A;
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
	public EnumTag(int value)
	{
		this.value=getEntry(value, tagvalues);
	}
	
}
