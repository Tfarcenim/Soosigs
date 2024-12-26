package tfar.soosigs.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import tfar.soosigs.block.GeneInjectorBlock;
import tfar.soosigs.block.SoosigEggBlock;

public class ModBlocks {
    public static final GeneInjectorBlock GENE_INJECTOR = new GeneInjectorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.5F));
    public static final Block SOOSIG_EGG = new SoosigEggBlock(BlockBehaviour.Properties.of().noOcclusion().pushReaction(PushReaction.DESTROY));
}
