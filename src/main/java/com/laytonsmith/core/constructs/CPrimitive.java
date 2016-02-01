package com.laytonsmith.core.constructs;

import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.annotations.typeof;
import com.laytonsmith.core.CHVersion;

/**
 *
 */
@typeof("primitive")
public abstract class CPrimitive extends Construct {

	public CPrimitive(String value, ConstructType type, Target t) {
		super(value, type, t);
	}

	@Override
	public String docs() {
		return new CPrimitiveTypeofRunner().docs();
	}

	@Override
	public Version since() {
		return new CPrimitiveTypeofRunner().since();
	}

}
