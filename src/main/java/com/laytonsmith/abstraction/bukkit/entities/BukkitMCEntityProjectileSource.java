package com.laytonsmith.abstraction.bukkit.entities;

import com.laytonsmith.PureUtilities.Vector3D;
import com.laytonsmith.abstraction.MCEntity;
import com.laytonsmith.abstraction.MCProjectile;
import com.laytonsmith.abstraction.MCProjectileSource;
import com.laytonsmith.abstraction.bukkit.BukkitConvertor;
import com.laytonsmith.abstraction.enums.MCProjectileType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Vector;

/**
 * Workaround class to accommodate for the likelihood of non-living entities that can shoot stuff.
 *
 * @author jb_aero
 */
public class BukkitMCEntityProjectileSource extends BukkitMCEntity implements MCProjectileSource {
	static boolean projectileSource;
	Entity eps;

	static {
		try {
			Class.forName(ProjectileSource.class.getName());
			projectileSource = true;
		} catch (NoClassDefFoundError | ClassNotFoundException ex) {
			projectileSource = false;
		}
	}

	public BukkitMCEntityProjectileSource(Entity source) {
		super(source);
		eps = source;
	}

	@Override
	public MCProjectile launchProjectile(MCProjectileType projectile) {
		return launchProjectile(projectile, null);
	}

	@Override
	public MCProjectile launchProjectile(MCProjectileType projectile, Vector3D init) {
		EntityType et = EntityType.valueOf(projectile.name());
		Class<? extends Entity> c = et.getEntityClass();
		Vector vector = new Vector(init.X(), init.Y(), init.Z());
		Class<? extends Projectile> projectileClass = c.asSubclass(Projectile.class);
		Projectile proj = null;
		if (projectileSource) {
			proj = ((ProjectileSource) eps).launchProjectile(projectileClass, vector);
		} else if (eps instanceof Player) {
			proj = ((Player) eps).launchProjectile(projectileClass);
		}
		MCEntity mcproj = BukkitConvertor.BukkitGetCorrectEntity(proj);
		if (mcproj instanceof MCProjectile) {
			return (MCProjectile) mcproj;
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return eps.toString();
	}

	@Override
	public int hashCode() {
		return eps.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return eps.equals(obj);
	}
}
