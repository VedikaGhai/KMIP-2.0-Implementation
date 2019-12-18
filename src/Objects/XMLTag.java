package Objects;

import Enum.EnumTag;
import Enum.EnumType;
import KMIPTypes.KMIPType;

public class XMLTag
{
    String name;
    EnumTag tag;
    EnumType type;
    KMIPType value;

    public XMLTag(String name, EnumTag tag, EnumType type, KMIPType value) {
        this.name = name;
        this.tag = tag;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumTag getTag() {
        return tag;
    }

    public void setTag(EnumTag tag) {
        this.tag = tag;
    }

    public EnumType getType() {
        return type;
    }

    public void setType(EnumType type) {
        this.type = type;
    }

    public KMIPType getValue() {
        return value;
    }

    public void setValue(KMIPType value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "XMLTag [name=" + name + ", tag=" + tag + ", type=" + type + ", value=" + value + "]";
    }

    
}