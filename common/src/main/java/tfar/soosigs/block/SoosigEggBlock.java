package tfar.soosigs.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import tfar.soosigs.blockentity.SoosigEggBlockEntity;
import tfar.soosigs.init.ModBlockEntityTypes;

import java.util.List;

public class SoosigEggBlock extends Block implements EntityBlock {
    public SoosigEggBlock(Properties $$0) {
        super($$0);
    }
    protected static final VoxelShape SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

    @Override
    public VoxelShape getShape(BlockState $$0, BlockGetter $$1, BlockPos $$2, CollisionContext $$3) {
        return SHAPE;
    }


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SoosigEggBlockEntity(blockPos,blockState);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable BlockGetter $$1, List<Component> tooltip, TooltipFlag $$3) {
        super.appendHoverText(stack, $$1, tooltip, $$3);
        CompoundTag compoundTag = stack.getTagElement(BlockItem.BLOCK_ENTITY_TAG);
        if (compoundTag != null) {
            Item item = BuiltInRegistries.ITEM.get(new ResourceLocation(compoundTag.getString("item")));
            tooltip.add(Component.literal("Produces: ").append(item.getDefaultInstance().getHoverName()));
        }
    }

    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return BaseEntityBlock.createTickerHelper(pBlockEntityType, ModBlockEntityTypes.SOOSIG_EGG, SoosigEggBlockEntity::tick);
    }


}
