package com.laytonsmith.abstraction.bukkit;

import com.laytonsmith.PureUtilities.Common.ReflectionUtils;
import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.MCOfflinePlayer;
import com.laytonsmith.abstraction.MCPlayer;
import com.laytonsmith.abstraction.bukkit.entities.BukkitMCPlayer;
import net.minecraft.server.v1_5_R3.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_5_R3.CraftOfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 *
 */
public class BukkitMCOfflinePlayer extends BukkitMCAnimalTamer implements MCOfflinePlayer {
    public static final String NBT_KEY_UUID_MOST = "UUIDMost";
    public static final String NBT_KEY_UUID_LEAST = "UUIDLeast";
    OfflinePlayer op;

    BukkitMCOfflinePlayer(OfflinePlayer offlinePlayer) {
        super(offlinePlayer);
        this.op = offlinePlayer;
    }

    @Override
    public boolean isOnline() {
        return op.isOnline();
    }

    @Override
    public String getName() {
        return op.getName();
    }

    @Override
    public boolean isBanned() {
        return op.isBanned();
    }

    @Override
    public boolean isWhitelisted() {
        return op.isWhitelisted();
    }

    @Override
    public void setWhitelisted(boolean value) {
        op.setWhitelisted(value);
    }

    @Override
    public MCPlayer getPlayer() {
        if (op instanceof Player) {
            return new BukkitMCPlayer(((Player) op));
        }
        return null;
    }

    @Override
    public long getFirstPlayed() {
        return op.getFirstPlayed();
    }

    @Override
    public long getLastPlayed() {
        return op.getLastPlayed();
    }

    @Override
    public boolean hasPlayedBefore() {
        return op.hasPlayedBefore();
    }

    @Override
    public MCLocation getBedSpawnLocation() {
        Location loc = op.getBedSpawnLocation();
        return loc == null ? null : new BukkitMCLocation(loc);
    }

    @Override
    public UUID getUniqueID() {
        if (op instanceof Entity) {
            return ((Entity) op).getUniqueId();
        } else if (op instanceof CraftOfflinePlayer) {
            CraftOfflinePlayer offlinePlayer = ((CraftOfflinePlayer) op);
            NBTTagCompound tag = (NBTTagCompound) ReflectionUtils.invokeMethod(CraftOfflinePlayer.class, offlinePlayer, "getBukkitData");
            if (tag != null && tag.hasKey(NBT_KEY_UUID_MOST) && tag.hasKey(NBT_KEY_UUID_LEAST)) {
                return new UUID(
                        tag.getLong(NBT_KEY_UUID_MOST),
                        tag.getLong(NBT_KEY_UUID_LEAST)
                );
            }
        }
        return null;
    }
}
