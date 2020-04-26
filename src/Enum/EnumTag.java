package Enum;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import Enum.KMIPEnum;

/**
 * EnumTag class encompasses mapping the various types of tags to their subsequent tags
 * as specified by KMIP for TTLV encoding.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPEnum
 */
//TTLV tags
public class EnumTag extends KMIPEnum {
	public static final int ProtocolVersion= 0x420069;
	public static final int ProtocolVersionMajor= 0x42006A;
	public static final int ProtocolVersionMinor= 0x42006B;
	public static final int BatchOrderOption= 0x420010;
	public static final int BatchCount= 0x42000D;
	public static final int RequestMessage= 0x420078;
	public static final int RequestHeader= 0x420077;
	public static final int BatchItem= 0x42000F;
	public static final int ClientCorrelationValue = 0x420105;
	public static final int Operation= 0x42005C;
	public static final int UniqueBatchItemId= 0x420093;
	public static final int RequestPayload= 0x420079;
	public static final int ObjectType= 0x420057;
	public static final int Attribute= 0x420008;
	public static final int CryptographicLength= 0x42002A;
	public static final int ResultStatus=0x42007F;
	public static final int CryptographicAlgorithm=0x420028;
	public static final int CryptographicUsageMask=0x42002C;
	public static final int AttributeName=0x42000A;
	public static final int AttributeValue=0x42000B;
	public static final int VendorIdentification=0x42009D;
	public static final int UniqueIdentifier=0x420094;
	public static final int KeyFormatType=0x420042;
	public static final int NameValue = 0x420055;
	public static final int NameType = 0x420054;
	public static final int ActivationDate = 0x420001;

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
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Parameterized constructor.
	 * @param value 
	 */
	public EnumTag(int value)
	{
		this.value=getEntry(value, tagvalues);
		//System.out.println("EnumTag : "+value);
	}
}
