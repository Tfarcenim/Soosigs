package tfar.soosigs;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class RespectfulSlot extends Slot {

    protected final int i;
    public RespectfulSlot(Container $$0, int $$1, int $$2, int $$3) {
        super($$0, $$1, $$2, $$3);
        i = $$1;
    }

    @Override
    public boolean mayPlace(ItemStack $$0) {
        return container.canPlaceItem(i,$$0);
    }
}
