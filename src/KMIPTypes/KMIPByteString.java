package KMIPTypes;

import java.util.Arrays;

//import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * KMIPByteString POJO class.
 * It describes the ByteString data type as interpreted by KMIP for reading values.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPType
 */ 
public class KMIPByteString extends KMIPType {

	byte[] value;
	int intvalue;

	/**
	 * Default constructor.
	 * describes the default length of each byte string value.
	 */
	public KMIPByteString() {
		super(0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor.
	 * @param value value in the form of a byte array  
	 */
	public KMIPByteString(byte[] value) {
		super(0);
		setValue(value);
	}

	/**
	 * Parameterized constructor.
	 * @param value value in the form of a String
	 */
	public KMIPByteString(String value) {
		super(0);
		setValue(value);
		this.intvalue=Integer.parseInt(value);
	}

	/**
	 * Getter.
	 * @return String byte array is converted to String before returning the value.
	 */
	public String getValue()
	{
		//byte temp;
		/*if(Integer.parseInt(Base64.encode(this.value))/10 == 0)
		{
			for(int i=this.value.length-2;i>=0;i--)
			{
				this.value[i+1]=this.value[i];
			}
			this.value[0]=(byte)0;
		}
		return Arrays.toString(this.value).replaceAll("\\[","").replaceAll("\\]", "");
		//return new String(Base64.encode(this.value));
		//return getStringFromByteArray(this.value);*/

		//return new String(this.value, StandardCharsets.US_ASCII);
		//return new String(this.value, Charset.forName("UTF-8"));
		
		/*String valueByteToStr = "";
		for(byte b : this.value)
		{
			char c = (char) b;
			valueByteToStr+=c;
		}

		return valueByteToStr;*/
		//int length=Integer.toBinaryString(this.intvalue).length();
		//int length=(String.format("%2s",Integer.toBinaryString(this.intvalue).replaceAll("", "0"))).length();
		//System.out.println(Integer.toBinaryString(17));
		int length=Integer.toBinaryString(this.intvalue).length();
		if(length%2!=0)
		{
			StringBuilder sb=new StringBuilder(Integer.toBinaryString(this.intvalue));
			sb.insert(0, "0");
			return sb.toString();
		}
		return Integer.toBinaryString(this.intvalue);

	}

	/**
	 * This method converts byte array to string.
	 * @param settingsData
	 * @return String
	 */
	public String getStringFromByteArray(byte[] settingsData) {

		StringBuilder sb = new StringBuilder();
		for(byte willBeChar: settingsData) {
			sb.append((char) willBeChar);
		}
	
		return sb.toString();
	}

	/**
	 * Setter. 
	 * @param value byte array value
	 */
	public void setValue(byte[] value) {
		this.value = value;
	}

	/**
	 * Setter. The string value is first converted to byte array and then set.
	 * @param value value in the form of a string
	 */
	public void setValue(String value) {
		byte[] val = new byte[(value.length() / 2)+1];
		for (int i = 0; i < val.length-1; i++) {
			int index = i * 2;
			int j = Integer.parseInt(value.substring(index, index + 2), 16);
			val[i] = (byte) j;
		}
		setValue(val);
	}

	@Override
	public String toString() {
		return "KMIPByteString [value=" + Arrays.toString(value) + "]";
	}
	
}
