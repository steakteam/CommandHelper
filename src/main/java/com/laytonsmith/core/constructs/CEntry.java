

package com.laytonsmith.core.constructs;

import com.laytonsmith.core.natives.interfaces.Mixed;

/**
 *
 * 
 */
public class CEntry extends Construct {
    Mixed ckey;
    Mixed construct;

    public CEntry(String value, Target t){
        super(value, ConstructType.ENTRY, t);
        throw new UnsupportedOperationException("CEntry Constructs cannot use this constructor");
    }
    public CEntry(Mixed key, Mixed value, Target t){
        super(key.val() + ":(CEntry)", ConstructType.ENTRY, t);
        this.ckey = key;
        this.construct = value;
    }
    
    @Override
    public String val(){
        return construct.val();
    }
    
    public Mixed construct(){
        return this.construct;
    }

    @Override
    public boolean isDynamic() {
        return false;
    }
    
}
