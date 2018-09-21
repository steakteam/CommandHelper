package com.laytonsmith.abstraction.enums.bukkit;

import com.laytonsmith.abstraction.enums.MCSound;
import com.laytonsmith.core.CHLog;
import com.laytonsmith.core.constructs.Target;
import org.bukkit.Sound;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 *
 */
public class BukkitMCSound extends MCSound<Sound> {

    public BukkitMCSound(MCVanillaSound vanillaSound, Sound sound) {
        super(vanillaSound, sound);
    }

    @Override
    public String name() {
        return getAbstracted() == MCVanillaSound.UNKNOWN ? concreteName() : getAbstracted().name();
    }

    @Override
    public String concreteName() {
        return getConcrete() == null ? "null" : getConcrete().name();
    }

    public static BukkitMCSound valueOfConcrete(Sound test) {
        for (MCSound t : mappings.values()) {
            if (((BukkitMCSound) t).getConcrete().equals(test)) {
                return (BukkitMCSound) t;
            }
        }
        return (BukkitMCSound) NULL;
    }

    public static BukkitMCSound valueOfConcrete(String test) {
        try {
            return valueOfConcrete(Sound.valueOf(test));
        } catch (IllegalArgumentException iae) {
            return (BukkitMCSound) NULL;
        }
    }

    // This way we don't take up extra memory on non-bukkit implementations
    public static void build() {
        mappings = new HashMap<>();
        NULL = new BukkitMCSound(MCVanillaSound.UNKNOWN, null);
        ArrayList<Sound> counted = new ArrayList<>();
        for (MCVanillaSound v : MCVanillaSound.values()) {
            if (v.existsInCurrent()) {
                Sound sound = getBukkitType(v);
                if (sound == null) {
                    CHLog.GetLogger().e(CHLog.Tags.RUNTIME, "Could not find a matching sound for " + v.name()
                            + ". This is an error, please report this to the bug tracker.", Target.UNKNOWN);
                    continue;
                }
                BukkitMCSound wrapper = new BukkitMCSound(v, sound);
                mappings.put(v.name(), wrapper);
                counted.add(sound);
            }
        }
        for (Sound s : Sound.values()) {
            if (!counted.contains(s)) {
                mappings.put(s.name(), new BukkitMCSound(MCVanillaSound.UNKNOWN, s));
            }
        }
    }

    private static Sound getBukkitType(MCVanillaSound v) {
        try {
            return Sound.valueOf(v.name());
        } catch (IllegalArgumentException iae) {
            return null;
        }
    }
}
