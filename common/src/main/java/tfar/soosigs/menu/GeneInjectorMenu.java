package tfar.soosigs.menu;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import tfar.soosigs.init.ModMenuTypes;

public class GeneInjectorMenu extends AbstractContainerMenu {

    public GeneInjectorMenu(int id, Inventory inventory) {
        this(id,inventory,new SimpleContainer(3));
    }

    public GeneInjectorMenu(int id, Inventory inventory, Container container) {
        super(ModMenuTypes.GENE_INJECTOR, id);

        int x;
        int y;

        this.addSlot(new Slot(container,0, 8, 48));
        this.addSlot(new Slot(container,1, 44, 48));
        this.addSlot(new Slot(container,2, 98, 48){
            @Override
            public boolean mayPlace(ItemStack $$0) {
                return false;
            }
        });

        for(x = 0; x < 3; ++x) {
            for(y = 0; y < 9; ++y) {
                this.addSlot(new Slot(inventory, y + x * 9 + 9, 8 + y * 18, 84 + x * 18));
            }
        }

        for(x = 0; x < 9; ++x) {
            this.addSlot(new Slot(inventory, x, 8 + x * 18, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }
}
