package com.laytonsmith.abstraction;

import com.laytonsmith.PureUtilities.Vector3D;
import com.laytonsmith.abstraction.enums.MCEntityEffect;
import com.laytonsmith.abstraction.enums.MCEntityType;
import com.laytonsmith.abstraction.enums.MCTeleportCause;
import com.laytonsmith.abstraction.events.MCEntityDamageEvent;

import java.util.List;
import java.util.UUID;

/**
 *
 *
 */
public interface MCEntity extends MCMetadatable {
    MCLocation getLocation();

    void setVelocity(Vector3D v);

    Vector3D getVelocity();

    boolean isOnGround();

    MCWorld getWorld();

    boolean teleport(MCEntity destination);

    boolean teleport(MCEntity destination, MCTeleportCause cause);

    boolean teleport(MCLocation location);

    boolean teleport(MCLocation location, MCTeleportCause cause);

    List<MCEntity> getNearbyEntities(double x, double y, double z);

    int getFireTicks();

    int getMaxFireTicks();

    void setFireTicks(int ticks);

    void remove();

    boolean isDead();

    MCServer getServer();

    MCEntity getPassenger();

    boolean setPassenger(MCEntity passenger);

    boolean isEmpty();

    boolean eject();

    float getFallDistance();

    void setFallDistance(float distance);

    void setLastDamageCause(MCEntityDamageEvent event);

    MCEntityDamageEvent getLastDamageCause();

    UUID getUniqueId();

    int getTicksLived();

    void setTicksLived(int value);

    void playEffect(MCEntityEffect type);

    MCEntityType getType();

    boolean isInsideVehicle();

    boolean leaveVehicle();

    MCEntity getVehicle();

    /**
     * Unlike {@see MCEntity#getLocation}, this will work when not run on the server
     * thread, but this does mean that the data recieved may be slightly outdated.
     *
     * @return
     */
    MCLocation asyncGetLocation();
}
