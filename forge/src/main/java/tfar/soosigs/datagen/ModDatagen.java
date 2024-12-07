package tfar.soosigs.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class ModDatagen {

    public static void gather(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        generator.addProvider(true,ModLootTableProvider.create(output));
        //generator.addProvider(true,new ModDataPackProvider(output,provider));
        generator.addProvider(event.includeClient(),new ModBlockstateProvider(output,event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(),new ModLangProvider(output));
        generator.addProvider(event.includeClient(),new ModItemModelProvider(output,helper));
        generator.addProvider(event.includeServer(),new ModRecipeProvider(output));
        generator.addProvider(event.includeServer(),new ModGlobalLootModifierProvider(output));
    }
}
