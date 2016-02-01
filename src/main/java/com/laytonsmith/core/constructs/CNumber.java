package com.laytonsmith.core.constructs;

import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.annotations.typeof;
import com.laytonsmith.core.CHVersion;

/**
 *
 */
@typeof("number")
public abstract class CNumber extends CPrimitive {

	public CNumber(String value, ConstructType type, Target t) {
		super(value, type, t);
	}

	@Override
	public String docs() {
		return new CNumberTypeofRunner().docs();
	}

	@Override
	public Version since() {
		return new CNumberTypeofRunner().since();
	}

}
