package com.laytonsmith.abstraction.bukkit.entities;

import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.MCProjectile;
import com.laytonsmith.abstraction.MCProjectileSource;
import com.laytonsmith.abstraction.bukkit.BukkitConvertor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;

public class BukkitMCProjectile extends BukkitMCEntity implements MCProjectile {

    Projectile proj;

    public BukkitMCProjectile(Entity e) {
        super(e);
        this.proj = (Projectile) e;
    }

    @Override
    public boolean doesBounce() {
        return proj.doesBounce();
    }

    @Override
    public MCProjectileSource getShooter() {
        LivingEntity source = proj.getShooter();
        if (source != null) {
            MCEntity e = BukkitConvertor.BukkitGetCorrectEntity(source);
            if (e instanceof MCProjectileSource) {
                return (MCProjectileSource) e;
            }
        }
        return null;
    }

    @Override
    public void setBounce(boolean doesBounce) {
        proj.setBounce(doesBounce);
    }

    @Override
    public void setShooter(MCProjectileSource shooter) {
        if (shooter == null) {
            proj.setShooter(null);
        } else if (shooter instanceof LivingEntity) {
            proj.setShooter((LivingEntity) shooter.getHandle());
        }
    }

    public Projectile asProjectile() {
        return proj;
    }
}
