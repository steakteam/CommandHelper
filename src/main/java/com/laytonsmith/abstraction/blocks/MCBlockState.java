package com.laytonsmith.abstraction.blocks;

import com.laytonsmith.abstraction.MCLocation;
import com.laytonsmith.abstraction.MCMaterialData;
import com.laytonsmith.abstraction.MCMetadatable;

public interface MCBlockState extends MCMetadatable {
    MCMaterialData getData();

    int getTypeId();

    void setTypeId(int type);

    void setRawData(byte data);

    MCBlock getBlock();

    MCLocation getLocation();

    void update();
}