package com.laytonsmith.core.constructs;

import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.core.CHVersion;
import com.laytonsmith.core.natives.interfaces.TypeofRunnerFor;
import com.laytonsmith.core.natives.interfaces.TypeofRunnerIface;

/**
 * 
 */
@TypeofRunnerFor(CPrimitive.class)
public class CPrimitiveTypeofRunner implements TypeofRunnerIface {
	@Override
	public String docs() {
		return "A primitive is any non-object and non-array data type. All primitives are pass by value.";
	}

	@Override
	public Version since() {
		return CHVersion.V3_0_1;
	}

}
