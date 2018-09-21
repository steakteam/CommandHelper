package com.laytonsmith.abstraction.entities;

import com.laytonsmith.PureUtilities.Vector3D;
import com.laytonsmith.abstraction.MCVehicle;

public interface MCMinecart extends MCVehicle {
    void setDamage(int damage);

    int getDamage();

    double getMaxSpeed();

    void setMaxSpeed(int speed);

    boolean isSlowWhenEmpty();

    void setSlowWhenEmpty(boolean slow);

    Vector3D getFlyingVelocityMod();

    void setFlyingVelocityMod(Vector3D var1);

    Vector3D getDerailedVelocityMod();

    void setDerailedVelocityMod(Vector3D var1);
}
