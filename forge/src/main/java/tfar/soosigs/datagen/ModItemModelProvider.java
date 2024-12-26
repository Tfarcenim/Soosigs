package tfar.soosigs.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import tfar.soosigs.Soosigs;
import tfar.soosigs.init.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput generator, ExistingFileHelper existingFileHelper) {
        super(generator, Soosigs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        makeSimpleBlockItem(ModItems.SOOSIG_EGG);
    }

    final ModelFile.ExistingModelFile generated = getExistingFile(mcLoc("item/generated"));

    protected void makeSimpleBlockItem(Item item, ResourceLocation model) {
        String s = BuiltInRegistries.ITEM.getKey(item).toString();
        getBuilder(s)
                .parent(getExistingFile(model));
    }

    protected void makeSimpleBlockItem(Item item) {
        makeSimpleBlockItem(item, Soosigs.id( "block/" + BuiltInRegistries.ITEM.getKey(item).getPath()));
    }


    protected void makeOneLayerItem(Item item, ResourceLocation texture) {
        String path = BuiltInRegistries.ITEM.getKey(item).getPath();
        if (existingFileHelper.exists(new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath())
                , PackType.CLIENT_RESOURCES, ".png", "textures")) {
            getBuilder(path).parent(generated)
                    .texture("layer0", new ResourceLocation(texture.getNamespace(), "item/" + texture.getPath()));
        } else {
            System.out.println("no texture for " + item + " found, skipping");
        }
    }

    protected void makeOneLayerItem(Item item) {
        ResourceLocation texture = BuiltInRegistries.ITEM.getKey(item);
        makeOneLayerItem(item, texture);
    }
}
