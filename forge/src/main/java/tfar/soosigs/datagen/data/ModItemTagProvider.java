package tfar.soosigs.datagen.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import tfar.soosigs.ModIntegration;
import tfar.soosigs.Soosigs;
import tfar.soosigs.init.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {


    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags,@Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, Soosigs.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.ALLOWED_RESOURCES).add(Items.AMETHYST_SHARD,
                Items.COAL,
                Items.DIAMOND,Items.EMERALD,
                Items.GOLD_INGOT,Items.IRON_INGOT,
                Items.LAPIS_LAZULI,
                Items.NETHERITE_SCRAP, Items.REDSTONE)
                .addTags(Tags.Items.GEMS_QUARTZ)
                .addOptionalTag(ModTags.Items.INGOTS_ALUMINUM.location())
                .addOptionalTag(ModTags.Items.INGOTS_CALORITE.location())
                .addOptionalTag(ModTags.Items.INGOTS_DESH.location())
                .addOptionalTag(ModTags.Items.INGOTS_DRACONIUM.location())
                .addOptionalTag(ModTags.Items.INGOTS_IRIDIUM.location())
                .addOptionalTag(ModTags.Items.INGOTS_LEAD.location())
                .addOptionalTag(ModTags.Items.INGOTS_MAGENTITE.location())
                .addOptionalTag(ModTags.Items.INGOTS_NICKEL.location())
                .addOptionalTag(ModTags.Items.INGOTS_OSMIUM.location())
                .addOptionalTag(ModTags.Items.INGOTS_OSTRUM.location())
                .addOptionalTag(ModTags.Items.INGOTS_PLATINUM.location())
                .addOptionalTag(ModTags.Items.INGOTS_SILVER.location())
                .addOptionalTag(ModTags.Items.INGOTS_TIN.location())
                .addOptionalTag(ModTags.Items.INGOTS_URANIUM.location())

                .addOptional(new ResourceLocation(ModIntegration.ae2.name(),"certus_quartz_crystal"))
                .addOptional(new ResourceLocation(ModIntegration.mysticalagriculture.name(),"prosperity_shard"))
        ;
    }
}
