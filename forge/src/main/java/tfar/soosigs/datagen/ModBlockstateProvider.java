package tfar.soosigs.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.soosigs.Soosigs;
import tfar.soosigs.init.ModBlocks;

public class ModBlockstateProvider extends BlockStateProvider {
    public ModBlockstateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Soosigs.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModelFile file = models().withExistingParent("soosig_egg",modLoc("block/tinted_dragon_egg"))
                .texture("all",modLoc("block/soosig_egg"))
                .texture("particle",modLoc("block/soosig_egg"));
        simpleBlock(ModBlocks.SOOSIG_EGG,file);
        simpleBlock(ModBlocks.GENE_INJECTOR, models().getExistingFile(new ResourceLocation("block/furnace")));
    }
}
