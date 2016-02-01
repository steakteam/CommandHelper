package com.laytonsmith.core.exceptions.CRE;

import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.annotations.typeof;
import com.laytonsmith.core.CHVersion;
import com.laytonsmith.core.constructs.Target;

/**
 * 
 */
@typeof("ClassNotFoundException")
public class CREClassNotFoundException extends CREException {

	public CREClassNotFoundException(String msg, Target t){
		super(msg, t);
	}

	public CREClassNotFoundException(String msg, Target t, Throwable cause){
		super(msg, t, cause);
	}

	@Override
	public String docs() {
		return "Thrown in the case that the class name cannot be found.";
	}

	@Override
	public Version since() {
		return CHVersion.V3_3_2;
	}
	
}
