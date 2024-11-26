package tfar.soosigs;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.IForgeShearable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;

public class SoosigEntityForge extends SoosigEntity implements GeoEntity, IForgeShearable {
    final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public SoosigEntityForge(EntityType<? extends PathfinderMob> $$0, Level $$1) {
        super($$0, $$1);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "main", 0, event -> {
            return event.setAndContinue(DefaultAnimations.IDLE);
        }));
    }

    @org.jetbrains.annotations.NotNull
    @Override
    public java.util.List<ItemStack> onSheared(@Nullable Player player, @org.jetbrains.annotations.NotNull ItemStack item, Level world, BlockPos pos, int fortune) {
        world.playSound(null, this, SoundEvents.SHEEP_SHEAR, player == null ? SoundSource.BLOCKS : SoundSource.PLAYERS, 1.0F, 1.0F);
        this.gameEvent(GameEvent.SHEAR, player);
        if (!world.isClientSide) {
            this.setSheared(true);
            int i = 1 + this.random.nextInt(3);

            java.util.List<ItemStack> items = new java.util.ArrayList<>();

            return items;
        }
        return java.util.Collections.emptyList();
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
