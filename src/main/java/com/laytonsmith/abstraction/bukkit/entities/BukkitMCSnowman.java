package com.laytonsmith.abstraction.bukkit.entities;

import com.laytonsmith.abstraction.AbstractionObject;
import com.laytonsmith.abstraction.entities.MCSnowman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Snowman;

public class BukkitMCSnowman extends BukkitMCLivingEntity implements MCSnowman {

    public BukkitMCSnowman(Entity snowman) {
        super(snowman);
    }

    public BukkitMCSnowman(AbstractionObject ao) {
        this((Snowman) ao.getHandle());
    }

}
