package com.laytonsmith.core.constructs;

import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.core.CHVersion;
import com.laytonsmith.core.natives.interfaces.TypeofRunnerFor;
import com.laytonsmith.core.natives.interfaces.TypeofRunnerIface;

/**
 * 
 */
@TypeofRunnerFor(CNumber.class)
public class CNumberTypeofRunner implements TypeofRunnerIface {
	@Override
	public String docs() {
		return "A number is any double or integer number.";
	}

	@Override
	public Version since() {
		return CHVersion.V3_0_1;
	}

}
