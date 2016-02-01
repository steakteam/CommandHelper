package com.laytonsmith.core.natives.interfaces;

import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.core.CHVersion;

/**
 * 
 */
@TypeofRunnerFor(ArrayAccess.class)
public class ArrayAccessTypeofRunner implements TypeofRunnerIface {
	@Override
	public String docs() {
		return "An ArrayAccess object is one that can be accessed with brackets ([]).";
	}

	@Override
	public Version since() {
		return CHVersion.V3_3_1;
	}

}
