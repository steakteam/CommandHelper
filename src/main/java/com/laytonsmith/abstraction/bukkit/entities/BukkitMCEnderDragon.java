package com.laytonsmith.abstraction.bukkit.entities;

import com.laytonsmith.abstraction.AbstractionObject;
import com.laytonsmith.abstraction.entities.MCEnderDragon;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;

public class BukkitMCEnderDragon extends BukkitMCComplexLivingEntity implements MCEnderDragon {

    EnderDragon ed;

    public BukkitMCEnderDragon(Entity ent) {
        super(ent);
        ed = (EnderDragon) ent;
    }

    public BukkitMCEnderDragon(AbstractionObject ao) {
        this((EnderDragon) ao.getHandle());
    }

    @Override
    public EnderDragon getHandle() {
        return ed;
    }
}