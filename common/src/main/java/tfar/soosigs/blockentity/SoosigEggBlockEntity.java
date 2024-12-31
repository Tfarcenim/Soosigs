package tfar.soosigs.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3f;
import tfar.soosigs.init.ModBlockEntityTypes;
import tfar.soosigs.init.ModEntities;

import java.util.HashSet;
import java.util.Set;

public class SoosigEggBlockEntity extends BlockEntity {

    public static final int HATCH_TIME = 20 * 5;

    private int ticksExisted;

    boolean validStructure;

    Set<BlockPos> missing = new HashSet<>();

    public SoosigEggBlockEntity(BlockPos $$1, BlockState $$2) {
        this(ModBlockEntityTypes.SOOSIG_EGG, $$1, $$2);
    }

    public SoosigEggBlockEntity(BlockEntityType<?> $$0, BlockPos $$1, BlockState $$2) {
        super($$0, $$1, $$2);
    }

    void tick() {
        if (!level.isClientSide) {

            if (level.getGameTime() % 20 == 1) {
                validStructure = checkEnclosure();
            }

            if (validStructure) {
                ticksExisted++;
                if (ticksExisted % 20 == 0) {
                    spawnGoodParticle(worldPosition);
                }
                setChanged();
                if (ticksExisted > HATCH_TIME) {
                    ModEntities.SOOSIG.spawn((ServerLevel) level, worldPosition, MobSpawnType.EVENT);
                    level.removeBlock(worldPosition, false);
                }
            } else {
                if (level.getGameTime() % 2 == 0) {
                    for (BlockPos pos : missing) {
                        spawnErrorParticle(pos);
                    }
                }
            }
        }
    }

    public static final Vector3f GREENSTONE_PARTICLE_COLOR = Vec3.fromRGB24(0x00ff00).toVector3f();
    public static final DustParticleOptions GREENSTONE = new DustParticleOptions(GREENSTONE_PARTICLE_COLOR, 1.0F);

    protected void spawnErrorParticle(BlockPos pos) {
        ((ServerLevel) level).sendParticles(DustParticleOptions.REDSTONE,
                pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 1, 0, 0, 0, 0);
    }

    protected void spawnGoodParticle(BlockPos pos) {
        ((ServerLevel) level).sendParticles(GREENSTONE,
                pos.getX() + .5, pos.getY() + 1, pos.getZ() + .5, 1, 0, 0, 0, 0);
    }

    protected boolean checkEnclosure() {
        missing.clear();
        return completeFloor() && completeWalls() && completeCeiling();
    }

    static final Direction[] directions = new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

    public boolean completeWalls() {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        mutableBlockPos.set(worldPosition);
        for (Direction direction : directions) {
            Set<BlockPos> toCheck = new HashSet<>();

            BlockPos wallBase = mutableBlockPos.relative(direction, 2);
            Direction wallDir = direction.getCounterClockWise();
            for (int y = 0; y < 3; y++) {
                for (int i = -1; i < 2; i++) {
                    toCheck.add(wallBase.relative(wallDir, i).relative(Direction.UP, y));
                }
            }


            for (BlockPos pos : toCheck) {
                BlockState state = level.getBlockState(pos);
                if (!state.isFaceSturdy(level, pos, direction) && !state.is(BlockTags.DOORS)) {
                    missing.add(pos);
                }
            }
        }
        return missing.isEmpty();
    }

    protected boolean completeFloor() {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int z = -2; z < 3; z++) {
            for (int x = -2; x < 3; x++) {
                mutableBlockPos.set(worldPosition.getX() + x, worldPosition.getY() - 1, worldPosition.getZ() + z);
                BlockState state = level.getBlockState(mutableBlockPos);
                if (!state.isFaceSturdy(level, mutableBlockPos, Direction.UP)) {
                    missing.add(mutableBlockPos.immutable());
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean completeCeiling() {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int y = 0; y < 3; y++) {
            for (int z = -1; z < 2; z++) {
                for (int x = -1; x < 2; x++) {
                    mutableBlockPos.set(worldPosition.getX() + x, worldPosition.getY() + y, worldPosition.getZ() + z);
                    BlockState state = level.getBlockState(mutableBlockPos);
                    if (mutableBlockPos.equals(worldPosition)) continue;
                    if (state.blocksMotion()) {
                        missing.add(mutableBlockPos.immutable());
                    }
                }
            }
        }

            for (int z = -1; z < 2; z++) {
                for (int x = -1; x < 2; x++) {
                    mutableBlockPos.set(worldPosition.getX() + x, worldPosition.getY() + 3, worldPosition.getZ() + z);
                    BlockState state = level.getBlockState(mutableBlockPos);
                    if (!state.isFaceSturdy(level,mutableBlockPos,Direction.DOWN)) {
                        missing.add(mutableBlockPos.immutable());
                    }
                }
            }

        return missing.isEmpty();
    }

    public static void tick(Level level, BlockPos pos, BlockState state, SoosigEggBlockEntity soosigEggBlockEntity) {
        soosigEggBlockEntity.tick();
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("ticksExisted", ticksExisted);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        ticksExisted = tag.getInt("ticksExisted");
    }
}
