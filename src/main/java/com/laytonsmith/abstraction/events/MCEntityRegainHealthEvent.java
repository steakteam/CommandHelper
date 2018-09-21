package com.laytonsmith.abstraction.events;

import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.enums.MCRegainReason;
import com.laytonsmith.core.events.BindableEvent;

/**
 * Created by EntryPoint on 2016-12-13.
 */
public interface MCEntityRegainHealthEvent extends BindableEvent {
    int getAmount();

    void setAmount(int amount);

    MCEntity getEntity();

    MCRegainReason getRegainReason();
}
