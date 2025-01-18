package tfar.soosigs.client;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import tfar.soosigs.SoosigEntityForge;
import tfar.soosigs.Soosigs;
import tfar.soosigs.blockentity.SoosigEggBlockEntity;
import tfar.soosigs.config.SoosigConfig;
import tfar.soosigs.config.SoosigEntry;
import tfar.soosigs.init.ModBlocks;
import tfar.soosigs.init.ModEntities;
import tfar.soosigs.init.ModItems;

public class ModClientForge {

    public static void init(IEventBus bus) {
        bus.addListener(ModClientForge::setup);
        bus.addListener(ModClientForge::renderer);
        bus.addListener(ModClientForge::colorsB);
        bus.addListener(ModClientForge::colorsI);
    }

    static BlockColor color = (pState, pLevel, pPos, pTintIndex) -> {
        if (pPos != null && pLevel != null) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof SoosigEggBlockEntity soosigEggBlockEntity) {
                return soosigEggBlockEntity.getColor();
            }
        }
        return 0xffffffff;
    };

    static ItemColor item_color = (stack, pTintIndex) -> {
        CompoundTag tag = stack.getTagElement(BlockItem.BLOCK_ENTITY_TAG);
        if (tag != null) {
            Item item = BuiltInRegistries.ITEM.get(new ResourceLocation(tag.getString("item")));
            return SoosigConfig.DEFAULTS.getOrDefault(item,new SoosigEntry(0xffffffff)).color();
        }
        return 0xffffffff;
    };

    static void setup(FMLClientSetupEvent event) {
        ModClient.setup();
    }

    static void colorsB(RegisterColorHandlersEvent.Block event) {
        event.register(color, ModBlocks.SOOSIG_EGG);
    }

    static void colorsI(RegisterColorHandlersEvent.Item event) {
        event.register(item_color, ModItems.SOOSIG_EGG);
    }

    static void renderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer((EntityType<SoosigEntityForge>) ModEntities.SOOSIG, pContext -> new SoosigRenderer(pContext, new SoosigModel(Soosigs.id("soosig"))));
    }

}
