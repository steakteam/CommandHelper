package com.laytonsmith.core.exceptions;

import com.laytonsmith.core.constructs.Construct;

/**
 *
 *
 */
public class MarshalException extends Exception {

    /**
     * Creates a new instance of <code>MarshalException</code> without detail message.
     */
    public MarshalException() {
    }

    /**
     * Constructs an instance of <code>MarshalException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public MarshalException(String msg) {
        super(msg);
    }

    /**
     * This is caused when a particular Construct was given that is incompatible.
     *
     * @param msg
     * @param c
     */
    public MarshalException(String msg, Construct c) {
        super(msg + ": " + c.toString());
    }
}
