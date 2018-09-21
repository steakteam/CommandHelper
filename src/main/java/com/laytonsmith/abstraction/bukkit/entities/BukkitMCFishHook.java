package com.laytonsmith.abstraction.bukkit.entities;

import com.laytonsmith.abstraction.entities.MCFishHook;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fish;

public class BukkitMCFishHook extends BukkitMCProjectile implements MCFishHook {

    Fish f;

    public BukkitMCFishHook(Entity e) {
        super(e);
        f = (Fish) e;
    }

}
