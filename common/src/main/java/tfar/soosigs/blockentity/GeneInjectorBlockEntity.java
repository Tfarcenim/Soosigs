package tfar.soosigs.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import tfar.soosigs.init.ModBlockEntityTypes;
import tfar.soosigs.menu.GeneInjectorMenu;

public class GeneInjectorBlockEntity extends BlockEntity implements MenuProvider {
    protected final SimpleContainer container = new SimpleContainer(3);

    public GeneInjectorBlockEntity(BlockPos pos, BlockState state) {
        this(ModBlockEntityTypes.GENE_INJECTOR, pos, state);
    }

    public GeneInjectorBlockEntity(BlockEntityType<?> $$0, BlockPos pos, BlockState state) {
        super($$0, pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        tag.put("inv",ContainerHelper.saveAllItems(new CompoundTag(), container.items));
        super.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        ContainerHelper.loadAllItems(tag.getCompound("inv"),container.items);
        super.load(tag);
    }

    @Override
    public Component getDisplayName() {
        return getBlockState().getBlock().getName();
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new GeneInjectorMenu(i,inventory,container);
    }
}