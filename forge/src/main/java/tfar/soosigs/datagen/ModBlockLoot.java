package tfar.soosigs.datagen;

import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class ModBlockLoot extends VanillaBlockLoot {

    @Override
    protected void generate() {
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return List.of();
    }
}
