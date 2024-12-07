package tfar.soosigs.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import tfar.soosigs.blockentity.GeneInjectorBlockEntity;

public class ModBlockEntityTypes {
    public static final BlockEntityType<GeneInjectorBlockEntity> GENE_INJECTOR = BlockEntityType.Builder.of(GeneInjectorBlockEntity::new,ModBlocks.GENE_INJECTOR).build(null);
}
