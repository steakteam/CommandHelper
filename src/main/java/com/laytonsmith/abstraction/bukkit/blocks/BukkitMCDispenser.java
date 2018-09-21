package com.laytonsmith.abstraction.bukkit.blocks;

import com.laytonsmith.abstraction.blocks.MCDispenser;
import org.bukkit.block.Dispenser;

public class BukkitMCDispenser extends BukkitMCBlockState implements MCDispenser {

    Dispenser d;

    public BukkitMCDispenser(Dispenser block) {
        super(block);
        d = block;
    }
}
