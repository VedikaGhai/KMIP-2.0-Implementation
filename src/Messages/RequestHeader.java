package Messages;

import Enum.EnumTag;
import KMIPTypes.KMIPBoolean;
import KMIPTypes.KMIPInteger;

public class RequestHeader {
	EnumTag ProtocolVersionMajor;
	EnumTag ProtocolVersionMinor;
	String ClientCorrelationValue;
	KMIPBoolean BatchOrderOption;
	KMIPInteger BatchCount;

}
