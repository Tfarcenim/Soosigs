package tfar.soosigs.blockentity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import tfar.soosigs.init.ModItems;
import tfar.soosigs.init.ModTags;

public class GeneContainer extends SimpleContainer {

    public GeneContainer() {
        super(3);
    }

    public static final int OUTPUT = 2;

    public void craft() {
        ItemStack input1 = getItem(0);
        ItemStack input2 = getItem(1);
        if (input1.isEmpty() || input2.isEmpty()) {
            return;
        } else {
            ItemStack stack= new ItemStack(input1.getItem());
            stack.getOrCreateTagElement(BlockItem.BLOCK_ENTITY_TAG).putString("item", BuiltInRegistries.ITEM.getKey(input2.getItem()).toString());
            setItem(GeneContainer.OUTPUT,stack);
            getItem(0).shrink(1);
            getItem(1).shrink(1);
            setChanged();
        }
    }

    @Override
    public boolean canPlaceItem(int slot, ItemStack stack) {
        return switch (slot){
            case 0 -> stack.is(ModItems.SOOSIG_EGG);
            case 1-> stack.is(ModTags.Items.ALLOWED_RESOURCES);
            case OUTPUT -> false;
            default -> false;
        };
    }
}
