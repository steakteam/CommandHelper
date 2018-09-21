package com.laytonsmith.abstraction.events;

import com.laytonsmith.abstraction.MCPlayer;

/**
 * @author Jason Unger <entityreborn@gmail.com>
 */
public interface MCPlayerToggleSprintEvent {
    boolean isSprinting();

    MCPlayer getPlayer();

    void setCancelled(boolean state);

    boolean isCancelled();
}
