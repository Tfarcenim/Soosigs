package tfar.soosigs.datagen;

import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import tfar.soosigs.Soosigs;
import tfar.soosigs.init.ModBlocks;

public class ModBlockLoot extends VanillaBlockLoot {

    @Override
    protected void generate() {
        dropSelf(ModBlocks.GENE_INJECTOR);
        dropSelf(ModBlocks.SOOSIG_EGG);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Soosigs.getKnownBlocks().toList();
    }
}
