package KMIPTypes;

public class KMIPBoolean extends KMIPType {
	boolean value;
	KMIPBoolean()
	{
		super(8);
	}
	KMIPBoolean(boolean value)
	{
		super(8);
		this.value=value;
	}
	KMIPBoolean(String value)
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
	public boolean getValue()
	{
		return this.value;
	}
}
