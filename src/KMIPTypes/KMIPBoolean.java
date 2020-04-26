package KMIPTypes;

import Enum.KMIPEnum;

/**
 * KMIPBoolean POJO class.
 * It describes the Boolean data type as interpreted by KMIP for reading values.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 * @see KMIPType
 */ 
public class KMIPBoolean extends KMIPType {
	
	boolean value;
	
	/**
	 * Default constructor. 
	 * describes the default length of each boolean value.
	 */
	public KMIPBoolean()
	{
		super(8);
	}

	/**
	 * Parameterized constructor. 
	 * @param value boolean value
	 */
	public KMIPBoolean(boolean value)
	{
		super(8);
		this.value=value;
	}

	/**
	 * Parameterized constructor.
	 * @param value boolean value
	 */
	public KMIPBoolean(String value)
	{
		super(8);
		setValue(value);
	}

	/**
	 * Setter.
	 * @param value boolean value in the form of a String
	 */
	public void setValue(String value)
	{
		if(value.toLowerCase().equals("true"))
			this.value=true;
		else
			this.value=false;
	}

	/**
	 * Setter.
	 * @param value boolean value as a boolean
	 */
	public void setValue(boolean value)
	{
		this.value=value;
	}

	/**
	 * Getter.
	 * @return String boolean value returned as a String
	 */
	public String getValue()
	{
		return Boolean.toString(this.value);
	}

	@Override
	public String toString() {
		return "KMIPBoolean [value=" + value + "]";
	}
	
}

