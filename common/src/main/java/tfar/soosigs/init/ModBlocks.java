package tfar.soosigs.init;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import tfar.soosigs.block.GeneInjectorBlock;

public class ModBlocks {
    public static final GeneInjectorBlock GENE_INJECTOR = new GeneInjectorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F));
}
