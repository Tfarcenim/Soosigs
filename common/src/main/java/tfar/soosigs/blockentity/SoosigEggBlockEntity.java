package tfar.soosigs.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import tfar.soosigs.init.ModBlockEntityTypes;
import tfar.soosigs.init.ModEntities;

public class SoosigEggBlockEntity extends BlockEntity {

    public static final int HATCH_TIME = 20 * 5;

    private int ticksExisted;

    public SoosigEggBlockEntity(BlockPos $$1, BlockState $$2) {
        this(ModBlockEntityTypes.SOOSIG_EGG, $$1, $$2);
    }

    public SoosigEggBlockEntity(BlockEntityType<?> $$0, BlockPos $$1, BlockState $$2) {
        super($$0, $$1, $$2);
    }

    void tick() {
        if (!level.isClientSide) {
            if (validEnclosure()) {
                ticksExisted++;
                setChanged();
                if (ticksExisted > HATCH_TIME) {
                    ModEntities.SOOSIG.spawn((ServerLevel) level,worldPosition, MobSpawnType.EVENT);
                    level.removeBlock(worldPosition,false);
                }
            }
        }
    }

    protected boolean validEnclosure() {
        return true;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, SoosigEggBlockEntity soosigEggBlockEntity) {
        soosigEggBlockEntity.tick();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("ticksExisted",ticksExisted);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        ticksExisted = tag.getInt("ticksExisted");
    }
}
