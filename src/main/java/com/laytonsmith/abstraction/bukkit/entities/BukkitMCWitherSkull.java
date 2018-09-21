package com.laytonsmith.abstraction.bukkit.entities;

import com.laytonsmith.abstraction.entities.MCWitherSkull;
import org.bukkit.entity.Entity;
import org.bukkit.entity.WitherSkull;

/**
 * @author Veyyn
 */
public class BukkitMCWitherSkull extends BukkitMCFireball implements MCWitherSkull {

    private final WitherSkull _skull;

    public BukkitMCWitherSkull(Entity skull) {
        super(skull);
        _skull = (WitherSkull) skull;
    }

    @Override
    public WitherSkull getHandle() {
        return _skull;
    }
}