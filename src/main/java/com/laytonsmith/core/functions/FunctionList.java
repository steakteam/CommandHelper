

package com.laytonsmith.core.functions;

import com.laytonsmith.annotations.api;
import com.laytonsmith.core.constructs.CFunction;
import com.laytonsmith.core.constructs.Target;
import com.laytonsmith.core.exceptions.ConfigCompileException;
import com.laytonsmith.core.extensions.ExtensionManager;
import com.laytonsmith.core.natives.interfaces.Mixed;
import java.util.Set;

/**
 *
 */
public class FunctionList {
    public static FunctionBase getFunction(String s, Target t) throws ConfigCompileException{
		return getFunction(new CFunction(s, t));
	}

	public static FunctionBase getFunction(String s, api.Platforms platform, Target t) throws ConfigCompileException{
		return getFunction(new CFunction(s, t), platform);
	}

    public static FunctionBase getFunction(Mixed c) throws ConfigCompileException{
        return getFunction(c, api.Platforms.INTERPRETER_JAVA);
    }

    public static FunctionBase getFunction(Mixed c, api.Platforms platform) throws ConfigCompileException {
        return ExtensionManager.GetFunction(c, platform);
    }

    public static Set<FunctionBase> getFunctionList(api.Platforms platform) {
        return ExtensionManager.GetFunctions(platform);
    }
}
