package KMIPTypes;

/**
 * KMIPInteger POJO class.
 * It describes the Integer data type as interpreted by KMIP for reading values.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPType
 */ 
public class KMIPInteger extends KMIPType{
	
	int value;

	/**
	 * Default constructor. 
	 * describes the default value for an integer value.
	 */
	public KMIPInteger() {
		super(4);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor.
	 * @param value String value
	 */
	public KMIPInteger(String value)
	{
		super(value);
		toInteger(value);
	}

	/**
	 * Method to convert String value to Integer.
	 * @param value String value.
	 */
	public void toInteger(String value)
	{
		if(value.length()>1&& value.substring(0,2)=="0x")
		{
			this.value=Integer.parseInt(value.substring(2), 16 );
		}
		else
			this.value=Integer.parseInt(value);

	}

	/**
	 * Method to convert Integer to String.
	 * @return String value
	 */
	public String toString()
	{
		return Integer.toString(value);
	}

	/**
	 * Getter.
	 * @return String integer value that has been converted to string
	 */
	public String getValue()
	{
		return String.valueOf(this.value);
	} 
	
	/**
	 * Setter.
	 * @param value integer value.
	 */
	public void setValue(int value)
	{
		this.value=value;
	}
	
	
}
