package KMIPTypes;

/**
 * KMIPEnumeration POJO class.
 * It describes the Enumeration data type as interpreted by KMIP for reading values.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPType
 */ 
public class KMIPEnumeration extends KMIPType
{
    int value;
    
    /**
     * Default constructor.
     * describes the default length of each Enumeration value.
     */
	public KMIPEnumeration() {
		super(4);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor. String value is converted to Integer before storing it.
	 * @param value value in the form of String data type.
	 */
	public KMIPEnumeration(String value)
	{
		super(value);
		toInteger(value);
	}

	/**
	 * This method is used to convert value from String to integer.
	 * @param value value in String data type.
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
	 * used to convert integer to string.
	 * @return String  converted String.
	 */
	public String toString()
	{
		return Integer.toString(value);
	}
	
	/**
	 * Setter.
	 * @param value value as an integer.
	 */
	public void setValue(int value)
	{
		this.value=value;
	}
}