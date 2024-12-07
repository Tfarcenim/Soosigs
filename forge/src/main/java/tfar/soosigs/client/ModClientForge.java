package tfar.soosigs.client;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import tfar.soosigs.SoosigEntityForge;
import tfar.soosigs.Soosigs;
import tfar.soosigs.init.ModEntities;

public class ModClientForge {

    public static void init(IEventBus bus) {
        bus.addListener(ModClientForge::setup);
        bus.addListener(ModClientForge::renderer);
    }

    static void setup(FMLClientSetupEvent event) {
        ModClient.setup();
    }

    static void renderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer((EntityType<SoosigEntityForge>) ModEntities.SOOSIG, pContext -> new SoosigRenderer(pContext, new SoosigModel(Soosigs.id("soosig"))));
    }

}
