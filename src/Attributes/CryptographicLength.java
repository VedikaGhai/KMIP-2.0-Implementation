package Attributes;
import javax.xml.bind.annotation.XmlRootElement;

import Enum.EnumTag;
import Enum.EnumType;
import KMIPTypes.KMIPInteger;

@XmlRootElement
public class CryptographicLength extends Attribute{

	public CryptographicLength(){
			
	}

	public CryptographicLength(KMIPInteger value) {
		super("CryptographicLength", value, new EnumType(EnumType.Integer), new EnumTag(EnumTag.CryptographicLength));
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CryptographicLength []";
	}
	
	
}
