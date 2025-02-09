package tfar.soosigs.init;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import tfar.soosigs.block.SoosigEggBlock;

public class ModCreativeTabs {
    public static final CreativeModeTab EGGS = CreativeModeTab.builder(null,-1)
            .icon(() -> new ItemStack(ModItems.SOOSIG_EGG))
            .title(Component.literal("Soosig Eggs"))
            .displayItems((itemDisplayParameters, output) -> {
                for (Item item : BuiltInRegistries.ITEM) {
                    if (item.getDefaultInstance().is(ModTags.Items.ALLOWED_RESOURCES)) {
                        output.accept(
                                SoosigEggBlock.craft(item));
                    }
                }
            })
            .build();
}
