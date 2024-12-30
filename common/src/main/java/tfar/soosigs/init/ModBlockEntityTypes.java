package tfar.soosigs.init;

import net.minecraft.world.level.block.entity.BlockEntityType;
import tfar.soosigs.blockentity.GeneInjectorBlockEntity;
import tfar.soosigs.blockentity.SoosigEggBlockEntity;

public class ModBlockEntityTypes {
    public static final BlockEntityType<GeneInjectorBlockEntity> GENE_INJECTOR = BlockEntityType.Builder.of(GeneInjectorBlockEntity::new,ModBlocks.GENE_INJECTOR).build(null);
    public static final BlockEntityType<SoosigEggBlockEntity> SOOSIG_EGG = BlockEntityType.Builder.of(SoosigEggBlockEntity::new,ModBlocks.SOOSIG_EGG).build(null);

}
