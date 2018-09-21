package com.laytonsmith.abstraction.bukkit.entities;

import com.laytonsmith.PureUtilities.Vector3D;
import com.laytonsmith.abstraction.entities.MCMinecart;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;

public class BukkitMCMinecart extends BukkitMCVehicle
        implements MCMinecart {

    Minecart m;

    public BukkitMCMinecart(Entity e) {
        super(e);
        this.m = (Minecart) e;
    }

    @Override
    public void setDamage(int damage) {
        m.setDamage(damage);
    }

    @Override
    public int getDamage() {
        return m.getDamage();
    }

    @Override
    public double getMaxSpeed() {
        return m.getMaxSpeed();
    }

    @Override
    public void setMaxSpeed(int speed) {
        m.setMaxSpeed(speed);
    }

    @Override
    public boolean isSlowWhenEmpty() {
        return m.isSlowWhenEmpty();
    }

    @Override
    public void setSlowWhenEmpty(boolean slow) {
        m.setSlowWhenEmpty(slow);
    }


    @Override
    public Vector3D getFlyingVelocityMod() {
        return new Vector3D(m.getFlyingVelocityMod());
    }

    @Override
    public void setFlyingVelocityMod(Vector3D var1) {
        m.setFlyingVelocityMod(var1.toBukkitVector());
    }

    @Override
    public Vector3D getDerailedVelocityMod() {
        return new Vector3D(m.getDerailedVelocityMod());
    }

    @Override
    public void setDerailedVelocityMod(Vector3D var1) {
        m.setDerailedVelocityMod(var1.toBukkitVector());
    }
}
