package KMIPTypes;

import javax.xml.bind.annotation.XmlAttribute;


public class KMIPBoolean extends KMIPType {
	boolean value;
	
	public KMIPBoolean()
	{
		super(8);
	}

	public KMIPBoolean(boolean value)
	{
		super(8);
		this.value=value;
	}

	public KMIPBoolean(String value)
	{
		super(8);
		setValue(value);
	}

	public void setValue(String value)
	{
		if(value.toLowerCase().equals("true"))
			this.value=true;
		else
			this.value=false;
	}

	public void setValue(boolean value)
	{
		this.value=value;
	}

	//@XmlAttribute(name="value")
	public boolean getValue()
	{
		return this.value;
	}

	@Override
	public String toString() {
		return "KMIPBoolean [value=" + value + "]";
	}

	
}
