package Enum;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class KMIPEnum {
	Entry<String, Integer> value;
	public final int defaultLength=4;

	//function to get entry if you have the hex value
	public Entry<String, Integer> getEntry(int value, HashMap<String, Integer> tagvalues)
	{
		for(Map.Entry<String, Integer> e: tagvalues.entrySet() )
		{
			if(e.getValue()==value)
				return e;
		}
		return null;
	}

	//function to get entry if you have the string (name) (that corresponds to the hex value)
	public Entry<String, Integer> getEntry(String value, HashMap<String, Integer> tagvalues)
	{
		for(Map.Entry<String, Integer> e: tagvalues.entrySet() )
		{
			if(e.getKey().equals(value))
				return e;
		}
		return null;
	}

	@Override
	public String toString() {
		return "KMIPEnum [defaultLength=" + defaultLength + ", value=" + value + "]";
	}

	
}
