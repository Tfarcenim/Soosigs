package tfar.soosigs;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Shearable;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

public class SoosigEntity extends PathfinderMob implements Shearable {

    private static final EntityDataAccessor<Integer> DATA_COLOR = SynchedEntityData.defineId(SoosigEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> DATA_SHEARED = SynchedEntityData.defineId(SoosigEntity.class, EntityDataSerializers.BOOLEAN);

    protected SoosigEntity(EntityType<? extends PathfinderMob> $$0, Level $$1) {
        super($$0, $$1);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_COLOR,0xffffff);
        entityData.define(DATA_SHEARED,false);
    }



    public void setSheared(boolean sheared) {
        entityData.set(DATA_SHEARED,sheared );
    }

    public boolean isSheared() {
        return entityData.get(DATA_SHEARED);
    }

    public void setColor(int color) {
        entityData.set(DATA_COLOR,color);
    }

    public int getColor() {
        return entityData.get(DATA_COLOR);
    }

    @Override
    public void shear(SoundSource soundSource) {

    }

    @Override
    public boolean readyForShearing() {
        return isAlive() && !isSheared();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag $$0) {
        super.addAdditionalSaveData($$0);
        $$0.putBoolean("Sheared", this.isSheared());
       // $$0.putByte("Color", (byte)this.getColor().getId());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag $$0) {
        super.readAdditionalSaveData($$0);
        this.setSheared($$0.getBoolean("Sheared"));
     //   this.setColor(DyeColor.byId($$0.getByte("Color")));
    }
}
