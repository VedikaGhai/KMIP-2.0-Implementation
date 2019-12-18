package Attributes;

import Enum.EnumTag;
import Enum.EnumType;
import KMIPTypes.KMIPType;

public class Attribute {
	String name;
	KMIPType value;
	EnumType type;
	EnumTag tag;
	int length;

	//POJO
	public Attribute(String name, KMIPType value, EnumType type, EnumTag tag) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
		this.tag = tag;
		this.length=value.getDefaultLength();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public KMIPType getValue() {
		return value;
	}
	public void setValue(KMIPType value) {
		this.value = value;
	}
	public EnumType getType() {
		return type;
	}
	public void setType(EnumType type) {
		this.type = type;
	}
	public EnumTag getTag() {
		return tag;
	}
	public void setTag(EnumTag tag) {
		this.tag = tag;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Attribute [length=" + length + ", name=" + name + ", tag=" + tag + ", type=" + type + ", value=" + value
				+ "]";
	}
	
	
}
