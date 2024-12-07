package tfar.soosigs.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import tfar.soosigs.AddItemChanceLootModifier;
import tfar.soosigs.Soosigs;
import tfar.soosigs.init.ModItems;

import java.util.HashSet;
import java.util.Set;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, Soosigs.MOD_ID);
    }

    // Obtainable through dungeons, shipwrecks, buried treasure, ocean ruins. (Low
    // chance of spawning in them)

    final Set<Block> tables = new HashSet<>();

    @Override
    protected void start() {
        tables.add(Blocks.GRASS);

        for (Block table : tables) {
            addModifier(table);
        }
    }

    void addModifier(Block table) {
        ResourceLocation name = BuiltInRegistries.BLOCK.getKey(table);
        add("add_item_chance_" + name.getPath(), new AddItemChanceLootModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(table.getLootTable()).build(),
                BlockLootSubProvider.HAS_NO_SILK_TOUCH.build()
        }, ModItems.SOOSIG_EGG, 1, 1, .05f));
    }
}
