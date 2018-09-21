package com.laytonsmith.core.exceptions.CRE;

import com.laytonsmith.PureUtilities.Version;
import com.laytonsmith.annotations.typeof;
import com.laytonsmith.core.CHVersion;
import com.laytonsmith.core.constructs.CClassType;
import com.laytonsmith.core.constructs.Target;

/**
 *
 */
@typeof("RangeException")
public class CRERangeException extends CREException {

    @SuppressWarnings("FieldNameHidesFieldInSuperclass")
    public static final CClassType TYPE = CClassType.get("RangeException");

    public CRERangeException(String msg, Target t) {
        super(msg, t);
    }

    public CRERangeException(String msg, Target t, Throwable cause) {
        super(msg, t, cause);
    }

    @Override
    public String docs() {
        return "This exception is thrown if a function expected a numeric value to be"
                + " in a particular range, and it wasn't";
    }

    @Override
    public Version since() {
        return CHVersion.V3_3_1;
    }
}
