package Attributes;

import Enum.EnumTag;
import Enum.EnumType;
import KMIPTypes.KMIPInteger;

public class CryptographicLength extends Attribute{

	public CryptographicLength(KMIPInteger value) {
		super("CryptographicLength", value, new EnumType(EnumType.Integer), new EnumTag(EnumTag.CryptographicLength));
		// TODO Auto-generated constructor stub
	}
	

}
