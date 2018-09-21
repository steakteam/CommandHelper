package com.laytonsmith.abstraction.bukkit.entities;

import com.laytonsmith.abstraction.entities.MCArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;

/**
 * @author Veyyn
 */
public class BukkitMCArrow extends BukkitMCProjectile implements MCArrow {

    private final Arrow _arrow;

    public BukkitMCArrow(Entity arrow) {
        super((Projectile) arrow);
        _arrow = (Arrow) arrow;
    }
}