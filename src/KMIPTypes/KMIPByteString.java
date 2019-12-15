package KMIPTypes;

public class KMIPByteString extends KMIPType {
	
	byte[] value;

	KMIPByteString() {
		super(0);
		// TODO Auto-generated constructor stub
	}
	KMIPByteString(byte[] value)
	{
		super(0);
		setValue(value);
	}
	KMIPByteString(String value)
	{
		super(0);
		setValue(value);
	}
	public void setValue(byte[] value)
	{
		this.value=value;
	}
	public void setValue(String value)
	{
		byte[] val = new byte[value.length() / 2];
		for (int i = 0; i < val.length; i++) {
			   int index = i * 2;
			   int j = Integer.parseInt(value.substring(index, index + 2), 16);
			   val[i] = (byte) j;
			}
		setValue(val);
	}
}
