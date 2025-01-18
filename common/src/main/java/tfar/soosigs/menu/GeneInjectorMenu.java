package tfar.soosigs.menu;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import tfar.soosigs.RespectfulSlot;
import tfar.soosigs.blockentity.GeneContainer;
import tfar.soosigs.init.ModMenuTypes;

public class GeneInjectorMenu extends AbstractContainerMenu {

    private final GeneContainer container;

    public GeneInjectorMenu(int id, Inventory inventory) {
        this(id,inventory,new GeneContainer());
    }

    public GeneInjectorMenu(int id, Inventory inventory, GeneContainer container) {
        super(ModMenuTypes.GENE_INJECTOR, id);
        this.container = container;

        int x;
        int y;

        this.addSlot(new RespectfulSlot(container,0, 8, 48));
        this.addSlot(new RespectfulSlot(container,1, 44, 48));
        this.addSlot(new RespectfulSlot(container,2, 98, 48));

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
    public boolean clickMenuButton(Player $$0, int $$1) {
        if ($$1 == 0) {
            if ($$0 instanceof ServerPlayer) {
                container.craft();
            }
            return true;
        }
        return super.clickMenuButton($$0, $$1);
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
