package com.laytonsmith.abstraction.bukkit;

import com.laytonsmith.abstraction.MCMapMeta;
import org.bukkit.inventory.meta.MapMeta;

public class BukkitMCMapMeta extends BukkitMCItemMeta implements MCMapMeta {
    private MapMeta mm;

    BukkitMCMapMeta(MapMeta im) {
        super(im);
        mm = im;
    }

    @Override
    public boolean isScaling() {
        return mm.isScaling();
    }

    @Override
    public void setScaling(boolean bool) {
        mm.setScaling(bool);
    }
}
