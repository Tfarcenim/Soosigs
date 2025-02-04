package tfar.soosigs;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Shearable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import tfar.soosigs.config.SoosigConfig;
import tfar.soosigs.config.SoosigEntry;

public class SoosigEntity extends PathfinderMob implements Shearable {

    private static final EntityDataAccessor<ItemStack> DATA_ITEMSTACK = SynchedEntityData.defineId(SoosigEntity.class, EntityDataSerializers.ITEM_STACK);
    private static final EntityDataAccessor<Boolean> DATA_SHEARED = SynchedEntityData.defineId(SoosigEntity.class, EntityDataSerializers.BOOLEAN);

    protected SoosigEntity(EntityType<? extends PathfinderMob> $$0, Level $$1) {
        super($$0, $$1);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_ITEMSTACK,ItemStack.EMPTY);
        entityData.define(DATA_SHEARED,false);
    }



    public void setSheared(boolean sheared) {
        entityData.set(DATA_SHEARED,sheared );
    }

    public boolean isSheared() {
        return entityData.get(DATA_SHEARED);
    }

    public int getColor() {
        return SoosigConfig.CLIENT.COLORS.get().getOrDefault(entityData.get(DATA_ITEMSTACK).getItem(),new SoosigEntry(0xffffffff)).color();
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
