package tfar.soosigs.init;

import net.minecraft.world.entity.EntityType;
import tfar.soosigs.SoosigEntity;
import tfar.soosigs.platform.Services;

public class ModEntities {

    public static final EntityType<? extends SoosigEntity> SOOSIG = Services.PLATFORM.createType();

}
